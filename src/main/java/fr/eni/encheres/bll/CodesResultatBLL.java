package fr.eni.encheres.bll;

/**
 * Les codes disponibles sont entre 20000 et 29999
 */
public abstract class CodesResultatBLL {
	
	/**
     * Echec quand le nom de l'article n'est pas défini
     */
    public static final int REGLE_NOM_OBLIGATOIRE = 20000;

    /**
     * Echec quand le nom de l'article ne respecte pas les règles définies, 30 caractères max
     */
    public static final int REGLE_NOM_ERREUR = 20001;
	
	/**
     * Echec quand la description de l'article n'est pas définie
     */
    public static final int REGLE_DESCRIPTION_OBLIGATOIRE = 20002;

    /**
     * Echec quand la description de l'article ne respecte pas les règles définies, 100 caractères max
     */
    public static final int REGLE_DESCRIPTION_ERREUR = 20003;
    
    /**
     * Echec quand la date de début d'enchères de l'article n'est pas définie
     */
    public static final int REGLE_DATE_DEBUT_OBLIGATOIRE = 20004;

    /**
     * Echec quand la date de debut d'enchères est avant la date actuelle
     */
    public static final int REGLE_DATE_DEBUT_ERREUR = 20005;
    
    /**
     * Echec quand la date de fin d'enchères de l'article n'est pas définie
     */
    public static final int REGLE_DATE_FIN_OBLIGATOIRE = 20006;
    
    /**
     * Echec quand la date de fin d'enchères est avant la date de début d'enchères
     */
    public static final int REGLE_DATE_FIN_ERREUR = 20007;
    
    /**
     * Echec quand la mise à prix n'est pas positive
     */
    public static final int REGLE_MISE_A_PRIX_ERREUR = 20009;
    
    /**
     * Echec quand catégorie n'est pas définie
     */
    public static final int REGLE_CATEGORIE_OBLIGATOIRE = 20010;
}
