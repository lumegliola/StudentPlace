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
			<form action="ModificaGdS" method="post" name="formModifica">
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
			
			<div > Aula: <select class="input" name="Aula" required="required"> 
				<option value="P1">P1 </option>
				<option value="P2">P2</option>
				<option value="P3">P3</option>
				<option value="P4">P4</option>
				<option value="P5">P5</option>
				</select>
			</div>
			<div class="testo"> <input id="bottone"type="submit" value="modifica"> </div>

			</form>
	
</div>


</div>

<%@ include file="../headerfooter/Footer.html"%>

</body>
</html>