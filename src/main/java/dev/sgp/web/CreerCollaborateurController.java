package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static java.util.stream.Collectors.*;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;

public class CreerCollaborateurController extends HttpServlet {
	
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/collab/creerCollaborateur.jsp")
			.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Map<Boolean, List<String>> validationParams = validerParametres(req, "nomInput","prenomInput", "dateNaissanceInput", "adresseInput", "secuInput");
		
		String nom = req.getParameter("nomInput");
		String prenom = req.getParameter("prenomInput");
		String dateNaissance = req.getParameter("dateNaissanceInput");
		String adresse = req.getParameter("adresseInput");
		String numSecuriteSociale = req.getParameter("secuInput");
		
		String matricule = UUID.randomUUID().toString();
		String email = nom + "." + prenom + "@" + "scociété" + ".com";
		String photo = "path" + "photo.png";
		
		
		resp.setCharacterEncoding("utf-8");
		
		if (validationParams.get(false) != null) {
			
			resp.setStatus(400);
			resp.getWriter().write("Les paramètres suivants sont incorrects : " + validationParams.get(false).stream().collect(joining(",")));
			
		}
		else if(numSecuriteSociale.length() != 15) {
			resp.setStatus(400);
			resp.getWriter().write("Numéro de sécurité sociale incorrecte");
		}
		else {
			
			resp.setStatus(201);
			resp.getWriter().write("Création d'un collaborateur avec les informations suivantes : " 
				+ validationParams.get(true).stream().map(p -> p + "=" + req.getParameter(p)).collect(joining(",")));
			
			Collaborateur collab = new Collaborateur(matricule, nom, prenom, LocalDate.parse(dateNaissance), adresse, numSecuriteSociale, email, photo);
			collabService.sauvegarderCollaborateur(collab);
			
			resp.sendRedirect(req.getContextPath() + "/collaborateurs/lister");
		}
		
	}
	
	private Map<Boolean, List<String>> validerParametres(HttpServletRequest req, String... params) {
		return Stream.of(params).collect(
				groupingBy(
						param -> req.getParameter(param) != null && !"".equals(req.getParameter(param)
				)));
	}

}