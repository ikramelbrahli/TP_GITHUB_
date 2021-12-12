package org.projet.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.projet.beans.Locataire;
import org.projet.beans.Proprietaire;

public class LocataireDB {

	 public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
	            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT","root","root");  
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	    }
	  public Locataire getLocataireById(int id) throws SQLException, ClassNotFoundException {
  		String jdbcURL = "jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT";		
      	String dbUser = "root";
      	String dbPassword = "root";
      	
      	Class.forName("com.mysql.jdbc.Driver");
      	Connection con = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
  		PreparedStatement ps=con.prepareStatement("select *  from user , locataire where user.id_user = ? and locataire.id_user = user.id_user ");
  		ps.setInt(1,id);
  		ResultSet rs=ps.executeQuery();
  		Locataire locataire = new Locataire();
  		while(rs.next()){
  			int id_= rs.getInt("id_user") ;
  			String description = rs.getString("description") ;
  			String sexe = rs.getString("sexe");
  			String organisation = rs.getString("organisation");
  			String  fumer = rs.getString("fumer");
  			String  nettoyage = rs.getString("nettoyage");
  			int  GSM = rs.getInt("GSM");
  			String nom = rs.getString("nom");
  			String prenom = rs.getString("prenom");
  			String email = rs.getString("email");
  			int age = rs.getInt("age");
  			int id_locataire=rs.getInt("id_locataire");
  			String profession = rs.getString("profession");
  			int budget =rs.getInt("budget");
  			int nombre_personnes=rs.getInt("nombre_personnes");
  			locataire.setDescription(description);
  			locataire.setAge(age);
  			locataire.setId_user(id_);   
  			locataire.setSexe(sexe);
  			locataire.setOrganisation(organisation);
  			locataire.setFumer(fumer);
  			locataire.setNettoyage(nettoyage);
  			locataire.setEmail(email);
  			locataire.setNom(nom);
  			locataire.setPrenom(prenom);
  			locataire.setId_locataire(id_locataire);
  			locataire.setGSM(GSM);
  			locataire.setProfession(profession);
  			locataire.setBudget(budget);
  			locataire.setNombre_personnes(nombre_personnes);
	
  		}
  		con.close();
		return locataire  ;
  }
  public boolean updateProfile(Locataire locataire) throws SQLException, ClassNotFoundException {
		String jdbcURL = "jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT";		
  	String dbUser = "root";
  	String dbPassword = "root";
  
  	
  	boolean flag = false;
  	Class.forName("com.mysql.jdbc.Driver");
  	Connection con = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
		PreparedStatement ps=con.prepareStatement("update user , locataire set   age= ? , description= ? , sexe= ? , organisation = ? , fumer = ? , nettoyage = ? , GSM = ? , nom = ? , prenom = ? , email = ? , profession = ? ,  nombre_personnes = ? , budget = ?  where user.id_user = ? and user.id_user=locataire.id_user ");
		ps.setInt(1,locataire.getAge());
		ps.setString(2,locataire.getDescription());
		ps.setString(3,locataire.getSexe());
		ps.setString(4,locataire.getOrganisation());
		ps.setString(5,locataire.getFumer());
		ps.setString(6,locataire.getNettoyage());
		ps.setInt(7,locataire.getGSM());
		ps.setString(8,locataire.getNom());
		ps.setString(9,locataire.getPrenom());
		ps.setString(10,locataire.getEmail());
		ps.setString(11, locataire.getProfession());
		ps.setInt(12, locataire.getNombre_personnes());
		ps.setInt(13, locataire.getBudget());
		ps.setInt(14,locataire.getId_user());
		ps.executeUpdate();
		flag = true;
		ps.close();	
		con.close();	
		
		   return flag ;
}
}
