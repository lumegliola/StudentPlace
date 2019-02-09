<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Place</title>
<link rel="icon"  href="view/images/logoxsp.png" />
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
<!-- INCLUDE PAGE -->
<body>
<%@ include file="../headerfooter/Header.jsp" %>
<div  style="min-height: 39em; margin-top: 15px;" class  ="home">

<%int larghezza=7;

	
				if(logged){
				 larghezza=11;
				
				}%>

<div style="margin: 1.5em;"  class="col-lg-<%=larghezza %> col-md-offset-1">
			<img style="width: 30%; float: left; margin: 5px;"
				id="groupStudyImg" alt="img group study"
				src="view/images/studygroup.jpg">
			<p style="text-align: justify; font-family: Century Gothic;">Quante
				volte ti &#232 capitato di sentirti il solo a non riuscire a superare
				quell&#8217esamone? Quante volte hai pensato di abbandonare proprio per
				mancanza di aiuto? Dispense incomprensibili, tutor introvabili,
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
			<%@ include file="../loginregistrazione/loginregistrazione.jsp"%>
					<%}
				%>
		</div>

</div>

<%@ include file="../headerfooter/Footer.html"%>

</body>
</html>