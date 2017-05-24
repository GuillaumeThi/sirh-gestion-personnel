package dev.sgp.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.VisiteLog;
import dev.sgp.service.VisiteWebService;

@WebServlet("/collaborateurs/statistiques")
public class ListerVisitesController extends HttpServlet {
	
//private VisiteWebService visiteService = Constantes.VISITE_SERVICE;
	@Inject private VisiteWebService visiteService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<VisiteLog> visites = visiteService.construireStatistiques();
		
		req.setAttribute("visites", visites);
		req.getRequestDispatcher("/WEB-INF/views/logs/listerVisites.jsp")
			.forward(req, resp);
	}
}
