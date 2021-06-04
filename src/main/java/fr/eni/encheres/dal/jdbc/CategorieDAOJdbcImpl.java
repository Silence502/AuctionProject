package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.BusinessException;

import fr.eni.encheres.bo.Categorie;

import fr.eni.encheres.dal.CategorieDAO;
import fr.eni.encheres.dal.CodesResultatDAL;
import fr.eni.encheres.dal.ConnectionProvider;


public class CategorieDAOJdbcImpl implements CategorieDAO {

    private static final String SELECT_ALL = "SELECT * FROM categories;";
    private static final String SELECT_NO_BY_LIBELLE = "SELECT no_categorie FROM categories WHERE libelle = ?;";

    @Override
    public List<Categorie> selectAll() throws BusinessException {
	
    	List<Categorie> categories = new ArrayList<>();
    	int num;
    	String cat;
    	
	try (Connection cnx = ConnectionProvider.getConnection()) {
	    
	    Statement stmt= cnx.createStatement();
		ResultSet rs = stmt.executeQuery(SELECT_ALL);
		
		while (rs.next()) {
		num = rs.getInt("no_categorie");
		cat = rs.getString("libelle");
		categories.add(new Categorie (num, cat));
		}
		}
	
	catch (Exception e) {
	    e.printStackTrace();
	    BusinessException businessException = new BusinessException();
	    businessException.ajouterErreur(CodesResultatDAL.SELECT_ALL_CATEGORIE_ECHEC);
	    throw businessException;}
	
	return categories;
    }

	@Override
	public int selectNoByLibelle(String libelle) throws BusinessException {
		
		int no = 0;

		try (Connection cnx = ConnectionProvider.getConnection()) {
		    
			PreparedStatement pstmt= cnx.prepareStatement(SELECT_NO_BY_LIBELLE);
			pstmt.setString(1, libelle);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
			no = rs.getInt("no_categorie");
			}
			}
		
		catch (Exception e) {
		    e.printStackTrace();
		    BusinessException businessException = new BusinessException();
		    businessException.ajouterErreur(CodesResultatDAL.SELECT_ALL_CATEGORIE_ECHEC);
		    throw businessException;}
		
		return no;
	}
}
    

