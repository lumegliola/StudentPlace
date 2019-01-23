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
<link rel="stylesheet" href="view/headerfooter/Header.css"
	type="text/css">
<link rel="stylesheet" href="view/headerfooter/Footer.css"
	type="text/css">
	
</head>
<!-- INCLUDE PAGE -->
<body>
<%@ include file="../headerfooter/Header.jsp" %>
<div style="min-height: 30em; padding-top: 3em;" class  ="home">
<script type="text/javascript">
	
function redirect() 
	{
		location.href = "ShowRegistrazione";
	}
		window.setTimeout("redirect()", 3000);
		</script>

<div id="home">
			<h2>Errore!</h2>
			<h3>Fra pochi secondi, sarai reindirizzato alla <a href="ShowRegistrazione">Home</a>!</h3>
			<h4>Clicca su <a href="ShowRegistrazione">Home</a> se non dovesse accadere in automatico.</h4>
			
	</div>

</div>

<%@ include file="../headerfooter/Footer.html"%>

</body>
</html>