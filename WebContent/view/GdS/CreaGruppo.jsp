<%@page import="javax.swing.text.Document"%>
<%@page import="bean.*"%>
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
			<form action="ServletCreaGds" method="post" name="formReg">
				<input type="hidden" name="autore"
					value="<%=session.getAttribute("matricola")%>">
				


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
					id="bottone" type="submit" value="Crea Gruppo">



			</form>

		</div>


	</div>
<script>
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
                   console.log("Aula libera:" + data[i].aula+",Giorno "+data[i].giorno+ " ");
                  }
                  });
     valore=false;
        }
        });
</script>

	<%@ include file="../headerfooter/Footer.html"%>
</body>
</html>