package fr.eni.encheres.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.ArticleVenduManager;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;
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
@WebServlet("/ServletAjoutArticle")
public class ServletAjoutArticle extends HttpServlet {
    private static final long serialVersionUID = 1L;
    CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();
    List<Categorie> selectionCat = new ArrayList<Categorie>();
    List<String> selectionNomCat = new ArrayList<String>();
    BusinessException exception = new BusinessException();

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
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	request.setAttribute("listeCategories", selectionNomCat);
	
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ajoutArticle.jsp");
	rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	LocalDate dateDebut;
	LocalDate dateFin;
	String num = request.getParameter("id");
	    Integer noUtilisateur = Integer.parseInt(num);
	    String nom = request.getParameter("nom");
	    String description = request.getParameter("description");
	    dateDebut = LocalDate.parse(request.getParameter("date_debut"));
	    dateFin = LocalDate.parse(request.getParameter("date_fin"));
	    int miseAPrix = Integer.parseInt(request.getParameter("mise_a_prix"));// }
	    Categorie cat = new Categorie();
	    cat.setLibelle(request.getParameter("categorie"));
	try {
	    cat.setNoCategorie(categorieDAO.selectNoByLibelle(cat.getLibelle()));
	    Utilisateur user = new Utilisateur();
	    user.setNoUtilisateur(noUtilisateur);
	    UtilisateurManager userManager = new UtilisateurManager();
	    userManager.selectById(user.getNoUtilisateur());
	    ArticleVendu articleVendu = new ArticleVendu(nom, description, dateDebut, dateFin, miseAPrix, user.getNoUtilisateur(),
		    cat);
	    ArticleVenduManager articleVenduManager = new ArticleVenduManager();
	    articleVenduManager.ajouter(articleVendu, user);
	    request.setAttribute("articleVendu", articleVendu);
	}

	catch (BusinessException e) {

	    request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
	}

	catch (NumberFormatException nfe) {

	    exception.ajouterErreur(CodesResultatServlets.REGLE_MISE_A_PRIX_OBLIGATOIRE);
	    request.setAttribute("listeCodesErreur", exception.getListeCodesErreur());
	}

	catch (DateTimeParseException dtpe) {

	    exception.ajouterErreur(CodesResultatServlets.REGLE_DATE_OBLIGATOIRE);
	    request.setAttribute("listeCodesErreur", exception.getListeCodesErreur());
	}

	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ajoutArticle.jsp");
	request.setAttribute("listeCategories", selectionNomCat);
	rd.forward(request, response);
    }

}
