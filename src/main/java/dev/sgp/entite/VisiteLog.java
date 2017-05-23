package dev.sgp.entite;

public class VisiteLog {

	private String chemin;
	private int nbVisites;
	private long min;
	private long max;
	private long moyenne;
	
	
	public VisiteLog(String chemin, int nbVisites, long min, long max, long moyenne) {
		super();
		this.chemin = chemin;
		this.nbVisites = nbVisites;
		this.min = min;
		this.max = max;
		this.moyenne = moyenne;
	}


	public String getChemin() {
		return chemin;
	}


	public void setChemin(String chemin) {
		this.chemin = chemin;
	}


	public int getNbVisites() {
		return nbVisites;
	}


	public void setNbVisites(int nbVisites) {
		this.nbVisites = nbVisites;
	}
	
	public void incrementNbVisites() {
		this.nbVisites++;
	}


	public long getMin() {
		return min;
	}


	public void setMin(long min) {
		this.min = min;
	}


	public long getMax() {
		return max;
	}


	public void setMax(long max) {
		this.max = max;
	}


	public long getMoyenne() {
		return moyenne;
	}


	public void setMoyenne(long moyenne) {
		this.moyenne = moyenne;
	}
	
	
	
}
