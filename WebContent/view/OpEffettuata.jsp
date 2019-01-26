<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<% String url = request.getParameter("redirect"); %>
<script type="text/javascript">
function byebye(){
	
	   window.location.replace("ServletVisualizzaProfilo");

	}
</script>
</head>
<body onload="setTimeout(byebye, 3000)">
	<h1>Operazione effettuata!</h1>
	tra un momento sarai reindirizzato al profilo
</body>
</html>