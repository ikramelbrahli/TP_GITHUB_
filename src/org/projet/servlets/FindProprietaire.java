package org.projet.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.projet.beans.Logement;
import org.projet.beans.Proprietaire;
import org.projet.db.ProprietaireDB;

/**
 * Servlet implementation class FindProprietaire
 */
@WebServlet(name = "FindProprietaire" , urlPatterns ="/FindProprietaire")
public class FindProprietaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindProprietaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nettoyage= request.getParameter("nettoyage");
		String fumer= request.getParameter("fumer");
		String organisation= request.getParameter("organisation");
		String sexe = request.getParameter("sexe");
		int age = Integer.parseInt(request.getParameter("age"));
		int budget = Integer.parseInt(request.getParameter("budget"));
		Proprietaire prop = new Proprietaire();
		prop.setAge(age);
		prop.setSexe(sexe);
		prop.setOrganisation(organisation);
		prop.setFumer(fumer);
		prop.setNettoyage(nettoyage);
		prop.setTemps_de_reponse(budget);
		ProprietaireDB proprietairedb = new ProprietaireDB();
		try {
			List<Proprietaire> listProprietaire=proprietairedb.FindProprietaire(prop);
			HttpSession session = request.getSession();
			session.setAttribute("listProprietaire", listProprietaire);
			RequestDispatcher dispatcher = request.getRequestDispatcher("FindProprietaire.jsp");
			dispatcher.forward(request, response);	
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
	}

}
