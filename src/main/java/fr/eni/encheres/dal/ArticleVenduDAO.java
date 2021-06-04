package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.BusinessException;

import fr.eni.encheres.bo.ArticleVendu;


public interface ArticleVenduDAO {
	/**
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param article
	 * @throws BusinessException
	 */
	void insert(ArticleVendu article) throws BusinessException;
	
	List<ArticleVendu> selectAll () throws BusinessException;
	
	
}
