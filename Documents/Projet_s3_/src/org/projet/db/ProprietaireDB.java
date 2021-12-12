package org.projet.db;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.projet.beans.*;

public class ProprietaireDB {

    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT","root","root");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }
    
 
    
    public Proprietaire getProprietaireById(int id) throws SQLException, ClassNotFoundException {
    		String jdbcURL = "jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT";		
        	String dbUser = "root";
        	String dbPassword = "root";
        	
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
    		PreparedStatement ps=con.prepareStatement("select *  from user , proprietaire where user.id_user = ? and proprietaire.id_user = user.id_user ");
    		ps.setInt(1,id);
    		ResultSet rs=ps.executeQuery();
    		Proprietaire prop = new Proprietaire();
    		while(rs.next()){
    			int id_= rs.getInt("id_user") ;
    			String description = rs.getString("description") ;
    			String sexe = rs.getString("sexe");
    			String organisation = rs.getString("organisation");
    			String  fumer = rs.getString("fumer");
    			String  nettoyage = rs.getString("nettoyage");
    			String  GSM = rs.getString("GSM");
    			String nom = rs.getString("nom");
    			String prenom = rs.getString("prenom");
    			String email = rs.getString("email");
    			int temps_reponse= rs.getInt("temps_reponse");
    			int age = rs.getInt("age");
    			int id_proprietaire=rs.getInt("id_proprietaire");
    			
    			prop.setDescription(description);
    			prop.setAge(age);
    			prop.setId_user(id_);   
    			prop.setSexe(sexe);
    			prop.setOrganisation(organisation);
    			prop.setFumer(fumer);
    			prop.setNettoyage(nettoyage);
    			prop.setGSM(GSM);
    			prop.setTemps_de_reponse(temps_reponse);
    			prop.setEmail(email);
    			prop.setNom(nom);
    			prop.setPrenom(prenom);
    			prop.setId_proprietaire(id_proprietaire);
    			prop.setTemps_de_reponse(temps_reponse);	
    		
    		}
    		con.close();
		return prop ;
    }
    public boolean updateProfile(Proprietaire prop) throws SQLException, ClassNotFoundException, FileNotFoundException {
		String jdbcURL = "jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT";		
    	String dbUser = "root";
    	String dbPassword = "root";
    	
    	
    	boolean flag = false;
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection con = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
		PreparedStatement ps=con.prepareStatement("update user , proprietaire set   age= ? ,description= ? , sexe= ? , organisation = ? , fumer = ? , nettoyage = ? , GSM = ? , temps_reponse = ? , nom = ? , prenom = ? , email = ?  where user.id_user = ? and user.id_user=proprietaire.id_user ");
	
		

		ps.setInt(1,prop.getAge());
		ps.setString(2,prop.getDescription());
		ps.setString(3,prop.getSexe());
		ps.setString(4,prop.getOrganisation());
		ps.setString(5,prop.getFumer());
		ps.setString(6,prop.getNettoyage());
		ps.setString(7,prop.getGSM());
		ps.setInt(8,prop.getTemps_de_reponse());
		ps.setString(9,prop.getNom());
		ps.setString(10,prop.getPrenom());
		ps.setString(11,prop.getEmail());
		ps.setInt(12,prop.getId_user());
		
		
		ps.executeUpdate();
		flag = true;
		ps.close();	
		con.close();	
		
		   return flag ;
}
    
    

	public List<Proprietaire> FindProprietaire(Proprietaire proprietaire) throws SQLException, ClassNotFoundException {
		List<Proprietaire> listProprietaire= new ArrayList<>();
		String jdbcURL = "jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT";		
    	String dbUser = "root";
    	String dbPassword = "root";
    	
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection con = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
		PreparedStatement ps=con.prepareStatement("select *  from user as u join locataire as l on u.id_user = l.id_user where age = ? and sexe = ? and organisation = ? and fumer = ? and nettoyage = ?  and budget = ?  ");
		ps.setInt(1,proprietaire.getAge()); 
		ps.setString(2,proprietaire.getSexe());
		ps.setString(3,proprietaire.getOrganisation());
		ps.setString(4,proprietaire.getFumer());
		ps.setString(5,proprietaire.getNettoyage());
		ps.setInt(6,proprietaire.getTemps_de_reponse());
		ResultSet rs=ps.executeQuery();
		Proprietaire prop = new Proprietaire();
		while(rs.next()){
			int id_= rs.getInt("id_user") ;
			String description = rs.getString("description") ;
			String sexe = rs.getString("sexe");
			String organisation = rs.getString("organisation");
			String  fumer = rs.getString("fumer");
			String  nettoyage = rs.getString("nettoyage");
			String  GSM = rs.getString("GSM");
			String nom = rs.getString("nom");
			String prenom = rs.getString("prenom");
			String email = rs.getString("email");
			int temps_reponse= rs.getInt("budget");
			int age = rs.getInt("age");
			int id_proprietaire=rs.getInt("id_locataire");
			prop.setDescription(description);
			prop.setAge(age);
			prop.setId_user(id_);   
			prop.setSexe(sexe);
			prop.setOrganisation(organisation);
			prop.setFumer(fumer);
			prop.setNettoyage(nettoyage);
			prop.setGSM(GSM);
			prop.setTemps_de_reponse(temps_reponse);
			prop.setEmail(email);
			prop.setNom(nom);
			prop.setPrenom(prenom);
			prop.setId_proprietaire(id_proprietaire);
			listProprietaire.add(prop);	
		}
		rs.close();
		con.close();
		return listProprietaire ;

	
}
	
	
	
}


