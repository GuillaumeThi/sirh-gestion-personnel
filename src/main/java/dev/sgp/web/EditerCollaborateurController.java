package dev.sgp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditerCollaborateurController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// récupère la valeur d'un paramètre dont le nom est matricule
		String matriculeParam = req.getParameter("matricule");
		
		resp.setContentType("text/html");
		
		if(matriculeParam != null) {
		
			// code HTML écrit dans le corps de la réponse
			resp.getWriter().write(""
					
				+ "<h1>Edition de collaborateur</h1>"
				+ "<span>Matricule : "+ matriculeParam + "</span>"
			);
		}
		else {
			resp.sendError(400, "Un matricule est attendu");
		}

	}

}
