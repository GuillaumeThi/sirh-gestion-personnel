<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
<title>SGP - App</title>
</head>
<body>
<h1 style="text-align:center; margin: 20px 0 30px 0">Nouveau collaborateur</h1>

	<form class="form-horizontal" method="post">
		<fieldset>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="nomInput">Nom</label>  
		  <div class="col-md-4">
		  <input id="nomInput" name="nomInput" type="text" placeholder="nom" class="form-control input-md" required="">
		    
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="prenomInput">Prénom</label>  
		  <div class="col-md-4">
		  <input id="prenomInput" name="prenomInput" type="text" placeholder="prénom" class="form-control input-md" required="">
		    
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="dateNaissanceInput">Date de naissance</label>  
		  <div class="col-md-4">
		  <input id="dateNaissanceInput" name="dateNaissanceInput" type="date"class="form-control input-md" required="">
		    
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="adresseInput">Adresse</label>  
		  <div class="col-md-4">
		  <input id="adresseInput" name="adresseInput" type="text" placeholder="adresse" class="form-control input-md" required="">
		    
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="secuInput">Numéro de sécurité sociale</label>  
		  <div class="col-md-4">
		  <input id="secuInput" name="secuInput" type="text" placeholder="numéro de sécurité sociale" class="form-control input-md" required="">
		    
		  </div>
		</div>
		
		<!-- Button -->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="nouveauCollabButton"></label>
		  <div class="col-md-4">
		    <button id="nouveauCollabButton" name="nouveauCollabButton" class="btn btn-primary">Créer</button>
		  </div>
		</div>
		
		</fieldset>
	</form>

</body>
</html>