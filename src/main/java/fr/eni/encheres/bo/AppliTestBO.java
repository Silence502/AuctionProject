package fr.eni.encheres.bo;

import java.time.LocalDate;

public class AppliTestBO {

    public static void main(String[] args) {
	//Test constructeurs
	
	Utilisateur user = new Utilisateur(1,"silence","Vidal","Mickael","email@meil.com","0601122345","12 rue du charme","10000","Troyes","Pa$$w0rd",0,0);
	System.out.println(user.toString());
	
	// Affichage d'un article 
	
	LocalDate dateDebut = LocalDate.of(2021, 6, 5);
	LocalDate dateFin = LocalDate.of(2021, 6, 10);
	Retrait lieuRetrait = new Retrait("Rue Principale", "59000", "Lille");
	Categorie cat = new Categorie(2, "MAISON");
	ArticleVendu unArticle = new ArticleVendu (1, "Fauteuil", "Très moelleux", dateDebut, dateFin, 200, 389, EtatVente.TERMINEE, lieuRetrait, cat); 
	System.out.println("\nREM : Affichage d'un article Stylo 'Bic'");
	System.out.println(unArticle.toString());
    }

}
