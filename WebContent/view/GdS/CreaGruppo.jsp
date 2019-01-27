 <%@page import="javax.swing.text.Document"%>
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
<link rel="stylesheet" href="view/GdS/CreaGruppo.css" type="text/css">
</head>
<!-- INCLUDE PAGE -->
<body>
	<%@ include file="../headerfooter/Header.jsp"%>

	<div class="container generale" style="text-align: center; align-content: center;">
		<div class=" col-lg-8 col-md-offset-2">
			<h2 style="color: #a01313; margin: 1em;">Crea Gruppo</h2>
			<form action="AulaLibera" method="post" name="formReg">
				<input type="hidden" name="autore"
					value="<%=session.getAttribute("matricola")%>">

					
					<label>Nome Gruppo:&nbsp;</label><br>
					 <input
				type="text" name="input" class="name" placeholder="Inserisci il nome del gruppo"  required="required"
				style="width: 70%; clear: both; margin-bottom: 0.5em;"><br>

			<label>Materia:&nbsp;</label><br><input
				type="text" name="materia" class="materia" placeholder="Materia"
				style="width: 70%; clear: both; margin-bottom: 0.7em;"> <br>
					
					<label>Data:</label>
						<input style="margin-bottom: 0.5em;" type="date" name="data" onchange="setdata()">
					
					<label>Orario inizio:</label>
					<input style="margin-bottom: 0.7em;" name="inizio" type="time" min="9:00" max="18:00"
							required="required" step="1800" onchange="setinizio()">
													
						<label>Orario fine:</label>
						<input style="margin-bottom: 0.7em;" name="fine"type="time" min="9:00" max="18:00"
							required="required" step="1800"><br>

						<input style="margin: 3em; background-color: #a01313; color: white; " id="bottone" type="submit" value="Crea Gruppo">



			</form>

		</div>


	</div>
	<script >
	
	var valoreData="";
	var valoreInizio="";
	function setdata(){
		setData=true;
		valoreData=document.getElementById('data').value;
		if(valoreData.length>0){
		console.log(valoreData);
		}
	}
	function setinizio(){
		setData=true;
		valoreInizio=document.getElementById('inizio').value;
		if(valoreInizio.length>0){
		console.log(valoreInizio);
		}
	}
	var valore=true;
		
 $("#inizio,#data").change(function(){
	 if(valoreInizio.length>0 && valoreData.length>0){
	 $.post("AulaLibera",
			  {
			    inizio:valoreInizio,
			    data:valoreData
			  },
			  function(data, status){
				  var num=data.length  ;
				  var i=0;
				  for(i=0;i<num;i++){
			       console.log("Aula libera: " + data[i].aula+data[i].giorno+ "\nStatus: ");
				  }
				  });
	 valore=false;
		}
		});
	</script>
	<%@ include file="../headerfooter/Footer.html"%>
</body>
</html>