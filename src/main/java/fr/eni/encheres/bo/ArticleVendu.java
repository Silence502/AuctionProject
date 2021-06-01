package fr.eni.encheres.bo;

import java.io.Serializable;
import java.time.LocalDate;

public class ArticleVendu implements Serializable {
	
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
	
	
	public ArticleVendu() {
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
			int miseAPrix, int prixVente, EtatVente etatVente, Retrait lieuRetrait, Categorie categorieArticle) {
		super();
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
			int miseAPrix, int prixVente, Retrait lieuRetrait, Categorie categorieArticle) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.lieuRetrait = lieuRetrait;
		this.categorieArticle = categorieArticle;
		this.etatVente = EtatVente.NON_DEBUTEE; // Quand la création de la vente se fait, l'état de la vente est logiquement à NON_DEBUTEE
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


	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix="
				+ miseAPrix + ", prixVente=" + prixVente + ", etatVente=" + etatVente + ", lieuRetrait=" + lieuRetrait
				+ ", categorieArticle=" + categorieArticle + "]";
	}
	
	
	
	
	

}
