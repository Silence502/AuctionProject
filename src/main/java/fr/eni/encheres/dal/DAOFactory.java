package fr.eni.encheres.dal;

import fr.eni.encheres.dal.jdbc.UtilisateurDAOJdbcImpl;
import fr.eni.encheres.dal.jdbc.ArticleVenduDAOJdbcImpl;
import fr.eni.encheres.dal.jdbc.CategorieDAOJdbcImpl;

public abstract class DAOFactory {

    public static ArticleVenduDAO getArticleVenduDAO() {
	return new ArticleVenduDAOJdbcImpl();
    }
    
    public static CategorieDAO getCategorieDAO() {
    	return new CategorieDAOJdbcImpl();
        }
    
    public static UtilisateurDAO getUtilisateurDAO() {
	return new UtilisateurDAOJdbcImpl();
    }
}
