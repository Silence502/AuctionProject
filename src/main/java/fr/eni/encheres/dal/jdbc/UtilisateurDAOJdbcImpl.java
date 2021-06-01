package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
    @SuppressWarnings("unused")
    private Utilisateur utilisateur;
    private final String INSERT = "INSERT INTO UTILISATEURS(pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,0,0)";
    
    PreparedStatement stmt = null;
    
    @Override
    public void insert(Utilisateur utilisateur) {
	try (Connection con = ConnectionProvider.getConnection()) {
	    stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
	    stmt.setString(1, utilisateur.getPseudo());
	    stmt.setString(2, utilisateur.getNom());
	    stmt.setString(3, utilisateur.getPrenom());
	    stmt.setString(4, utilisateur.getEmail());
	    stmt.setString(5, utilisateur.getTelephone());
	    stmt.setString(6, utilisateur.getRue());
	    stmt.setString(7, utilisateur.getCodePostal());
	    stmt.setString(8, utilisateur.getVille());
	    stmt.setString(9, utilisateur.getMotDePasse());
	    stmt.execute();
	    ResultSet rs = stmt.getGeneratedKeys();
	    if (rs.next()) {
		utilisateur.setNoUtilisateur(1);
	    }
	    stmt.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public Utilisateur selectById(int id) {
	return null;
    }

    @Override
    public List<Utilisateur> selectAll() {
	return null;
    }

    @Override
    public void update(Utilisateur utilisateur) {
	
    }

    @Override
    public void delete(int id) {
	
    }

}
