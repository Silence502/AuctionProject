package fr.eni.encheres.servlets;

import java.io.IOException;

import fr.eni.encheres.UtilisateurException;
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
 * Servlet implementation class ServletProfileManager
 */
@WebServlet("/ServletProfileManager")
public class ServletProfileManager extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final boolean IS_EXISTS = false;
    private final boolean CHANGED = true;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/profile.jsp");
	rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();

	String pseudo = request.getParameter("pseudo");
	String nom = request.getParameter("nom");
	String prenom = request.getParameter("prenom");
	String email = request.getParameter("email");
	String telephone = request.getParameter("telephone");
	String rue = request.getParameter("rue");
	String codePostal = request.getParameter("codePostal");
	String ville = request.getParameter("ville");
	String motDePasse = request.getParameter("motDePasse");
	String mdp_tocheck = request.getParameter("mdp_tocheck");
	String num = request.getParameter("id");
	Integer noUtilisateur = Integer.parseInt(num);

	if (pseudo.length() < 4) {
	    // Si le nouveau pseudo saisie est inf??rieur ?? 4 caract??res
	    int tooSmallId = pseudo.length();
	    request.setAttribute("tooSmall", tooSmallId);
	    // On re-dispatche ?? la m??me page
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/profile.jsp");
	    rd.forward(request, response);
	} else if (!motDePasse.equals(mdp_tocheck)) {
	    request.setAttribute("isNotOk", false);
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/profile.jsp");
	    rd.forward(request, response);
	} else {
	    // Si le pseudo est valide on construit l'utilisateur
	    Utilisateur utilisateur = new Utilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue,
		    codePostal, ville, motDePasse);
	    try {
		// Et on initialise le manager
		UtilisateurManager userManager = new UtilisateurManager();
		// On ajoute l'utilisateur au manager qui v??rifie l'existance du pseudo et du
		// mail
		userManager.updateUtilisateur(utilisateur);
		// On r??cup??re les nouvelles informations dans la session
		session.setAttribute("user", utilisateur);
		// On remplace l'attribut de session par le nouvel utilisateur
		request.setAttribute("changedSession", CHANGED);
		RequestDispatcher rd = request.getRequestDispatcher("/ServletHomeConnected");
		rd.forward(request, response);
	    } catch (UtilisateurException e) {
		e.getMessage();
		// Si les donn??es correspondent ?? un utilisateur existant on passe un attribut
		// de session ?? false
		request.setAttribute("alreadyExistsSession", IS_EXISTS);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/profile.jsp");
		rd.forward(request, response);
	    }
	}
    }
}
