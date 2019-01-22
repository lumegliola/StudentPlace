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


<div class="col-lg-3 col-md-offset-1">
<h2>LISTA ULTIMI GRUPPi</h2>
<p>al posto di nulla non � male</p>

</div>
<div class="col-lg-3 col-md-offset-1">
			<form action="Registrazione" method="post" name="formReg">
				<h2>REGISTRATI!</h2>
				<div class="testo">
					Username: <input class="input" type="text" name="user"
						placeholder="username" required="required"">
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
				<p style="color: red"></p>
				<div class="testo">
					<input id="bottone" type="submit" value="Iscriviti!">
				</div>

			</form>
	
</div>
<div id = "col-dx" style=" border-left: 1px solid red;" class = "col-lg-4">

		
			<div class="container-fluid login" ">
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

</div>

<%@ include file="../headerfooter/Footer.html"%>

</body>
</html>