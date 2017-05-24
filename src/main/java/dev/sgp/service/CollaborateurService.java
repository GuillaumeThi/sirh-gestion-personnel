package dev.sgp.service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import dev.sgp.entite.CollabEvent;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.TypeCollabEvent;

@ApplicationScoped
public class CollaborateurService {
	
	@Inject Event<CollabEvent> collabEvent;
	
	List<Collaborateur> listeCollaborateurs = new ArrayList<>();
	
	
	public List<Collaborateur> listerCollaborateurs() {
		return listeCollaborateurs;
	}
	
	public void sauvegarderCollaborateur(Collaborateur collab) {
		
		ZonedDateTime now = ZonedDateTime.now();
		collab.setDateHeureCreation(now);
		collab.setActif(true);
		listeCollaborateurs.add(collab);
		collabEvent.fire(new CollabEvent(now, TypeCollabEvent.CREATION_COLLAB, collab.getMatricule()));
	}
}
