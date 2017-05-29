package dev.sgp.ecouteur;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.stream.Stream;
import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;

@WebListener
public class DemarrageEcouteur implements ServletContextListener {

	@Inject
	private CollaborateurService collabService;
	
	@Inject
	private DepartementService depService;

	@Override
    public void contextInitialized(ServletContextEvent sce) {
        
        ZonedDateTime dateHeureCreation = ZonedDateTime.now();
        
        
        Stream.of(new Departement(0,"Comptabilité"),
                new Departement(1,"Ressources Humaines"),
                new Departement(2,"Informatique"),
                new Departement(3,"Administratif")
        )
        .forEach(dep -> depService.sauvegarderDepartement(dep));
        
        
        Stream.of(
                new Collaborateur("1", "ee", "ss", LocalDate.parse("1993-06-25"), "14", "121212121212121", "ee.ss@societe.com","img.png" ,dateHeureCreation , true, depService .listerDepartements().get(0), "LCL", "ijbfesfd", "iubibyh"),
                new Collaborateur("2", "est", "rr", LocalDate.parse("1993-06-25"), "14", "121212121212121", "ee.ss@societe.com","img.png" ,dateHeureCreation , true, depService .listerDepartements().get(0), "Caisse d'Epargne", "uuibui", "hbvuy"),
                new Collaborateur("3", "pmp", "cdr", LocalDate.parse("1993-06-25"), "14", "121212121212121", "ee.ss@societe.com","img.png" ,dateHeureCreation , true, depService .listerDepartements().get(1), "banque a", "yyu", "yguvuy"),
                new Collaborateur("4", "sar", "vif", LocalDate.parse("1993-06-25"), "14", "121212121212121", "ee.ss@societe.com","img.png" ,dateHeureCreation , true, depService .listerDepartements().get(2), "banque b", "ibuibu", "ubui"),
                new Collaborateur("5", "pop", "youpi", LocalDate.parse("1993-06-25"), "14", "121212121212121", "ee.ss@societe.com","img.png" ,dateHeureCreation , true, depService .listerDepartements().get(2), "banque c", "yuvuvy", "hvbh")
        )
        .forEach(collab -> collabService.sauvegarderCollaborateur(collab));
        
        
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
}

