package org.projet.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.projet.beans.Locataire;
import org.projet.beans.Proprietaire;
import org.projet.db.LocataireDB;
import org.projet.db.ProprietaireDB;

/**
 * Servlet implementation class LocataireServlet
 */
@WebServlet("/LocataireServlet")
public class LocataireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocataireServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	private void UpdateProfile(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		LocataireDB locatairedb = new LocataireDB();
		try {
			Locataire locataire = locatairedb.getLocataireById(id);
			request.setAttribute("locataire", locataire);
			RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateProfileLocataire.jsp");
			dispatcher.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void ViewProfile(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		LocataireDB locatairedb = new LocataireDB();
		try {
			Locataire locataire = locatairedb.getLocataireById(id);
			request.setAttribute("locataire", locataire);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewProfileLocataire.jsp");
			dispatcher.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		
		switch(action) {

		case "UpdateProfile":
				UpdateProfile(request, response);
				break;
		case "ViewProfile" :
				ViewProfile(request,response);
				break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		int id = Integer.parseInt(request.getParameter("id"));
		String description= request.getParameter("description");

		String sexe= request.getParameter("sexe");
        int age = Integer.parseInt(request.getParameter("age"));  
        String organisation=request.getParameter("organisation");
        String fumer=request.getParameter("fumer");
        String nettoyage=request.getParameter("nettoyage");
        int GSM=Integer.parseInt(request.getParameter("GSM"));
        String nom =request.getParameter("nom");
        String prenom =request.getParameter("prenom");
        String email =request.getParameter("email");
        int budget = Integer.parseInt(request.getParameter("budget"));
        String profession = request.getParameter("profession");
        int nombre_personnes =Integer.parseInt(request.getParameter("nombre_personnes"));
      
        Locataire locataire = new Locataire();    
        locataire.setId_user(id);
        locataire.setDescription(description);
        locataire.setSexe(sexe);
        locataire.setOrganisation(organisation);
        locataire.setFumer(fumer);
        locataire.setNettoyage(nettoyage);
        locataire.setGSM(GSM);
        locataire.setAge(age);
        locataire.setNom(nom);
        locataire.setEmail(email);
        locataire.setPrenom(prenom);
        locataire.setBudget(budget);
        locataire.setProfession(profession);
        locataire.setNombre_personnes(nombre_personnes);

        LocataireDB locatairedb = new LocataireDB();
        try {
        	locatairedb.updateProfile(locataire);    
       	 
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
