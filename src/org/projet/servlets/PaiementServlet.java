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
import org.projet.beans.Paiement;
import org.projet.beans.Reservation;
import org.projet.db.LocataireDB;
import org.projet.db.PaiementDB;
import org.projet.db.ReservationDB;

/**
 * Servlet implementation class PaiementServlet
 */
@WebServlet(name = "PaiementServlet" , urlPatterns ="/PaiementServlet")
public class PaiementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaiementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		switch(action) {
		
		case "ViewAllPayments" :
			try {
				ViewAllPayments(request,response);
				
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break ;	
		
		case "Pay" :
			try {
				Pay(request,response);
				
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break ;	
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private void Pay(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ClassNotFoundException, SQLException{
		int id = Integer.parseInt(request.getParameter("id"));
		PaiementDB paiementdb = new PaiementDB();
		int prix_total = paiementdb.Calculer_prix_total(id);
		HttpSession session = request.getSession();
		session.setAttribute("id_reservation", id );	
		session.setAttribute("prix_total", prix_total );
		RequestDispatcher dispatcher = request.getRequestDispatcher("PaymentForm.jsp");
		dispatcher.forward(request, response);	
		
		

	}
	private void ViewAllPayments(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ClassNotFoundException, SQLException{
		int id_user = Integer.parseInt(request.getParameter("id"));
		LocataireDB locatairedb = new LocataireDB();
		Locataire locataire = locatairedb.getLocataireById(id_user);
		int id_locataire= locataire.getId_locataire() ;
		PaiementDB paiementdb = new PaiementDB();		
		List<Paiement> listPaiement = paiementdb.getPaiement_all(id_locataire);
		HttpSession session = request.getSession();
		session.setAttribute("listPaiement", listPaiement );
		session.setAttribute("locataire", locataire);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewPayments.jsp");
		dispatcher.forward(request, response);	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id_reservation =  Integer.parseInt(request.getParameter("id_reservation"));
		int RIB =  Integer.parseInt(request.getParameter("RIB")); 
		int code_verification =  Integer.parseInt(request.getParameter("code_verification"));
		String nom_complet = request.getParameter("nom_complet");
		String date_expiration = request.getParameter("date_expiration");
		Paiement paiement = new Paiement();
		PaiementDB paiementdb = new PaiementDB();
		paiement.setRIB(RIB);
		paiement.setCode_verification(code_verification);
		paiement.setId_reservation(id_reservation);
		paiement.setNom_complet(nom_complet);
		try {
			java.util.Date sdf = new SimpleDateFormat("yyyy-MM-dd").parse(date_expiration);			
			java.sql.Date sqlStartDate = new java.sql.Date(sdf.getTime()); 
			paiement.setDate_expiration(sqlStartDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			paiementdb.addPaiement(paiement);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewReservations.jsp");
			dispatcher.forward(request, response);	
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		
	}

}
