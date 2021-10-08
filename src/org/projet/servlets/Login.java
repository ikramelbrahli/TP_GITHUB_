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

import org.projet.beans.User;
import org.projet.db.LoginDB;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
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
		doGet(request, response);
		 	String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        LoginDB userDao = new LoginDB();
	         
	        try {
	            User user = userDao.checkLogin(email, password );
	            HttpSession session = request.getSession();
                session.setAttribute("user", user);
	            String destPage = "login.jsp";
	             
	            if (user != null ) {
	                
	                if (user.getStatut().equals("proprietaire")) {
	                	
	                	destPage = "home_proprietaire.jsp";}
	                if (user.getStatut().equals("locataire")){
		                destPage = "home_proprietaire.jsp";}
	                if (user.getStatut().equals("admin")){
		                destPage = "home.jsp";}
	            } else {
	                String message = "Invalid email/password";
	                request.setAttribute("message", message);
	            }
	            
	            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
	            dispatcher.forward(request, response);
	             
	        } catch (SQLException | ClassNotFoundException ex) {
	            throw new ServletException(ex);
	        }
	}

}
