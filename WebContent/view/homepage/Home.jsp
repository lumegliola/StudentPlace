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
	<script>
 $(document).ready(function() {
	 console.log("Ciao");
	 	$("#log").show();
    	$("#reg").hide();
     
	 $("#pulsanteReg").click(function(){
	    	$("#reg").show();
	    	$("#log").hide();
	    	
	    });
	 $("#pulsanteLog").click(function(){
	    	$("#log").show();
	    	$("#reg").hide();
	    	
	    });
   });
 </script>
</head>
<!-- INCLUDE PAGE -->
<body>
<%@ include file="../headerfooter/Header.jsp" %>
<div style="min-height: 30em; padding-top: 3em;" class  ="home">

<%int larghezza=7;

	
				if(logged){
				 larghezza=11;
				
				}%>

<div class="col-lg-<%=larghezza %> col-md-offset-1">
<h2>Immagine carina e coccolosa</h2>
<p>al posto di nulla non è male</p>

</div>

<div id = "col-dx" style=" border-left: 1px solid red;" class = "col-lg-4">

		<%
				if(logged==false){
				%>
			<div class="container-fluid login" n="login" method="post" >
			<form action="login" method="post" name="formLog" id="log">

					<label>E-mail:&nbsp;</label><label id="resMail"></label><br />
					<input type="text" name="email" id="email"
						placeholder="email"
						style="width: 90%; clear: both;"><br /> <br /> 
						
						<label>Password:&nbsp;</label><label id="resPass"></label><br/> 
						<input type="password" name="password" id="password"
						placeholder="password" style="width: 90%; clear: both;"><br /><br />
					
					
					<span><input type="submit" class="button" value="Accedi" ></input>
					<sub>o <a id="pulsanteReg">Registrati</a></sub>
					</span>
					</form>
						
			<form action="ServletRegistrazione" method="post" name="formReg" id="reg">
				<h2>REGISTRATI!</h2>
				<div class="testo">
					Nome: <input class="input" type="text" name="nome"
						placeholder="Nome" required="required"">
				</div>
				<div class="testo">
					Cognome: <input class="input" type="text" name="cognome"
						placeholder="cognome" required="required"">
				</div>
				<p style="color: red"></p>
				<div class="testo">
					Password: <input class="input" type="password" name="password"
						placeholder="password" required="required"">
				</div>
				<p style="color: red"></p>
				<div class="testo">
					E-mail: <input class="input" type="email" name="email"
						placeholder="esempio@gmail.com" required="required"">
				</div>
				<div class="testo">
					Matricola: <input class="input" type="text" name="matricola"
						placeholder="0512100000" required="required"">
				</div>
				<p style="color: red"></p>
				<div class="testo">
					<span><input id="bottone" type="submit" value="Iscriviti!"> <a id="pulsanteLog">Sei registrato?</a></span>
				</div>

			</form>
	
					<% }%>
					
					
			</div>
		</div>

</div>

</div>

<%@ include file="../headerfooter/Footer.html"%>

</body>
</html>