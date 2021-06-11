<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
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
<link rel="stylesheet" href="../css/home-style.css">
</head>
<body>
	<!--[if lt IE 7]>
			<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="#">upgrade your browser</a> to improve your experience.</p>
		<![endif]-->

	<p>Session numéro : ${pageContext.session.id} |
		${user.pseudo}-${user.noUtilisateur}</p>
	<p>${test }</p>
	<div class="container">
		<div class="row">
			<div class="col col-md-12"
				style="display: flex;  flex-direction: column; margin-bottom: 20px;">
				<h1>Accueil</h1>
				<hr>
					<c:if test="${changedSession == true}">
					<p style="color: green">Profil modifié avec succès !</p>
				</c:if>
				<c:if test="${empty user}">
					<div style="display: flex;justify-content: flex-end;">
						<a href="signin.jsp">Se connecter / S'inscrire</a>
					</div>
				</c:if>
				<c:if test="${!empty user}">
				
					<div style="display: flex;justify-content: space-between;">
						<div>
							<p><strong>Connecté : </strong>${user.pseudo}</p>
						</div>
						<div>
							<p>
								<a href="${pageContext.request.contextPath}/ServletHomeDisconnected">Se déconnecter </a> |
								<a href="${pageContext.request.contextPath}/ServletMembersList">Liste des membres </a> |
								<a href="${pageContext.request.contextPath}/ServletProfileManager">Mon profil </a> |
								<a href="${pageContext.request.contextPath}/ServletAjoutArticle">Créer une enchère</a>
							</p>
						</div>
					</div>
				</c:if>

				<hr>
				<form
					action="${pageContext.request.contextPath}/ServletHomeConnected"
					method="GET">
					<h3>Filtres :</h3>
					<div style="display: flex; justify-content: space-between;">
						<div class="form-inline">
							<input class="form-control" type="texte" style="margin-bottom: 10px;"
								placeholder="Le nom de l'article contient" type="texte"
								id="idRecherche" name="recherche" style="margin-right: 2%;"
								value="<c:if test="${!empty listeCodesErreur}"> ${recherche} </c:if>">
							<input type="submit" class="btn btn-dark" value="Rechercher" style="margin-bottom: 10px;" />
						</div>
						<div>
							<label for="idCategorie">Catégorie : </label> <select
								id="idCategorie" name="categorie">
								<option class="form-control" value="toutes">TOUTES</option>
								<c:forEach items="${listeCategories}" var="cat">
									<option <c:if test="${cat.equals(choix)}"> selected  </c:if>
										value="${cat}">${cat}</option>
								</c:forEach>
							</select> <br /> <br />
						</div>
					</div>
					<hr>
					<table class="table">
						<thead class="thead-light">
							<tr>
								<th scope="col">Nom</th>
								<th scope="col">Description</th>
								<th scope="col">Date de fin</th>
								<th scope="col">Prix de départ</th>
								<th scope="col">Vendeur</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${!empty selectionArticles}">
								<c:forEach items="${selectionArticles}" var="article">
									<tr>
										<td scope="row">${article.nomArticle}</td>
										<td>${article.description}</td>
										<td>${article.dateFinEncheres}</td>
										<td>${article.prixVente}</td>
										<td>${article.noUtilisateur}</td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
	${article.toString()}
	<script src=""></script>
</body>
</html>