package org.projet.servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.projet.beans.Proprietaire;
import org.projet.db.ProprietaireDB;

import com.mysql.cj.util.Util;

/**
 * Servlet implementation class ProprietaireServlet
 */
@WebServlet(name = "ProprietaireServlet",urlPatterns = "/ProprietaireServlet")
// upload file's size up to 16MB
@MultipartConfig(maxFileSize = 16177216)//1.5mb

public class ProprietaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RequestDispatcher dispatcher = null;
	ProprietaireDB proprietairedb = null;

	 public static final int TAILLE_TAMPON = 10240;
	    public static final String CHEMIN_FICHIERS = "/Projets3/WebContent/images"; // A changer


  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProprietaireServlet() {
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

		case "UpdateProfile":
				UpdateProfile(request, response);
				break;
		case "ViewProfile" :
				ViewProfile(request,response);
				break;
		case "AddLogement" :
				AddLogement(request,response);
		case "UpdateLogement" :
			UpdateLogement(request,response);
				
		}
		 		
	}
	private void AddLogement(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		ProprietaireDB proprietairedb = new ProprietaireDB();
		try {
			Proprietaire prop = proprietairedb.getProprietaireById(id);
			HttpSession session = request.getSession();
			session.setAttribute("prop", prop);
			RequestDispatcher dispatcher = request.getRequestDispatcher("AddLogement.jsp");
			dispatcher.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void UpdateLogement(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		ProprietaireDB proprietairedb = new ProprietaireDB();
		try {
			Proprietaire prop = proprietairedb.getProprietaireById(id);
			request.setAttribute("prop", prop);
			RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateLogement.jsp");
			dispatcher.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void UpdateProfile(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		ProprietaireDB proprietairedb = new ProprietaireDB();
		try {
			Proprietaire prop = proprietairedb.getProprietaireById(id);
			request.setAttribute("prop", prop);
			RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateProfileProprietaire.jsp");
			dispatcher.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void ViewProfile(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		ProprietaireDB proprietairedb = new ProprietaireDB();
		try {
			Proprietaire prop = proprietairedb.getProprietaireById(id);
			request.setAttribute("prop", prop);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewProfileProprietaire.jsp");
			dispatcher.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    private static String getNomFichier( Part part ) {
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( contentDisposition.trim().startsWith( "filename" ) ) {
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        return null;
    }   
    private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
            entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
            sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);

            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur;
            while ((longueur = entree.read(tampon)) > 0) {
                sortie.write(tampon, 0, longueur);
            }
        } finally {
            try {
                sortie.close();
            } catch (IOException ignore) {
            }
            try {
                entree.close();
            } catch (IOException ignore) {
            }
        }
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Proprietaire prop = new Proprietaire();
		int id = Integer.parseInt(request.getParameter("id"));
		String description= request.getParameter("description");
		String sexe= request.getParameter("sexe");
        int age = Integer.parseInt(request.getParameter("age"));
        int tdr = Integer.parseInt(request.getParameter("tdr"));  
        String organisation=request.getParameter("organisation");
        String fumer=request.getParameter("fumer");
        String nettoyage=request.getParameter("nettoyage");
        String GSM=request.getParameter("GSM");
        String nom =request.getParameter("nom");
        String prenom =request.getParameter("prenom");
        String email =request.getParameter("email");
    
      prop.setTemps_de_reponse(tdr);
        prop.setId_user(id);
        prop.setDescription(description);
        prop.setSexe(sexe);
        prop.setOrganisation(organisation);
        prop.setFumer(fumer);
        prop.setNettoyage(nettoyage);
        prop.setTemps_de_reponse(tdr);
        prop.setGSM(GSM);
        prop.setAge(age);
        prop.setNom(nom);
        prop.setEmail(email);
        prop.setPrenom(prenom);
       /* prop.setPath(savePath);*/
        response.getWriter().print(prop.getImage());

      
        ProprietaireDB proprietairedb = new ProprietaireDB();
        try {
       
       	 proprietairedb.updateProfile(prop);    
       	 
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  // select nom , prenom from proprietaire , user where user.id_user=proprietaire.id_user and proprietaire.id_user=9;
// update nom , prenom , GSM from proprietaire , user set nom=elbrahli , prenom=ikrame , GSM=2 where user.id_user=proprietaire.id_user and proprietaire.id_user=9
	
	}
		
		
		
	
	


}