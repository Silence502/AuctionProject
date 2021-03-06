package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ArticleVenduDAO;
import fr.eni.encheres.dal.CodesResultatDAL;
import fr.eni.encheres.dal.ConnectionProvider;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {
    private static final String INSERT = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie) VALUES(?,?,?,?,?,?,?);";
    private static final String SELECT_ALL = "SELECT * FROM articles_vendus;";
    private static final String SELECT_BY_CATEGORIE = "SELECT * FROM articles_vendus WHERE no_categorie = ?;";
    private static final String SELECT_BY_MOT_CLE = "SELECT * FROM articles_vendus WHERE nom_article LIKE ?";

    @Override
    public void insert(ArticleVendu article, Utilisateur utilisateur) throws BusinessException {
	if (article == null) {
	    BusinessException businessException = new BusinessException();
	    businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
	    throw businessException;
	}

	try (Connection cnx = ConnectionProvider.getConnection()) {
	    PreparedStatement pstmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
	    pstmt.setString(1, article.getNomArticle());
	    pstmt.setString(2, article.getDescription());
	    pstmt.setDate(3, java.sql.Date.valueOf(article.getDateDebutEncheres()));
	    pstmt.setDate(4, java.sql.Date.valueOf(article.getDateFinEncheres()));
	    pstmt.setInt(5, article.getMiseAPrix());
	    pstmt.setInt(7, article.getCategorieArticle().getNoCategorie());
	    pstmt.setInt(6, utilisateur.getNoUtilisateur());
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

	    Statement stmt = cnx.createStatement();
	    ResultSet rs = stmt.executeQuery(SELECT_ALL);

	    while (rs.next()) {
		articles.add(new ArticleVendu(rs.getString("nom_article"), rs.getString("description"),
			rs.getDate("date_fin_encheres").toLocalDate(), rs.getInt("prix_initial"),
			rs.getInt("no_utilisateur")));
	    }
	}

	catch (Exception e) {
	    e.printStackTrace();
	    BusinessException businessException = new BusinessException();
	    businessException.ajouterErreur(CodesResultatDAL.SELECT_ALL_ECHEC);
	    throw businessException;
	}

	return articles;
    }

    @Override
    public List<ArticleVendu> selectByCategorie(int num) throws BusinessException {
	List<ArticleVendu> articles = new ArrayList<>();

	try (Connection cnx = ConnectionProvider.getConnection()) {

	    PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_CATEGORIE);
	    pstmt.setInt(1, num);
	    ResultSet rs = pstmt.executeQuery();
	    while (rs.next()) {
		articles.add(new ArticleVendu(rs.getString("nom_article"), rs.getString("description"),
			rs.getDate("date_fin_encheres").toLocalDate(), rs.getInt("prix_initial"),
			rs.getInt("no_utilisateur")));
	    }
	}

	catch (Exception e) {
	    e.printStackTrace();
	    BusinessException businessException = new BusinessException();
	    businessException.ajouterErreur(CodesResultatDAL.SELECT_BY_CATEGORIE_ECHEC);
	    throw businessException;
	}

	return articles;
    }

    @Override
    public List<ArticleVendu> selectByMotCle(String motCle) throws BusinessException {
	List<ArticleVendu> articles = new ArrayList<>();

	try (Connection cnx = ConnectionProvider.getConnection()) {

	    PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_MOT_CLE);
	    pstmt.setString(1, '%' + motCle + '%');
	    ResultSet rs = pstmt.executeQuery();
	    while (rs.next()) {
		articles.add(new ArticleVendu(rs.getString("nom_article"), rs.getString("description"),
			rs.getDate("date_fin_encheres").toLocalDate(), rs.getInt("prix_initial"),
			rs.getInt("no_utilisateur")));
	    }
	}

	catch (Exception e) {
	    e.printStackTrace();
	    BusinessException businessException = new BusinessException();
	    businessException.ajouterErreur(CodesResultatDAL.SELECT_BY_MOT_CLE_ECHEC);
	    throw businessException;
	}

	return articles;
    }
}
