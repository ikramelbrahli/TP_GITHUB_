package org.projet.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.projet.beans.Reservation;

public class ReservationDB {
	 public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
	            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT","root","root");  
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	    }
	 public boolean addReservation(Reservation reservation) throws ClassNotFoundException, SQLException {
		 String jdbcURL = "jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT";		
	    	String dbUser = "root";
	    	String dbPassword = "root";
	    	boolean flag = false;
	    	Class.forName("com.mysql.jdbc.Driver");
	    	Connection con = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
			PreparedStatement ps=con.prepareStatement("insert into reservation(id_logement , id_locataire , date_move_in , date_move_out , statut )values(? , ? , ? , ? , ?)");
	
			ps.setInt(1,reservation.getId_logement());
			ps.setInt(2,reservation.getId_locataire());
			//ps.setInt(2,reservation.getId_locataire());
			ps.setDate(3, reservation.getDate_move_in());
			ps.setDate(4,reservation.getDate_move_out());
			ps.setString(5,"En attente");
			ps.executeUpdate();
			flag = true;
			ps.close();	
			con.close();	
			
			   return flag ;

	 }
	 public void deleteReservation(int id_reservation) throws ClassNotFoundException, SQLException{
		 String jdbcURL = "jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT";		
	    	String dbUser = "root";
	    	String dbPassword = "root";
	    	Class.forName("com.mysql.jdbc.Driver");
	    	Connection con = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
			PreparedStatement ps=con.prepareStatement("delete from reservation where id_reservation = ? ");
			ps.setInt(1, id_reservation);
			ps.executeUpdate() ;
			ps.close();	
			con.close();
	 }
	 
	 
	 
		public List<Reservation> getReservation_all(int id_locataire) throws SQLException, ClassNotFoundException {
			List<Reservation> listReservation= new ArrayList<>();
			String jdbcURL = "jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT";		
	    	String dbUser = "root";
	    	String dbPassword = "root";
	    	Class.forName("com.mysql.jdbc.Driver");
	    	Connection con = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
			PreparedStatement ps=con.prepareStatement("select *  from reservation , locataire where locataire.id_locataire = ? and locataire.id_locataire = reservation.id_locataire ");
			ps.setInt(1,id_locataire);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int id_user = rs.getInt("id_user");
				int id_logement_= rs.getInt("id_logement") ;
				int id_reservation= rs.getInt("id_reservation") ;
				Date date_move_in = rs.getDate("date_move_in"); 
				Date date_move_out = rs.getDate("date_move_out");
				String statut = rs.getString("statut");
				Reservation reservation = new Reservation();
				reservation.setDate_move_in(date_move_in);
				reservation.setDate_move_out(date_move_out);
				reservation.setId_locataire(id_locataire);
				reservation.setStatut(statut);
				reservation.setId_logement(id_logement_);
				reservation.setId_reservation(id_reservation);
				reservation.setId_user(id_user);
				

				listReservation.add(reservation);
			}
			rs.close();
			con.close();
			return listReservation ;
			
		}
		 public boolean updateStatut(Reservation reservation) throws ClassNotFoundException, SQLException {
			 String jdbcURL = "jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT";		
		    	String dbUser = "root";
		    	String dbPassword = "root";
		    	boolean flag = false;
		    	Class.forName("com.mysql.jdbc.Driver");
		    	Connection con = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
				PreparedStatement ps=con.prepareStatement("update  reservation set  statut = ? where id_reservation = ? ");
				ps.setString(1,reservation.getStatut());
				ps.setInt(2,reservation.getId_reservation());
				ps.executeUpdate();
				flag = true;
				ps.close();	
				con.close();	
				
				   return flag ;

		 }
		 
			public List<Reservation> getReservation_prop(int id_proprietaire) throws SQLException, ClassNotFoundException {
				List<Reservation> listReservation= new ArrayList<>();
				String jdbcURL = "jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT";		
		    	String dbUser = "root";
		    	String dbPassword = "root";
		    	Class.forName("com.mysql.jdbc.Driver");
		    	Connection con = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
				PreparedStatement ps=con.prepareStatement("select *  from reservation , logement  where logement.id_proprietaire = ? and logement.id_logement = reservation.id_logement ");
				ps.setInt(1,id_proprietaire);
				
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					
					int id_locataire= rs.getInt("id_locataire") ;
					int id_logement_= rs.getInt("id_logement") ;
					int id_reservation= rs.getInt("id_reservation") ;
					Date date_move_in = rs.getDate("date_move_in"); 
					Date date_move_out = rs.getDate("date_move_out") ;
					String statut = rs.getString("statut");
					Reservation reservation = new Reservation();
					reservation.setDate_move_in(date_move_in);
					reservation.setDate_move_out(date_move_out);
					reservation.setId_locataire(id_locataire);
					reservation.setStatut(statut);
					reservation.setId_logement(id_logement_);
					reservation.setId_reservation(id_reservation);
					listReservation.add(reservation);
				}
				rs.close();
				con.close();
				return listReservation ;
				
			}
			
}
