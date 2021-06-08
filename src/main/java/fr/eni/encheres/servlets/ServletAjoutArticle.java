package fr.eni.encheres.servlets;

import java.io.IOException;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.ArticleVenduManager;
import fr.eni.encheres.bll.CodesResultatBLL;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.CategorieDAO;
import fr.eni.encheres.dal.DAOFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAjoutAvis
 */
@WebServlet("/ServletAjoutArticle")
public class ServletAjoutArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();
	List<Categorie> selectionCat = new ArrayList<Categorie>();
	List<String> selectionNomCat = new ArrayList<String>();
       
	public void init() throws ServletException { 
		
		
	try {
		selectionCat = categorieDAO.selectAll();
	} catch (BusinessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	for (Categorie cat : selectionCat) {
		selectionNomCat.add(cat.getLibelle());
	}
	
	super.init(); 
	}

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

    	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ajoutArticle.jsp");
		
		request.setAttribute("listeCategories", selectionNomCat);
    	
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String nom;
		String description;
		LocalDate dateDebut;
		LocalDate dateFin;
		int miseAPrix;
		
		try
		{
			nom = request.getParameter("nom");
			description = request.getParameter("description");
			dateDebut = LocalDate.parse(request.getParameter("date_debut"));
			dateFin = LocalDate.parse(request.getParameter("date_fin"));
			
		//	try {
			miseAPrix = Integer.parseInt(request.getParameter("mise_a_prix"));//}
			
		//	catch (BusinessException e) {
			
		//.ajouterErreur(CodesResultatBLL.REGLE_MISE_A_PRIX_OBLIGATOIRE);}
			
			
			
			Categorie cat = new Categorie();
			cat.setLibelle(request.getParameter("categorie"));
			cat.setNoCategorie(categorieDAO.selectNoByLibelle(cat.getLibelle()));
			ArticleVenduManager articleVenduManager = new ArticleVenduManager();
			ArticleVendu articleVendu = articleVenduManager.ajouter(nom, description, dateDebut, dateFin, miseAPrix, cat);
			request.setAttribute("articleVendu", articleVendu);
		}
		
		catch (BusinessException e) {
	
			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ajoutArticle.jsp");
		request.setAttribute("listeCategories", selectionNomCat);
		rd.forward(request, response);
	}

}
