package org.projet.beans;

public class Reservation extends Locataire {
	
	private int id_logement ;
	private java.sql.Date date_move_in ;
	private java.sql.Date date_move_out ;
	private int id_locataire ;
	private int id_reservation ;
	private String statut ;
	private int prix_total ;
	
	public int getId_logement() {
		return id_logement;
	}
	public void setId_logement(int id_logement) {
		this.id_logement = id_logement;
	}
	public java.sql.Date getDate_move_in() {
		return date_move_in;
	}
	public void setDate_move_in(java.sql.Date date_move_in) {
		this.date_move_in = date_move_in;
	}
	public java.sql.Date getDate_move_out() {
		return date_move_out;
	}
	public void setDate_move_out(java.sql.Date date_move_out) {
		this.date_move_out = date_move_out;
	}
	public int getId_locataire() {
		return id_locataire;
	}
	public void setId_locataire(int id_locataire) {
		this.id_locataire = id_locataire;
	}
	public int getId_reservation() {
		return id_reservation;
	}
	public void setId_reservation(int id_reservation) {
		this.id_reservation = id_reservation;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public int getPrix_total() {
		return prix_total;
	}
	public void setPrix_total(int prix_total) {
		this.prix_total = prix_total;
	}
	

}
