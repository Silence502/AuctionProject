package fr.eni.encheres.dal;

public abstract class DAOFactory {
	
	public static ArticleVenduDAO getAvisDAO()
	{
		return new ArticleVenduDAOJdbcImpl();
	}
}
