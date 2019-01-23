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
<link rel="stylesheet" href="view/headerfooter/Home.css"
	type="text/css">
	
</head>
<!-- INCLUDE PAGE -->
<body>
<%@ include file="../headerfooter/Header.jsp" %>
<div style="min-height: 30em; padding-top: 3em;" class  ="home">


<div class="col-lg-7 col-md-offset-1">
<img id="groupStudyImg" alt="img group study" src="view/images/studygroup.jpg">
<p>Quante volte ti è capitato di sentirti il solo a non riuscire a superare quell’esamone? 
Quante volte hai pensato di abbandonare proprio per mancanza di aiuto? 
Dispende incomprensibili, tutor introvabili, professori non reperibili, questi sono gli ingredienti che bastano per farti pensare di non potercela fare, di essere l’unico ad avere grossi problemi. 
Tranquillo, non sei solo!
Hai avuto solo la sfortuna di cercare nel posto sbagliato al momento sbagliato! 
Ora, grazie a StudentPlace, non dovrai più preoccuparti di questo.  
Grazie alla nostra piattaforma potrai facilmente metterti in contatto con studenti con le tue stesse difficoltà: potrai rapidamente creare e/o cercare un gruppo di studio che ti permetterà finalmente di trovare qualcuno che ti aiuti a superare quell’esame. Lo studio di gruppo può essere il primo passo verso il successo e verso… la laurea! Riuscirai a superare quell’esame confrontandoti con altri studenti. Perché come dice il detto: “L’unione fa la forza!” 
E per chi invece è un lupo solitario e preferisce studiare da solo ed in tranquillità, nessun problema! 
Grazie a StudentPlace potrà cercare un’aula libera in cui studiare. 

StudentPlace nasce proprio per soccombere alle esigenze in ambito universitario che molti ragazzi provano durante il proprio percorso di laurea. Questa piattaforma aiuta lo studente nell’organizzazione dello studio di gruppo e/o individuale. Esso offre allo studente la possibilità di creare un gruppo di studio inerente ad una materia in particolare a cui altri studenti potranno iscriversi per partecipare. Stabilita l’aula in cui si terrà l’incontro, l’ora e la materia di studio non resta da fare altro che dare il via allo studio! 
</p>

</div>

<div id = "col-dx" style=" border-left: 1px solid red;" class = "col-lg-4">

		
			<div class="container-fluid login" ">
			<div>
				<label class="creaaccount">Accedi a Student place:</label><br />

				<form action="login" method="post" onsubmit="return validateForm()">

					<label>E-mail:&nbsp;</label><label id="resMail"></label><br />
					<input type="text" name="email" id="email"
						placeholder="email"
						style="width: 90%; clear: both;"><br /> <br /> 
						
						<label>Password:&nbsp;</label><label id="resPass"></label><br/> 
						<input type="password" name="password" id="password"
						placeholder="password" style="width: 90%; clear: both;"><br /><br />
					
					
					<span><input type="submit" class="button" value="Accedi"></input>
					<sub>o <a href="ShowRegistrazione">Registrati</a></sub>
					</span>
					</form>
					
					
					
			</div>
		</div>

</div>

</div>

<%@ include file="../headerfooter/Footer.html"%>

</body>
</html>