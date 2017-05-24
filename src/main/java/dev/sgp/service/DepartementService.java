package dev.sgp.service;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import dev.sgp.entite.Departement;


@Stateless
public class DepartementService {
    
    @PersistenceContext(unitName="sgp-pu") private EntityManager em;
    
    public List<Departement> listerDepartements() {
        
        List<Departement> listeDepartement = new ArrayList<>();
        
        
        TypedQuery<Departement> query = em.createQuery("SELECT d FROM Departement d",Departement.class);
        
        listeDepartement = query.getResultList();
    
        
        return listeDepartement;
    }
    
    public void sauvegarderDepartement(Departement departement) {
        
        
        em.persist(departement);
        
    }
}