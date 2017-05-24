package dev.sgp.entite;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;



public class CollabEvent {

	private ZonedDateTime dateHeure;
	private TypeCollabEvent type;
	private String matricule;
	
	
	public CollabEvent(ZonedDateTime dateHeure, TypeCollabEvent type, String matricule) {
		super();
		this.dateHeure = dateHeure;
		this.type = type;
		this.matricule = matricule;
	}

	public String getFormattedDateHeure() {
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
	    return dateHeure.format(format);
		
	}

	public ZonedDateTime getDateHeure() {
		return dateHeure;
		
	}


	public void setDateHeure(ZonedDateTime dateHeure) {
		this.dateHeure = dateHeure;
	}


	public TypeCollabEvent getType() {
		return type;
	}


	public void setType(TypeCollabEvent type) {
		this.type = type;
	}


	public String getMatricule() {
		return matricule;
	}


	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	
	
}
