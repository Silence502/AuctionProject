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
 * Servlet implementation class ServletMemberDetails
 */
@WebServlet("/ServletMemberDetails")
public class ServletMemberDetails extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String pseudo = request.getParameter("detail_pseudo");
	String nom = request.getParameter("detail_nom");
	String prenom = request.getParameter("detail_prenom");
	String email = request.getParameter("detail_email");
	String telephone = request.getParameter("detail_telephone");
	String rue = request.getParameter("detail_rue");
	String codePostal = request.getParameter("detail_cp");
	String ville = request.getParameter("detail_ville");

	Utilisateur member = new Utilisateur(pseudo,nom,prenom,email,telephone,rue,codePostal,ville);
	
	request.setAttribute("member", member);
	
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/memberProfile.jsp");
	rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doGet(request, response);
    }

}
