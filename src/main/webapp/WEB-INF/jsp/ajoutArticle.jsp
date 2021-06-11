<%@page import="fr.eni.encheres.messages.LecteurMessage"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="fr.eni.encheres.bo.ArticleVendu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:mso="urn:schemas-microsoft-com:office:office"
	xmlns:msdt="uuid:C2F41010-65B3-11d1-A29F-00AA00C14882">
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
<p>Session numéro : ${pageContext.session.id} |
		${user.pseudo}-${user.noUtilisateur}</p>
	<div class="container">
		<div class="row">
			<div class="col col-md-12-justify-content"
				style="display: flex; align-content: center; align-items: center; flex-direction: column; margin-top: 5%">
				<h1>Créer une enchère</h1>
				<hr>
				<c:if test="${!empty articleVendu}">
					<p style="color: green;">L'article suivant a été ajouté avec
						succès :</p>
					<p>${articleVendu.nomArticle} - ${articleVendu.description}</p>
				</c:if>

				<c:if test="${!empty listeCodesErreur}">
					<p style="color: red";>Erreur, l'article n'a pas pu être ajouté
						:</p>
					<c:forEach items="${listeCodesErreur}" var="codeErreur">
						<p>${LecteurMessage.getMessageErreur(codeErreur)}</p>
					</c:forEach>
				</c:if>
				<form
					action="${pageContext.request.contextPath}/ServletAjoutArticle"
					method="post">
					<input type="hidden" name="id" value="${user.noUtilisateur}">
					<div class="form-group">
						<label for="idNom">Nom du produit : </label> <input
							class="form-control" id="idNom" name="nom"
							value="<c:if test="${!empty listeCodesErreur}"> ${nom} </c:if>">
					</div>
					<div class="form-group">
						<label for="idDescription">Description : </label> <input
							class="form-control" type="texte" id="idDescription"
							name="description"
							value="<c:if test="${!empty listeCodesErreur}"> ${description} </c:if>">
					</div>
					<label for="idCategorie">Catégorie : </label> <select
						id="idCategorie" name="categorie" class="form-control">
						<option></option>
						<c:forEach items="${listeCategories}" var="cat">
							<option value="${cat}">${cat}</option>
						</c:forEach>
					</select>
					<div class="form-group">
						<label for="idDateDebut">Date de début : </label> <input
							class="form-control" type="date" id="idDateDebut"
							name="date_debut"
							value="${!empty listeCodesErreur ? date_debut : LocalDate.now()}">
					</div>
					<div class="form-group">
						<label for="idDateFin">Date de fin : </label> <input
							class="form-control" type="date" id="idDateFin" name="date_fin"
							value="${!empty listeCodesErreur ? date_fin : LocalDate.now().plusDays(7)}">
					</div>
					<div class="form-group">
						<label for="idMiseAPrix">Mise à prix : </label> <input
							class="form-control" type="number" id="idMiseAPrix"
							name="mise_a_prix"
							value="${!empty listeCodesErreur ? mise_a_prix : 0}">
					</div>
					<input type="submit" class="btn btn-dark" value="Valider" /> <a
						class="btn btn-dark"
						href="${pageContext.request.contextPath}/ServletListeArticles">Retour</a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
