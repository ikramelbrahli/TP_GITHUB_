package org.projet.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.projet.beans.Rating;
import org.projet.beans.Reservation;

public class RatingDB {
	 public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
	            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT","root","root");  
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	    }

	 public boolean addRating(Rating rating) throws ClassNotFoundException, SQLException {
		 String jdbcURL = "jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT";		
	    	String dbUser = "root";
	    	String dbPassword = "root";
	    	boolean flag = false;
	    	Class.forName("com.mysql.jdbc.Driver");
	    	Connection con = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
			PreparedStatement ps=con.prepareStatement("insert into rating(rate , comment , id_reservation , date_publication )values(? , ? , ? , curdate()) ");
	
			ps.setInt(1,rating.getRate());
			ps.setString(2,rating.getComment());
			ps.setInt(3,rating.getId_reservation());
			
			ps.executeUpdate();
			flag = true;
			ps.close();	
			con.close();	
			
			   return flag ;

	 }
}
