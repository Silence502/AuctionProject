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
				<div style="display: flex;justify-content: flex-start;">
					<div>
						<h3>Mon profil</h3>
					</div>
					<div>
						<input style="margin-left:50%" type="submit" class="btn btn-dark" value="Valider les modifications">
					</div>
				</div>
				<form method="POST"
					action="${pageContext.request.contextPath}/ServletProfileManager">
					<input type="hidden" name="id" value="${user.noUtilisateur}">
					<c:if test="${alreadyExistsSession == true}">
						<td style="color: red;">Le pseudo doit être suppérieur à 4
							caractères !</td>
					</c:if>
					<table class="table table-bordered" style="width:50%">
						<thead>
							<tr>
								<th colspan="7">Données personnelles</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th>Pseudo :</th>
								<td><input class="form-control" name="pseudo" type="text" required
									pattern="([A-Za-z0-9]+)" maxlength="15" value="${user.pseudo}"></td>
								<c:if test="${tooSmall < 4}">
									<td style="color: red;"> -> Le pseudo doit être suppérieur à 4
										caractères !</td>
								</c:if>
							</tr>
							<tr>
								<th>Nom :</th>
								<td><input class="form-control" name="nom" type="text" required
									value="${user.nom}"></td>
							</tr>
							<tr>
								<th>Prénom :</th>
								<td><input class="form-control" name="prenom" type="text" required
									value="${user.prenom}"></td>
							</tr>
							<tr>
								<th>Email :</th>
								<td><input class="form-control" name="email" type="email" required
									value="${user.email}"
									pattern="[A-Za-z0-9](([_\.\-]?[a-zA-Z0-9]+)*)@([A-Za-z0-9]+)(([_\.\-]?[a-zA-Z0-9]+)*)\.([A-Za-z]{2,})">
								</td>
							</tr>
							<tr>
								<th>Téléphone :</th>
								<td><input class="form-control" name="telephone" type="tel"
									value="${user.telephone}"
									pattern="(01|02|03|04|05|06|07|08|09)[ \.\-]?[0-9]{2}[ \.\-]?[0-9]{2}[ \.\-]?[0-9]{2}[ \.\-]?[0-9]{2}"></td>
							</tr>
							<tr>
								<th>Adresse :</th>
								<td><input class="form-control" name="rue" type="text" required
									value="${user.rue}"></td>

							</tr>
							<tr>
								<th>Code postal :</th>
								<td><input class="form-control" name="codePostal" type="text" required
									value="${user.codePostal}"
									pattern="([A-Z]+[A-Z]?\-)?[0-9]{1,2} ?[0-9]{3}"></td>
							</tr>
							<tr>
								<th>Ville :</th>
								<td><input class="form-control" name="ville" type="text" required
									value="${user.ville}"></td>
							</tr>
							<tr>
								<th>Mot de passe : </th>
								<td><input class="form-control" name="motDePasse" type="password"
									placeholder="*******" required></td>
								<c:if test="${isNotOk == false}">
									<td style="color:red;"> -> Mot de passe incorrect</td>
								</c:if>
								
							</tr>
							<tr>
								<th>Crédit :</th>
								<td>${user.credit}</td>
							</tr>
						</tbody>
					</table>
					<input type="hidden" name="mdp_tocheck" value="${user.motDePasse}">
					<hr>
				</form>
			</div>
		</div>
	</div>

	<script src=""></script>
</body>
</html>