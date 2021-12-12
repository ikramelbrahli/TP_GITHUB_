package org.projet.beans;

public class Locataire extends User {
	
	
	private int budget ;
	private String nationalite ;
	private String interets ;
	//private String date_move_in_estime ;
	//private String date_move_out_estime ;
	
	private String profession ;
	
	private int id_locataire ;
	
	
	public Locataire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Locataire(String username, String email, String password, String nom, String prenom, String statut) {
		super(username, email, password, nom, prenom, statut);
		// TODO Auto-generated constructor stub
	}
	public Locataire(String username, String password, String email, String statut) {
		super(username, password, email, statut);
		// TODO Auto-generated constructor stub
	}
	public Locataire(String username, String password, String email) {
		super(username, password, email);
		// TODO Auto-generated constructor stub
	}
	public Locataire(String username, String email, String password, String nom, String prenom, String statut,
			String age, String sexe, int budget, String nationalite, String interets, String date_move_in_estime,
			String date_move_out_estime, String organisation, String nettoyage, String fumer) {
		super(username, email, password, nom, prenom, statut);
		
		
		this.budget = budget;
		this.nationalite = nationalite;
		this.interets = interets;
	
		this.organisation = organisation;
		this.nettoyage = nettoyage;
		this.fumer = fumer;
	}
	

	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public String getInterets() {
		return interets;
	}
	public void setInterets(String interets) {
		this.interets = interets;
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
	public String getFumer() {
		return fumer;
	}
	public void setFumer(String fumer) {
		this.fumer = fumer;
	}
	private String description ;
	private int nombre_personnes ;
	private int age ;
	private int GSM ;
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNombre_personnes() {
		return nombre_personnes;
	}
	public void setNombre_personnes(int nombre_personnes) {
		this.nombre_personnes = nombre_personnes;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGSM() {
		return GSM;
	}
	public void setGSM(int GSM) {
		this.GSM = GSM;
	}
	public int getId_locataire() {
		return id_locataire;
	}
	public void setId_locataire(int id_locataire) {
		this.id_locataire = id_locataire;
	}
	
	
	
	
}
