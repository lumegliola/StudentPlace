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
<link rel="stylesheet" href="view/headerfooter/Header.css"
	type="text/css">
<link rel="stylesheet" href="view/headerfooter/Footer.css"
	type="text/css">
	<link rel="stylesheet" href="view\creagruppo\creagruppo.css"
	type="text/css">
</head>
<!-- INCLUDE PAGE -->
<body>
<%@ include file="../headerfooter/Header.jsp" %>

<div class="container generale">
<div class=" col-lg-8 col-md-offset-2">
			<form action="Registrazione" method="post" name="formReg">
				<h2>Crea Gruppo!</h2>
				<div >
					Nome Gruppo: <input class="input" type="text" name="name"
						placeholder="Nome Gruppo" required="required"">
				</div>
				<div><input type="hidden" name="autore" value="<%=session.getAttribute("matricola")%>">
				</div>
				<div >
					Materia <input class="input" type="text" name="materia"
						placeholder="Materia" required="required"">
				</div>
				
				<p style="color: red"></p>
				<div > Ora Inizio: <select class="input" name="inizio" required="required"> 
				<option value="09">09</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
				<option value="13">13</option>
				<option value="14">14</option>
				<option value="15">15</option>
				<option value="16">16</option>
				<option value="17">17</option>
				<option value="18">18</option>
				</select>
				</div>
				<div > Ora Fine: <select class="input" name="fine" required="required"> 
				<option value="09">09</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
				<option value="13">13</option>
				<option value="14">14</option>
				<option value="15">15</option>
				<option value="16">16</option>
				<option value="17">17</option>
				<option value="18">18</option>
			
				
				</select>
			</div>
			<div > Giorno: <select class="input" name="giorno" required="required"> 
				<option value="Lunedi">Lunedi</option>
				<option value="Martedi">Martedi</option>
				<option value="Mercoledi">Mercoledi</option>
				<option value="Giovedi">Giovedi</option>
				<option value="Venerdi">Venerdi</option>
				</select>
			</div>
			<div > Aula: <select class="input" name="Aula" required="required"> 
				<option value="P1">P1 </option>
				<option value="P2">P2</option>
				<option value="P3">P3</option>
				<option value="P4">P4</option>
				<option value="P5">P5</option>
				</select>
			</div>
			<div class="testo"> <input id="bottone"type="submit" value="Iscriviti!"> </div>

			</form>
	
</div>


</div>

<%@ include file="../headerfooter/Footer.html"%>

</body>
</html>