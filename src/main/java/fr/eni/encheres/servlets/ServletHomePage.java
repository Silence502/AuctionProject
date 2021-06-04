package fr.eni.encheres.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.UtilisateurException;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.CodesResultatDAL;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletHomePage
 */
@WebServlet(description = "Servlet gérant les requêtes de la page d'accueil et de l'inscription", urlPatterns = { "/ServletHomePage" })
public class ServletHomePage extends HttpServlet {
    private static final long serialVersionUID = 1L;

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
	

	String pseudo = request.getParameter("pseudo");
	String nom = request.getParameter("nom");
	String prenom = request.getParameter("prenom");
	String email = request.getParameter("email");
	String telephone = request.getParameter("telephone");
	String rue = request.getParameter("rue");
	String codePostal = request.getParameter("codePostal");
	String ville = request.getParameter("ville");
	String motDePasse = request.getParameter("motDePasse");

	Utilisateur utilisateur = new Utilisateur(pseudo,nom,prenom,email,telephone,rue,codePostal,ville,motDePasse);

	UtilisateurManager utilisateurManager = new UtilisateurManager();

	try {
	    utilisateurManager.addUtilisateur(utilisateur);
	} catch (UtilisateurException e) {
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/is_exist_error.jsp");
	    rd.forward(request, response);
	}

	RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
	rd.forward(request, response);
    }
}
