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
		<nav class="navbar navbar-expand-lg navbar navbar-custom">
			
			<div class="collapse navbar-collapse" id="navbarNavDropdown">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link" href="#">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Gruppo di studio</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Aule libere</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Chi siamo</a>
					</li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Cerca Gruppo </a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<form class="form-inline">
								<input class="form-control mr-sm-2" type="search"
									placeholder="Materia" aria-label="Search"> <input
									class="form-control mr-sm-2" type="search"
									placeholder="Nome Gruppo" aria-label="Search">
							</form>
							<button class="btnCerca " type="submit">Cerca</button>
						</div></li>
				</ul>
			</div>
		</nav>
	</div>
	
</body>
</html>