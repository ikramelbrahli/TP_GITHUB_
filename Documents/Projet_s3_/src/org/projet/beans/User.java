package org.projet.beans;

public class User {
	
		private String username ;
	    private String email ;
	    private String password ;
	    private String nom ;
	    private String prenom ;
	    private String statut ;
	    private int id_user;
	    private String sexe ;
	    private int budget ;
	    private String organisation ;
		private String nettoyage ;
		private String fumer ;
	    
	    
	    public User(String username, String email, String password, String nom, String prenom ,String statut) {
	        this.username = username;
	        this.email = email;
	        this.password = password;
	        this.nom = nom;
	        this.prenom = prenom;
	        this.statut = statut;
	    }

	    public User(String username, String password, String email) {
	    	this.username = username;
	        this.email = email;
	        this.password = password;
	        
	    }
	    public User(String username, String password, String email,String statut) {
	    	this.username = username;
	        this.email = email;
	        this.password = password;
	        this.statut = statut;
	        
	    }
	    public User() {
	    	
	    }

	    public String getStatut() {
	        return statut;
	    }

	    public void setStatut(String statut) {
	        this.statut = statut;
	    }

	    
	    
	    public String getNom() {
	        return nom;
	    }

	    public void setNom(String nom) {
	        this.nom = nom;
	    }

	    public String getPrenom() {
	        return prenom;
	    }

	    public void setPrenom(String prenom) {
	        this.prenom = prenom;
	    }

	  

	    public String getUsername() {
	        return username;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

		public int getId_user() {
			return id_user;
		}

		public void setId_user(int id_user) {
			this.id_user = id_user;
		}

		public String getSexe() {
			return sexe;
		}

		public void setSexe(String sexe) {
			this.sexe = sexe;
		}

		public int getBudget() {
			return budget;
		}

		public void setBudget(int budget) {
			this.budget = budget;
		}

		public String getOrganisation() {
			return organisation;
		}

		public void setOrganisation(String organisation) {
			this.organisation = organisation;
		}

		public String getNettoyage() {
			return nettoyage;
		}

		public void setNettoyage(String nettoyage) {
			this.nettoyage = nettoyage;
		}

		public String getFumer() {
			return fumer;
		}

		public void setFumer(String fumer) {
			this.fumer = fumer;
		}

}
