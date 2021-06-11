package fr.eni.encheres.servlets;

import java.io.IOException;
import java.util.List;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletMembersList
 */
@WebServlet("/ServletMembersList")
public class ServletMembersList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	UtilisateurManager utilisateurMananger = new UtilisateurManager();
	List<Utilisateur> utilisateurs = utilisateurMananger.getUtilisateur();
	request.setAttribute("userList", utilisateurs);
	System.out.println(utilisateurs.size());
	
	
	
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/membersList.jsp");
	rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	RequestDispatcher rd = request.getRequestDispatcher("/membersList.jsp");
	rd.forward(request, response);
	
    }

}
