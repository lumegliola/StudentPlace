<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione orario</title>
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
<link rel="stylesheet" href="view/headerfooter/Header.css"
	type="text/css">
<link rel="stylesheet" href="view/headerfooter/Footer.css"
	type="text/css">
<link rel="stylesheet" href="view/GdS/CreaGruppo.css" type="text/css">
<link rel="stylesheet" href="view/GdS/ListaGruppi.css">
</head>
<body>
	<%
		List<AulaLibera> auleLibere = (List<AulaLibera>) request.getAttribute("auleLibere");
	%>
	<script>
    var valoreData="";
    var valoreInizio="";
    function setdata(){
        setData=true;
        valoreData=document.getElementById('data').value;
        if(valoreData.length>0){
        console.log(valoreData);
        }
    }</script>
	<%@ include file="../headerfooter/Header.jsp"%>
	<div class="container-fluid" style="padding: 3%">
	
		<div class="col-lg-6" style="overflow: auto; min-height: 20em;">
			<h4 style="text-align: center;">Lista completa delle aule libere</h4>
			<table style="width: 100%">
				<tr style="background-color: #a01313; color: white;">
					<th style="text-align: center">Aula</th>
					<th style="text-align: center">Libera il giorno:</th>
					<th style="text-align: center">Dalle:</th>
					<th style="text-align: center">Fino alle:</th>
					<th style="text-align: center"></th>
				</tr>
				<%
					for (int i = 0; i < auleLibere.size(); i++) {
						String link = "ShowOrario?aula="+auleLibere.get(i).getAula().getNomeAula()+"&giorno="+auleLibere.get(i).getGiorno().replace('ì','i')+"&orario="+auleLibere.get(i).getOrario().getIdOrario();			
			
						
						String color;
								if (i % 2 == 0)
									color = "#DCDCDC";
								else
									color = "white";
					%>		
			
				
				<tr class="gds" style="background-color: <%=color%>" onclick="document.location='<%=link %>'">
						<td><%=auleLibere.get(i).getAula().getNomeAula()%></td>
						<td><%=auleLibere.get(i).getOrario().getGiorno()%>   <%=auleLibere.get(i).getOrario().getInizio().toString().substring(0, 10)%></td>
						<td><%=auleLibere.get(i).getOrario().getInizio().toString().substring(10, 16)%></td>
						<td><%=auleLibere.get(i).getOrario().getFine().toString().substring(10, 16)%></td>
						<td><form action="ModificaAulaLibera">
								<input type="hidden" name="operazione" value="elimina">
								<input type="hidden" name="aula" value="<%=auleLibere.get(i).getAula().getNomeAula()%>">
								<input type="hidden" name="giorno" value="<%=auleLibere.get(i).getGiorno().replace('ì','i')%>">
								<input type="hidden" name="idOrario" value="<%=auleLibere.get(i).getOrario().getIdOrario()%>">
    							<input type="submit" value="Elimina"/>
							</form>
						</td>
					</tr>

				<%
					}
				%>
			</table>

		</div>
		<div class="col-lg-6" style="border-left: 1px solid red">
			<h4 style="text-align: center;">inserisci una nuova aula libera</h4>
			<form action="inserisciOrario" method="post" name="formReg">
				<table style="margin-left: 25%">
					<tr>
						<td>Aula</td>
						<td><div class="testo">
					<select class="input" name="aula" required="required">
					<%for(int i=0;i<21;i++){ %>
						<option value="P<%=i+1%>F3">P<%=i+1%></option>
						
						<%} %>
				<%for(int  i=0;i<8;i++){ %>
						<option value="F<%=i+1%>F2">F<%=i+1%></option>
						
						<%} %>
						<%for(int i=0;i<6;i++){ %>
						<option value="S<%=i+1%>F">S<%=i+1%></option>
						
						<%} %>
				
					</select>
				</div>
					</tr>
					<tr>
						<label>Data:</label>
						<input style="margin-bottom: 0.5em;" type="date" name="data" onchange="setdata()" id="data">
					</tr>
					<tr>
						<td>Orario inizio:</td>
						<td><input name="inizio" type="time" min="9:00" max="18:00"
							required="required" step="1800"></td>
					</tr>
					<tr>
						<td>Orario fine:</td>
						<td><input name="fine" type="time" min="9:00" max="19:00"
							required="required" step="1800"></td>
					</tr>
					<tr>
						<td>Per quante settimane vuoi ripetere il settaggio?
						</td>
						<td><div class="testo">
					<select class="input" name="settimane" required="required">
					<%for(int i=0;i<24;i++){ %>
						<option value="<%=i+1%>"><%=i+1%></option>
						
						<%} %>
				
				
					</select>
				</div>
					</tr>
					<tr>
						<td>L'aula è libera tutta la settimana in questo intervallo?
						</td>
						<td><div class="testo">
					<select class="input" name="tuttasettimana" required="required">
					
						<option value="si">si</option>
						<option value="no">no</option>
						
					
				
				
					</select>
				</div>
					</tr>
					<tr>
						<td><input id="bottone" type="submit" value="Inserisci">
						</td>
					</tr>
				</table>
			</form>
		</div>
		
	</div>
	<%@ include file="../headerfooter/Footer.html"%>
</body>
</html>