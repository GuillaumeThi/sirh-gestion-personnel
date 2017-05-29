package dev.sgp.service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dev.sgp.entite.CollabEvent;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.TypeCollabEvent;

@Stateless
public class CollaborateurService {
	
	@Inject Event<CollabEvent> collabEvent;
	
	@PersistenceContext(unitName="sgp-pu") private EntityManager em;
	
	
	public List<Collaborateur> listerCollaborateurs(Integer idDep) {
		
		List<Collaborateur> collaborateurs = new ArrayList<>();
		
		if (idDep == null) {
			
			TypedQuery<Collaborateur> query = em.createQuery("select c from Collaborateur c", Collaborateur.class);
			
			collaborateurs = query.getResultList();
		}
		else {
			
			TypedQuery<Collaborateur> query = em.createQuery("select c from Collaborateur c where c.departement.id = :idDep", Collaborateur.class)
					.setParameter("idDep", idDep);
			
			collaborateurs = query.getResultList();
		}
		
		return collaborateurs;
	}
	
	
	public Collaborateur findByMatricule(String matricule) {
		
		TypedQuery<Collaborateur> query = em.createQuery("select c from Collaborateur c where c.matricule = :matricule", Collaborateur.class)
				.setParameter("matricule", matricule);
		
		return query.getSingleResult();
	}
	
	public void sauvegarderCollaborateur(Collaborateur collab) {
		
		ZonedDateTime now = ZonedDateTime.now();
		collab.setDateHeureCreation(now);
		collab.setActif(true);
		em.persist(collab);
		collabEvent.fire(new CollabEvent(now, TypeCollabEvent.CREATION_COLLAB, collab.getMatricule()));
	}
	
	public void editerCollaborateur(Collaborateur collab) {
		
	}
}
