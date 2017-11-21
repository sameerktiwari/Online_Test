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
		<ul class="nav navbar-nav navbar-right">
			<li><a href="logout.htm"><span
					class="glyphicon glyphicon-log-in"></span>${sessionScope.user.username}(Logout)</a></li>
		</ul>
	</div>
	</nav>
	<form method="post">
		<h3>${index+1}.${q.question}</h3>
		<c:forEach var="option" items="${options}">
			<h4>
				<input type="radio" name="option" value="${option.optionId}"
					required>"${option.ansDescription}"
			</h4>
		</c:forEach>
		<input type="hidden" name="currIndex" value="${index}">
		<c:if test="${index gt 0}">
			<input class="btn btn-default" type="submit" value="Previous" formaction="showTest.htm?index=${index-1}">
		</c:if>
		<c:if test="${index lt 10}">
			<input class="btn btn-default" type="submit" value="Next" formaction="showTest.htm?index=${index+1}">
		</c:if>
		<input class="btn btn-default" type="submit" value="Submit" formaction="complete.htm">
	</form>
</body>
</html>