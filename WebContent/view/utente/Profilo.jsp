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

</head>
<body>
	<%@ include file="../headerfooter/Header.jsp"%>
	<%
		Utente u = (Utente) request.getAttribute("utente");
	%>
	<div style="min-height: 30em; margin-top: 15px;" class="home">
		<div class="col-lg-1"></div>
		<div class="col-lg-6"></div>
		<-----------------------info profilo------------------------>
		<div class="col-lg-4">
			<table>
				<tr>
					<th> <img alt="avatar" src="view/images/avatar.jpg"></th>
				</tr>
				<tr>
					<td><h4><%=u.getNome()%> <%=u.getCognome()%></h4></td>
				</tr>
				<tr>
					<td><%=u.getMatricola()%></td>
				</tr>
				<tr>
					<td><%=g.getOrario().getGiorno()%></td>
				</tr>
				<tr>
					<td><h3>Data:</td>
					<td><%=g.getOrario().getInizio().getDay()%>/<%=g.getOrario().getInizio().getMonth()%>/<%=g.getOrario().getInizio().getYear() + 1900%></td>
				</tr>
				<tr>
					<td><h3>Orario:</td>
					<td>dalle: <%=g.getOrario().getInizio().getHours()%>:<%=g.getOrario().getInizio().getMinutes()%>
						alle:<%=g.getOrario().getFine().getHours()%>:<%=g.getOrario().getFine().getMinutes()%></td>
				</tr>
			</table>
		</div>
		<div class="col-lg-1"></div>
	</div>

	<%@ include file="../headerfooter/Footer.html"%>
</body>
</html>