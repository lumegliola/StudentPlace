<%@page import="java.util.GregorianCalendar"%>
<%@page import="bean.GruppoDiStudio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		GruppoDiStudio b = (GruppoDiStudio) request.getAttribute("gruppo");

		//List<TechnicalSpecificationBean> l = DAOFactory.getTechnicalSpecificationDAO().doRetrieveByProduct(b);
	%>

	<div id="container_product_description" class=" container-fluid">

		<div class="row img_row">
			<div class="left_div col-md-5">
				<div id="nome">
					<%=b.getNomeGruppo()%>
				</div>


			</div>
			<div class="right_div col-md-7">
				<div class="row">
					<div class="col-md-12 col_materia">
						<h1 id=materia>
							<%=b.getMateria()%>
						</h1>
					</div>
				</div>
				<div class="row ">
					<div class="col-md-12 col_aula">
						<div id="aula">
							in:
							<%=b.getAula()%>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6 col_orario">
						<h3>Orario:</h3>
					</div>
					<div class="col-md-6 col_orario">

						<span id=inizio class="center"> <%=b.getOrario().getInizio()%>
						<br>
						
								
					</div>
				</div>
				
			</div>
		</div>
		
	</div>
</body>
</html>