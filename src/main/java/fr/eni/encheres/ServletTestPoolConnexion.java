package fr.eni.encheres;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ServletTestPoolConnexion
 */
@WebServlet("/ServletTestPoolConnexion")
public class ServletTestPoolConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			Context context = new InitialContext();
			
			//Recherche de la datasource
			DataSource datasource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
			//Demande une connexion. La méthode getConnexion met la demande en attente tant qu'il n'y a pas de connexion disponible dans le pool.
			Connection cnx = datasource.getConnection();
			out.print("La connexion est " + (cnx.isClosed()?"fermée":"ouverte")+".");
			//Libérer la connexion lorsque l'on en n'a plus besoin
			cnx.close(); // connexion non fermée mais remise dans le pool
			
		} catch (NamingException | SQLException e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
			out.println("Une erreur est survenue lors de l'utilisation de la base de données :" + e.getMessage());
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
