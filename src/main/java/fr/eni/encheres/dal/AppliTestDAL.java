package fr.eni.encheres.dal;


import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Categorie;


public class AppliTestDAL {
	
	public static void main(String[] args) {
		
		//Déclaration et instanciation de la DAO
			CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();
		
		List<Categorie> selectionCat = null;
		
		try {
			selectionCat = categorieDAO.selectAll();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
				
		System.out.println(selectionCat);
	
		
		

		
	}
}
