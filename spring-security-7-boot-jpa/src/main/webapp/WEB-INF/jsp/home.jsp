<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>welcome</title>
	<link rel="icon" href="/images/favicon.ico">
</head>
<body>

	<h2>home.jsp</h2>
	<hr>
	
	<div>message: ${message}</div>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		welcome ${pageContext.request.userPrincipal.name }!<br>
		<!-- If you are using logout with CSRF you must perform a POST. -->
		<!-- spring security 4 use POST method -->
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="Logout" />
		</form:form>
	</c:if>
	<hr>
	
	<a href="<c:url value="/login" />">login</a><br>
	<a href="<c:url value="/user" />">user</a><br>
	<a href="<c:url value="/admin" />">admin</a><br>
	<a href="<c:url value="/super" />">super</a><br>

</body>
</html>