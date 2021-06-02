package fr.eni.encheres.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletConnection
 */
@WebServlet("/ServletConnection")
public class ServletConnection extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	//Récupération des champs du formulaire d'inscription
	String pseudo = request.getParameter("pseudo");
	String motDePasse = request.getParameter("motDePasse");
	int isCorrect = 0;
	
	//Récupération et reconstruction de l'utilisateur depuis la BDD
	UtilisateurManager utilisateurManager = new UtilisateurManager();
	Utilisateur utilisateur = utilisateurManager.selectUtilisateur(pseudo, motDePasse);
	request.setAttribute("user", utilisateur);
	request.setAttribute("isCorrect", isCorrect);

	if (utilisateur != null) {
	    //Si le constructeur à récupéré toutes les données
	    response.sendRedirect("home.jsp");
	} else {
	    //Si le constructeur n'a récupéré aucune données
	    response.sendRedirect("signin.jsp");
	    isCorrect = 1;
	}

    }

}
