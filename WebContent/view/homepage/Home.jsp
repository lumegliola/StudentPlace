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
<div style="min-height: 20em; padding-top: 3em;" class  ="home">
<div class = "col-lg-1"></div>

<div id= "col-sx" class = "col-lg-4">
CIAO! non sappiamo cosa mettere qui, 
quindi per adesso ci limitiamo a scrivere questo

CIAO! non sappiamo cosa mettere qui, 
quindi per adesso ci limitiamo a scrivere questo

CIAO! non sappiamo cosa mettere qui, 
quindi per adesso ci limitiamo a scrivere questo

CIAO! non sappiamo cosa mettere qui, 
quindi per adesso ci limitiamo a scrivere questo

CIAO! non sappiamo cosa mettere qui, 
quindi per adesso ci limitiamo a scrivere questo

CIAO! non sappiamo cosa mettere qui, 
quindi per adesso ci limitiamo a scrivere questo

CIAO! non sappiamo cosa mettere qui, 
quindi per adesso ci limitiamo a scrivere questo

</div>
<div class = "col-lg-2">
</div>
<div id = "col-dx" class = "col-lg-4">

		
			<div class="container-fluid login">
			<div>
				<label class="creaaccount">Accedi a Student place:</label><br />

				<form action="login" method="post" onsubmit="return validateForm()">

					<label>E-mail:&nbsp;</label><label id="resMail"></label><br />
					<input type="text" name="email" id="email"
						placeholder="email"
						style="width: 90%; clear: both;"><br /> <br /> 
						
						<label>Password:&nbsp;</label><label id="resPass"></label><br/> 
						<input type="password" name="password" id="password"
						placeholder="password" style="width: 90%; clear: both;"><br /><br />
					
					
					<input type="submit" class="button" value="Accedi"></input>
				</form>
			</div>
		</div>

</div>
<div class = "col-lg-1">
</div>
</div>

<%@ include file="../headerfooter/Footer.html"%>

</body>
</html>