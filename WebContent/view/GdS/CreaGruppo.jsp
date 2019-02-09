<%@page import="javax.swing.text.Document"%>
<%@page import="model.bean.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.Timestamp"%>
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

	<div class="container generale"
		style="text-align: center; align-content: center;">
		<div class=" col-lg-8 col-md-offset-2">
			<h2 style="color: #a01313; margin: 1em;">Crea Gruppo</h2>
			<form action="ServletCreaGds" method="get" name="formReg">
				<input type="hidden" name="autore"
					value="<%=session.getAttribute("matricola")%>">
				<label>Nome Gruppo:&nbsp;</label><br>
					 <input
				type="text" name="nomeGruppo" class="name" placeholder="Inserisci il nome del gruppo"  required="required"
				style="width: 70%; clear: both; margin-bottom: 1.5em;"><br>

			<label>Materia:&nbsp;</label><br><input
				type="text" name="materia" class="materia" placeholder="Materia"
				style="width: 70%; clear: both; margin-bottom: 1.5em;"> <br>

					<label>Data:</label>
						<input style="margin-bottom: 1.5em;" type="date" name="data" onchange="setdata()" id="data">
					
					<label>Orario inizio:</label>
					<input style="margin-bottom: 1.5em;" name="inizio" type="time" min="9:00" max="18:00"
							 step="1800" onchange="setinizio()" id="inizio">

						<label>Orario fine:</label>

						<input style="margin-bottom: 0.7em;" id ="fine" name="fine"type="time" min="9:00" max="18:00"
							 step="1800" value="10:00"  onchange="setfine()"><br>

					

						<span>	<label>Aula:</label><select id="aule" name="aula">
							
							  <option style="margin-bottom: 1em;" value=" ">---</option>
							
							</select></span><br>
							<%if(logged){ %>
							<input type="hidden" name="operazione" value="crea">
				<input style="margin: 1em; background-color: #a01313; color: white; " id="bottone" type="submit" value="Crea Gruppo">

<%}else{ %>
<a  style="padding: 2em; font-size:x-large; color: #a01313; " href="ShowHome">Iscriviti per creare Gruppi</a>

<%} %>
	

			</form>

		</div>


	</div>
<script>
    var valoreData="";
    var valoreInizio="";
    var valoreFine="";
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
    function setfine(){
        setData=true;
        valoreFine=document.getElementById('fine').value;
        if(valoreFine.length>0){
        console.log(valoreFine);
        }
    }
    var valore=true;
    var auleLibere;
 	$("#inizio,#data,#fine").change(function(){
 		$("#aule").html("<option value=\" \">---</option>");
 		
     if(valoreInizio.length>0 && valoreData.length>0 && valoreFine.length>0){
     $.post("AulaLibera",
              {
                inizio:valoreInizio,
                data:valoreData,
                fine:valoreFine
              },
              function(data, status){
            	  auleLibere=data;
                  var num=data.length  ;
                  var i=0;
                  for(i=0;i<num;i++){
                //    data[i].aula+",Giorno "+data[i].giorno+ " ");
                    $("#aule").append("<option id=\""+data[i].id+"\" value=\""+data[i].aula+"\">"+data[i].aula+"</option>");
                  }
                  });
     valore=false;
        }
        });
        $("#aule").change(function(){
            var id = $(this).children("option:selected").attr("id");
            console.log(id);
            for(var i=0;i<auleLibere.length;i++){
            	if(auleLibere[i].id==id){
            		var inizio;	
            		if(aulaLibere[i].inizio=="9"){
            			inzio=("0").concat(auleLibere[i].inizio);
            		}
            		var fine=(auleLibere[i].fine).concat(":00:00");
            		 inizio=(auleLibere[i].inizio).concat(":00:00");
            		document.getElementById('fine').value=fine;
            		document.getElementById('inizio').value=inizio;
            	}
            }
        });
</script>

	<%@ include file="../headerfooter/Footer.html"%>
</body>
</html>