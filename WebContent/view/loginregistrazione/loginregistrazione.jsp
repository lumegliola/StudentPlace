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
<link rel="stylesheet" href="view\registrazione\loginregistrazione.css"
	type="text/css">
<script >
$(window).on("load",function() {

 $("#pulsanteReg").click(function(){
    	$("#reg").show();
    	$("#log").hide();
    	
    });
 $("#pulsanteLog").click(function(){
    	$("#log").show();
    	$("#reg").hide();
    	
    });
});</script>
	
</head>
<!-- INCLUDE PAGE -->
<body>

	<div class="container-fluid login" n="login" method="post">
		<form action="login" method="post" name="formLog" id="log">
		<h4 style="color: #a01313">Login</h4>
			<label>E-mail:&nbsp;</label><label id="resMail"></label><br /> <input
				type="text" name="email" id="email" placeholder="Inserisci email"
				style="width: 90%; clear: both; margin-bottom: 2em;"><br />

			<label>Password:&nbsp;</label><label id="resPass"></label> <input
				type="password" name="password" id="password" placeholder="Inserisci password"
				style="width: 90%; clear: both; margin-bottom: 2em;"> <span><input
				type="submit" class="button" value="Accedi"></input> <sub>o <a
					id="pulsanteReg">Registrati</a></sub></span>
		</form>

		<form action="ServletRegistrazione" method="post" name="formReg"
			id="reg" style="display:none;">
			<h4 style="color: #a01313">Registrazione</h4>
			<label>Nome:&nbsp;</label> <input
				type="text" name="nome" id="nome" placeholder="Inserisci il tuo nome"
				style="width: 90%; clear: both; margin-bottom: 0.5em;">

			<label>Cognome:&nbsp;</label><input
				type="text" name="cognome" id="cognome" placeholder="Inserisci il tuo cognome"
				style="width: 90%; clear: both; margin-bottom: 0.5em;"> 
				
						<label>E-mail:&nbsp;</label><input
				type="text" name="email" id="cemail" placeholder="Inserisci la tua email"
				style="width: 90%; clear: both; margin-bottom: 0.5em;"> 
				
							<label>Password:&nbsp;</label><input
				type="password" name="password" id="cpassword" placeholder="Scegli una password"
				style="width: 90%; clear: both; margin-bottom: 0.5em;"> 
				
							<label>Matricola:&nbsp;</label><input
				type="text" name="matricola" id="matricola" placeholder="Inserisci la tua matricola"
				style="width: 90%; clear: both; margin-bottom: 1em;"> 
				
					<span><input id="bottone" type="submit" value="Iscriviti!">
						<a id="pulsanteLog">Sei registrato?</a></span>
				</div>
		</form>
	</div>

</body>
</html>