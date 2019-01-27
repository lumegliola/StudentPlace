<%@page import="dao.interfaces.GdSDAO"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dao.DAOFactory"%>
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

</head>
<body>
	<%@ include file="../headerfooter/Header.jsp"%>
	<%
		Utente u = (Utente) request.getAttribute("utente");

		List<GruppoDiStudio> iscrizioni = new ArrayList<>();
		List<GruppoDiStudio> creatore = DAOFactory.getGdSDAO().doRetrieveByCreator(u.getMatricola());
		List<Iscrizione> gruppi = DAOFactory.getIscrizioneDAO().doRetrieveByUser(u.getMatricola());
		for (int i = 0; i < gruppi.size(); i++) {
			GruppoDiStudio p = DAOFactory.getGdSDAO().doRetrieveById(gruppi.get(i).getGruppo().getId());
			iscrizioni.add(p);

		}
	%>
	<div style="min-height: 30em; margin-top: 15px;">

		<!----------------------- Gruppi dell'utente ----------------------->


		<div id=group_container class="container-fluid col-lg-9">


			<% if(!creatore.isEmpty()){%>

			<div class="col-lg-9">
				<h4>I tuoi gruppi</h4>

				<table style="width: 100%">
					<tr>
						<th style="text-align: center">Nome</th>
						<th style="text-align: center">Materia</th>
						<th style="text-align: center">Luogo</th>
						<th style="text-align: center">Giorno e ora</th>
					</tr>

					<% 
						try {
							for (int i = 0; i < creatore.size(); i++) {
								GruppoDiStudio p = creatore.get(i);
					%>


					<tr>
						<td><%=p.getNomeGruppo()%></td>
						<td><%=p.getMateria()%></td>
						<td>Edificio: <%=p.getAula().getEdificio()%>,Aula: <%=p.getAula().getNomeAula()%></td>
						<td><%=p.getOrario().getInizio().toGMTString().substring(0, 21)%>
							fino alle: <%=p.getOrario().getFine().toString().substring(11, 19)%></td>
							<td><form action="CreaModificaGruppo" method="post">
								<input name="operazione" type="hidden"
									value="Modifica"> 
								<button type="submit" name="modifica"
									style="background-color: red; color: white;">modifica</button>
							</form></td>
						<td><form action="EliminaGdS" method="post">
								<input name="materia" type="hidden"
									value="<%=p.getMateria()%>"> 
									<input name="nomeGruppo"
									type="hidden" value="<%=p.getNomeGruppo()%>">
								<button type="submit" name="cancella_gruppo"
									style="background-color: red; color: white;">Elimina</button>
							</form></td>
					</tr>



					<%
						}
						
					%>
				</table>
			</div>
			<%
					} catch (IndexOutOfBoundsException e) {

					}
				}else{
				%>
			<div style="text-align: center; border-bottom: 1px solid #a01313; padding: 2%; color:  #a01313">
				<h3>Nessun gruppo creato</h3>
				<a href="CreaModificaGruppo?operazione=crea">Crea un nuovo gruppo</a>
			</div>
			<% }%>
			

			<!----------------------- Iscrizioni dell'utente ----------------------->


			<% if(!iscrizioni.isEmpty()){%>

			<h3 style="text-align: center; color:  #a01313">Gruppi a cui sei iscritto:</h3><br>

			<table style="width: 100%;padding-top: 5%">
				<tr>
					<th style="text-align: center">Nome</th>
					<th style="text-align: center">Materia</th>
					<th style="text-align: center">Luogo</th>
					<th style="text-align: center">Giorno e ora</th>
				</tr>


				<%
						try {
							for (int i = 0; i < iscrizioni.size(); i++) {
								GruppoDiStudio p = iscrizioni.get(i);
					%>

			

					<tr>
						<td><%=p.getNomeGruppo()%></td>
						<td><%=p.getMateria()%></td>
						<td>Aula: <%=p.getAula().getNomeAula()%>, Edificio: <%=p.getAula().getEdificio()%></td>
						<td><%=p.getOrario().getInizio().toString().substring(0, 10)%>
							dalle: <%=p.getOrario().getInizio().toString().substring(10, 16)%></td>
						<td><form action="IscrizioneGdS">
								<input name="operazione" type="hidden"
									value="cancella"> 
								<input name="matricola" type="hidden"
									value="<%=u.getMatricola()%>"> 
									<input name="idGruppo"
									type="hidden" value="<%=p.getId()%>">
								<button type="submit" name="cancella_iscrizione"
									style="background-color: #a01313; color: white;">Cancella
									iscrizione</button>
							</form></td>
					</tr>

					<%
							}
						%>
				
			</table>
			<div class="col-lg-2"></div>
		
		<%
				} catch (IndexOutOfBoundsException e) {

				}}else{
			%>
			
				
		
		<div style="text-align: center; margin-top:1em; padding: 2%; color:  #a01313">
				<h3 style="text-align: center;">Non sei iscritto a nessun gruppo</h3>
				<a href="CreaModificaGruppo?operazione=cerca">Lista gruppi di studio</a>
			</div>
			<% }%>
	</div>		

		<!-----------------------info profilo------------------------>

		<div class="col-lg-3"
			style="border-left: 1px solid #a01313; padding-bottom: 10%">
			<table style="text-align: center">
				<tr>
					<th style="text-align: center"><img alt="avatar"
						src="view/images/avatar.jpg" width="50%"></th>
				</tr>
				<tr>
					<td><h4><%=u.getNome()%>
							<%=u.getCognome()%></h4></td>
				</tr>
				<tr>
					<td><%=u.getMatricola()%></td>
				</tr>
				<tr>
					<td><%=u.getMail()%></td>
				</tr>

			</table>
		</div>
		<div class="col-lg-1"></div>
	</div>


	<%@ include file="../headerfooter/Footer.html"%>
</body>
</html>