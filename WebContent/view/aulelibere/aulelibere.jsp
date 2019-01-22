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
//lista delle aula divisa per giorno e fasce orarie
   List <String> lunedi1 = (List <String>)request.getAttribute("lunedi1");
List <String> lunedi2 = (List <String>)request.getAttribute("lunedi2");
List <String> lunedi3 = (List <String>)request.getAttribute("lunedi3");
List <String> lunedi4 = (List <String>)request.getAttribute("lunedi4");
List <String> lunedi5 = (List <String>)request.getAttribute("lunedi5");
List <String> lunedi6 = (List <String>)request.getAttribute("lunedi6");
List <String> lunedi7 = (List <String>)request.getAttribute("lunedi7");
List <String> lunedi8 = (List <String>)request.getAttribute("lunedi8");
List <String> lunedi9 = (List <String>)request.getAttribute("lunedi9");
List <String> lunedi10 = (List <String>)request.getAttribute("lunedi10");
List <String> martedi1 = (List <String>)request.getAttribute("martedi1");
List <String> martedi2 = (List <String>)request.getAttribute("martedi2");
List <String> martedi3 = (List <String>)request.getAttribute("martedi3");
List <String> martedi4 = (List <String>)request.getAttribute("martedi4");
List <String> martedi5 = (List <String>)request.getAttribute("martedi5");
List <String> martedi6 = (List <String>)request.getAttribute("martedi6");
List <String> martedi7 = (List <String>)request.getAttribute("martedi7");
List <String> martedi8 = (List <String>)request.getAttribute("martedi8");
List <String> martedi9 = (List <String>)request.getAttribute("martedi9");
List <String> martedi10 = (List <String>)request.getAttribute("martedi10");
List <String> mercoledi1 = (List <String>)request.getAttribute("mercoledi1");
List <String> mercoledi2 = (List <String>)request.getAttribute("mercoledi2");
List <String> mercoledi3 = (List <String>)request.getAttribute("mercoledi3");
List <String> mercoledi4 = (List <String>)request.getAttribute("mercoledi4");
List <String> mercoledi5 = (List <String>)request.getAttribute("mercoledi5");
List <String> mercoledi6 = (List <String>)request.getAttribute("mercoledi6");
List <String> mercoledi7 = (List <String>)request.getAttribute("mercoledi7");
List <String> mercoledi8 = (List <String>)request.getAttribute("mercoledi8");
List <String> mercoledi9 = (List <String>)request.getAttribute("mercoledi9");
List <String> mercoledi10 = (List <String>)request.getAttribute("mercoledi10");
List <String> giovedi1 = (List <String>)request.getAttribute("giovedi1");
List <String> giovedi2 = (List <String>)request.getAttribute("giovedi2");
List <String> giovedi3 = (List <String>)request.getAttribute("giovedi3");
List <String> giovedi4 = (List <String>)request.getAttribute("giovedi4");
List <String> giovedi5 = (List <String>)request.getAttribute("giovedi5");
List <String> giovedi6 = (List <String>)request.getAttribute("giovedi6");
List <String> giovedi7 = (List <String>)request.getAttribute("giovedi7");
List <String> giovedi8 = (List <String>)request.getAttribute("giovedi8");
List <String> giovedi9 = (List <String>)request.getAttribute("giovedi9");
List <String> giovedi10 = (List <String>)request.getAttribute("giovedi10");
List <String> venerdi1 = (List <String>)request.getAttribute("venerdi1");
List <String> venerdi2 = (List <String>)request.getAttribute("venerdi2");
List <String> venerdi3 = (List <String>)request.getAttribute("venerdi3");
List <String> venerdi4 = (List <String>)request.getAttribute("venerdi4");
List <String> venerdi5 = (List <String>)request.getAttribute("venerdi5");
List <String> venerdi6 = (List <String>)request.getAttribute("venerdi6");
List <String> venerdi7 = (List <String>)request.getAttribute("venerdi7");
List <String> venerdi8 = (List <String>)request.getAttribute("venerdi8");
List <String> venerdi9 = (List <String>)request.getAttribute("venerdi9");
List <String> venerdi10 = (List <String>)request.getAttribute("venerdi10");
   
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
					<td>09/10</td>
					<td>
						<%
					
if(lunedi1.size()!=0){for(int i=0;i< lunedi1.size();i++) {
	
	{
		%>
						<p>
							<%=lunedi1.get(i) %>,
							</p>
						<%
	}
}}
%>

					</td>
					<td>
					<%
					
if(martedi1.size()!=0){for(int i=0;i< martedi1.size();i++) {
	
	{
		%>
						<p>
							<%=martedi1.get(i) %>,
							</p>
						<%
	}
}}
%>
					</td>
					<td><%
					
if(mercoledi1.size()!=0){for(int i=0;i< mercoledi1.size();i++) {
	
	{
		%>
						<p>
							<%=mercoledi1.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(giovedi1.size()!=0){for(int i=0;i< giovedi1.size();i++) {
	
	{
		%>
						<p>
							<%=giovedi1.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(venerdi1.size()!=0){for(int i=0;i< venerdi1.size();i++) {
	
	{
		%>
						<p>
							<%=venerdi1.get(i) %>,
							</p>
						<%
	}
}}
%></td>
				</tr>
				<tr>
					<td>10/11</td>
					<td><%
if(lunedi2.size()!=0){for(int i=0;i< lunedi2.size();i++) {
	
	{
		%>
						<p>
							<%=lunedi2.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td>	<%
					
if(martedi2.size()!=0){for(int i=0;i< martedi2.size();i++) {
	
	{
		%>
						<p>
							<%=martedi2.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(mercoledi2.size()!=0){for(int i=0;i< mercoledi2.size();i++) {
	
	{
		%>
						<p>
							<%=mercoledi2.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(giovedi2.size()!=0){for(int i=0;i< giovedi2.size();i++) {
	
	{
		%>
						<p>
							<%=giovedi2.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(venerdi2.size()!=0){for(int i=0;i< venerdi2.size();i++) {
	
	{
		%>
						<p>
							<%=venerdi2.get(i) %>,
							</p>
						<%
	}
}}
%></td>
				</tr>
				<tr>
					<td>11/12</td>
					<td><%
if(lunedi3.size()!=0){for(int i=0;i< lunedi3.size();i++) {
	
	{
		%>
						<p>
							<%=lunedi3.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td>	<%
					
if(martedi3.size()!=0){for(int i=0;i< martedi3.size();i++) {
	
	{
		%>
						<p>
							<%=martedi3.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(mercoledi3.size()!=0){for(int i=0;i< mercoledi3.size();i++) {
	
	{
		%>
						<p>
							<%=mercoledi3.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(giovedi3.size()!=0){for(int i=0;i< giovedi3.size();i++) {
	
	{
		%>
						<p>
							<%=giovedi3.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(venerdi3.size()!=0){for(int i=0;i< venerdi3.size();i++) {
	
	{
		%>
						<p>
							<%=venerdi3.get(i) %>,
							</p>
						<%
	}
}}
%></td>
				</tr>
				<tr>
					<td>12/13</td>
					<td><%
if(lunedi4.size()!=0){for(int i=0;i< lunedi4.size();i++) {
	
	{
		%>
						<p>
							<%=lunedi4.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td>	<%
					
if(martedi4.size()!=0){for(int i=0;i< martedi4.size();i++) {
	
	{
		%>
						<p>
							<%=martedi4.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(mercoledi4.size()!=0){for(int i=0;i< mercoledi4.size();i++) {
	
	{
		%>
						<p>
							<%=mercoledi4.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(giovedi4.size()!=0){for(int i=0;i< giovedi4.size();i++) {
	
	{
		%>
						<p>
							<%=giovedi4.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(venerdi4.size()!=0){for(int i=0;i< venerdi4.size();i++) {
	
	{
		%>
						<p>
							<%=venerdi4.get(i) %>,
							</p>
						<%
	}
}}
%></td>
				</tr>
				<tr>
					<td>13/14</td>
					<td><%
if(lunedi5.size()!=0){for(int i=0;i< lunedi5.size();i++) {
	
	{
		%>
						<p>
							<%=lunedi5.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td>	<%
					
if(martedi5.size()!=0){for(int i=0;i< martedi5.size();i++) {
	
	{
		%>
						<p>
							<%=martedi5.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(mercoledi5.size()!=0){for(int i=0;i< mercoledi5.size();i++) {
	
	{
		%>
						<p>
							<%=mercoledi5.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(giovedi5.size()!=0){for(int i=0;i< giovedi5.size();i++) {
	
	{
		%>
						<p>
							<%=giovedi5.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(venerdi5.size()!=0){for(int i=0;i< venerdi5.size();i++) {
	
	{
		%>
						<p>
							<%=venerdi5.get(i) %>,
							</p>
						<%
	}
}}
%></td>
				</tr>
				<tr>
					<td>14/15</td>
					<td><%
if(lunedi6.size()!=0){for(int i=0;i< lunedi6.size();i++) {
	
	{
		%>
						<p>
							<%=lunedi6.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td>	<%
					
if(martedi6.size()!=0){for(int i=0;i< martedi6.size();i++) {
	
	{
		%>
						<p>
							<%=martedi6.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(mercoledi6.size()!=0){for(int i=0;i< mercoledi6.size();i++) {
	
	{
		%>
						<p>
							<%=mercoledi6.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(giovedi6.size()!=0){for(int i=0;i< giovedi6.size();i++) {
	
	{
		%>
						<p>
							<%=giovedi6.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(venerdi6.size()!=0){for(int i=0;i< venerdi6.size();i++) {
	
	{
		%>
						<p>
							<%=venerdi6.get(i) %>,
							</p>
						<%
	}
}}
%></td>
				</tr>
				<tr>
					<td>15/16</td>
					<td><%
if(lunedi7.size()!=0){for(int i=0;i< lunedi7.size();i++) {
	
	{
		%>
						<p>
							<%=lunedi7.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td>	<%
					
if(martedi7.size()!=0){for(int i=0;i< martedi7.size();i++) {
	
	{
		%>
						<p>
							<%=martedi7.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(mercoledi7.size()!=0){for(int i=0;i< mercoledi7.size();i++) {
	
	{
		%>
						<p>
							<%=mercoledi7.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(giovedi7.size()!=0){for(int i=0;i< giovedi7.size();i++) {
	
	{
		%>
						<p>
							<%=giovedi7.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(venerdi7.size()!=0){for(int i=0;i< venerdi7.size();i++) {
	
	{
		%>
						<p>
							<%=venerdi7.get(i) %>,
							</p>
						<%
	}
}}
%></td>
				</tr>
				<tr>
					<td>16/17</td>
					<td><%
if(lunedi8.size()!=0){for(int i=0;i< lunedi8.size();i++) {
	
	{
		%>
						<p>
							<%=lunedi8.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td>	<%
					
if(martedi8.size()!=0){for(int i=0;i< martedi8.size();i++) {
	
	{
		%>
						<p>
							<%=martedi8.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(mercoledi8.size()!=0){for(int i=0;i< mercoledi8.size();i++) {
	
	{
		%>
						<p>
							<%=mercoledi8.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(giovedi8.size()!=0){for(int i=0;i< giovedi8.size();i++) {
	
	{
		%>
						<p>
							<%=giovedi8.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(venerdi8.size()!=0){for(int i=0;i< venerdi8.size();i++) {
	
	{
		%>
						<p>
							<%=venerdi8.get(i) %>,
							</p>
						<%
	}
}}
%></td>
				</tr>
				<tr>
					<td>17/18</td>
					<td><%
if(lunedi9.size()!=0){for(int i=0;i< lunedi9.size();i++) {
	
	{
		%>
						<p>
							<%=lunedi9.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td>	<%
					
if(martedi9.size()!=0){for(int i=0;i< martedi9.size();i++) {
	
	{
		%>
						<p>
							<%=martedi9.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(mercoledi9.size()!=0){for(int i=0;i< mercoledi9.size();i++) {
	
	{
		%>
						<p>
							<%=mercoledi9.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(giovedi9.size()!=0){for(int i=0;i< giovedi9.size();i++) {
	
	{
		%>
						<p>
							<%=giovedi9.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(venerdi9.size()!=0){for(int i=0;i< venerdi9.size();i++) {
	
	{
		%>
						<p>
							<%=venerdi9.get(i) %>,
							</p>
						<%
	}
}}
%></td>
				</tr>
				<tr>
					<td>18/19</td>
					<td><%
if(lunedi10.size()!=0){for(int i=0;i< lunedi10.size();i++) {
	
	{
		%>
						<p>
							<%=lunedi10.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td>	<%
					
if(martedi10.size()!=0){for(int i=0;i< martedi10.size();i++) {
	
	{
		%>
						<p>
							<%=martedi10.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(mercoledi10.size()!=0){for(int i=0;i< mercoledi10.size();i++) {
	
	{
		%>
						<p>
							<%=mercoledi10.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(giovedi10.size()!=0){for(int i=0;i< giovedi10.size();i++) {
	
	{
		%>
						<p>
							<%=giovedi10.get(i) %>,
							</p>
						<%
	}
}}
%></td>
					<td><%
					
if(venerdi10.size()!=0){for(int i=0;i< venerdi10.size();i++) {
	
	{
		%>
						<p>
							<%=venerdi10.get(i) %>,
							</p>
						<%
	}
}}
%></td>
				</tr>
			</tbody>
		</table>
	</div>


	<%@ include file="../headerfooter/Footer.html"%>

</body>
</html>