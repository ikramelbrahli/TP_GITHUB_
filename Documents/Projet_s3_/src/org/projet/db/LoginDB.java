package org.projet.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.projet.beans.User;

public class LoginDB {
    public User checkLogin(String email, String password) throws SQLException,
    ClassNotFoundException {
    	String jdbcURL = "jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT";		
    	String dbUser = "root";
    	String dbPassword = "root";
    	String statut = null ;
    	int id ;
    	
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
    	String sql = "SELECT * FROM user WHERE email = ? and password = ?   ";
    	PreparedStatement statement = connection.prepareStatement(sql);
    	statement.setString(1, email);
    	statement.setString(2, password);
    	ResultSet result = statement.executeQuery();
    	
    	User user = null;

    	while(result.next()) {
    		statut = result.getString("statut");
    		id=result.getInt("id_user");
    		String nom=result.getString("nom");
    		String prenom=result.getString("prenom");
    		user = new User();
    		user.setEmail(email);
    		user.setStatut(statut);
    		user.setId_user(id);
    		user.setPrenom(prenom);
    	
    		user.setNom(nom);
    	}

    	connection.close();

    	return user;
    }
}
