<%@page import="dao.DAOFactory"%>
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
		Utente completo = DAOFactory.getUserDAO().doRetrieveByMailAndPass(u.getMail(), u.getPassword());
	%>
	<div style="min-height: 30em; margin-top: 15px;" class="home">
		<div class="col-lg-1"></div>
		<div class="col-lg-6"></div>
		<!-----------------------info profilo------------------------>
		<div class="col-lg-4" style=" border-left: 1px solid red;">
			<table>
				<tr>
					<th> <img alt="avatar" src="view/images/avatar.jpg"></th>
				</tr>
				<tr>
					<td><h4><%=completo.getNome()%> <%=completo.getCognome()%></h4></td>
				</tr>
				<tr>
					<td><%=completo.getMatricola()%></td>
				</tr>
				<tr>
					<td><%=completo.getMail()%></td>
				</tr>
				<tr>
					<td><%=completo.getPassword()%></td>
					<td></td>
				</tr>
				<tr>
					<td><h3></td>
					<td></td>
				</tr>
			</table>
		</div>
		<div class="col-lg-1"></div>
	</div>

	<%@ include file="../headerfooter/Footer.html"%>
</body>
</html>