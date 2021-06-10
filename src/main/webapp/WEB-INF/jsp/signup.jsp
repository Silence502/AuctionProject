<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]>      <html class="no-js"> <!--<![endif]-->
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title></title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<link rel="stylesheet" href="../css/signup-style.css">
</head>
<body>
	<!--[if lt IE 7]>
			<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="#">upgrade your browser</a> to improve your experience.</p>
		<![endif]-->
	<p>Session numéro : ${pageContext.session.id} | ${user.pseudo}-${user.noUtilisateur}</p>
	<div class="container">
		<div class="row">
			<div class="col col-md-4-justify-content"
				style="display: flex; align-content: center; align-items: center; flex-direction: column">
				<h1>Inscription</h1>

				<form method="POST" action="${pageContext.request.contextPath}/ServletHomePage"
					style="display: flex; align-content: center; align-items: center; flex-direction: column">
					<c:if test="${tooSmall < 4}"><span style="color:red">Le pseudo doit être supérieur à 3 caractères</span></c:if>
					<c:if test="${alreadyExistsSession == true}">
						<div style="width:400px;text-align:center;" class="elert alert-warning" role="alert">
							<span style="color:red">Les identifiants correspondent à un utilisateur enregistré.</span>
							<span style="color:red">Vérifiez que vous ne possédez pas déjà un compte ou réessayez avec un autre email ou pseudo.</span>	
						</div>					
					</c:if>
						<label for="pseudo">Pseudo*</label> 
						<input name="pseudo" type="text"
						placeholder="pseudo" required pattern="([A-Za-z0-9]+)" maxlength="15"> 
						<label for="nom">Nom*</label>
						<input name="nom" type="text" placeholder="nom" required value="${userSave.nom}">
						<label for="prenom">Prenom*</label>
						<input name="prenom" type="text" placeholder="prenom" required value="${userSave.prenom}"> 
						<label for="email">Adresse mail*</label> 
						<input name="email" type="email"
						placeholder="email" required pattern="[A-Za-z0-9](([_\.\-]?[a-zA-Z0-9]+)*)@([A-Za-z0-9]+)(([_\.\-]?[a-zA-Z0-9]+)*)\.([A-Za-z]{2,})"> 
						<label for="telephone">Telephone</label> 
						<input name="telephone"
						type="tel" placeholder="telephone" value="${userSave.telephone}" pattern="(01|02|03|04|05|06|07|08|09)[ \.\-]?[0-9]{2}[ \.\-]?[0-9]{2}[ \.\-]?[0-9]{2}[ \.\-]?[0-9]{2}"> 
						<label for="rue">Rue*</label> 
						<input name="rue" type="text" placeholder="rue" required value="${userSave.rue}"> 
						<label for="codePostal">Code postal*</label> 
						<input name="codePostal"
						type="text" placeholder="code postal" required value="${userSave.codePostal}" pattern="([A-Z]+[A-Z]?\-)?[0-9]{1,2} ?[0-9]{3}">
						<label for="ville">Ville*</label> 
						<input name="ville" type="text" placeholder="ville" required value="${userSave.ville}"> 
						<label for="motDePasse">Mot de passe*</label> 
						<input name="motDePasse" type="password" placeholder="*******" required>
						<cite>* mentions obligatoires</cite>
					<input type="submit" value="Envoyer">
					<a href="signin.jsp">Retour</a>
				</form>
			</div>
		</div>
	</div>

	<script src=""></script>
</body>
</html>