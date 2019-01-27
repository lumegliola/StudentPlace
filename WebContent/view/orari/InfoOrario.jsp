<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Info aula liberai</title>
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
<link rel="stylesheet" href="view/GdS/CreaGruppo.css" type="text/css">
</head>
<body>
<% AulaLibera al = (AulaLibera)request.getAttribute("aulaLibera");
	Orario or = (Orario)request.getAttribute("orario");
%>
	<%@ include file="../headerfooter/Header.jsp"%>
	<div class="container-fluid" style="padding: 3%">

		<div class="col-lg-6" style="overflow: auto; min-height: 20em;">
		
		<table style="margin-left: 37%; margin-right: 37%; margin-top: 5%; margin-bottom: 5%">
  
  <tr>
    <td><h3>Aula </h3></td>
    <td><%= al.getAula().getNomeAula()%></td>
  </tr>
  <tr>
  		<td> <h3>Edificio: </h3></td>
  		<td><%=al.getAula().getEdificio()%>
  </tr>
  <tr>
		<td><h3>Giorno: </h3></td>
		<td> <%=al.getGiorno()%></td>  	
  </tr>
  <tr>
  		<td><h3>Data:</td>
  		<td> <%=or.getInizio().getDay()%>/<%=or.getInizio().getMonth()%>/<%=or.getInizio().getYear()+1900%></td>
  </tr>
  <tr>
  		<td><h3>dalle: </td>
  		<td><%=or.getInizio().getHours()%>:<%=or.getInizio().getMinutes()%> </td>
  </tr>
  
  <tr>
  	<td><h3>alle:</h3></td>
  	<td><%=or.getFine().getHours()%>:<%=or.getFine().getMinutes()%>/td>
  </tr>
</table>
		
		</div>
		<div class="col-lg-6" style="border-left: 1px solid red"></div>
	</div>
	<%@ include file="../headerfooter/Footer.html"%>
</body>
</html>