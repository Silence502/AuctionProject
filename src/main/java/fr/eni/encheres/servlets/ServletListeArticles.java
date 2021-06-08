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
	List<ArticleVendu> selectionArtMotCle = new ArrayList<ArticleVendu>();
	List<String> selectionNomCat = new ArrayList<String>();
	List<Categorie> selectionCat = new ArrayList<Categorie>();
	String choix = "toutes";
	int numCat;
	String recherche;
       
	
	public void init() throws ServletException { 
		
		// Enregistre dans une variable la liste des catégories
		try {
			selectionCat = categorieDAO.selectAll();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		// Liste seulement l'ensemble des libellés des catégories
		for (Categorie cat : selectionCat) {
			selectionNomCat.add(cat.getLibelle());
		}
		
		super.init(); 
		}

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Enregistre dans une variable la liste des articles
		try {
			selectionArt = articleVenduDAO.selectAll();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("selectionArticles", selectionArt);
		
    	request.setAttribute("listeCategories", selectionNomCat);
    	
    	request.setAttribute("choix", "toutes");
    	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/listeArticles.jsp");
    	
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// on enregistre le choix de la catégorie dans la variable choix
		choix =	request.getParameter("categorie");
		recherche = request.getParameter("recherche");
		
		// On s'assure que le choix n'est pas null
		if (!choix.equals(null)) {
			
			// si le choix est sur une catégorie
			if (!choix.equals("toutes")) { 
				
				// on repère d'abord le numéro de la catégorie correspondant
				try {
					numCat = categorieDAO.selectNoByLibelle(choix);
				} catch (BusinessException e1) {
					e1.printStackTrace();
				}
				
				// on sélectionne tous les articles de la catégorie
				try {
					selectionArt = articleVenduDAO.selectByCategorie(numCat);
				} catch (BusinessException e) {
					e.printStackTrace();
				}	
			}
			
			// sinon on sélectionne tout
			else {
				
				try {
					selectionArt = articleVenduDAO.selectAll();
				} catch (BusinessException e) {
					e.printStackTrace();
				}
			}
			
				if ((!recherche.equals(null)) && (!recherche.equals(""))) {
					try {
						selectionArtMotCle = articleVenduDAO.selectByMotCle(recherche);
						System.out.println(selectionArtMotCle);
						System.out.println(selectionArt);
						selectionArt.retainAll(selectionArtMotCle);
						System.out.println(selectionArt);
					} catch (BusinessException e) {
						e.printStackTrace();
					}
				}
				
			}
					
		request.setAttribute("selectionArticles", selectionArt);
		
		request.setAttribute("listeCategories", selectionNomCat);
		
		request.setAttribute("choix", choix);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/listeArticles.jsp");
    	
		rd.forward(request, response);
		
		
	}
}

