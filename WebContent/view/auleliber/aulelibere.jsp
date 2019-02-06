<%@page import="model.bean.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.Timestamp"%>
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

<!-- IMPORT CSS-->
<link rel="stylesheet" href="\view\headerfooter\Footer.css"
	type="text/css">
<link rel="stylesheet" href="\view\headerfooter\Header.css"
	type="text/css">
<link rel="stylesheet" href="view\auleliber\aulelibere.css"
	type="text/css">
</head>
<!-- INCLUDE PAGE -->
<body>
	<%@ include file="../headerfooter/Header.jsp"%>
	<div class="container">
		<table class="col-lg-12 tabella">
			<%
				//lista delle aula divisa per giorno e fasce orarie
					ArrayList<ListaAuleLibere> lista = (ArrayList<ListaAuleLibere>) session.getAttribute("lista");
					List<String> giorni = new ArrayList<>();
					giorni.add("Lunedì");
					giorni.add("Martedì");
					giorni.add("Mercoledì");
					giorni.add("Giovedì");
					giorni.add("Venerdì");
					int s = 0, k = 1, intervallo = 9;
			%>
			<thead>
				<tr style="color: white;">
					<th>Orario</th>
					<th>Lunedì</th>
					<th>Martedì</th>
					<th>Mercoledì</th>
					<th>Giovedì</th>
					<th>Venerdì</th>
				</tr>
			</thead>
			
			<%for(int cont=0;cont<10;cont++){%>
				<tr>
					<td style="font-weight: bold; padding: 0.5em;"><%=intervallo%>:00-<%=intervallo + 1%>:00</td>
					<%for(int t =0;t<5;t++){%>
					<td  style="font-weight: bold;">
						<%
							if (lista.size() != 0) {
								for (int i = 0; i < lista.size(); i++) {
									if (lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria() == k) {
						%> <%=lista.get(i).getNomeaula()%> <%
 				}
			}
			s++;
 	}
 %>					</td><%}s = 0;
			 		k++;intervallo++;} %>
				</tr>
		</table></div>	</body>
	
	<%@ include file="../headerfooter/Footer.html"%>

</body>
</html>