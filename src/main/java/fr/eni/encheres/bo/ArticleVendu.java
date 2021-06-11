package fr.eni.encheres.bo;


import java.time.LocalDate;

public class ArticleVendu {
	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private int miseAPrix;
	private int prixVente;
	private EtatVente etatVente;
	private Retrait lieuRetrait;
	private Categorie categorieArticle;
	private Integer noUtilisateur;
	
	
	public ArticleVendu() {
	}


	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int miseAPrix) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
	}

	
	
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int miseAPrix, int prixVente, EtatVente etatVente, Retrait lieuRetrait,
			Categorie categorieArticle) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.lieuRetrait = lieuRetrait;
		this.categorieArticle = categorieArticle;
	}


	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			int miseAPrix, Categorie categorieArticle) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.categorieArticle = categorieArticle;
	}
	
	


	/**
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param miseAPrix
	 * @param categorieArticle
	 * @param noUtilisateur
	 */
	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres,
		LocalDate dateFinEncheres, int miseAPrix, Integer noUtilisateur, Categorie categorieArticle) {
	    this.nomArticle = nomArticle;
	    this.description = description;
	    this.dateDebutEncheres = dateDebutEncheres;
	    this.dateFinEncheres = dateFinEncheres;
	    this.miseAPrix = miseAPrix;
	    this.categorieArticle = categorieArticle;
	    this.noUtilisateur = noUtilisateur;
	}


	public ArticleVendu(String nomArticle, String description, LocalDate dateFinEncheres, int prixVente,
			int noUtilisateur) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateFinEncheres = dateFinEncheres;
		this.prixVente = prixVente;
		this.noUtilisateur = noUtilisateur;
	}


	public int getNoArticle() {
		return noArticle;
	}


	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}


	public String getNomArticle() {
		return nomArticle;
	}


	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}


	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}


	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}


	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}


	public int getMiseAPrix() {
		return miseAPrix;
	}


	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}


	public int getPrixVente() {
		return prixVente;
	}


	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}


	public EtatVente getEtatVente() {
		return etatVente;
	}


	public void setEtatVente(EtatVente etatVente) {
		this.etatVente = etatVente;
	}


	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}


	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}


	public Categorie getCategorieArticle() {
		return categorieArticle;
	}


	public void setCategorieArticle(Categorie categorieArticle) {
		this.categorieArticle = categorieArticle;
	}
	/**
	 * Getter de noUtilisateur
	 * @return noUtilisateur
	 */
	public Integer getNoUtilisateur() {
	    return noUtilisateur;
	}


	/**
	 * Setter de noUtilisateur
	 * @param noUtilisateur étant noUtilisateur à paramétrer de type Integer
	 */
	public void setNoUtilisateur(Integer noUtilisateur) {
	    this.noUtilisateur = noUtilisateur;
	}
	


	@Override
	public String toString() {
		return "ArticleVendu [nomArticle=" + nomArticle + ", description=" + description + ", dateFinEncheres="
				+ dateFinEncheres + ", prixVente=" + prixVente + ", noUtilisateur=" + noUtilisateur + "]";
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ArticleVendu))
			return false;
		ArticleVendu art = (ArticleVendu) obj;
		return (art.nomArticle.equals(nomArticle) && (art.description.equals(description)) && (art.dateFinEncheres.equals(dateFinEncheres)) 
				&& (art.prixVente == prixVente) && (art.noUtilisateur == noUtilisateur));
	}


	
	

}
