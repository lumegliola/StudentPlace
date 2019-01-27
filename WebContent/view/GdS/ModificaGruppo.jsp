<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../headerfooter/Header.jsp" %>

<div class="container generale"
		style="text-align: center; align-content: center;">
		<div class=" col-lg-8 col-md-offset-2">
			<h2 style="color: #a01313; margin: 1em;">Modifica Gruppo</h2>
			
			<form action="ModificaGdS" method="post" name="formReg">
			<%String  nomeGruppov= (String)session.getAttribute("nomeGruppov");
			String materiav=(String)session.getAttribute("materiav");%>
				<input type="hidden" name="autore"
					value="<%=session.getAttribute("matricola")%>">
					<%=nomeGruppov %>
					<%=session.getAttribute("matricola")%>


				<label>Nome Gruppo:&nbsp;</label><br> <input type="text"
					name="name" class="name"
					placeholder="Inserisci il nome del gruppo" required="required"
					style="width: 70%; clear: both; margin-bottom: 0.5em;"><br>

				<label>Materia:&nbsp;</label><br>
				<input type="text" name="materia" class="materia"
					placeholder="Materia"
					style="width: 70%; clear: both; margin-bottom: 0.7em;"> <br>

				<label>Data: <select class="input" name="giorno" required="required">
					<%for(int i=0;i<31;i++){ %>
						<option value="<%=i+1%>"><%=i+1%></option>
						<%} %>
					</select>
					<select class="input" name="mese" required="required">
					<%for(int i=0;i<12;i++){ %>
						<option value="<%=i+1%>"><%=i+1%></option>
						<%} %>
					</select>
					<select class="input" name="anno" required="required">
					<%for(int i=2018;i<2020;i++){ %>
						<option value="<%=i+1%>"><%=i+1%></option>
						<%} %>
					</select>
					<label>Orario inizio:</label>
					<select class="input" name="inizio" required="required">
					<%for(int i=8;i<19;i++){ %>
						<option value="<%=i+1%>"><%=i+1%></option>
						<%} %>
					</select>
					
					 <label>Orario fine:</label> <select class="input" name="fine" required="required">
					<%for(int i=8;i<20;i++){ %>
						<option value="<%=i+1%>"><%=i+1%></option>
						<%} %>
					</select><br>
				<div class="testo">
					Aula: <select class="input" name="aula" required="required">
					<%for(int i=0;i<21;i++){ %>
						<option value="P<%=i+1%>">P<%=i+1%></option>
						<%} %>
				<%for(int  i=0;i<8;i++){ %>
						<option value="F<%=i+1%>">F<%=i+1%></option>
						<%} %>
						<%for(int i=0;i<6;i++){ %>
						<option value="S<%=i+1%>">S<%=i+1%></option>
						<%} %>
				
					</select>
				</div>
				<input style="margin: 3em; background-color: #a01313; color: white;"
					id="bottone" type="submit" value="Modifica Gruppo">
				</table>
			</form>
	
</div>


</div>

<%@ include file="../headerfooter/Footer.html"%>

</body>
</html>