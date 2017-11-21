<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
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
		</ul>
		<ul class="nav navbar-nav">
			<li><a href="signup.htm">Sign Up</a></li>
		</ul>
	</div>
	</nav>
	<form:form action="validate.htm" method="post" modelAttribute="user">
		<div class="container">
			<table align="center" class="table table-condensed"
				style="width: 40%;">
				<caption style="background-color: black; text-align: center;">
					<font color="white"><b>Enter your LoginId and Password</b></font>
				</caption>
				<tr>
					<td>Username:</td>
					<td><form:input path="username" required="required" /> <form:errors
							path="username" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="password" required="required" /> <form:errors
							path="password" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" class="btn btn-default"
						value="Login"></td>
				</tr>
			</table>
		</div>
	</form:form>
</body>
</html>