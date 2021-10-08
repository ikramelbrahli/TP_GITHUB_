package org.projet.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.projet.beans.Locataire;
import org.projet.beans.Logement;
import org.projet.beans.Reservation;
import org.projet.db.LocataireDB;
import org.projet.db.LogementDB;
import org.projet.db.ReservationDB;

/**
 * Servlet implementation class UpdateStatut
 */
@WebServlet(name = "UpdateServlet" , urlPatterns ="/UpdateServlet")
public class UpdateStatut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStatut() {
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
		int id_reservation_= -1 ;
		String id_reservation = request.getParameter("id_reservation");
		String statut = request.getParameter("statut");
		id_reservation_ = Integer.parseInt(id_reservation);
		Reservation reservation = new Reservation();
		reservation.setId_reservation(id_reservation_);
		reservation.setStatut(statut);
		ReservationDB reservationdb =  new ReservationDB();
		try {
			reservationdb.updateStatut(reservation);
			RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateStatut.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		
		
		
	}

}
