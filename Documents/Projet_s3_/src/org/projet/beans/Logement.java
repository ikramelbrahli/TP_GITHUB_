package org.projet.beans;

import java.util.Date;
import java.util.List;

public class Logement extends Proprietaire {
private int id_logement ;
private int nombre_pieces ;
private String description ;
private String [] equipement ;
private String myList ;
private String  regles ; 
private String pays ;
private String ville ;
private String rue ;
private int prix ;
private String titre_logement ;
private java.sql.Date disponibilite_move_in ;
private java.sql.Date disponibilite_move_out ;
private java.sql.Date date_publication ;
private int colocataires_actuels ;
private int rate ;
private int id_rate ;
private String comment ;
private String equipements ;

private int nombre_chambre ;
private int nombre_lit ;
public int getId_logement() {
	return id_logement;
}
public void setId_logement(int id_logement) {
	this.id_logement = id_logement;
}
public int getNombre_pieces() {
	return nombre_pieces;
}
public void setNombre_pieces(int nombre_pieces) {
	this.nombre_pieces = nombre_pieces;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String[] getEquipement() {
	return equipement;
}
public void setEquipement(String[] equipement) {
	this.equipement = equipement;
}
public String getRegles() {
	return regles;
}
public void setRegles(String regles) {
	this.regles = regles;
}
public String getPays() {
	return pays;
}
public void setPays(String pays) {
	this.pays = pays;
}
public String getVille() {
	return ville;
}
public void setVille(String ville) {
	this.ville = ville;
}
public String getRue() {
	return rue;
}
public void setRue(String rue) {
	this.rue = rue;
}
public int getPrix() {
	return prix;
}
public void setPrix(int prix) {
	this.prix = prix;
}

public Logement() {
	// TODO Auto-generated constructor stub
}
public String getTitre_logement() {
	return titre_logement;
}
public void setTitre_logement(String titre_logement) {
	this.titre_logement = titre_logement;
}


public int getNombre_chambre() {
	return nombre_chambre;
}
public void setNombre_chambre(int nombre_chambre) {
	this.nombre_chambre = nombre_chambre;
}
public int getNombre_lit() {
	return nombre_lit;
}
public void setNombre_lit(int nombre_lit) {
	this.nombre_lit = nombre_lit;
}

public String getMyList() {
	return myList;
}
public void setMyList(String myList) {
	this.myList = myList;
}
public String getEquipements() {
	return equipements;
}
public void setEquipements(String equipements) {
	this.equipements = equipements;
}
public java.sql.Date getDisponibilite_move_in() {
	return disponibilite_move_in;
}
public void setDisponibilite_move_in(java.sql.Date disponibilite_move_in) {
	this.disponibilite_move_in = disponibilite_move_in;
}
public java.sql.Date getDisponibilite_move_out() {
	return disponibilite_move_out;
}
public void setDisponibilite_move_out(java.sql.Date disponibilite_move_out) {
	this.disponibilite_move_out = disponibilite_move_out;
}
public int getRate() {
	return rate;
}
public void setRate(int rate) {
	this.rate = rate;
}
public int getId_rate() {
	return id_rate;
}
public void setId_rate(int id_rate) {
	this.id_rate = id_rate;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
public int getColocataires_actuels() {
	return colocataires_actuels;
}
public void setColocataires_actuels(int colocataires_actuels) {
	this.colocataires_actuels = colocataires_actuels;
}
public java.sql.Date getDate_publication() {
	return date_publication;
}
public void setDate_publication(java.sql.Date date_publication) {
	this.date_publication = date_publication;
}



}
