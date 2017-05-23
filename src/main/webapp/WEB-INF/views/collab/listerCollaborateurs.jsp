<%@page import="dev.sgp.entite.Collaborateur"%>
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
	<h1>Les collaborateurs</h1>
	
	<ul>
		<c:forEach var="collab" items="${collaborateurs}">
			<li>${collab.matricule} - ${collab.nom} ${collab.prenom}</li>
		</c:forEach>
	</ul>
</body>
</html>