<%@page import="dao.DAOFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="bean.*"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="view/GdS/ListaGruppi.css">
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
	<%@ include file="../headerfooter/Header.jsp"%>

	<%!List<GruppoDiStudio> list;%>
	<div class="container-fluid" style="padding: 3%;">
		<table style="width: 100%">
			<tr style="background-color: #a01313; color: white; font-size: large;">
				<th style="text-align: center">Nome</th>
				<th style="text-align: center">Materia</th>
				<th style="text-align: center">Luogo</th>
				<th style="text-align: center">Giorno e ora</th>
			</tr>



				<%
					list = (List<GruppoDiStudio>) request.getAttribute("gruppi");
				%>
				<%
					try {
						for (int i = 0; i < list.size(); i++) {
							GruppoDiStudio p = list.get(i);
				%>
				<!-- -------------------------- product row --------------------------- -->


				<%
					String color;
							if (i % 2 == 0)
								color = "#DCDCDC";
							else
								color = "white";
				%>


				<div class="row">

					<%
						String link = "ShowGdS?idGruppo=" + p.getId();
					%>
					<tr class="gds" style="background-color: <%=color%>"
						onclick="document.location ='<%=link%>'">
						<td style="font-size: medium; font-weight: 600;"><%=p.getNomeGruppo()%></td>
						<td><%=p.getMateria()%></td>
						<td><span style="font-size: medium; font-weight: 600;">Aula:</span>
							<span style="margin-right: 1em;"> <%=p.getAula().getNomeAula()%>
						</span><span style="font-size: medium; font-weight: 600;">Edificio:</span>
							<%=p.getAula().getEdificio()%></td>
						<td><%=p.getOrario().getInizio().toString().substring(0, 10)%>
							<span style="font-size: medium; font-weight: 600;">dalle: </span> <%=p.getOrario().getInizio().toString().substring(10, 16)%></td>
					
					</tr>
				</div> </div>
				<%
					}
					} catch (IndexOutOfBoundsException e) {

					}
				%>
			
		</table>
	</div>
	<%@ include file="../headerfooter/Footer.html"%>
</body>
</html>