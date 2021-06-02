package fr.eni.encheres.dal;

import java.util.List;


import fr.eni.encheres.bo.Utilisateur;

public interface UtilisateurDAO {
    public void insert(Utilisateur utilisateur);
    public Utilisateur selectById(int id);
    public List<Utilisateur> selectAll();
    public void update(Utilisateur utilisateur);
    public void delete(int id);
}
