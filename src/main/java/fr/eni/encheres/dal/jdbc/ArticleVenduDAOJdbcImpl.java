package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.ArticleVenduDAO;
import fr.eni.encheres.dal.CodesResultatDAL;
import fr.eni.encheres.dal.ConnectionProvider;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {

    private static final String INSERT = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie) VALUES(?,?,?,?,?,1,?);";
    private static final String SELECT_ALL = "SELECT * FROM articles_vendus;";
    
    @Override
    public void insert(ArticleVendu article) throws BusinessException {
	if (article == null) {
	    BusinessException businessException = new BusinessException();
	    businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
	    throw businessException;
	}

	try (Connection cnx = ConnectionProvider.getConnection()) {
	    PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
	    pstmt.setString(1, article.getNomArticle());
	    pstmt.setString(2, article.getDescription());
	    pstmt.setDate(3, java.sql.Date.valueOf(article.getDateDebutEncheres()));
	    pstmt.setDate(4, java.sql.Date.valueOf(article.getDateFinEncheres()));
	    pstmt.setInt(5, article.getMiseAPrix());
	    pstmt.setInt(6, article.getCategorieArticle().getNoCategorie());
	    pstmt.executeUpdate();
	    ResultSet rs = pstmt.getGeneratedKeys();
	    if (rs.next()) {
		article.setNoArticle(rs.getInt(1));
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    BusinessException businessException = new BusinessException();
	    businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
	    throw businessException;
	}
    }

	@Override
	public List<ArticleVendu> selectAll() throws BusinessException {
		List<ArticleVendu> articles = new ArrayList<>();
    	
	try (Connection cnx = ConnectionProvider.getConnection()) {
	    
	    Statement stmt= cnx.createStatement();
		ResultSet rs = stmt.executeQuery(SELECT_ALL);
		
		while (rs.next()) {
		articles.add(new ArticleVendu (rs.getString("nom_article"), rs.getString("description"), rs.getDate("date_fin_encheres").toLocalDate(), rs.getInt("prix_vente"), rs.getInt("no_utilisateur")));
		}
		}
	
	catch (Exception e) {
	    e.printStackTrace();
	    BusinessException businessException = new BusinessException();
	    businessException.ajouterErreur(CodesResultatDAL.SELECT_ALL_CATEGORIE_ECHEC);
	    throw businessException;}
	
	return articles;
    }
}
