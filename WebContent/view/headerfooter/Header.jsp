<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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

<title>Header</title>

</head>
<body>
	<div class="container-fluid container-header">
		<div class="row row_loghi">
			<!-- COLONNA LOGO UNISA-->
			<div class="col-md-3 column_logoUnisa">
				<img class="logoHeaderFirst" alt="Logo Unisa"
					src="view/images/logoUnisa.png">
			</div>

			<!-- COLONNA LOGO STUDENTPLACE-->
			<div class="col-md-6 column_logoSP">
				<div class="row_StudentPlace">
					<img class="logoSPxl" alt="Logo StudentPlace"
						src="view/images/logoSPxl.png">
					<p class="iconsocial">
						<i style="font-size: 3em; color: #a01313; margin-right: 0.5em;"
							class="fa">&#xf09a;</i> <i
							style="font-size: 3em; color: #a01313; margin-right: 0.5em;"
							class="fa">&#xf099;</i> <i
							style="font-size: 3em; color: #a01313; margin-right: 0.5em;"
							class="fa">&#xf16d;</i>
					</p>
				</div>
			</div>

			<!-- COLONNA LOGO INFORMATICA-->
			<div class="col-md-3 column_logoInformatica">
				<img class="logoHeaderSecond" alt="Smart Logo Informatica"
					src="view/images/logoInformatica.jpg">
			</div>
		</div>

		<!-- RIGA NAVBAR-->
		<nav class="navbar navbar-expand-lg navbar-custom">
			<span class="navbar-brand"> StudentPlace </span>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav nav nav-pills nav-fill">
					<li class="nav-item active"><a class="nav-link" href="ShowHome">
							<span class="glyphicon glyphicon-home"></span>
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
					<li class="nav-item"><input type="text" class="form-control"
						placeholder="Cerca gruppo" aria-label="Cerca gruppo"
						aria-describedby="basic-addon1"></li>

				</ul>
				<ul class="nav navbar-nav navbar-right">
				
				<%boolean logged=(boolean)session.getAttribute("logged");
				if(logged){
				Utente utente=(Utente)session.getAttribute("utente");
				
				
				%>
				
					<li class="nav-item"><a href="#"><%=utente.getNome() %></a></li>
					<li class="nav-item"><a href="logout"><span
							class="glyphicon glyphicon-log-out"></span> Logout</a></li>
							<%}
				else if(logged==false){%>
				 <a href="ShowHome">Login</a>
				 <%} %>
				</ul>
			</div>
		</nav>
	</div>

</body>
</html>