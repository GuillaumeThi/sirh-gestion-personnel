package dev.sgp.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;


@Path("/collaborateurs")
public class CollaborateurResource {
	
	@Inject private CollaborateurService collabService;
	
	

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
	
}