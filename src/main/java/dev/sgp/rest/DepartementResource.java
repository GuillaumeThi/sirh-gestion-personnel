package dev.sgp.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import dev.sgp.entite.Departement;

@Path("/departements")

public class DepartementResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Departement> list() {
		List<Departement> departements = new ArrayList<Departement>();
		departements.add(new Departement(0, "Ressources Humaines"));
		departements.add(new Departement(1, "Comptabilité"));
		departements.add(new Departement(2, "Service technique"));
		departements.add(new Departement(3, "Recherche et développement"));
		return departements;
	}
}
