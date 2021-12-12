package org.projet.beans;

public class Paiement extends Reservation {
	private int id_paiment ;
	private int RIB ;
	private int code_verification ;
	private java.sql.Date date_paiement ;
	private int montant_total ; 
	private String nom_complet ;
	private java.sql.Date date_expiration ;
	public int getId_paiment() {
		return id_paiment;
	}
	public void setId_paiment(int id_paiment) {
		this.id_paiment = id_paiment;
	}
	public int getRIB() {
		return RIB;
	}
	public void setRIB(int rIB) {
		RIB = rIB;
	}
	public int getCode_verification() {
		return code_verification;
	}
	public void setCode_verification(int code_verification) {
		this.code_verification = code_verification;
	}
	public java.sql.Date getDate_paiement() {
		return date_paiement;
	}
	public void setDate_paiement(java.sql.Date date_paiement) {
		this.date_paiement = date_paiement;
	}
	public int getMontant_total() {
		return montant_total;
	}
	public void setMontant_total(int montant_total) {
		this.montant_total = montant_total;
	}
	public String getNom_complet() {
		return nom_complet;
	}
	public void setNom_complet(String nom_complet) {
		this.nom_complet = nom_complet;
	}
	public java.sql.Date getDate_expiration() {
		return date_expiration;
	}
	public void setDate_expiration(java.sql.Date date_expiration) {
		this.date_expiration = date_expiration;
	}
	
	
}
