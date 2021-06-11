package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.BusinessException;

import fr.eni.encheres.bo.Categorie;


public interface CategorieDAO {
	/**
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param article
	 * @throws BusinessException
	 */
	List<Categorie> selectAll() throws BusinessException;
	
	int selectNoByLibelle (String libelle) throws BusinessException;
}
