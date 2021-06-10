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
	<p>Session numéro : ${pageContext.session.id} | ${user.pseudo}-${user.noUtilisateur}</p>
	<div class="container">
		<div class="row">
			<div class="col col-md-12">
				<h1>Liste des membres</h1>
				<hr>
				<p><strong>Connecté :</strong> ${user.pseudo}  (<a href="${pageContext.request.contextPath}/ServletProfileManager">Voir profil</a>) | <a href="home.jsp">Retour à l'accueil</a></p>
				<hr>

				<p>Membres inscrits : ${userList.size()}</p>
				<p>${requestScope.request.testDetail}</p>
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Pseudo</th>
							<th scope="col">Nom</th>
							<th scope="col">Prénom</th>
							<th scope="col">Email</th>
							<th scope="col">Téléphone</th>
							<th scope="col">Adresse</th>
							<th scope="col">Détails</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="member" items="${userList}">
							<tr>
								<td scope="row">${member.pseudo}</td>
								<td>${member.nom}</td>
								<td>${member.prenom}</td>
								<td>${member.email}</td>
								<td>${member.telephone}</td>
								<td>${member.rue}, ${member.codePostal} ${member.ville}</td>
								<td><a href="${pageContext.request.contextPath}/ServletTest?detail=${member.pseudo}">Voir</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script src=""></script>
</body>
</html>