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

import org.projet.beans.Locataire;
import org.projet.beans.Logement;
import org.projet.beans.Proprietaire;
import org.projet.beans.Reservation;
import org.projet.db.LocataireDB;
import org.projet.db.LogementDB;
import org.projet.db.ProprietaireDB;
import org.projet.db.ReservationDB;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet(name = "ReservationServlet" , urlPatterns ="/ReservationServlet")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    private void ViewAllReservations(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ClassNotFoundException, SQLException{
		int id_user = Integer.parseInt(request.getParameter("id"));
		LocataireDB locatairedb = new LocataireDB();
		Locataire locataire = locatairedb.getLocataireById(id_user);
		int id_locataire= locataire.getId_locataire() ;
		ReservationDB reservationdb = new ReservationDB();		
		List<Reservation> listReservation = reservationdb.getReservation_all(id_locataire);
		HttpSession session = request.getSession();
		session.setAttribute("listReservation", listReservation );
		session.setAttribute("locataire", locataire);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewReservations.jsp");
		dispatcher.forward(request, response);	
		
	}
    private void ViewAllReservationsProp(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ClassNotFoundException, SQLException{
		int id_user = Integer.parseInt(request.getParameter("id"));
		ProprietaireDB proprietairedb = new ProprietaireDB();
		Proprietaire proprietaire = proprietairedb.getProprietaireById(id_user);
		int id_proprietaire= proprietaire.getId_proprietaire() ;
		ReservationDB reservationdb = new ReservationDB();		
		List<Reservation> listReservation = reservationdb.getReservation_prop(id_proprietaire);
		HttpSession session = request.getSession();
		session.setAttribute("listReservation", listReservation );
		session.setAttribute("proprietaire", proprietaire);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateStatut.jsp");
		dispatcher.forward(request, response);	
	}
    
	

	private void DeleteReservation(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ClassNotFoundException, SQLException{
		int id = Integer.parseInt(request.getParameter("id"));
		ReservationDB reservationdb = new ReservationDB();
		reservationdb.deleteReservation(id);	
		RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateStatut.jsp");
		dispatcher.forward(request, response);	

	}
	private void AddReservation(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		int id_logement = Integer.parseInt(request.getParameter("id_logement"));
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			LocataireDB locatairedb = new LocataireDB();
			LogementDB logementdb = new LogementDB();
			Logement logement = logementdb.getLogementbyID(id_logement);
			Locataire locataire = locatairedb.getLocataireById(id);
			HttpSession session = request.getSession();
			session.setAttribute("locataire", locataire);
			session.setAttribute("logement",logement);
			RequestDispatcher dispatcher = request.getRequestDispatcher("AddReservation.jsp");
			dispatcher.forward(request, response);	
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch(action) {
		
	
		
		case "ViewAllReservations" :
			try {
				ViewAllReservations(request,response);
				
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break ;	
		case "AddReservation" :
			try {
				AddReservation(request,response);
				
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break ;	
		
	
		case "ViewAllReservationsProp" :
			try {
				ViewAllReservationsProp(request,response);
				
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break ;
		
		
		case "deleteReservation" :
			try {
				DeleteReservation(request,response);
			}catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break ;
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id_locataire=request.getParameter("id_locataire");
		int id_logement_= -1 ;
		String id_logement = request.getParameter("id_logement");
		
		int id_locataire_ = Integer.parseInt(id_locataire);
		id_logement_ = Integer.parseInt(id_logement);
		String date_move_in=request.getParameter("date_move_in");
		String date_move_out=request.getParameter("date_move_out");
		
		Reservation reservation = new Reservation();
		try {
			java.util.Date sdf = new SimpleDateFormat("yyyy-MM-dd").parse(date_move_in);
			java.sql.Date sqlStartDate = new java.sql.Date(sdf.getTime()); 
			reservation.setDate_move_in(sqlStartDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		try {
			java.util.Date sdf = new SimpleDateFormat("yyyy-MM-dd").parse(date_move_out);
			java.sql.Date sqlStartDate = new java.sql.Date(sdf.getTime()); 
			reservation.setDate_move_out(sqlStartDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		reservation.setId_locataire(id_locataire_);
		reservation.setId_logement(id_logement_);
		
		ReservationDB reservationdb =  new ReservationDB();
		try {
			reservationdb.addReservation(reservation);
			RequestDispatcher dispatcher = request.getRequestDispatcher("FindLogement.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	
}
