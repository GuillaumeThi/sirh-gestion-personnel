package dev.sgp.entite;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VisiteWeb {
	
	@Id
	private int id;
	private String chemin;
	private long tempsExecution;
	
	public VisiteWeb() {
		
	}
	
	public VisiteWeb(String chemin, long tempsExecution) {
		super();
		this.chemin = chemin;
		this.tempsExecution = tempsExecution;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getChemin() {
		return chemin;
	}


	public void setChemin(String chemin) {
		this.chemin = chemin;
	}


	public long getTempsExecution() {
		return tempsExecution;
	}


	public void setTempsExecution(long tempsExecution) {
		this.tempsExecution = tempsExecution;
	}
	
	
	
}
