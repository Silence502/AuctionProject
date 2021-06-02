<%@page import="fr.eni.encheres.messages.LecteurMessage"%>
<%@page import="java.util.List"%>
<%@page import="fr.eni.encheres.bo.ArticleVendu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<%
		ArticleVendu articleVendu = (ArticleVendu)request.getAttribute("articleVendu");
		if(articleVendu!=null)
		{
	%>
			<p style="color:red;">L'article a été ajouté avec succès :</p>
			<p><%=articleVendu %></p>
	<%	
		} 
	%>
	
	<%
		List<Integer> listeCodesErreur = (List<Integer>)request.getAttribute("listeCodesErreur");
		if(listeCodesErreur!=null)
		{
	%>
			<p style="color:red;">Erreur, l'article n'a pas pu être ajouté :</p>
	<%
			for(int codeErreur:listeCodesErreur)
			{
	%>
				<p><%=LecteurMessage.getMessageErreur(codeErreur)%></p>
	<%	
			}
		}
	%>
	<form action="<%=request.getContextPath()%>/ServletAjoutArticle" method="post">
		<label for="idNom">Nom : </label><input type="texte" id="idNom" name="nom" value="<%=listeCodesErreur!=null?request.getParameter("nom"):""%>"/>
		<br/>
		<label for="idDescription">Description : </label><input type="texte" id="idDescription" name="description" value="<%=listeCodesErreur!=null?request.getParameter("description"):""%>"/>
		<br/>
		<label for="idCategorie">Catégorie : </label> <select id="idCategorie" name="categorie">
											<option value="HIGH-TECH"> HIGH-TECH </option>
											<option value="MAISON"> MAISON </option>
											<option value="JARDIN"> JARDIN </option>
											<option value="AUTO-MOTO"> AUTO-MOTO </option>
											</select>
		<br/>
		<label for="idDateDebut">Date de début : </label><input type="date" id="idDateDebut" name="date_debut" value="<%=listeCodesErreur!=null?request.getParameter("date_debut"):""%>"/>
		<br/>
		<label for="idDateFin">Date de fin : </label><input type="date" id="idDateFin" name="date_fin" value="<%=listeCodesErreur!=null?request.getParameter("date_fin"):""%>"/>
		<br/>
		<label for="idMiseAPrix">Mise à prix : </label><input type="number" id="idMiseAPrix" name="mise_a_prix" value="<%=listeCodesErreur!=null?request.getParameter("mise_a_prix"):""%>"/>
		<br/>
		<input type="submit" value="Valider"/>
	</form>
	<a href="index.html">Retour</a>
</body>
</html>