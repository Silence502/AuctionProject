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
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<!--[if lt IE 7]>
			<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="#">upgrade your browser</a> to improve your experience.</p>
		<![endif]-->
	<p>Session numéro : ${pageContext.session.id} | version 0.070621mv</p>
	<div class="container">
		<div class="row">
			<div class="col col-md-12">
				<h1>Profil</h1>
				<hr>
				<p>
					<strong>Connecté :</strong> ${sessionScope.userSession} | <a href="home.jsp">Retour à l'accueil</a>
				</p>
				<hr>
				<h3>Modifer mon profil</h3>
				<form action="">
				<table>
					<thead>
						<tr>
							<th colspan="7">Données du profil</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>Pseudo :</th>
							<td>${sessionScope.userSession}</td>
						</tr>
						<tr>
							<th>Nom :</th>
							<td>${sessionScope.nomSession}</td>
						</tr>
						<tr>
							<th>Prénom :</th>
							<td>${sessionScope.prenomSession}</td>
						</tr>
						<tr>
							<th>Email :</th>
							<td>${sessionScope.emailSession}</td>
						</tr>
						<tr>
							<th>Téléphone :</th>
							<td>${sessionScope.telSession}</td>
						</tr>
						<tr>
							<th>Adresse :</th>
							<td>${sessionScope.rueSession}</td>
						
						</tr>
						<tr>
							<th>Mot de passe :</th>
							<td><input type="password" placeholder="******"></td>
						</tr>
					</tbody>
				</table>
					<input type="submit" value="Valider">
				</form>
			</div>
		</div>
	</div>

	<script src=""></script>
</body>
</html>