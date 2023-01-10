<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="EUC-KR">
<title>Home Page</title>
</head>
<body style = "bgcolor:red;">

	<script src='https://unpkg.com/magic-snowflakes/dist/snowflakes.min.js'></script>
	<script>
	    var sf = new Snowflakes({
	        count: 75, // 갯수
	        minOpacity: 0.2, // 최소 투명도 0: 투명 | 1: 불투명
	        maxOpacity: 0.6 // 최대 투명도
	    });
	</script>
	
	<h2>💓 💔 💕 Home Page 💖 💗 💘</h2>
	<hr>
	
	Welcome to home page~~
	
	<hr>
	<p>
		User: <security:authentication property = "principal.username"/>
		<br><br>
		Role(s): <security:authentication property = "principal.authorities"/>
	</p>
	<hr>
	
	
		<c:if test="${principal.authorities == 'ROLE_MANAGER'}">
			<i class = "failed">Wrong Information</i>
		</c:if>
	
	 <security:authorize access = "hasRole('MANAGER')">
		<a href="${pageContext.request.contextPath}/leaders" style = "text-decoration: none;">Leadership Meeting</a>(Only for Managers)<br>
		<input type = "button" value = "Leadership Meeting" class ="add-button" 
         onclick="window.location.href='leaders'; return false;"/>   
	</security:authorize>
	
	<hr>
	
	 <security:authorize access = "hasRole('ADMIN')">
		<a href="${pageContext.request.contextPath}/systems" style = "text-decoration: none;">IT Systems Meeting</a>(Only for Admins)<br>
		<input type = "button" value = "Leadership Meeting" class ="add-button" 
         onclick="window.location.href='systems'; return false;"/>
	</security:authorize>
	
	<hr>
				
		<form:form action="${pageContext.request.contextPath}/customlogout" method="POST">
			<input type=submit value="Logout">
		</form:form>
		
	<hr>
		
	<!-- 지도를 표시할 div 입니다 -->
	<div id="map" style="width:400px;height:300px;left:200px;"></div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=09435e8a15e006b36a9a83d98131dd0f"></script>
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = { 
		        center: new kakao.maps.LatLng(37.570993000203984 , 126.99251768639506), // 지도의 중심좌표
		        level: 3 // 지도의 확대 레벨
		    };
		
		// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
		var map = new kakao.maps.Map(mapContainer, mapOption);
	</script>
		
</body>
</html>