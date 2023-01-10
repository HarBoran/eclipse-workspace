<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="css/style.css">

<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>My Custom Login Page</title>
</head>

<body>
	<h2>My Custom Login Page</h2>
	<form:form
		action="${pageContext.request.contextPath}/authenticateTheUser"
		method="POST">

		<div>
			<c:if test="${param.error != null}">
				<i class = "failed">Wrong Information</i>
			</c:if>
		</div>
		
		<p>
			User Name : <input name="username" placeholder="아이디" />
		</p>
		<p>
			Password : <input type="password" name="password" placeholder="비밀번호" />
		</p>
		<input type=submit value="Login">

	</form:form>
</body>
</html>
