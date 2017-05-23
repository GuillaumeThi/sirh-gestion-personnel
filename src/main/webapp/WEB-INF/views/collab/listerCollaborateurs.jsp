<%@ page import="java.util.List"%>
<%@ page import="dev.sgp.entite.Collaborateur"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
<title>SGP - App</title>
</head>
<body>
<h1>Les collaborateurs</h1>

	<!-- Liste des noms -->
	
	
	<%
		List<Collaborateur> collaborateurs = (List<Collaborateur>)request.getAttribute("collaborateurs");
		for (Collaborateur collaborateur : collaborateurs) {
	%>
	
	<div style="float:left">
		<ul>
			<li>Nom : <%= collaborateur.getNom() %></li>
			<li>Prénom : <%= collaborateur.getPrenom() %></li>
			<li>Matricule : <%= collaborateur.getMatricule() %></li>
			<li>Date de naissance : <%= collaborateur.getDateDeNaissance() %></li>
			<li>Adresse : <%= collaborateur.getAdresse() %></li>
			<li>Num sécu : <%= collaborateur.getNumSecu() %></li>
			<li>Email : <%= collaborateur.getEmail() %></li>
			<li>Photo : <%= collaborateur.getPhoto() %></li>
			<li>Date d'inscription : <%= collaborateur.getDateHeureCreation() %></li>
			<li>Statut : <% if(collaborateur.getActif()) { %>
								ACTIF
						<%	} else {  %>
								Inactif
						<%	} %></li>
		</ul>
	</div>
	
	<%
		}
	%>
	
	
</body>
</html>