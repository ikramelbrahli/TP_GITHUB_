package org.projet.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.projet.beans.Logement;

public class LogementDB {
	 public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
	            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT","root","root");  
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	    }
	 public boolean addLogement(Logement logement) throws ClassNotFoundException, SQLException {
		 String jdbcURL = "jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT";		
	    	String dbUser = "root";
	    	String dbPassword = "root";
	    	boolean flag = false;
	    	Class.forName("com.mysql.jdbc.Driver");
	    	Connection con = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
			PreparedStatement ps=con.prepareStatement("insert into logement( id_proprietaire, titre_logement , description , pays , ville , rue , nombre_pieces , nombre_chambre ,regles , nombre_lit , prix , disponibilite_move_in , disponibilite_move_out , equipement , colocataires_actuels ) values( ? , ? , ? , ?, ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )");
	
			ps.setInt(1,logement.getId_proprietaire());
			ps.setString(2,logement.getTitre_logement());
			ps.setString(3, logement.getDescription());
			ps.setString(4,logement.getPays());
			ps.setString(5,logement.getVille());
			ps.setString(6,logement.getRue());
			
			ps.setInt(7,logement.getNombre_pieces());
			
		
			ps.setInt(8, logement.getNombre_chambre());
			
			ps.setString(9,logement.getRegles());
			ps.setInt(10,logement.getNombre_lit());
			ps.setInt(11,logement.getPrix());
			
			ps.setDate(12,logement.getDisponibilite_move_in());
			ps.setDate(13,logement.getDisponibilite_move_out());
			String[] list = logement.getEquipement();
			String value ="";
			for (int i = 0 ; i<list.length ; i++) {
			
				value += list[i]+",";
			}
			ps.setString(14, value);
			ps.setInt(15, logement.getColocataires_actuels());
			ps.executeUpdate();
			flag = true;
			ps.close();	
			con.close();	
			
			   return flag ;
			
	
		 
	 }
	 public void deleteLogement(int id_logement) throws ClassNotFoundException, SQLException{
		 String jdbcURL = "jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT";		
	    	String dbUser = "root";
	    	String dbPassword = "root";
	    	Class.forName("com.mysql.jdbc.Driver");
	    	Connection con = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
			PreparedStatement ps=con.prepareStatement("delete from logement where id_logement = ? ");
			ps.setInt(1, id_logement);
			ps.executeUpdate() ;
			ps.close();	
			con.close();
	 }
	 public boolean updateLogement(Logement logement) throws ClassNotFoundException, SQLException {
		 
		 String jdbcURL = "jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT";		
	    	String dbUser = "root";
	    	String dbPassword = "root";
	    	boolean flag = false;
	    	Class.forName("com.mysql.jdbc.Driver");
	    	Connection con = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
			PreparedStatement ps=con.prepareStatement("update  logement set  titre_logement = ? , description = ? , pays = ? , ville = ? , rue = ? , nombre_pieces = ? , nombre_chambre = ? ,regles = ? , nombre_lit = ? , prix = ? , disponibilite_move_in = ? , disponibilite_move_out = ? , equipement = ? , colocataires_actuels = ? where id_proprietaire = ? and id_logement = ? ");

			ps.setString(1,logement.getTitre_logement());
			ps.setString(2, logement.getDescription());
			ps.setString(3,logement.getPays());
			ps.setString(4,logement.getVille());
			ps.setString(5,logement.getRue());
			ps.setInt(6,logement.getNombre_pieces());
			ps.setInt(7, logement.getNombre_chambre());
			ps.setString(8,logement.getRegles());
			ps.setInt(9,logement.getNombre_lit());
			ps.setInt(10,logement.getPrix());
			ps.setDate(11,logement.getDisponibilite_move_in());
			ps.setDate(12,logement.getDisponibilite_move_out());
			ps.setString(13, logement.getEquipements());
			ps.setInt(14, logement.getColocataires_actuels());
			ps.setInt(15,logement.getId_proprietaire());
			ps.setInt(16,logement.getId_logement());
			ps.executeUpdate();
			flag = true;
			ps.close();	
			con.close();	
			
			   return flag ;
		 
	 }
	 
	public Logement getLogementbyID(int id_logement) throws SQLException, ClassNotFoundException {
		String jdbcURL = "jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT";		
    	String dbUser = "root";
    	String dbPassword = "root";
    	
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection con = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
		PreparedStatement ps=con.prepareStatement("select *  from logement , proprietaire , user where  id_logement = ? and proprietaire.id_proprietaire= logement.id_proprietaire and proprietaire.id_user = user.id_user ");
	
		ps.setInt(1,id_logement);	
		ResultSet rs=ps.executeQuery();
		Logement logement = new Logement();
		while(rs.next()) {
			int id_proprietaire_= rs.getInt("id_proprietaire") ;
			int id_logement_= rs.getInt("id_logement") ;
			String titre_logement = rs.getString("titre_logement");
			String pays = rs.getString("pays");
			String ville = rs.getString("ville");
			Date disponibilite_move_in = rs.getDate("disponibilite_move_in");
			Date disponibilite_move_out = rs.getDate("disponibilite_move_out");
			int nombre_chambre = rs.getInt("nombre_chambre");
			int nombre_lit=rs.getInt("nombre_lit");
			int prix = rs.getInt("prix");
			String GSM = rs.getString("GSM");
			String nom = rs.getString("nom");
			String prenom = rs.getString("prenom");
			String email = rs.getString("email");
			String rue = rs.getString("rue");
			String description = rs.getString("description");
			String regles = rs.getString("regles");
			String equipement = rs.getString("equipement");
			int nombre_piece=rs.getInt("nombre_pieces");	
			int id_user=rs.getInt("id_user");
			int coloc_actuels =rs.getInt("colocataires_actuels");
			
			logement.setTitre_logement(titre_logement);
			logement.setId_proprietaire(id_proprietaire_);
			logement.setId_logement(id_logement_);
			logement.setPays(pays);
			logement.setVille(ville);
			logement.setGSM(GSM);
			
			logement.setDisponibilite_move_in(disponibilite_move_in);
			logement.setDisponibilite_move_out(disponibilite_move_out);
			logement.setNombre_chambre(nombre_chambre);
			logement.setNombre_lit(nombre_lit);
			logement.setNombre_pieces(nombre_lit);
			logement.setPrix(prix);
			logement.setRue(rue);
			logement.setDescription(description);
			logement.setRegles(regles);
			
			logement.setMyList(equipement);
			
			logement.setNombre_pieces(nombre_piece);
			logement.setNom(nom);
			logement.setPrenom(prenom);
			logement.setEmail(email);
			logement.setId_user(id_user);
			logement.setColocataires_actuels(coloc_actuels);
		}
		con.close();
		return logement ;
		
	}
	
	public List<Logement> getLogement_all(int id_proprietaire) throws SQLException, ClassNotFoundException {
		List<Logement> listLogement= new ArrayList<>();
		String jdbcURL = "jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT";		
    	String dbUser = "root";
    	String dbPassword = "root";
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection con = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
		PreparedStatement ps=con.prepareStatement("select *  from logement where id_proprietaire = ?  ");
		ps.setInt(1,id_proprietaire);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			int id_proprietaire_= rs.getInt("id_proprietaire") ;
			int id_logement_= rs.getInt("id_logement") ;
			String titre_logement = rs.getString("titre_logement");
			String pays = rs.getString("pays");
			String ville = rs.getString("ville");
			Date disponibilite_move_in = rs.getDate("disponibilite_move_in"); 
			Date disponibilite_move_out = rs.getDate("disponibilite_move_out");
			int nombre_chambre = rs.getInt("nombre_chambre");
			int nombre_lit=rs.getInt("nombre_lit");
			int prix = rs.getInt("prix");
			String rue = rs.getString("rue");
			String description = rs.getString("description");
			String regles = rs.getString("regles");
			//String equipement = rs.getString("equipement");
			int nombre_piece=rs.getInt("nombre_pieces");
			int coloc_actuels =rs.getInt("colocataires_actuels");
			Logement logement = new Logement();
			logement.setTitre_logement(titre_logement);
			logement.setId_proprietaire(id_proprietaire_);
			
			logement.setId_logement(id_logement_);
			logement.setPays(pays);
			logement.setVille(ville);
			logement.setDisponibilite_move_in(disponibilite_move_in);
			logement.setDisponibilite_move_out(disponibilite_move_out);
			logement.setNombre_chambre(nombre_chambre);
			logement.setNombre_lit(nombre_lit);
			logement.setNombre_pieces(nombre_piece);
			logement.setPrix(prix);
			logement.setRue(rue);
			logement.setDescription(description);
			logement.setRegles(regles);
			//logement.setEquipement(equipement);
			logement.setNombre_pieces(nombre_lit);
			logement.setColocataires_actuels(coloc_actuels);
	
			listLogement.add(logement);
		}
		rs.close();
		con.close();
		return listLogement ;
		
	}
	
	public List<Logement> FindLogement(Logement logement) throws SQLException, ClassNotFoundException {
		List<Logement> listLogement= new ArrayList<>();
		String jdbcURL = "jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT";		
    	String dbUser = "root";
    	String dbPassword = "root";
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection con = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
		PreparedStatement ps=con.prepareStatement("select distinct * from logement as l join proprietaire as p on l.id_proprietaire=p.id_proprietaire  where disponibilite_move_in >= ? and prix <= ? and pays = ? and ville = ? and ( nombre_lit = ? or nombre_chambre = ?  ) ");
	
		ps.setDate(1, logement.getDisponibilite_move_in());
		
		ps.setInt(2,logement.getPrix());
		ps.setString(3, logement.getPays());
		ps.setString(4, logement.getVille());
		ps.setInt(5,logement.getNombre_lit());
		ps.setInt(6, logement.getNombre_chambre());
		
		//ps.setString(7, logement.getFumer());


		
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			
			int id_logement_= rs.getInt("id_logement") ;
		
			Date disponibilite_move_in = rs.getDate("disponibilite_move_in");
			Date disponibilite_move_out = rs.getDate("disponibilite_move_out");
		    int nombre_chambre = rs.getInt("nombre_chambre");
			int nombre_lit=rs.getInt("nombre_lit");
			int coloc_actuels =rs.getInt("colocataires_actuels");
			int prix = rs.getInt("prix");
			String organisation = rs.getString("organisation");
			String nettoyage =rs.getString("nettoyage");
			String fumer = rs.getString("fumer");
			String tl = rs.getString("titre_logement");
			String pays = rs.getString("pays");
			String ville = rs.getString("ville");
			String rue =rs.getString("rue");
			Logement logement1 = new Logement();
		
			logement1.setDisponibilite_move_in(disponibilite_move_in);
			logement1.setDisponibilite_move_out(disponibilite_move_out);
			logement1.setId_logement(id_logement_);
	
			logement1.setNombre_chambre(nombre_chambre);
			logement1.setNombre_lit(nombre_lit);
		
			logement1.setPrix(prix);
			logement1.setTitre_logement(tl);
			logement1.setPays(pays);
			logement1.setVille(ville);
			logement1.setRue(rue);
			
			logement1.setNombre_pieces(nombre_lit);
			logement1.setColocataires_actuels(coloc_actuels);
			
			listLogement.add(logement1);
		}
		rs.close();
		con.close();
		return listLogement ;
		
	}
	public List<Logement> ShowRate(int id_logement) throws SQLException, ClassNotFoundException {
		List<Logement> listReviews= new ArrayList<>();
		String jdbcURL = "jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT";		
    	String dbUser = "root";
    	String dbPassword = "root";
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection con = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
    	PreparedStatement ps=con.prepareStatement(" select * from rating , reservation , logement , locataire , user where rating.id_reservation=reservation.id_reservation and reservation.id_logement=logement.id_logement and reservation.id_locataire = locataire.id_locataire and user.id_user = locataire.id_user and logement.id_logement = ? ");
    	ps.setInt(1,id_logement);
    	ResultSet rs=ps.executeQuery();
    	
    	while(rs.next()) {
    		Logement logement = new Logement();
    		String prenom = rs.getString("prenom");
    		String nom = rs.getString("nom");
    		int rate = rs.getInt("rate");
    		String comment = rs.getString("comment");
    		Date date_publication = rs.getDate("date_publication");
    		logement.setDate_publication(date_publication);
    		logement.setNom(nom);
    		logement.setPrenom(prenom);
    		logement.setRate(rate);
    		logement.setComment(comment);
    		listReviews.add(logement);
		
    	}
    	rs.close();
		con.close();
		return listReviews ;
		
	}
	
}
