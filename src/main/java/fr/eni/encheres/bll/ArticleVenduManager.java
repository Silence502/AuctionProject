package fr.eni.encheres.bll;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.ArticleVenduDAO;
import fr.eni.encheres.dal.DAOFactory;

/**
 * 
 * @author Administrator
 *
 *         Cette classe permet d'effectuer les traitements attendus sur la
 *         classe ArticleVendu
 */
public class ArticleVenduManager {

    private ArticleVenduDAO articleVenduDAO;

    /**
     * Le constructeur permet d'initialiser la variable articleVenduDAO pour
     * permettre une communication avec la base de données.
     */

    public ArticleVenduManager() {
	this.articleVenduDAO = DAOFactory.getArticleVenduDAO();
    }

    /**
     * @param description
     * @param note
     * @return un objet ArticleVendu en cas de succcès
     * @throws BusinessException
     */
    public ArticleVendu ajouter(String nom, String description, LocalDate dateDebut, LocalDate dateFin, int miseAPrix,
	    Categorie categorie) throws BusinessException

    {
	BusinessException exception = new BusinessException();

	ArticleVendu articleVendu = new ArticleVendu(nom, description, dateDebut, dateFin, miseAPrix, categorie);

	this.validerDescription(articleVendu, exception);

	if (!exception.hasErreurs()) {
	    this.articleVenduDAO.insert(articleVendu);
	}

	if (exception.hasErreurs()) {
	    throw exception;
	}
	return articleVendu;
    }

    /**
     * Cette méthode permet de vérifier les règles à respecter sur la variable
     * desvription. En cas d'erreur, le code d'erreur est enregistré dans l'objet
     * businessException.
     * 
     * @param articleVendu
     * @param businessException
     */
    private void validerDescription(ArticleVendu articleVendu, BusinessException businessException) {

	if (articleVendu.getDescription().length() > 30) {
	    businessException.ajouterErreur(CodesResultatBLL.REGLE_DESCRIPTION_ERREUR);
	}
    }

}
