package dev.sgp.rest;

import java.util.List;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import dev.sgp.entite.CollabEvent;
import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;


@Path("/collaborateurs")
public class CollaborateurResource {
	
	@Inject private CollaborateurService collabService;
	@Inject Event<CollabEvent> collabEvent;
	
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Collaborateur> list(@QueryParam("departement") Integer idDep) {
		
		return collabService.listerCollaborateurs(idDep);
	}
	
	
	@GET
	@Path("/{matricule}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collaborateur findByMatricule(@PathParam("matricule") String matricule) {
		
		return collabService.findByMatricule(matricule);
	}
	
	@GET
	@Path("/{matricule}/banque")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> afficherDonneesBancaires(@PathParam("matricule") String matricule) {
		
		return collabService.afficherDonneesBancaires(matricule);
	}
	
	
	@PUT
	@Path("/{matricule}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editerCollaborateur(@PathParam("matricule") String matricule, Collaborateur collaborateur) {
		
		collabService.editerCollaborateur(matricule, collaborateur);
		
		ResponseBuilder builder = Response.ok("modification collaborateur OK");
		return builder.build();
	}
	
	@PUT
	@Path("/{matricule}/banque")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editerDonneesBancaires(@PathParam("matricule") String matricule, Collaborateur collaborateur) {
		
		ResponseBuilder builder;
		List<String> erreurs = collabService.editerDonneesBancaires(matricule, collaborateur);
		
		if(erreurs.isEmpty()) {
			
			builder = Response.ok();
		}
		else {
			
			builder = Response
				.status(400)
				.entity("Manquants : " + erreurs);
		}
			
		return builder.build();
	}
	
}