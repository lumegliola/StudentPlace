<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<!-- IMPORT CSS-->
<link rel="stylesheet" href="Header.css">
<head>
<meta charset="ISO-8859-1">
<title>Header</title>

<!-- IMPORT BOOTSTRAP-->
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>
<body>
	<div class="container-fluid container-header">
		<div class="row row_loghi">
			<!-- COLONNA LOGO UNISA-->
			<div class="col-md-3 column_logoUnisa">
				<img class="logo" alt="Logo Unisa" src="logoUnisa.png">
			</div>

			<!-- COLONNA LOGO STUDENTPLACE-->
			<div class="col-md-6 column_logoSP">
				<div class="row_StudentPlace">
					<img class="logoSPxl" alt="Logo StudentPlace" src="logoSPxl.png">
				</div>
			</div>

			<!-- COLONNA LOGO INFORMATICA-->
			<div class="col-md-3 column_logoInformatica">
				<img class="logo" alt="Smart Logo Informatica"
					src="logoInformatica.jpg">
			</div>
		</div>

		<!-- RIGA NAVBAR-->
		<nav class="navbar navbar-expand-lg navbar-custom">
			<span class="navbar-brand">
				StudentPlace
			</span>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav nav nav-pills nav-fill">
					<li class="nav-item active"><a class="nav-link" href="#">
							<span class="glyphicon glyphicon-home"></span> Home
					</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> Gruppi di Studio</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="#">Crea</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Modifica</a>
						</div></li>
					<li class="nav-item"><a class="nav-link" href="#">Cerca
							aule libere</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Contatti</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Chi
							Siamo</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="nav-item"><a href="#">Ciao! Nome Utente</a></li>
					<li class="nav-item"><a href="#"><span class="glyphicon glyphicon-log-out"></span>
							Logout</a></li>
				</ul>
			</div>
		</nav>
	</div>

</body>
</html>