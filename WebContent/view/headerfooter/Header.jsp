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
				<div class="row row_StudentPlace">
					<img class="logoSPxl" alt="Logo StudentPlace" src="logoSPxl.png">
				</div>
				<div class="row row_Social">
					<img class="social" alt="fb" src="fb.png"> <img
						class="social" alt="is" src="is.png"> <img class="social"
						alt="tw" src="tw.png">
				</div>
			</div>

			<!-- COLONNA LOGO INFORMATICA-->
			<div class="col-md-3 column_logoInformatica">
				<img class="logo" alt="Smart Logo Informatica"
					src="logoInformatica.jpg">
			</div>
		</div>

		<!-- RIGA NAVBAR-->
		<div class="row row_navbar">
			<nav class="navbar navbar-custom">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">StudentPlace</a>
					</div>
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#">Gruppi di studio</a></li>
						<li><a href="#">Aule libere</a></li>
						<li><a href="#">Chi Siamo</a></li>
						<li><a href="#">Aiuto</a></li>
					</ul>
				</div>
			</nav>
		</div>
	</div>
</body>
</html>