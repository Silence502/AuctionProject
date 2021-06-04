package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.UserAlreadyExistException;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
    private Utilisateur utilisateur;
    private final String INSERT = "INSERT INTO UTILISATEURS(pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,0,0)";
    private final String SELECT_BY_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur=?";
    private final String SELECT_BY_PS = "SELECT * FROM UTILISATEURS WHERE pseudo=? AND mot_de_passe=?";
    private final String SELECT_CHECK = "SELECT pseudo, email FROM UTILISATEURS WHERE pseudo=? AND email=?";

    PreparedStatement stmt = null;
    PreparedStatement stmtCheck = null;
    BusinessException businessException = new BusinessException();

    @Override
    public void insert(Utilisateur utilisateur) throws UserAlreadyExistException {
	Utilisateur userCheck = new Utilisateur();
	try (Connection con = ConnectionProvider.getConnection()) {
	    // Préparation d'un insert et d'un select
	    stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
	    stmtCheck = con.prepareStatement(SELECT_CHECK);
	    // Récupération des données saisie dans l'insert
	    stmt.setString(1, utilisateur.getPseudo());
	    stmt.setString(2, utilisateur.getNom());
	    stmt.setString(3, utilisateur.getPrenom());
	    stmt.setString(4, utilisateur.getEmail());
	    stmt.setString(5, utilisateur.getTelephone());
	    stmt.setString(6, utilisateur.getRue());
	    stmt.setString(7, utilisateur.getCodePostal());
	    stmt.setString(8, utilisateur.getVille());
	    stmt.setString(9, utilisateur.getMotDePasse());
	    // Récupération du pseudo et de l'email saisie dans le select
	    stmtCheck.setString(1, utilisateur.getPseudo());
	    stmtCheck.setString(2, utilisateur.getEmail());
	    // Exécution de la requête et stockage dans le ResultSet
	    ResultSet rsCheck = stmtCheck.executeQuery();
	    if (rsCheck.next()) {// Le pseudo et l'email étant uniquent le curseur ne se placera que sur l'unique
				 // ligne générée
		// Construction d'un utilisateur avec seulement le pseudo et l'email s'il a été
		// trouvé dans le select sinon il seront juste null
		userCheck = new Utilisateur(rsCheck.getString("pseudo"), rsCheck.getString("email"));
	    }
	    // Vérification du pseudo et de l'email saisie et du pseudo et de l'email
	    // selectionné dans le BDD
	    if (utilisateur.getPseudo().equalsIgnoreCase(userCheck.getPseudo())) {
		// S'il y a une correspondance on ferme tout.../...
		stmt.close();
		stmtCheck.close();
		// .../...et on propage l'exception jusqu'à la servlet chargée de gérer
		// l'inscription (ServletHomePage)
		throw new UserAlreadyExistException("Cet email est déjà associé à un utilisateur dans la base de données.");
	    } else if (utilisateur.getEmail().equals(userCheck.getEmail())) {
		// S'il y a une correspondance on ferme tout.../...
		stmt.close();
		stmtCheck.close();
		// .../...et on propage l'exception jusqu'à la servlet chargée de gérer
		// l'inscription (ServletHomePage)
		throw new UserAlreadyExistException("Ce pseudo est déjà associé à un utilisateur dans la base de données.");
	    } else {
		// S'il n'y a pas de correspondance on ferme le select et on exécute l'insert
		// avant fermeture
		stmtCheck.close();
		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
		    utilisateur.setNoUtilisateur(1);
		}
		stmt.close();
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public Utilisateur selectById(int id) {
	try (Connection con = ConnectionProvider.getConnection()) {
	    stmt = con.prepareStatement(SELECT_BY_ID);
	    stmt.setInt(1, id);
	    ResultSet rs = stmt.executeQuery();
	    if (rs.next()) {
		utilisateur = new Utilisateur(rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"),
			rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
			rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),
			rs.getInt("credit"));
	    }
	    stmt.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return utilisateur;
    }

    @Override
    public Utilisateur selectByPseudo(String pseudo, String mdp) {
	try (Connection con = ConnectionProvider.getConnection()) {
	    stmt = con.prepareStatement(SELECT_BY_PS);
	    stmt.setString(1, pseudo);
	    stmt.setString(2, mdp);
	    ResultSet rs = stmt.executeQuery();
	    if (rs.next()) {
		utilisateur = new Utilisateur(rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"),
			rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
			rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),
			rs.getInt("credit"));
	    }
	    stmt.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return utilisateur;
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
