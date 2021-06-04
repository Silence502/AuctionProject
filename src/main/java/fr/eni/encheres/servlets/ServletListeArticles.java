package fr.eni.encheres.servlets;

import java.io.IOException;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.ArticleVenduManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.ArticleVenduDAO;
import fr.eni.encheres.dal.CategorieDAO;
import fr.eni.encheres.dal.DAOFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAjoutAvis
 */
@WebServlet("/ServletListeArticles")
public class ServletListeArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();
	ArticleVenduDAO articleVenduDAO = DAOFactory.getArticleVenduDAO();
	List<ArticleVendu> selectionArt = new ArrayList<ArticleVendu>();
	List<String> selectionNomCat = new ArrayList<String>();
       
    

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		try {
			selectionArt = articleVenduDAO.selectAll();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
    	request.setAttribute("selectionArticles", selectionArt);
    	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/listeArticles.jsp");
    	
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
	}

}
