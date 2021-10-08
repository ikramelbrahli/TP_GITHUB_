package org.projet.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.projet.beans.Logement;
import org.projet.db.LogementDB;

/**
 * Servlet implementation class UpdateLogement
 */
@WebServlet(name = "UpdateLogement" , urlPatterns ="/UpdateLogement")
public class UpdateLogement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLogement() {
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
		int id_proprietaire=Integer.parseInt(request.getParameter("id"));
		int id_logement = Integer.parseInt(request.getParameter("id_logement"));
		String description= request.getParameter("description");
		String titre_logement= request.getParameter("titre_logement");
		int nombre_pieces= Integer.parseInt(request.getParameter("nombre_pieces"));
		String pays= request.getParameter("pays");
		String ville= request.getParameter("ville");
		String rue= request.getParameter("rue");
		int prix=Integer.parseInt(request.getParameter("prix"));
		String disponibilite_move_in=request.getParameter("disponibilite_move_in");
		String disponibilite_move_out=request.getParameter("disponibilite_move_out");
		String regles= request.getParameter("regles");
		int nombre_chambre=Integer.parseInt( request.getParameter("nombre_chambre"));
		int nombre_lit= Integer.parseInt( request.getParameter("nombre_lit"));
		String equipement= request.getParameter("equipement");
		int nombres_coloc = Integer.parseInt(request.getParameter("nombres_coloc"));
		Logement logement = new Logement();
		try {
			java.util.Date sdf = new SimpleDateFormat("yyyy-MM-dd").parse(disponibilite_move_in);
			
			java.sql.Date sqlStartDate = new java.sql.Date(sdf.getTime()); 
			logement.setDisponibilite_move_in(sqlStartDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		try {
			java.util.Date sdf = new SimpleDateFormat("yyyy-MM-dd").parse(disponibilite_move_out);
			java.sql.Date sqlStartDate = new java.sql.Date(sdf.getTime()); 
			logement.setDisponibilite_move_out(sqlStartDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		logement.setColocataires_actuels(nombres_coloc);
		logement.setDescription(description);
		logement.setPays(pays);
		logement.setVille(ville);
		logement.setRue(rue);
		logement.setId_logement(id_logement);
		logement.setEquipements(equipement);
		logement.setNombre_pieces(nombre_pieces);
		logement.setRegles(regles);
		logement.setNombre_chambre(nombre_chambre);
		logement.setNombre_lit(nombre_lit);
		logement.setTitre_logement(titre_logement);
		logement.setId_proprietaire(id_proprietaire);
		logement.setPrix(prix);
		LogementDB logementdb =  new LogementDB();
		try {
			logementdb.updateLogement(logement);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewAllLogement.jsp");
			dispatcher.forward(request, response);	
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
	
	
	}

}
