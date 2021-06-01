package fr.eni.encheres.dal;

import fr.eni.encheres.dal.jdbc.UtilisateurDAOJdbcImpl;

public abstract class DAOFactory {

    public static ArticleVenduDAO getArticleVenduDAO() {
	return new ArticleVenduDAOJdbcImpl();
    }
    public static UtilisateurDAO getUtilisateurDAO() {
	return new UtilisateurDAOJdbcImpl();
    }
}
