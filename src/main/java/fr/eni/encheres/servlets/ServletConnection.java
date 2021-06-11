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
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletConnection
 */
@WebServlet("/ServletConnection")
public class ServletConnection extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final boolean IS_NOT_CORRECT = false;
    private final boolean IS_CORRECT = true;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// Obtention de la session en cours
	HttpSession session = request.getSession();
	// Si une session existe bel et bien on déconnecte
	if (session != null) {
	    session.invalidate();
	}
	// Retour à la page d'accueil
	RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
	rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();

	// Récupération des champs du formulaire d'inscription
	String id = request.getParameter("id");
	String motDePasse = request.getParameter("motDePasse");

	// Récupération et reconstruction de l'utilisateur depuis la BDD
	UtilisateurManager utilisateurManager = new UtilisateurManager();
	Utilisateur utilisateur = utilisateurManager.selectUtilisateur(id, motDePasse);

	if (utilisateur != null) {
	    // Si le constructeur à récupéré toutes les données
	    if (utilisateur.getMotDePasse().equalsIgnoreCase(motDePasse)) {
		// Si le mot de passe correspond
		session.setAttribute("user", utilisateur);
		session.setAttribute("userConnected", IS_CORRECT);
		RequestDispatcher rd = request.getRequestDispatcher("/ServletHomeConnected");
		rd.forward(request, response);
	    } else {
		// Si le mot de passe ne correspond pas
		request.setAttribute("connected", IS_NOT_CORRECT);
		RequestDispatcher rd = request.getRequestDispatcher("/signin.jsp");
		rd.forward(request, response);
	    }
	} else {
	    // Si le constructeur n'a récupéré aucune données
	    request.setAttribute("connected", IS_NOT_CORRECT);
	    RequestDispatcher rd = request.getRequestDispatcher("/signin.jsp");
	    rd.forward(request, response);
	}
    }
}
