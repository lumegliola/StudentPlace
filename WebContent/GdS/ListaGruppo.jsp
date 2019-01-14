<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="bean.*"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="" method="post">
		<span><label>Ricerca per nome o materia:</label> <br> <input
			type="text" name="inputRicerca" placeholder="Ricerca Gruppo"
			style="width: 90%; clear: both;"><input type="submit"
			class="button" value="Cerca"></input></span>
	</form>

	<%!List<GruppoDiStudio> list;%>

	<div id=products_container class="container-fluid">

		<%
			list = (List<GruppoDiStudio>) request.getAttribute("gruppi");

			int numPagina = (Integer) request.getAttribute("pagina");
		%>


		<%
			try {
			for(int i = ((numPagina * 10)-10) ; i < (numPagina * 10); i++) {
				GruppoDiStudio p = list.get(i);
		%>
		<!-- -------------------------- product row --------------------------- -->

		<div class="row">
			<div class="col-lg-1">
				<span class="id_gruppo" alt="Gruppo"><%=p.getId()%></span>
			</div>

			<div class="col-lg-3">
				<br /> <span class="nome_gruppo"><%=p.getNomeGruppo()%></span><br /> 
			</div>

			<div class="col-lg-2">
				<br />
				<span class="aula"><%=p.getAula()%></span>
			</div>
			<div class="col-lg-2">
				<br />
				<span class="inizio"><%=p.getOrario().getInizio()%></span>
				<br>
				<span class="fine"><%=p.getOrario().getFine()%></span>
			</div>
		</div>
		<%
			} 
			} catch (IndexOutOfBoundsException e) {
				
			}
		%>

		<%  int numGruppi = list.size(); 
			int i = 0;
			if (numGruppi > 10) {
		%>

		<div id=pagination_container>
			<ul class="pagination">

				<% while (numGruppi > 0) { 
					numGruppi = numGruppi - 10; 
					i++;
					if (i == numPagina) {
			%>
				<li><a id="active"
					href="cerca?cosa=<%=variabile%>&pagina=<%=i%>"><%=i %></a></li>

				<% } else {%>
				<li><a href="cerca?cosa=<%=variabile%>&pagina=<%=i%>"><%=i %></a></li>

				<% } //chiude l'else. %>

				<% } //chiude il while. %>
			</ul>
			<% } //chiude l'if %>
		</div>
	</div>

</body>
</html>