<%@page import="dev.sgp.entite.VisiteWeb"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
<title>SGP - App</title>
</head>

<body>

	<%@include file="../template/header.jsp"%>

	<h1 style="text-align:center; margin:20px 0 30px 0">Activités depuis le démarrage de l'application</h1>
	
	<table class="table table-striped">
		<thead>
            <tr>
                <th>Date/Heure</th>
                <th>Libellé</th>
            </tr>
        </thead>
        
        <tbody>
        	<c:forEach var="collabEvent" items="${collabEvents}">
        	<tr>
        		<td>${collabEvent.formattedDateHeure}</td>
        		
        		<c:if test="${collabEvent.type == 'CREATION_COLLAB'}">
        		<td>Création d'un nouveau collaborateur - matricule : ${collabEvent.matricule}</td>
        		</c:if>
        		
        		<c:if test="${collabEvent.type == 'MODIFICATION_COLLAB'}">
        		<td>Modification d'un collaborateur - matricule : ${collabEvent.matricule}</td>
        		</c:if>
        	</tr>
        	</c:forEach>
        </tbody>
        
	
	</table>
</body>
</html>