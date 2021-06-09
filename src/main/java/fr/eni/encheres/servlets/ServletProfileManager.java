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
	HttpSession sessionChanging = request.getSession();

	String pseudo = request.getParameter("pseudo");
	String nom = request.getParameter("nom");
	String prenom = request.getParameter("prenom");
	String email = request.getParameter("email");
	String telephone = request.getParameter("telephone");
	String rue = request.getParameter("rue");
	String codePostal = request.getParameter("codePostal");
	String ville = request.getParameter("ville");
	String motDePasse = request.getParameter("motDePasse");
	String num = request.getParameter("id");
	Integer noUtilisateur = Integer.parseInt(num);

	if (pseudo.length() < 4) {
	    // Si le nouveau pseudo saisie est inférieur à 4 caractères
	    int tooSmallId = pseudo.length();
	    sessionChanging.setAttribute("tooSmall", tooSmallId);
	    sessionChanging.setMaxInactiveInterval(1);
	    // On re-dispatche à la même page
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/profile.jsp");
	    rd.forward(request, response);
	} else {
	    // Si le pseudo est valide on construit l'utilisateur
	    Utilisateur utilisateur = new Utilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue,
		    codePostal, ville, motDePasse);
	    // Et on initialise le manager
	    UtilisateurManager userManager = new UtilisateurManager();
	    try {
		// On ajoute l'utilisateur au manager qui vérifie l'existance du pseudo et du mail
		userManager.updateUtilisateur(utilisateur);
		// On récupère les nouvelles informations dans la session
		session.setAttribute("idSession", utilisateur.getNoUtilisateur());
		session.setAttribute("userSession", utilisateur.getPseudo());
		session.setAttribute("nomSession", utilisateur.getNom());
		session.setAttribute("prenomSession", utilisateur.getPrenom());
		session.setAttribute("emailSession", utilisateur.getEmail());
		session.setAttribute("telSession", utilisateur.getTelephone());
		session.setAttribute("rueSession", utilisateur.getRue());
		session.setAttribute("cpSession", utilisateur.getCodePostal());
		session.setAttribute("villeSession", utilisateur.getVille());
		session.setAttribute("creditSession", utilisateur.getCredit());
		session.setAttribute("mdpSession", utilisateur.getMotDePasse());
		sessionChanging.setAttribute("changedSession", CHANGED);
		response.sendRedirect("home.jsp");
	    } catch (UtilisateurException e) {
		e.getMessage();
		// Si les données correspondent à un utilisateur existant on passe un attribut de session à false
		session.setAttribute("alreadyExistsSession", IS_EXISTS);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/profile.jsp");
		rd.forward(request, response);
	    }
	    //sessionChanging.invalidate();
	}
    }
}
