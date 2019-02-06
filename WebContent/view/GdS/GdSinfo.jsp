<%@page import="model.dao.DAOFactory"%>
<%@page import="model.bean.GruppoDiStudio"%>
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

	<div style="text-align: center;">

		<h1 style="color: #a01313;"><%=g.getNomeGruppo()%></h1>
        <span style="font-size: x-large;">Materia:</span><span style="margin-right: 1em;"><%=g.getMateria()%></span><br>
		<span style="font-size: x-large;">Si svolge nell'aula: </span> <span
			style="margin-right: 1em;"><%=g.getAula().getNomeAula()%></span> <span
			style="font-size: x-large;">edificio:</span> <span> <%=g.getAula().getEdificio()%>
		</span><br> <span style="font-size: x-large;">Giorno </span> <span style="margin-right: 1em;">
			<%=g.getOrario().getGiorno()%>
		</span> <span style="font-size: x-large;"> Data </span> <span><%=g.getOrario().getInizio().getDay()%>/<%=g.getOrario().getInizio().getMonth()%>/<%=g.getOrario().getInizio().getYear() + 1900%>
		</span> <br>
		 <span style="font-size: x-large;">dalle:</span>
		<span style="margin-right: 1em;"> <%=g.getOrario().getInizio().getHours()%>:<%=g.getOrario().getInizio().getMinutes()%>0
		</span>
		 <span style="font-size: x-large;">alle:</span>
		<span> <%=g.getOrario().getFine().getHours()%>:<%=g.getOrario().getFine().getMinutes()%>0
		</span>
		<form action="IscrizioneGdS" method="post">
			<input type="hidden" name="operazione" value="iscrivi"> <input
				type="hidden" name="idGds" value="<%=g.getId()%>"> <input
				type="hidden" name="matricola" value=<%=u.getMatricola()%>>
			<button style="margin: 2em; background-color: #a01313; color: white; " type="submit">Iscriviti al gruppo</button>
			

		</form>
	</div>



	<%@ include file="../headerfooter/Footer.html"%>
</body>
</html>