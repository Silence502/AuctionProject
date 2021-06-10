<%@page import="fr.eni.encheres.messages.LecteurMessage"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="fr.eni.encheres.bo.ArticleVendu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:mso="urn:schemas-microsoft-com:office:office" xmlns:msdt="uuid:C2F41010-65B3-11d1-A29F-00AA00C14882">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter un article</title>

<!--[if gte mso 9]><xml>
<mso:CustomDocumentProperties>
<mso:_dlc_DocId msdt:dt="string">Z5HNVW24N33T-678105430-3881</mso:_dlc_DocId>
<mso:_dlc_DocIdItemGuid msdt:dt="string">e4fbd88a-9c55-481f-9bba-0498eeb0f0ab</mso:_dlc_DocIdItemGuid>
<mso:_dlc_DocIdUrl msdt:dt="string">http://inet/eni-transverse/ecole-numérique/_layouts/15/DocIdRedir.aspx?ID=Z5HNVW24N33T-678105430-3881, Z5HNVW24N33T-678105430-3881</mso:_dlc_DocIdUrl>
</mso:CustomDocumentProperties>
</xml><![endif]-->
</head>
<body>
	<c:if test="${!empty articleVendu}">
			<p style="color:red;">L'article suivant a été ajouté avec succès :</p>
			<p>${articleVendu.nomArticle} ${articleVendu.description}</p>
	</c:if>
	
	<c:if test="${!empty listeCodesErreur}">
			<p style="color:red";> Erreur, l'article n'a pas pu être ajouté :</p>			
		<c:forEach items="${listeCodesErreur}" var ="codeErreur">
			  	<p>${LecteurMessage.getMessageErreur(codeErreur)}</p>   
		</c:forEach>
	</c:if>
	
	  
	<form action="${pageContext.request.contextPath}/ServletAjoutArticle" method="post">
		<label for="idNom">Nom : </label><input id="idNom" name="nom" value= "<c:if test="${!empty listeCodesErreur}"> ${nom} </c:if>">
		<br/>
		<label for="idDescription">Description : </label><input type="texte" id="idDescription" name="description" value= "<c:if test="${!empty listeCodesErreur}"> ${description} </c:if>">
		<br/>
		<label for="idCategorie">Catégorie : </label> 
		<select id="idCategorie" name="categorie">
		
		
		
											<option> </option>
		<c:forEach items="${listeCategories}" var ="cat">
											<option value= "${cat}"> ${cat} </option>
		</c:forEach>
	
		</select>
		<br/>
		<label for="idDateDebut">Date de début : </label><input type="date" id="idDateDebut" name="date_debut" value= "${!empty listeCodesErreur ? date_debut : LocalDate.now()}">
		<br/>
																													
		<label for="idDateFin">Date de fin : </label><input type="date" id="idDateFin" name="date_fin" value= "${!empty listeCodesErreur ? date_fin : LocalDate.now().plusDays(7)}"> 
		<br/>
		<label for="idMiseAPrix">Mise à prix : </label><input type="number" id="idMiseAPrix" name="mise_a_prix" value= "${!empty listeCodesErreur ? mise_a_prix : 0}"> 
		<br/>
		<input type="submit" value="Valider"/>
	</form> 
	<a href="index.html">Retour</a>
</body>
</html>