package fr.eni.encheres.bll;

import java.time.LocalDate;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Utilisateur;
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

    public List<ArticleVendu> getArticleVendu() throws BusinessException {
	List<ArticleVendu> list = articleVenduDAO.selectAll();
	return list;
    }

    /**
     * @param description
     * @param note
     * @return un objet ArticleVendu en cas de succcès
     * @throws BusinessException
     */
    public void ajouter(ArticleVendu a, Utilisateur u) throws BusinessException {

	BusinessException exception = new BusinessException();
	this.validerNom(a, exception);
	this.validerDescription(a, exception);
	this.validerDateDebut(a, exception);
	this.validerDateFin(a, exception);
	this.validerMiseAPrix(a, exception);
	this.validerCategorie(a, exception);
	if (!exception.hasErreurs()) {
	    this.articleVenduDAO.insert(a, u);
	}

	if (exception.hasErreurs()) {
	    throw exception;
	}
    }

    /**
     * Règles à respecter sur la variable nom. En cas d'erreur, le code d'erreur est
     * enregistré dans l'objetbusinessException.
     * 
     * @param articleVendu
     * @param businessException
     */
    private void validerNom(ArticleVendu articleVendu, BusinessException businessException) {

	// Le nom est obligatoire
	if (articleVendu.getNomArticle() == null || articleVendu.getNomArticle().equals("")) {
	    businessException.ajouterErreur(CodesResultatBLL.REGLE_NOM_OBLIGATOIRE);
	}

	// Le nom ne doit pas dépasser 30 caractères.
	if (articleVendu.getNomArticle().length() > 30) {
	    businessException.ajouterErreur(CodesResultatBLL.REGLE_NOM_ERREUR);
	}
    }

    /**
     * Règles à respecter sur la variable description. En cas d'erreur, le code
     * d'erreur est enregistré dans l'objetbusinessException.
     * 
     * @param articleVendu
     * @param businessException
     */
    private void validerDescription(ArticleVendu articleVendu, BusinessException businessException) {

	// La description est obligatoire
	if (articleVendu.getDescription() == null || articleVendu.getDescription().equals("")) {
	    businessException.ajouterErreur(CodesResultatBLL.REGLE_DESCRIPTION_OBLIGATOIRE);
	}

	// La description ne doit pas dépasser 100 caractères.
	if (articleVendu.getDescription().length() > 100) {
	    businessException.ajouterErreur(CodesResultatBLL.REGLE_DESCRIPTION_ERREUR);
	}
    }

    /**
     * Règles à respecter sur la variable dateDebut. En cas d'erreur, le code
     * d'erreur est enregistré dans l'objetbusinessException.
     * 
     * @param articleVendu
     * @param businessException
     */
    private void validerDateDebut(ArticleVendu articleVendu, BusinessException businessException) {

	// La date de début est obligatoire
	if (articleVendu.getDateDebutEncheres() == null) {
	    businessException.ajouterErreur(CodesResultatBLL.REGLE_DATE_DEBUT_OBLIGATOIRE);
	}

	// La date de début ne peut pas être antérieure au moment de l'enregistrement.
	if (articleVendu.getDateDebutEncheres().isBefore(LocalDate.now())) {
	    businessException.ajouterErreur(CodesResultatBLL.REGLE_DATE_DEBUT_ERREUR);
	}
    }

    /**
     * Règles à respecter sur la variable dateFin. En cas d'erreur, le code d'erreur
     * est enregistré dans l'objetbusinessException.
     * 
     * @param articleVendu
     * @param businessException
     */
    private void validerDateFin(ArticleVendu articleVendu, BusinessException businessException) {

	// La date de fin est obligatoire
	if (articleVendu.getDateFinEncheres() == null) {
	    businessException.ajouterErreur(CodesResultatBLL.REGLE_DATE_FIN_OBLIGATOIRE);
	}

	// La date de fin ne peut pas être antérieure à la date de début
	if (articleVendu.getDateFinEncheres().isBefore(articleVendu.getDateDebutEncheres())) {
	    businessException.ajouterErreur(CodesResultatBLL.REGLE_DATE_FIN_ERREUR);
	}
    }

    /**
     * Règles à respecter sur la variable miseAPrix. En cas d'erreur, le code
     * d'erreur est enregistré dans l'objetbusinessException.
     * 
     * @param articleVendu
     * @param businessException
     */
    private void validerMiseAPrix(ArticleVendu articleVendu, BusinessException businessException) {

	// La mise à prix doit être posititive
	if (articleVendu.getMiseAPrix() <= 0) {
	    businessException.ajouterErreur(CodesResultatBLL.REGLE_MISE_A_PRIX_ERREUR);
	}

    }

    /**
     * Règles à respecter sur la variable catégorie. En cas d'erreur, le code
     * d'erreur est enregistré dans l'objetbusinessException.
     * 
     * @param articleVendu
     * @param businessException
     */
    private void validerCategorie(ArticleVendu articleVendu, BusinessException businessException) {

	// La catégorie doit être renseignée
	if (articleVendu.getCategorieArticle() == null) {
	    businessException.ajouterErreur(CodesResultatBLL.REGLE_CATEGORIE_OBLIGATOIRE);
	}

    }

}
