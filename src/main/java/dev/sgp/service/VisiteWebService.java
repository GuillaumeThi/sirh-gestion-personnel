package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.VisiteLog;
import dev.sgp.entite.VisiteWeb;

public class VisiteWebService {
	
List<VisiteWeb> listeVisites = new ArrayList<>();
List<VisiteLog> listeLogs = new ArrayList<>();
	
	public List<VisiteWeb> listerVisites() {
		return listeVisites;
	}
	
	public void sauvegarderVisite(VisiteWeb visite) {
		
		listeVisites.add(visite);
	}
	
	public List<VisiteLog> listerLogs() {
		return listeLogs;
	}
	
	public void sauvegarderLogs(VisiteLog visite) {
		
		listeLogs.add(visite);
	}
	
}
