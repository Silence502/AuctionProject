package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.BusinessException;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Utilisateur;


public interface ArticleVenduDAO {
	/**
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param article
	 * @throws BusinessException
	 */
	void insert(ArticleVendu article, Utilisateur utilisateur) throws BusinessException;
	
	List<ArticleVendu> selectAll () throws BusinessException;
	
	List<ArticleVendu> selectByCategorie(int num) throws BusinessException;
	
	List<ArticleVendu> selectByMotCle(String motCle) throws BusinessException;

	
	
}
