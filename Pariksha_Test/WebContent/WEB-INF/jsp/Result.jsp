<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js">
	
</script>
<script src="js/jquery-3.2.1.min.js">
	
</script>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="index.htm">Pariksha.co</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="index.htm">Home</a></li>
			<li><a href="logout.htm">Logout</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="logout.htm"><span
					class="glyphicon glyphicon-log-in"></span>${sessionScope.user.username}(Logout)</a></li>
		</ul>
	</div>
	</nav>
	<div class="container">
			<table align="center" class="table table-condensed"
				style="width: 40%;">
				<caption style="background-color: black; text-align: center;">
					<font color="white"><b>Score (${sessionScope.user.username})</b></font>
				</caption>
				<tr>
					<td>Total Marks:</td>
					<td>${sessionScope.result}/10</td>
				</tr>
				<tr>
					<td>Result:</td>
					<td><c:if test="${sessionScope.result gt 5}">Pass</c:if><c:if test="${sessionScope.result lt 6}">Fail</c:if></td>
				</tr>
				<tr>
					<td colspan="2">Passing marks is Above 5</td>
				</tr>
			</table>
		</div>
</body>
</html>