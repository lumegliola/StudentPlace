<%@page import="bean.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Place</title>

<!-- IMPORT BOOTSTRAP-->
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- IMPORT CSS-->
<link rel="stylesheet" href="\view\headerfooter\Footer.css"
	type="text/css">
<link rel="stylesheet" href="\view\headerfooter\Header.css"
	type="text/css">
<link rel="stylesheet" href="view\registrazione\registrazione.css"
	type="text/css">
</head>
<!-- INCLUDE PAGE -->
<body>
	<%@ include file="../headerfooter/Header.jsp"%>
	<div class="container ">
		<div class="col-lg-3 col-md-offset-4 row down7">
			<form action="Registrazione" method="post" name="formReg">
				<h2>REGISTRATI!</h2>
				<div class="testo">
					Nome: <input class="input" type="text" name="nome"
						placeholder="Nome" required="required"">
				</div>
				<div class="testo">
					Cognome: <input class="input" type="text" name="cognome"
						placeholder="cognome" required="required"">
				</div>
				<p style="color: red"></p>
				<div class="testo">
					Password: <input class="input" type="password" name="pass"
						placeholder="password" required="required"">
				</div>
				<p style="color: red"></p>
				<div class="testo">
					E-mail: <input class="input" type="email" name="email"
						placeholder="esempio@gmail.com" required="required"">
				</div>
				<div class="testo">
					Matricola: <input class="input" type="text" name="matricola"
						placeholder="0512100000" required="required"">
				</div>
				<p style="color: red"></p>
				<div class="testo">
					<input id="bottone" type="submit" value="Iscriviti!">
				</div>

			</form>
		</div>
	</div>


	<%@ include file="../headerfooter/Footer.html"%>

</body>
</html>