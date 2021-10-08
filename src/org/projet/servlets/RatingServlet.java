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

import org.projet.beans.Rating;
import org.projet.db.LocataireDB;
import org.projet.db.PaiementDB;
import org.projet.db.RatingDB;

/**
 * Servlet implementation class RatingServlet
 */
@WebServlet("/RatingServlet")
public class RatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RatingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	private void Rate(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ClassNotFoundException, SQLException{
		int id = Integer.parseInt(request.getParameter("id"));
		
		HttpSession session = request.getSession();
		session.setAttribute("id_reservation", id );	
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("RatingForm.jsp");
		dispatcher.forward(request, response);	
		
		

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		switch(action) {
		case "Rate" :
			try {
				Rate(request,response);
				
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int rate = Integer.parseInt(request.getParameter("rating"));
		int id_reservation = Integer.parseInt(request.getParameter("id_reservation"));//hidden
		String comment = request.getParameter("comment");
		Rating review =  new Rating();
		review.setRate(rate);
		review.setId_reservation(id_reservation);
		review.setComment(comment);
		RatingDB ratingdb = new RatingDB();
        try {
        	ratingdb.addRating(review);    
        	RequestDispatcher dispatcher = request.getRequestDispatcher("ViewReservations.jsp");
			dispatcher.forward(request, response);	
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
