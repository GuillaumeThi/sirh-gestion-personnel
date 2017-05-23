package dev.sgp.filtre;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import dev.sgp.entite.VisiteLog;
import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.VisiteWebService;
import dev.sgp.util.Constantes;

public class FrequentationFilter implements Filter {
	
	private FilterConfig config = null;
	private VisiteWebService visiteService = Constantes.VISITE_SERVICE;
	
	public static int id = 0;

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		config.getServletContext().log("FreqFilter initialized");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
		throws IOException, ServletException {
		long before = System.currentTimeMillis();
		String path = ((HttpServletRequest) req).getRequestURI();
		chain.doFilter(req, resp);
		long after = System.currentTimeMillis();
		long time = after - before;
		config.getServletContext().log(path + " : " + time);
		boolean ok = true;
		
		VisiteWeb visite = new VisiteWeb(id++, path, time);
		visiteService.sauvegarderVisite(visite);
		
		if(visiteService.listerLogs() == null) {
			visiteService.sauvegarderLogs(new VisiteLog(path, 1, time, time, time));
		}
		else {
			for(int i=0; i<visiteService.listerLogs().size(); i++) {
				if(path.equals(visiteService.listerLogs().get(i).getChemin())) {
					ok = false;
					visiteService.listerLogs().get(i).incrementNbVisites();
					if(time < visiteService.listerLogs().get(i).getMin()) {
						visiteService.listerLogs().get(i).setMin(time);
					}
					if(time > visiteService.listerLogs().get(i).getMax()) {
						visiteService.listerLogs().get(i).setMax(time);
					}
					long nouvelleMoyenne = (visiteService.listerLogs().get(i).getMoyenne()*visiteService.listerLogs().get(i).getNbVisites() + time)/(visiteService.listerLogs().get(i).getNbVisites() + 1);
					visiteService.listerLogs().get(i).setMoyenne(nouvelleMoyenne);
				}
			}
			if(ok) {
				visiteService.sauvegarderLogs(new VisiteLog(path, 1, time, time, time));
			}
		}
		
	}

	@Override
	public void destroy() {}

}
