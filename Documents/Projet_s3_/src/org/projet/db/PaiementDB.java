package org.projet.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.projet.beans.Paiement;
import org.projet.beans.Reservation;

public class PaiementDB {
	 public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
	            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT","root","root");  
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	    }
	 public boolean addPaiement(Paiement paiement) throws ClassNotFoundException, SQLException {
		 String jdbcURL = "jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT";		
	    	String dbUser = "root";
	    	String dbPassword = "root";
	    	boolean flag = false;
	    	Class.forName("com.mysql.jdbc.Driver");
	    	Connection con = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
			PreparedStatement ps=con.prepareStatement("insert into paiement(id_reservation ,  date_paiement , rib , code_verification , nom_complet , date_expiration )values(? , curdate() , ? , ? , ? , ?)");
	
			ps.setInt(1,paiement.getId_reservation());
			ps.setInt(2,paiement.getRIB());
			//ps.setInt(2,reservation.getId_locataire());
			ps.setInt(3, paiement.getCode_verification());
			ps.setString(4, paiement.getNom_complet());
			ps.setDate(5, paiement.getDate_expiration());
			ps.executeUpdate();
			
			ps.close();	
			PreparedStatement ps2=con.prepareStatement("update reservation set statut = ? where id_reservation = ?");
			
			ps2.setString(1,"Payé");
			ps2.setInt(2,paiement.getId_reservation());
			
			ps2.executeUpdate();
			flag = true;
			ps2.close();	
			
			con.close();	
			
			   return flag ;

	 }

	 public List<Paiement> getPaiement_all(int id_locataire)throws ClassNotFoundException, SQLException{
		 List<Paiement> listPaiement= new ArrayList<>();
		 String jdbcURL = "jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT";		
	    	String dbUser = "root";
	    	String dbPassword = "root";
	    	
	    	Class.forName("com.mysql.jdbc.Driver");
	    	Connection con = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
	    	PreparedStatement ps=con.prepareStatement("select *  from paiement , reservation where reservation.id_locataire = ? and paiement.id_reservation = reservation.id_reservation ");
			ps.setInt(1,id_locataire);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int id_logement_= rs.getInt("id_logement") ;
				int id_paiement= rs.getInt("id_paiement") ;
				int id_reservation= rs.getInt("id_reservation") ;
				Date date_move_in = rs.getDate("date_move_in"); 
				Date date_move_out = rs.getDate("date_move_out") ;
				String statut = rs.getString("statut");
				Date date_paiement = rs.getDate("date_paiement") ;
				String nom_complet = rs.getString("nom_complet");
				Paiement paiement = new Paiement();
				paiement.setDate_move_in(date_move_in);
				paiement.setDate_move_out(date_move_out);
				paiement.setId_locataire(id_locataire);
				paiement.setStatut(statut);
				paiement.setId_logement(id_logement_);
				paiement.setId_reservation(id_reservation);
				paiement.setId_paiment(id_paiement);
				paiement.setDate_paiement(date_paiement);
				paiement.setNom_complet(nom_complet);
				int prix_total = Calculer_prix_total(id_reservation);
				paiement.setMontant_total(prix_total);
				listPaiement.add(paiement);
				
			}
			rs.close();
			con.close();
			return listPaiement ;
	 }
	 public int Calculer_prix_total(int id_reservation)throws SQLException, ClassNotFoundException {
			int prix_total = 0 ;
			String jdbcURL = "jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT";		
	    	String dbUser = "root";
	    	String dbPassword = "root";
	    	Class.forName("com.mysql.jdbc.Driver");
	    	Connection con = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
			PreparedStatement ps=con.prepareStatement("select datediff(date_move_out,date_move_in) as duree_sejour , prix from reservation , logement where id_reservation= ? and reservation.id_logement = logement.id_logement ");
			
			ps.setInt(1,id_reservation);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int duree_sejour = rs.getInt("duree_sejour");
				int prix = rs.getInt("prix");
				if(duree_sejour <30) {
					prix_total = prix ;
				}
				else {
					while(duree_sejour>=30) {
						prix_total =  prix_total+prix ;
						duree_sejour=duree_sejour-30 ;
					}
				}
			}
			
			rs.close();
			con.close();
			
			
			
			return prix_total;
			
		}
}
