package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import dev.sgp.entite.CollabEvent;

@ApplicationScoped
public class ActiviteService {
	
	private List<CollabEvent> collabEvents = new ArrayList<>();

	public void recevoirEvenementCollab(@Observes CollabEvent event) {
		
		collabEvents.add(event);
	}
	
	public List<CollabEvent> listerActivitesCollab() {
		
		return collabEvents;
	}
}
