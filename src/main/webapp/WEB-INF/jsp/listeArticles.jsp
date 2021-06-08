<%@page import="fr.eni.encheres.messages.LecteurMessage"%>
<%@page import="java.util.List"%>
<%@page import="fr.eni.encheres.bo.ArticleVendu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:mso="urn:schemas-microsoft-com:office:office" xmlns:msdt="uuid:C2F41010-65B3-11d1-A29F-00AA00C14882">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lister les articles</title>

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
		List<Integer> listeCodesErreur = (List<Integer>)request.getAttribute("listeCodesErreur");

	%>
	
	<form action="<%=request.getContextPath()%>/ServletListeArticles" method="post">
		<fieldset>
		<label for="idRecherche"></label><input type="texte" placeholder="Le nom de l'article contient" type="texte" id="idRecherche" name="recherche" value="<%=listeCodesErreur!=null?request.getParameter("recherche"):""%>"/>
		<br/>
		<label for="idCategorie">Catégorie : </label> <select id="idCategorie" name="categorie">
		
		
		<%	List<String> listeCategories = (List<String>) request.getAttribute("listeCategories");
		String choix = (String) request.getAttribute("choix");
		if(listeCategories!=null) {%>
											<option value ="toutes"> TOUTES </option>
		<% for (String cat : listeCategories) { %>
		
		
											<option <% if (cat.equals(choix)) { %> selected <% } %> value=<%= cat%>> <%= cat%> </option>
		<%}} %>
											</select>
		<br/>
		<input type="submit" value="Rechercher"/>

		</fieldset>
		
		<% 
		List<ArticleVendu> listeArticles = (List<ArticleVendu>) request.getAttribute("selectionArticles");
		if (listeArticles!=null) {
		for (ArticleVendu article : listeArticles) { 
		out.println(article.toString());%>
		<br/>
		<% }}
		%>
										
	</form>
	<a href="index.html">Retour</a>
</body>
</html>