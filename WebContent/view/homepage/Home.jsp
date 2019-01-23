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
			<img style="width: 40%; float: left; margin: 10px;"
				id="groupStudyImg" alt="img group study"
				src="view/images/studygroup.jpg">
			<p style="text-align: justify; font-family: Century Gothic;">Quante
				volte ti &#232 capitato di sentirti il solo a non riuscire a superare
				quell&#8217esamone? Quante volte hai pensato di abbandonare proprio per
				mancanza di aiuto? Dispende incomprensibili, tutor introvabili,
				professori non reperibili, questi sono gli ingredienti che bastano
				per farti pensare di non potercela fare, di essere l&#8217unico ad avere
				grossi problemi. Tranquillo, non sei solo! Hai avuto solo la
				sfortuna di cercare nel posto sbagliato al momento sbagliato! Ora,
				grazie a StudentPlace, non dovrai pi&#249 preoccuparti di questo. Grazie
				alla nostra piattaforma potrai facilmente metterti in contatto con
				studenti con le tue stesse difficolt&#225: potrai rapidamente creare e/o
				cercare un gruppo di studio che ti permetter&#225 finalmente di trovare
				qualcuno che ti aiuti a superare quell&#8217esame. Lo studio di gruppo
				pu&#242 essere il primo passo verso il successo e verso... la laurea!
				Riuscirai a superare quell&#8217esame confrontandoti con altri studenti.
				Perch&#232 come dice il detto: &#8220L&#8217unione fa la forza!&#8221 E per chi invece
				&#232 un lupo solitario e preferisce studiare da solo ed in
				tranquillit&#225, nessun problema! Grazie a StudentPlace potr&#225 cercare
				un&#8217aula libera in cui studiare. StudentPlace nasce proprio per
				soccombere alle esigenze in ambito universitario che molti ragazzi
				provano durante il proprio percorso di laurea. Questa piattaforma
				aiuta lo studente nell&#8217organizzazione dello studio di gruppo e/o
				individuale. Esso offre allo studente la possibilit&#225 di creare un
				gruppo di studio inerente ad una materia in particolare a cui altri
				studenti potranno iscriversi per partecipare. Stabilita l&#8217aula in
				cui si terr&#225 l&#8217incontro, l&#8217ora e la materia di studio non resta da
				fare altro che dare il via allo studio!</p>
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

<%@ include file="../headerfooter/Footer.html"%>

</body>
</html>