package fr.eni.encheres.servlets;

import java.io.IOException;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletHomePage
 */
@WebServlet(description = "Servlet gérant les requêtes de la page d'accueil", urlPatterns = { "/ServletHomePage" })
public class ServletHomePage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	
	String con = request.getParameter("connexion");
	String ins = request.getParameter("inscription");
	
	RequestDispatcher rd;
	
	if (con != null) {
	    rd = request.getRequestDispatcher("/WEB-INF/jsp/signin.jsp");
	    rd.forward(request, response);
	} else if (ins != null) {
	    rd = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
	    rd.forward(request, response);
	}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	Utilisateur utilisateur = new Utilisateur();
	
	String pseudo = request.getParameter("pseudo");
	String nom = request.getParameter("nom");
	String prenom = request.getParameter("prenom");
	String email = request.getParameter("email");
	String telephone = request.getParameter("telephone");
	String rue = request.getParameter("rue");
	String codePostal = request.getParameter("codePostal");
	String ville = request.getParameter("ville");
	String motDePasse = request.getParameter("motDePasse");
	
	utilisateur.setPseudo(pseudo);
	utilisateur.setNom(nom);
	utilisateur.setPrenom(prenom);
	utilisateur.setEmail(email);
	utilisateur.setTelephone(telephone);
	utilisateur.setRue(rue);
	utilisateur.setCodePostal(codePostal);
	utilisateur.setVille(ville);
	utilisateur.setMotDePasse(motDePasse);
	
	UtilisateurManager utilisateurManager = new UtilisateurManager();
	utilisateurManager.addUtilisateur(utilisateur);
	
	RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
	rd.forward(request, response);
    }
}
