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
		</ul>
	</div>
	</nav>
	<form:form action="register.htm" method="post"
		modelAttribute="user">

		<table align="center" class="table table-condensed"
			style="width: 50%;">
			<caption style="background-color: black; text-align: center;">
				<font color="white"><b>Register</b></font>
			</caption>
			<tr>
				<td>Username</td>
				<td><form:input path="username" required="required"/><form:errors
						path="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input path="password" required="required" type="password"/><form:errors
						path="password" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" required="required" /><form:errors
						path="email" /></td>
			</tr>
			<tr>
				<td colspan="2"><input class="btn btn-default" type="submit"
					value="Register" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>