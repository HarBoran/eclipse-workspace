<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
   <title>List Customers</title>
   <!--  css파일 적용-->
	   <link type="text/css"
       		rel="stylesheet"
       		href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
      <link type= "text/css"
      		rel="stylesheet"
      		href="${pageContext.request.contextPath}/resources/css/style.css"/>
        
      <link type= "text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/snow.css"/>
      <script src ="${pageContext.request.contextPath}/resources/js/main.js"></script>
      <script>
      $(document).ready(function(){
    	 $("").arlet({

    	 });	 
      });
      </script>
</head>
<body style = "background-color: white;">

<script src='https://unpkg.com/magic-snowflakes/dist/snowflakes.min.js'></script>
<script>
    var sf = new Snowflakes({
        count: 75, // 갯수
        minOpacity: 0.2, // 최소 투명도 0: 투명 | 1: 불투명
        maxOpacity: 0.6 // 최대 투명도
    });
</script>

   <div id="wrapper">
      <div id="header">
         <h2>Customer Management</h2>
      </div>
   </div>
   
  <form:form action = "search" method = "GET">
	  Search customer: <input name = "theSearchName"/> <button class = "add-button">Search</button>
  </form:form>
      
   <div id="container">
   
      <div id="content">
      
         <!-- add our html table here -->
         <input type = "button" value = "Add Customer" class ="add-button" 
         onclick="window.location.href='showFormForAdd'; return false;"/>    
         <table>
            <tr>
               <th>First Name</th>
               <th>Last Name</th>
               <th>Email</th>
               <th>Action</th>
            </tr>
            
            <!-- loop over and print our customers -->
            <c:forEach var="tempCustomer" items="${customers}">
            
               <tr>
                  <td> ${tempCustomer.firstName} </td>
                  <td> ${tempCustomer.lastName} </td>
                  <td> ${tempCustomer.email} </td>
				  <%-- <c:url value = 'showFormForUpdate?customerId=${tempCustomer.id}' var ="updateLink"/> --%>
				  <c:url value = 'showFormForUpdate' var ="updateLink">
				  	<c:param name ="customerId" value = "${tempCustomer.id}"/>
				  </c:url>
				  <c:url value = 'delete' var ="deleteLink">
				  	<c:param name ="customerId" value = "${tempCustomer.id}"/>
				  </c:url>
				  
				  <td><a href = "${updateLink}" style = "text-decoration-line: none">Update</a>
				  <a href = "${deleteLink}" style = "text-decoration-line: none"> | Delete</a></td>             
               </tr>
            
            </c:forEach>
                  
         </table>
            
      </div>
   
   </div>
   
</body>
</html>