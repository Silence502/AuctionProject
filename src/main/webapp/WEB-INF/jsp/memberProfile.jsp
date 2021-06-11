<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<!--[if lt IE 7]>
			<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="#">upgrade your browser</a> to improve your experience.</p>
		<![endif]-->

	<p>Session numéro : ${pageContext.session.id} |
		${user.pseudo}-${user.noUtilisateur}</p>
	<div class="container">
		<div class="row">
			<div class="col col-md-12">
				<h1>Profil</h1>
				<hr>
				<div style="display: flex;justify-content: space-between;">
					<div>
					 	<p><strong>Connecté :</strong> ${user.pseudo}</p>
					</div>
					
					<div>
						<a href="${pageContext.request.contextPath}/ServletListeArticles">Retour
						à l'accueil</a>
					</div>
				</div>
				<hr>
				<h3>Mon profil de ${member.pseudo}</h3>
				<table class="table table-bordered" style="width:50%">
						<thead>
							<tr>
								<th colspan="7">Données personnelles</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th>Pseudo :</th>
								<td>${member.pseudo}</td>
							</tr>
							<tr>
								<th>Nom :</th>
								<td>${member.nom}</td>
							</tr>
							<tr>
								<th>Prénom :</th>
								<td>${member.prenom}</td>
							</tr>
							<tr>
								<th>Email :</th>
								<td>${member.email}</td>
							</tr>
							<tr>
								<th>Téléphone :</th>
								<td>${member.telephone}</td>
							</tr>
							<tr>
								<th>Adresse :</th>
								<td>${member.rue}</td>

							</tr>
							<tr>
								<th>Code postal :</th>
								<td>${member.codePostal}</td>
							</tr>
							<tr>
								<th>Ville :</th>
								<td>${member.ville}</td>
							</tr>
						</tbody>
					</table>
			</div>
		</div>
	</div>
	<script src=""></script>
</body>
</html>