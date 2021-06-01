package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {
    private static UtilisateurDAO utilisateurDAO;
    
    public UtilisateurManager() {
	utilisateurDAO = DAOFactory.getUtilisateurDAO();
    }
    
    public void addUtilisateur(Utilisateur u) {
	utilisateurDAO.insert(u);
    }
}
