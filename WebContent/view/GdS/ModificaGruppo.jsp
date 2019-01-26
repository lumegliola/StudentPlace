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

<div class="container generale">
<div class=" col-lg-8 col-md-offset-2">
			
				<h2>Modifica Gruppo</h2>
		
					<form action="Registrazione" method="post" name="formReg">
				<input type="hidden" name="autore"
					value="<%=session.getAttribute("matricola")%>">
				<table>
					<tr>
						<td>Nome Gruppo:</td>
						<td><input class="input" type="text" name="name"
							placeholder="Nome Gruppo" required="required""></td>
					</tr>
					<tr>
						<td>Materia</td>
						<td><input class="input" type="text" name="materia"
							placeholder="Materia" required="required""></td>
					</tr>
					<tr>
						<td>Data:</td>
						<td><input type="date" id="data"></td>
					</tr>
					<tr>
						<td>Orario inizio:</td>
						<td><input id="inizio" type="time" min="9:00" max="18:00"
							required="required" step="1800"></td>
					</tr>
					<tr>
						<td>Orario fine:</td>
						<td><input  id="fine"type="time" min="9:00" max="18:00"
							required="required" step="1800"></td>
					</tr>
					
					<tr>
						<td><input id="bottone" type="submit" value="Iscriviti!">
						</td>
					</tr>
				</table>
			</form>
	
</div>


</div>

<%@ include file="../headerfooter/Footer.html"%>

</body>
</html>