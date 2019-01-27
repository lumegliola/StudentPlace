<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<% String url = request.getParameter("redirect"); %>
<script type="text/javascript">
function byebye(){
	
	   window.location.replace("ServletVisualizzaProfilo");

	}
</script>
</head>
<body onload="setTimeout(byebye, 3000)">

<div class="alert alert-success" role="alert" style="text-align: center; padding: 2%; margin: 5%">
	<img style="width: 20%" class="logoSPxl" alt="Logo StudentPlace"
		src="images/logoSPxl.png">
	<h1 class="alert-heading">Operazione effettuata!</h1>
	<p class="mb-0">Tra un momento sarai reindirizzato al profilo</p></div>
</body>
</html>