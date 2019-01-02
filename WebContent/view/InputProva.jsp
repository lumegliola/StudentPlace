<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/ServletCreaGds" method="post">
      <label>Nome Gds:</label>
      <input type="text" name ="nome">
      <br>
      <label>Materia Gds:</label>
      <input type="text"  name="materia">
      <br>
      <label>Data:</label>
      <input type="date" id="date" name="date"
       value="2018-07-22"
       min="2018-01-01" max="2018-12-31">
      <br>
      <label>Inizio:</label>
      <input type="time" id="timeStart" name="timeStart"
       min="9:00" max="18:00" required>
      <br>
      <label>Fine:</label>
      <input type="time" id="timeEnd" name="timeEnd"
       min="9:00" max="18:00" required>
      <br>
      <input type="submit">
       

	</form>

</body>
</html>