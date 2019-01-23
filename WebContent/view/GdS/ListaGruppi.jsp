<%@page import="dao.DAOFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="bean.*"%>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	

	<%!List<GruppoDiStudio> list;%>

	<div id=products_container class="container-fluid">

		<%
			list = (List<GruppoDiStudio>) request.getAttribute("listaGruppi");
			

		%>


		<%
			try {
			for(int i = 0 ; i < list.size(); i++) {
				GruppoDiStudio p = list.get(i);
		%>
		<!-- -------------------------- product row --------------------------- -->

		<div class="row">
			<div class="col-lg-1">
				<h3><span class="id_gruppo" alt="Gruppo" style="vertical-align: middle;"><%=p.getId()%></span></h3>
			</div>

			<div class="col-lg-3">
				<br /> <span class="nome_gruppo"><%=p.getNomeGruppo()%></span><br /> 
			</div>

			<div class="col-lg-2">
				<br />
				<span class="aula">Edificio: <%=p.getAula().getEdificio()%>, Aula: <%=p.getAula().getNomeAula()%> </span>
			</div>
			<div class="col-lg-2">
				<br />
				<span class="giorno"><%=p.getOrario().getInizio().getDate()%></span>       
				<span class="orario">Dalle: <%=p.getOrario().getInizio().getHours()%>:<%=p.getOrario().getInizio().getMinutes()%>
									 alle: <%=p.getOrario().getFine().getHours()%>:<%=p.getOrario().getFine().getMinutes()%>
				</span>
			</div>
		</div>
		<%
		} 
		} catch (IndexOutOfBoundsException e) {
				
		}
		%>

		<% // int numGruppi = list.size(); 
			//int i = 0;
			//if (numGruppi > 10) {
		%>

		
	</div>

</body>
</html>