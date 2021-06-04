package fr.eni.encheres.bll;

import fr.eni.encheres.UtilisateurException;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {
    private static UtilisateurDAO utilisateurDAO;
    
    public UtilisateurManager() {
	utilisateurDAO = DAOFactory.getUtilisateurDAO();
    }
    
    public void addUtilisateur(Utilisateur u) throws UtilisateurException {
	utilisateurDAO.insert(u);
    }
    
    public Utilisateur selectUtilisateur(String pseudo, String mdp) {
	Utilisateur user = new Utilisateur();
	user = utilisateurDAO.selectByPseudo(pseudo, mdp);
	return user;
    }
    
    public Utilisateur selectById(int id) {
	Utilisateur user = new Utilisateur();
	user = utilisateurDAO.selectById(id);
	return user;
    }
}
