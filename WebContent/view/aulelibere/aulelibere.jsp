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
<link rel="stylesheet" href="\view\headerfooter\Footer.css"
	type="text/css">
<link rel="stylesheet" href="\view\headerfooter\Header.css"
	type="text/css">
<link rel="stylesheet" href="view\aulelibere\aulelibere.css"
	type="text/css">
</head>
<!-- INCLUDE PAGE -->
<body>
	<%@ include file="../headerfooter/Header.jsp"%>
	<div class="container">
		<table class="col-lg-12 tabella">
			<% 

   List <AulaLibera> elenco = (List <AulaLibera>)request.getAttribute("elenco");
   
%>
			<thead>
				<tr>
					<th>Orario </th>
					<th>Lunedì</th>
					<th>Martedì</th>
					<th>Mercoledì</th>
					<th>Giovedì</th>
					<th>Venerdì</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="orario">09/10</td>
					<td>
						<%if(elenco.size()>0){
for(int i=0;i < elenco.size();i++) {
	if(elenco.get(i).getOrario().getGiorno().equals("Lunedì")){
	
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==9){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=10)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera
					</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Martedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==9){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=10)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera
					</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Mercoledì")){
	
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==9){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=10)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Giovedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==9){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=10)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Venerdì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==9){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=10)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
				</tr>
				<tr>
					<td class="orario">10/11</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Lunedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==10){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=11)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Martedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==10){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=11)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Mercoledì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==10){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=11)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Giovedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==10){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=11)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Venerdì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==10){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=11)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
				</tr>
				<tr>
					<td class="orario">11/12</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Lunedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==11){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=12)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Martedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==11){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=12)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Mercoledì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==11){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=12)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Giovedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==11){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=12)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Venerdì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==11){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=12)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
				</tr>
				<tr>
					<td class="orario">12/13</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Lunedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==12){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=13)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Martedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==12){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=13)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Mercoledì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==12){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=13)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Giovedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==12){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=13)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Venerdì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==12){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=13)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
				</tr>
				<tr>
					<td class="orario">13/14</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Lunedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==13){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=14)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Martedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==13){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=14)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Mercoledì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==13){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=14)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Giovedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==13){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=14)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Venerdì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==13){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=14)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
				</tr>
				<tr>
					<td class="orario">14/15</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Lunedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==14){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=15)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Martedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==14){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=15)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Mercoledì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==14){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=15)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Giovedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==14){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=15)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Venerdì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==14){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=15)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
				</tr>
				<tr>
					<td class="orario">15/16</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Lunedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==15){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=16)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Martedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==15){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=16)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Mercoledì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==15){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=16)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Giovedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==15){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=16)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Venerdì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==15){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=16)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
				</tr>
				<tr>
					<td class="orario">16/17</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Lunedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==16){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=17)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Martedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==16){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=17)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Mercoledì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==16){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=17)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Giovedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==16){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=17)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Venerdì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==16){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=17)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
				</tr>
				<tr>
					<td class="orario">17/18</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Lunedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==17){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=18)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Martedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==17){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=18)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Mercoledì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==17){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=18)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Giovedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==17){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=18)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Venerdì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==17){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=18)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
				</tr>
				<tr>
					<td class="orario">18/19</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Lunedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==18){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=19)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Martedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==18){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=19)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Mercoledì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==18){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=19)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Giovedì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==18){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=19)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
					<td><%if(elenco.size()>0){
for(int i=0;i< elenco.size();i++) {
	if(elenco.get(i).getGiorno().equals("Venerdì")){
		
	
			if((int)elenco.get(i).getOrario().getInizio().getHours()==18){
				 
			if((int)elenco.get(i).getOrario().getFine().getHours()>=19)
	{
		%>
						<p>
							 <%=elenco.get(i).getAula().getNomeAula() %>
							edificio <%=elenco.get(i).getAula().getEdificio()%></p>
						<%
	}}}
}
}
else
%>nessuna aula libera</td>
				</tr>
			</tbody>
		</table>
	</div>


	<%@ include file="../headerfooter/Footer.html"%>

</body>
</html>