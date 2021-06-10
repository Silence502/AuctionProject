package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.UtilisateurException;
import fr.eni.encheres.bo.Utilisateur;

public interface UtilisateurDAO {
    public void insert(Utilisateur utilisateur) throws UtilisateurException, NullPointerException;
    public Utilisateur selectById(int id);
    public List<Utilisateur> selectAll();
    public void update(Utilisateur utilisateur) throws UtilisateurException, NullPointerException;
    public void delete(int id);
    public Utilisateur selectByPseudo(String pseudo, String mdp);
}
