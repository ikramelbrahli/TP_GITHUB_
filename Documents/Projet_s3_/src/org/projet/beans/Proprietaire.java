package org.projet.beans;

import java.io.File;
import java.io.InputStream;
import java.sql.Blob;

import javax.servlet.http.Part;

public class Proprietaire extends User {
	
	private int id_proprietaire;
    private int temps_de_reponse ;
    
	private String image ;
	private String filename ;
	private String path ;
	private Blob profile_image ;
	private Part image_test ;

    
    public Proprietaire(int temps_de_reponse, String GSM, String description, String username, String email, String password, String nom, String prenom , String statut) {
        super(username, email, password, nom, prenom, statut);
        this.temps_de_reponse = temps_de_reponse;
        this.GSM = GSM;
        this.description = description;
    }

    
    public Proprietaire(String username, String email, String password, String nom, String prenom, String statut,
			int temps_de_reponse, String GSM, String description, String organisation, String nettoyage, String fumer,
			int age, String sexe , InputStream profile_image) {
		super(username, email, password, nom, prenom, statut);
		this.temps_de_reponse = temps_de_reponse;
		this.GSM =  GSM;
		this.description = description;
		this.organisation = organisation;
		this.nettoyage = nettoyage;
		this.fumer = fumer;
		this.age = age;
		this.sexe = sexe;
	
	}


	public Proprietaire() {
		// TODO Auto-generated constructor stub
	}


	
	  private String description ;
	public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemps_de_reponse() {
        return temps_de_reponse;
    }

    public void setTemps_de_reponse(int temps_de_reponse) {
        this.temps_de_reponse = temps_de_reponse;
    }
    private String GSM ;

    public String getGSM() {
        return GSM;
    }

    public void setGSM(String GSM) {
        this.GSM = GSM;
    }

    private String organisation ;
	public String getOrganisation() {
		return organisation;
	}


	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	private String nettoyage ;

	public String getNettoyage() {
		return nettoyage;
	}


	public void setNettoyage(String nettoyage) {
		this.nettoyage = nettoyage;
	}

	private String fumer ;
	private int age ;
	private String sexe ;
	public String getFumer() {
		return fumer;
	}


	public void setFumer(String fumer) {
		this.fumer = fumer;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getSexe() {
		return sexe;
	}


	public void setSexe(String sexe) {
		this.sexe = sexe;
	}



	public int getId_proprietaire() {
		return id_proprietaire;
	}


	public void setId_proprietaire(int id_proprietaire) {
		this.id_proprietaire = id_proprietaire;
	}





	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Blob getProfile_image() {
		return profile_image;
	}


	public void setProfile_image(Blob profile_image) {
		this.profile_image = profile_image;
	}


	public Part getImage_test() {
		return image_test;
	}


	public void setImage_test(Part image_test) {
		this.image_test = image_test;
	}

    

}
