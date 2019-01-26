<%@page import="dao.DAOFactory"%>
<%@page import="bean.GruppoDiStudio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<%
	GruppoDiStudio g = (GruppoDiStudio) request.getAttribute("gds");
	Utente u = (Utente) session.getAttribute("utente");
	
%>
</head>
<body>
<%@ include file="../headerfooter/Header.jsp"%>

<table style="margin-left: 37%; margin-right: 37%; margin-top: 5%; margin-bottom: 5%">
  <tr>
    <th><h2><%=g.getNomeGruppo()%></h2></th>
  </tr>
  <tr>
    <td><h3>Aula </h3></td>
    <td><%= g.getAula().getNomeAula()%></td>
  </tr>
  <tr>
  		<td> <h3>Edificio: </h3></td>
  		<td><%=g.getAula().getEdificio()%>
  </tr>
  <tr>
		<td><h3>Giorno: </h3></td>
		<td> <%=g.getOrario().getGiorno()%></td>  	
  </tr>
  <tr>
  		<td><h3>Data:</td>
  		<td> <%=g.getOrario().getInizio().getDay()%>/<%=g.getOrario().getInizio().getMonth()%>/<%=g.getOrario().getInizio().getYear()+1900%></td>
  </tr>
  <tr>
  		<td><h3>Orario:</td>
  		<td>dalle: <%=g.getOrario().getInizio().getHours()%>:<%=g.getOrario().getInizio().getMinutes()%> alle:<%=g.getOrario().getFine().getHours()%>:<%=g.getOrario().getFine().getMinutes()%></td>
  </tr>
  <tr>
  	<td>
  		<form action="IscrizioneGdS" method="post">
  		<input type="hidden" name="operazione" value="iscrivi">
  		<input type="hidden" name="idGds" value="<%=g.getId()%>">
  		<input type="hidden" name="matricola" value=<%=u.getMatricola()%>>
  		<button type="submit">Iscriviti</button>
  		
  		</form>
  	</td>
  </tr>
</table>





<%@ include file="../headerfooter/Footer.html"%>
</body>
</html>