package fr.eni.encheres.dal;

/**
 * Les codes disponibles sont entre 10000 et 19999
 */
public abstract class CodesResultatDAL {
	
	/**
	 * Echec général quand tentative d'ajouter un objet null
	 */
	public static final int INSERT_OBJET_NULL=10000;
	
	/**
	 * Echec général quand erreur non gérée à l'insertion 
	 */
	public static final int INSERT_OBJET_ECHEC=10001;
	
	/**
	 * Echec de l'insertion d'un article
	 */
	public static final int INSERT_ARTICLE_VENDU_ECHEC=10002;
	
	/**
	 * Echec de la selection de toutes les catégories
	 */
	public static final int SELECT_ALL_CATEGORIE_ECHEC=10003;
	
	/**
	 * Echec de la selection de l'ensemble des articles
	 */
	public static final int SELECT_ALL_ECHEC=10004;
	
	/**
	 * Echec de la selection par catégorie
	 */
	public static final int SELECT_BY_CATEGORIE_ECHEC=10005;
	
	/**
	 * Echec de la selection par mot clé
	 */
	public static final int SELECT_BY_MOT_CLE_ECHEC=10005;
}
