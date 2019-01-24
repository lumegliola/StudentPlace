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
<% int id =Integer.parseInt(request.getParameter("gds"));
	GruppoDiStudio g = DAOFactory.getGdSDAO().doRetrieveById(id);
	
%>
</head>
<body>
<table>
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
</table>





</body>
</html>