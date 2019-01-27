<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="bean.*"%>
<%@page session="true"%>
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
<script type="text/javascript">
	function showResult(str) {
		if (str.length == 0) {
			document.getElementById("livesearch").innerHTML = "";
			document.getElementById("livesearch").style.border = "0px";
			return;
		}
		if (window.XMLHttpRequest) {
			// per IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else { // per IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				document.getElementById("livesearch").innerHTML = this.responseText;
				document.getElementById("livesearch").style.border = "1px solid #A5ACB2";
			}
		}
		xmlhttp.open("GET", "RicercaGds?inputGruppo=" + str, true);
		xmlhttp.send();
	}
</script>

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
					<li class="nav-item active"><a class="nav-link"
						href="ShowHome"> <span class="glyphicon glyphicon-home"></span>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="CreaModificaGruppo?operazione=crea">nuovo gruppo di studio</a></li>
					<li class="nav-item"><a class="nav-link"
						href="visualizzaAuleLibere">Cerca aule libere</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Contatti</a></li>
					
					<% Utente admin = (Utente) session.getAttribute("utente");
					System.out.println(admin.isAdmin());
					if( admin.isAdmin() == true){ %>
					
					<li class="nav-item"><a class="nav-link" href="GestioneOrario">Gestione orari</a></li>
					
					<%} %>
					
					<li style="padding: 3px;" class="nav-item "><form class="form-inline" action="RicercaGds" method="post" autocomplete="off">

							<input class="form-control mr-sm-2" id=search_input type="text" class="bar" name="inputGruppo"
								placeholder="Cerca un gruppo di studio" onkeyup="showResult(this.value)">

							
								<button class="btn btn-outline-success my-2 my-sm-0" id=submit_search class="btn btn-info submit search "
									type="submit">
									<i class="glyphicon glyphicon-search"></i>
								</button>
							
						
					</form></li>

					<% //if(session != null && session.getAttribute("logged")!=null){
					//	boolean admin = false;
						
						//admin = (boolean) session.getAttribute("admin");
					
						//if(admin==true){ %>

					

					<%//}
					//	} %>
				</ul>
				<ul class="nav navbar-nav navbar-right">

					<%
				boolean logged=false;
				if(session.getAttribute("logged")==null){
					logged=false;
				}else{
				logged=(boolean)session.getAttribute("logged");
				}
				if(logged){
				Utente utente=(Utente)session.getAttribute("utente");
				
				
				%>

					<li class="nav-item"><a href="ServletVisualizzaProfilo"><%=utente.getNome() %></a></li>
					<li class="nav-item"><a href="logout"><span
							class="glyphicon glyphicon-log-out"></span> Logout</a></li>
					<%}
				else if(logged==false){%>
					<li class="nav-item"><a href="ShowHome">Login</a></li>
					<%} %>
				</ul>
				<div class="col-lg-6"></div>
				<div id="livesearch" class="col-lg-6 column-center result"></div>
			</div>
		</nav>
	</div>

</body>
</html>