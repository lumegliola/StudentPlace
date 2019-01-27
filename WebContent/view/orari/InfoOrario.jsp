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
<%@ include file="../headerfooter/Header.jsp"%>
<% 	AulaLibera al = (AulaLibera)session.getAttribute("aulaLibera");
	Orario or = (Orario)session.getAttribute("orario");
	Aula a = (Aula)session.getAttribute("aula");
	al.setAula(a);
	if(or==null || al==null){
		System.out.println("strunz");
		}else { %>
	<div class="container-fluid" style="padding: 3%">

		<div class="col-lg-6" style="overflow: auto; min-height: 20em;">
		
		<table style="margin-left: 37%; margin-right: 37%; margin-top: 5%; margin-bottom: 5%">
  
  <tr>
    <td><h3>Aula </h3></td>
    <td><%=al.getAula().getNomeAula()%></td>
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
  	<td><%=or.getFine().getHours()%>:<%=or.getFine().getMinutes()%></td>
  </tr>
</table>
		
		</div>
		<div class="col-lg-6" style="border-left: 1px solid red">
		
		<form action="ModificaOrario" method="post" name="formOr">
					<h3>Modifica l'orario</h3>
					<label>Giorno:&nbsp;</label>
					 <input type="select" name="giorno" class="name"  required="required">
					 <select name="giorno" form = "formOr">
					 <option>lunedì</option>
					 <option>martedì</option>
					 <option>mercoledì</option>
					 <option>giovedì</option>
					 <option>venerdì</option>
					 </select>
					 <br>

					
					<label>Orario inizio:</label>
					<input style="margin-bottom: 0.7em;" name="inizio" type="time" min="9:00" max="18:00"
							required="required" step="1800" onchange="setinizio()">
													
						<label>Orario fine:</label>
						<input style="margin-bottom: 0.7em;" name="fine"type="time" min="9:00" max="18:00"
							required="required" step="1800"><br>

						<input style="margin: 3em; background-color: #a01313; color: white; " id="bottone" type="submit" value="modifica">
			</form>
		
		</div>
	</div>
	<%} %>
	<%@ include file="../headerfooter/Footer.html"%>
</body>
</html>