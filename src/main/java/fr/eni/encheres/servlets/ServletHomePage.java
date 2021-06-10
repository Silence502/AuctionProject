package fr.eni.encheres.servlets;

import java.io.IOException;

import fr.eni.encheres.UtilisateurException;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletHomePage
 */
@WebServlet(description = "Servlet gérant les requêtes de la page d'accueil et de l'inscription", urlPatterns = {
	"/ServletHomePage" })
public class ServletHomePage extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final boolean IS_EXISTS = true;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
	rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// Ouverture d'une session
	HttpSession session = request.getSession();

	// Récupération des informations saisie dans le formulaire
	String nom = request.getParameter("nom");
	String prenom = request.getParameter("prenom");
	String email = request.getParameter("email");
	String telephone = request.getParameter("telephone");
	String rue = request.getParameter("rue");
	String codePostal = request.getParameter("codePostal");
	String ville = request.getParameter("ville");
	String motDePasse = request.getParameter("motDePasse");
	String pseudo = request.getParameter("pseudo");
	Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
		motDePasse);
	// Test de validité
	if (pseudo.length() < 4) {
	    // Si la taille du pseudo est inférieure à 4
	    int tooSmallId = pseudo.length();
	    // Sauvegarde des informations saisie dans le formulaire pour éviter
	    // à l'utilisateur de recommencer
	    request.setAttribute("user", utilisateur);
	    request.setAttribute("tooSmall", tooSmallId);
	    // Fermeture de la session après 1 seconde pour éviter le cumul d'avertissements
	    // Délégation de la requête à la même page pour que l'utilisateur réitère sa
	    // requête
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
	    rd.forward(request, response);
	} else {

	    try {
		try {
		    // Si la saisie du pseudo est valide on construit l'utilisateur avec les données
		    // saisies
		    UtilisateurManager utilisateurManager = new UtilisateurManager();
		    // On ajoute l'utilisateur construit à la classe utilisateurManager pour
		    // l'envoyer à la BDD
		    utilisateurManager.addUtilisateur(utilisateur);
		} catch (NullPointerException e) {
		    e.printStackTrace();
		    // On garde en mémoire le pseudo et le mot de passe pour l'ajouter
		    // automatiquement
		    // au formulaire de connexion pour le confort de l'utilisateur
		    session.setAttribute("user", utilisateur);
		    // Délégation de la requête à l'affichage des félicitations
		    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/congratulation.jsp");
		    rd.forward(request, response);
		}
	    } catch (UtilisateurException e) {
		// Si lors de l'envoie à la base de données le pseudo ou l'email correspondent
		// à un utilisateur déjà enregistré...
		// On passe false à un attribut de session pour l'affichage du warning à
		// l'utilisateur
		request.setAttribute("alreadyExistsSession", IS_EXISTS);
		// On sauvegarde les informations saisies dans le formulaire hormis le pseudo et
		// l'email
		request.setAttribute("user", utilisateur);
		// Fermeture de la session après 1 seconde pour éviter le cumul d'avertissements
		// Délégation de la requête à la même page pour que l'utilisateur réitère sa
		// requête
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
		rd.forward(request, response);
	    }
	}
    }
}
