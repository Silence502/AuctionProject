package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.UtilisateurException;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
    private Utilisateur utilisateur;
    private final String INSERT = "INSERT INTO UTILISATEURS(pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,0,0)";
    private final String SELECT_BY_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur=?";
    private final String SELECT_BY_PS = "SELECT * FROM UTILISATEURS WHERE pseudo=? OR email=? AND mot_de_passe=?";
    private final String SELECT_CHECK = "SELECT pseudo, email FROM UTILISATEURS WHERE pseudo=? OR email=?";
    private final String SELECT_ALL = "SELECT * FROM UTILISATEURS";

    PreparedStatement stmt = null;
    PreparedStatement stmtCheck = null;
    BusinessException businessException = new BusinessException();

    /**
     * @parama utilisateur
     * Méthode permetant l'insertion et donc l'inscription d'un utilisateur.
     */
    @Override
    public void insert(Utilisateur utilisateur) throws UtilisateurException {
	Utilisateur userCheck = null;
	try (Connection con = ConnectionProvider.getConnection()) {
	    // Préparation d'un insert et d'un select
	    stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
	    stmtCheck = con.prepareStatement(SELECT_CHECK);
	    // Récupération des données saisie pour l'insert
	    stmt.setString(1, utilisateur.getPseudo().trim());
	    stmt.setString(2, utilisateur.getNom().toUpperCase());
	    stmt.setString(3, utilisateur.getPrenom());
	    stmt.setString(4, utilisateur.getEmail().toLowerCase().trim());
	    stmt.setString(5, utilisateur.getTelephone());
	    stmt.setString(6, utilisateur.getRue());
	    stmt.setString(7, utilisateur.getCodePostal().trim());
	    stmt.setString(8, utilisateur.getVille());
	    stmt.setString(9, utilisateur.getMotDePasse());
	    // Récupération du pseudo et de l'email saisie pour le select
	    stmtCheck.setString(1, utilisateur.getPseudo());
	    stmtCheck.setString(2, utilisateur.getEmail());
	    // Exécution de la requête select et stockage dans le ResultSet
	    ResultSet rsCheck = stmtCheck.executeQuery();
	    if (rsCheck.next()) {// L'email et le pseudo étant uniquent le curseur ne se placera que sur l'unique
				 // ligne générée
		// Construction d'un utilisateur avec seulement le pseudo et l'email s'ils ont
		// été trouvé dans la BDD avec la requête select sinon il sera juste null
		userCheck = new Utilisateur(rsCheck.getString("pseudo"), rsCheck.getString("email"));
	    }
	    try {
		// Comparaison du pseudo et de l'email saisie avec le pseudo et l'email
		// selectionné dans la BDD
		if (utilisateur.getEmail().equalsIgnoreCase(userCheck.getEmail())
			|| utilisateur.getPseudo().equalsIgnoreCase(userCheck.getPseudo())) {
		    // S'il y a une correspondance on ferme tout.../...
		    stmt.close();
		    stmtCheck.close();
		    // .../...et on propage l'exception jusqu'à la servlet chargée de gérer
		    // l'inscription (ServletHomePage)
		    throw new UtilisateurException("Un utilisateur est déjà enregistré avec ce pseudo ou cet email");
		}
	    } catch (NullPointerException e) {
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
	    throw new UtilisateurException("L'insertion à échoué " + e);
	}
    }

    /**
     * @param id
     * Selection d'un utilisateur via son identifiant dans la BDD prenant en paramètre un entier.
     */
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

    /**
     * @param id
     * @param mdp
     * Sélection d'un utilisateur via son pseudo/email et son mot de passe.
     * Prend en paramètre deux chaînes de caractères.
     */
    @Override
    public Utilisateur selectByPseudo(String id, String mdp) {
	try (Connection con = ConnectionProvider.getConnection()) {
	    stmt = con.prepareStatement(SELECT_BY_PS);
	    // Récupération du pseudo et l'email dans la même variable de sorte que
	    // quoi que l'utilisateur saisisse (email ou pseudo) il peut se connecter
	    stmt.setString(1, id);
	    stmt.setString(2, id);
	    stmt.setString(3, mdp);
	    ResultSet rs = stmt.executeQuery();
	    if (rs.next()) {
		utilisateur = new Utilisateur(rs.getString("pseudo"),
			rs.getString("email"),rs.getString("mot_de_passe"));
	    }
	    stmt.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return utilisateur;
    }

    @Override
    public List<Utilisateur> selectAll() {
	List<Utilisateur> list = new ArrayList<Utilisateur>();
	try (Connection con = ConnectionProvider.getConnection()) {
	    // On prépare la requête
	    stmt = con.prepareStatement(SELECT_ALL);
	    ResultSet rs = stmt.executeQuery();
	    // Tant qu'il existe une ligne suivante
	    while (rs.next()) {
		// On reconstruit l'utilisateur
		utilisateur = new Utilisateur(rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"),
			rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
			rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),
			rs.getInt("credit"));
		// Et on l'ajoute à la liste
		list.add(utilisateur);
	    }
	    stmt.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return list;
    }

    @Override
    public void update(Utilisateur utilisateur) {

    }

    @Override
    public void delete(int id) {
	
    }

}
