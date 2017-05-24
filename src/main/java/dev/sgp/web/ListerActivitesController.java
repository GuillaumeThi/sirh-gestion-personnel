package dev.sgp.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.CollabEvent;
import dev.sgp.service.ActiviteService;



@WebServlet("/collaborateurs/activites")
public class ListerActivitesController extends HttpServlet {
	
	@Inject private ActiviteService activiteService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<CollabEvent> collabEvents = activiteService.listerActivitesCollab();
		
		req.setAttribute("collabEvents", collabEvents);
		req.getRequestDispatcher("/WEB-INF/views/activites/listerActivites.jsp")
			.forward(req, resp);
	}
}
