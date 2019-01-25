<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<% String url = request.getParameter("redirect"); %>
<script type="text/javascript">
function byebye(){
	   var newWin = window.open(<%=url%>);
	}
</script>
</head>
<body onload="byebye()">
	<h1>Operazione effettuata!</h1>
</body>
</html>