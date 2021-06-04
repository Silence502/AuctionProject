package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.dal.ArticleVenduDAO;
import fr.eni.encheres.dal.CodesResultatDAL;
import fr.eni.encheres.dal.ConnectionProvider;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {

    private static final String INSERT = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie) VALUES(?,?,?,?,?,1,?);";

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
}
