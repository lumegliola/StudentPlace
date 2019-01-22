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
 List <String> giorni= new ArrayList<>();
	giorni.add("Luned�");
	giorni.add("Marted�");
	giorni.add("Mercoled�");
	giorni.add("Gioved�");
	giorni.add("Venerd�");
	int s=0,k=1;

%>
			<thead>
				<tr>
					<th>Orario </th>
					<th>Luned�</th>
					<th>Marted�</th>
					<th>Mercoled�</th>
					<th>Gioved�</th>
					<th>Venerd�</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>09/10</td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%>
 </td>
					<td>
					
					<%
					if(lista.size() != 0) {
						for (int i =0; i<lista.size(); i++) {
							if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
								%> <%=lista.get(i).getNomeaula()%>, <%
							}

					
				
		}s++;
					}
	%>
					</td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s=0;k++;
						}
 	%></td>
				</tr>
				<tr>
					<td>10/11</td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s=0;k++;
						}
 	%></td>
				</tr>
				<tr>
					<td>11/12</td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s=0;k++;
						}
 	%></td>
				</tr>
				<tr>
					<td>12/13</td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s=0;k++;
						}
 	%></td>
				</tr>
				<tr>
					<td>13/14</td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s=0;k++;
						}
 	%></td>
				</tr>
				<tr>
					<td>14/15</td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s=0;k++;
						}
 	%></td>
				</tr>
				<tr>
					<td>15/16</td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s=0;k++;
						}
 	%></td>
				</tr>
				<tr>
					<td>16/17</td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s=0;k++;
						}
 	%></td>
				</tr>
				<tr>
					<td>17/18</td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s=0;k++;
						}
 	%></td>
				</tr>
				<tr>
					<td>18/19</td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s++;
						}
 	%></td>
					<td><%
						if(lista.size() != 0) {
							for (int i =0; i<lista.size(); i++) {
								if(lista.get(i).getGiorno().equals(giorni.get(s)) && lista.get(i).getFasciaoraria()==k){
									%> <%=lista.get(i).getNomeaula()%>, <%
								}

						
					
 		}s=0;k++;
						}
 	%></td>
				</tr>
			</tbody>
		</table>
	</div>


	<%@ include file="../headerfooter/Footer.html"%>

</body>
</html>