<%@page import="bean.*"%>
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
<link rel="stylesheet" href="view\aulelibere\aulelibere.css"
	type="text/css">
</head>
<!-- INCLUDE PAGE -->
<body>
	<%@ include file="../headerfooter/Header.jsp"%>
	<div class="container">
		<table class="col-lg-12 tabella">
			<% 
//lista delle aula divisa per giorno e fasce orarie
 ArrayList <listaAuleLibere> lista =(ArrayList <listaAuleLibere>)request.getAttribute("lista");

%>
			<thead>
				<tr>
					<th>Orario </th>
					<th>Lunedì</th>
					<th>Martedì</th>
					<th>Mercoledì</th>
					<th>Giovedì</th>
					<th>Venerdì</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>09/10</td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Lunedì") && lista.get(i).getFasciaoraria()==1){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%>
 </td>
					<td>
					<%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Martedì") && lista.get(i).getFasciaoraria()==1){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%>
					</td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Mercoledì") && lista.get(i).getFasciaoraria()==1){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Giovedì") && lista.get(i).getFasciaoraria()==1){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Venerdì") && lista.get(i).getFasciaoraria()==1){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
				</tr>
				<tr>
					<td>10/11</td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Lunedì") && lista.get(i).getFasciaoraria()==2){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Martedì") && lista.get(i).getFasciaoraria()==2){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Mercoledì") && lista.get(i).getFasciaoraria()==2){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Giovedì") && lista.get(i).getFasciaoraria()==2){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Venerdì") && lista.get(i).getFasciaoraria()==2){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
				</tr>
				<tr>
					<td>11/12</td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Lunedì") && lista.get(i).getFasciaoraria()==3){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Martedì") && lista.get(i).getFasciaoraria()==3){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Mercoledì") && lista.get(i).getFasciaoraria()==3){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Giovedì") && lista.get(i).getFasciaoraria()==3){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Venerdì") && lista.get(i).getFasciaoraria()==3){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
				</tr>
				<tr>
					<td>12/13</td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Lunedì") && lista.get(i).getFasciaoraria()==4){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Martedì") && lista.get(i).getFasciaoraria()==4){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Mercoledì") && lista.get(i).getFasciaoraria()==4){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Giovedì") && lista.get(i).getFasciaoraria()==4){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Venerdì") && lista.get(i).getFasciaoraria()==4){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
				</tr>
				<tr>
					<td>13/14</td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Lunedì") && lista.get(i).getFasciaoraria()==5){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Martedì") && lista.get(i).getFasciaoraria()==5){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Mercoledì") && lista.get(i).getFasciaoraria()==5){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Giovedì") && lista.get(i).getFasciaoraria()==5){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Venerdì") && lista.get(i).getFasciaoraria()==5){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
				</tr>
				<tr>
					<td>14/15</td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Lunedì") && lista.get(i).getFasciaoraria()==6){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Martedì") && lista.get(i).getFasciaoraria()==6){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Mercoledì") && lista.get(i).getFasciaoraria()==6){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Giovedì") && lista.get(i).getFasciaoraria()==6){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Venerdì") && lista.get(i).getFasciaoraria()==6){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
				</tr>
				<tr>
					<td>15/16</td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Lunedì") && lista.get(i).getFasciaoraria()==7){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Martedì") && lista.get(i).getFasciaoraria()==7){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Mercoledì") && lista.get(i).getFasciaoraria()==7){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Giovedì") && lista.get(i).getFasciaoraria()==7){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Venerdì") && lista.get(i).getFasciaoraria()==7){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
				</tr>
				<tr>
					<td>16/17</td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Lunedì") && lista.get(i).getFasciaoraria()==8){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Martedì") && lista.get(i).getFasciaoraria()==8){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Mercoledì") && lista.get(i).getFasciaoraria()==8){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Giovedì") && lista.get(i).getFasciaoraria()==8){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Venerdì") && lista.get(i).getFasciaoraria()==8){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
				</tr>
				<tr>
					<td>17/18</td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Lunedì") && lista.get(i).getFasciaoraria()==9){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Martedì") && lista.get(i).getFasciaoraria()==9){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Mercoledì") && lista.get(i).getFasciaoraria()==9){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Giovedì") && lista.get(i).getFasciaoraria()==9){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Venerdì") && lista.get(i).getFasciaoraria()==9){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
				</tr>
				<tr>
					<td>18/19</td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Lunedì") && lista.get(i).getFasciaoraria()==10){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Martedì") && lista.get(i).getFasciaoraria()==10){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Mercoledì") && lista.get(i).getFasciaoraria()==10){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Giovedì") && lista.get(i).getFasciaoraria()==10){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals("Venerdì") && lista.get(i).getFasciaoraria()==10){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}
						}
 	%></td>
				</tr>
			</tbody>
		</table>
	</div>


	<%@ include file="../headerfooter/Footer.html"%>

</body>
</html>