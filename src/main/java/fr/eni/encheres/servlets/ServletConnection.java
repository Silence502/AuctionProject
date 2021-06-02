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

	String pseudo = request.getParameter("pseudo");
	String motDePasse = request.getParameter("motDePasse");

	UtilisateurManager utilisateurManager = new UtilisateurManager();
	Utilisateur utilisateur = utilisateurManager.selectUtilisateur(pseudo, motDePasse);
	request.setAttribute("user", utilisateur);

	try {
	    System.out.println("Pseudo : " + utilisateur.getPseudo());
	    System.out.println("Mot de passe : " + utilisateur.getMotDePasse());
	} catch (NullPointerException e) {
	    e.printStackTrace();
	}

	if (utilisateur != null) {
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/connected.jsp");
	    rd.forward(request, response);
	} else {
	    RequestDispatcher rd = request.getRequestDispatcher("/signin.jsp");
	    rd.forward(request, response);
	}

    }

}
