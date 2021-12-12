package org.projet.beans;

public class Rating extends Reservation {
	
	private int rate ;
	private int id_rate ;
	private java.sql.Date date_publication;
	private String comment ;
	
	public int getId_rate() {
		return id_rate;
	}
	public void setId_rate(int id_rate) {
		this.id_rate = id_rate;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public java.sql.Date getDate_publication() {
		return date_publication;
	}
	public void setDate_publication(java.sql.Date date_publication) {
		this.date_publication = date_publication;
	}

}
