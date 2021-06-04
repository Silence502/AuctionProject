<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div class="container">
		<div class="row">
			<div class="col col-md-4-justify-content"
				style="display: flex; align-content: center; align-items: center; flex-direction: column">
				<h1>Inscription</h1>

				<form method="POST" action="${pageContext.request.contextPath}/ServletHomePage"
					style="display: flex; align-content: center; align-items: center; flex-direction: column">
					<label for="pseudo">Pseudo*</label> <input name="pseudo" type="text"
						placeholder="pseudo" required="required"> <label for="nom">Nom*</label>
					<input name="nom" type="text" placeholder="nom" required="required">
					<label for="prenom">Prenom*</label> <input name="prenom" type="text"
						placeholder="prenom" required="required"> <label
						for="email">Adresse mail*</label> <input name="email" type="email"
						placeholder="email" required="required"> <label
						for="telephone">Telephone</label> <input name="telephone"
						type="tel" placeholder="telephone"> <label
						for="rue">Rue*</label> <input name="rue" type="text"
						placeholder="rue" required="required"> <label
						for="codePostal">Code postal*</label> <input name="codePostal"
						type="text" placeholder="code postal" required="required">
					<label for="ville">Ville*</label> <input name="ville" type="text"
						placeholder="ville" required="required"> <label
						for="motDePasse">Mot de passe*</label> <input name="motDePasse"
						type="password" placeholder="*******" required="required">
						<cite>* mentions sont obligatoires</cite>
					<input type="submit" value="Envoyer">
					<a href="signin.jsp">Retour</a>
				</form>
			</div>
		</div>
	</div>

	<script src=""></script>
</body>
</html>