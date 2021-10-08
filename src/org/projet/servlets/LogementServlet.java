package org.projet.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
import org.projet.db.LogementDB;
import org.projet.db.ProprietaireDB;

/**
 * Servlet implementation class LogementServlet
 */
@WebServlet(name = "LogementServlet" , urlPatterns ="/LogementServlet")
public class LogementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogementServlet() {
        super(); 
        // TODO Auto-generated constructor stub
    }
	private void ViewAllLogement(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ClassNotFoundException, SQLException{
		int id = Integer.parseInt(request.getParameter("id"));
		LogementDB logementdb = new LogementDB();		
		List<Logement> listLogement = logementdb.getLogement_all(id);
		HttpSession session = request.getSession();
		session.setAttribute("listLogement", listLogement);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewAllLogement.jsp");
			dispatcher.forward(request, response);	
	}
	
	private void ViewLogement(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ClassNotFoundException, SQLException{
		int id = Integer.parseInt(request.getParameter("id"));
		LogementDB logementdb = new LogementDB();
		Logement logement = logementdb.getLogementbyID(id);
		List<Logement> listRate = logementdb.ShowRate(id);
		HttpSession session = request.getSession();
		session.setAttribute("logement",  logement );
		session.setAttribute("listRate",  listRate );
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewLogementbyId.jsp");
			dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch(action) {
		case "AddLogement" :
			AddLogement(request,response);
			break ;
		case "UpdateLogement" :
			try {
				UpdateLogement(request,response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			break ;
		case "ViewLogement":
		
			try {
				ViewLogement(request,response);
				
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break ;
		
		case "ViewAllLogement" :
			try {
				ViewAllLogement(request,response);
				
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break ;	
		case "FindLogement":
			try {
				FindLogement(request,response);
				
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break ;	
		
		
		
		case "deleteLogement" :
			try {
				DeleteLogement(request,response);
			}catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break ;
		}

	}
	private void AddLogement(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		ProprietaireDB proprietairedb = new ProprietaireDB();
		try {
			Proprietaire prop = proprietairedb.getProprietaireById(id);
			request.setAttribute("prop", prop);
			RequestDispatcher dispatcher = request.getRequestDispatcher("AddLogement.jsp");
			dispatcher.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void UpdateLogement(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ClassNotFoundException, SQLException{
		int id = Integer.parseInt(request.getParameter("id"));
		LogementDB logementdb = new LogementDB();
		Logement logement = logementdb.getLogementbyID(id);
		HttpSession session = request.getSession();
		session.setAttribute("logement",  logement );
		RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateLogement.jsp");
		dispatcher.forward(request, response);	
	}
	private void DeleteLogement(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ClassNotFoundException, SQLException{
		int id = Integer.parseInt(request.getParameter("id"));
		LogementDB logementdb = new LogementDB();
		logementdb.deleteLogement(id);	 
		int id_prop = 	Integer.parseInt(request.getParameter("id_proprietaire"));	
		List<Logement> listLogement = logementdb.getLogement_all(id_prop);
		HttpSession session = request.getSession();
		session.setAttribute("listLogement", listLogement);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewAllLogement.jsp");
			dispatcher.forward(request, response);		
	
	}
	private void FindLogement(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ClassNotFoundException, SQLException{
		String disponibilite_move_in=request.getParameter("disponibilite_move_in");
		String disponibilite_move_out=request.getParameter("disponibilite_move_out");
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
		LogementDB logementdb =  new LogementDB();
		try {
			List<Logement> listLogement=logementdb.FindLogement(logement);
			HttpSession session = request.getSession();
			session.setAttribute("listLogement", listLogement);
			RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
			dispatcher.forward(request, response);	
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id_proprietaire=Integer.parseInt(request.getParameter("id"));
		String description= request.getParameter("description");
		String titre_logement= request.getParameter("titre_logement");
		int nombre_pieces= Integer.parseInt(request.getParameter("nombre_pieces"));
		String pays= request.getParameter("pays");
		String ville= request.getParameter("ville");
		String rue= request.getParameter("rue");
		int nombres_coloc = Integer.parseInt(request.getParameter("nombres_coloc"));
		int prix=Integer.parseInt(request.getParameter("prix"));
		String disponibilite_move_in=request.getParameter("disponibilite_move_in");
		String disponibilite_move_out=request.getParameter("disponibilite_move_out");
		String regles= request.getParameter("regles");
		int nombre_chambre=Integer.parseInt( request.getParameter("nombre_chambre"));
		int nombre_lit= Integer.parseInt( request.getParameter("nombre_lit"));
		String equipement[] = request.getParameterValues("equipement");
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
		logement.setEquipement(equipement);
		logement.setNombre_pieces(nombre_pieces);
		logement.setRegles(regles);
		logement.setNombre_chambre(nombre_chambre);
		logement.setNombre_lit(nombre_lit);	
		logement.setTitre_logement(titre_logement);
		logement.setId_proprietaire(id_proprietaire);
		logement.setPrix(prix);
		LogementDB logementdb =  new LogementDB();
		try {
			logementdb.addLogement(logement);
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
	
	}
	

}
