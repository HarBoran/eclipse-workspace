<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Access Denied</title>
</head>
<body>

		<h2>Access Denied</h2>

		<p>You are not authorized to this resource.</p>
	<hr>	
		
<a href="${pageContext.request.contextPath}/">Back to Home Page</a>
</body>
</html>
