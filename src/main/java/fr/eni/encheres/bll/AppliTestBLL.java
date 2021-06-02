package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.jdbc.UtilisateurDAOJdbcImpl;

public class AppliTestBLL {

    public static void main(String[] args) {
	Utilisateur user = new Utilisateur();
	UtilisateurManager userManager = new UtilisateurManager();
	user = userManager.selectById(1);
	
	System.out.println(user.getPseudo());
    }
}