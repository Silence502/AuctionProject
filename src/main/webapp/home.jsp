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
	
	<p>Session numéro : ${pageContext.session.id} | version 0.070621mv | ${sessionScope.userSession} ${sessionScope.idSession}</p>
	<div class="container">
		<div class="row">
			<div class="col col-md-4-justify-content box"
				style="display: flex; align-content: center; align-items: center; flex-direction: column; margin-bottom: 20px;">
				<h1>Accueil</h1>
				<c:if test="${sessionScope.changedSession == true}">
					<p>Profil modifié avec succès !</p>
				</c:if>
				<c:if test="${empty userSession}">
					<a href="signin.jsp">Se connecter - S'inscrire</a>
					<p>Aucune session</p>
				</c:if>
				<c:if test="${!empty userSession}">
					<a href="${pageContext.request.contextPath}/ServletConnection">Se déconnecter</a>
					<a href="${pageContext.request.contextPath}/ServletMembersList">Liste des membres</a>
					<a href="${pageContext.request.contextPath}/ServletProfileManager">Mon profil</a>
					<p>Session ouverte : ${sessionScope.userSession}</p>
				</c:if>
			</div>
		</div>
	</div>
	<script src=""></script>
</body>
</html>