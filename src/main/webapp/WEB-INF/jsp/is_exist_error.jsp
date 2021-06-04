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



	<div class="container">
		<div class="row">
			<div class="col col-md-5-justify-content">
				<div class="elert alert-warning" role="alert" 
					style="display: flex; align-content: center; align-items: center; flex-direction: column; margin-top: 20%; text-align: center;">
					<h3>! Attention !</h3>
					<p style="margin:10px">L'adresse email ou le pseudo correspondent à un utilisateur enregistré, vérifier que vous ne
						possédez pas déjà un compte ou réessayez avec un autre pseudo ou email.</p>
					<form method="GET"
						action="${pageContext.request.contextPath}/ServletHomePage">
						<input type="submit" value="Retour" style="margin:10px;">
					</form>
				</div>
			</div>
		</div>
	</div>

	<script src=""></script>
</body>
</html>