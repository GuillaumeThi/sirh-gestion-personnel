package dev.sgp.entite;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Collaborateur {

	@Id
	private String matricule;
	private String nom;
	private String prenom;
	private LocalDate dateDeNaissance;
	private String adresse;
	private String numSecu;
	private String email;
	private String photo;
	private ZonedDateTime dateHeureCreation;
	private boolean actif;
	private String banque;
	private String bic;
	private String iban;

	@ManyToOne
	private Departement departement;
	
	
	public Collaborateur() {
		
	}
	
	public Collaborateur(String matricule, String nom, String prenom, LocalDate dateDeNaissance, String adresse,
			String numSecu, String email, String photo) {
		
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
		this.numSecu = numSecu;
		this.email = email;
		this.photo = photo;
	}
	
	public Collaborateur(String matricule, String nom, String prenom, LocalDate dateDeNaissance, String adresse, String numSecu,
			String email, String photo, ZonedDateTime dateHeureCreation, boolean actif) {
		
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
		this.numSecu = numSecu;
		this.email = email;
		this.photo = photo;
		this.dateHeureCreation = dateHeureCreation;
		this.actif = actif;
	}
	
	public Collaborateur(String matricule, String nom, String prenom, LocalDate dateDeNaissance, String adresse, String numSecu,
			String email, String photo, ZonedDateTime dateHeureCreation, boolean actif, Departement departement, String banque, String bic, String iban) {
		
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
		this.numSecu = numSecu;
		this.email = email;
		this.photo = photo;
		this.dateHeureCreation = dateHeureCreation;
		this.actif = actif;
		this.departement = departement;
		this.banque = banque;
		this.bic = bic;
		this.iban = iban;
	}

	public String getMatricule() {
		return matricule;
	}
	
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}
	
	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getNumSecu() {
		return numSecu;
	}
	
	public void setNumSecu(String numSecu) {
		this.numSecu = numSecu;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoto() {
		return photo;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public ZonedDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}
	
	public void setDateHeureCreation(ZonedDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}
	
	public boolean isActif() {
		return actif;
	}
	
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	
	public Departement getDepartement() {
		return departement;
	}
	
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
	public String getBanque() {
		return banque;
	}

	public void setBanque(String banque) {
		this.banque = banque;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}
	
}
