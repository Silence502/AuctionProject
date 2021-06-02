package fr.eni.encheres.dal;

import fr.eni.encheres.BusinessException;


import fr.eni.encheres.bo.ArticleVendu;



public interface ArticleVenduDAO {
	/**
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param article
	 * @throws BusinessException
	 */
	
	public void insert(ArticleVendu article) throws BusinessException;
		
	}

