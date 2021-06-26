<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap/bootstrap.min.js" />

<html>
    <head>
        <title>SE Company Home Page</title>
        
    </head>
    
    <body>
    	<jsp:include page="header.jsp" />
	    <p>
	        <a href="${pageContext.request.contextPath}/register">Register New User</a>
	        <a href="${pageContext.request.contextPath}/login">Login</a>
	    </p>
	    
	    <security:authorize access="hasAnyRole('ADMIN','USER')">         
	          <a href="${pageContext.request.contextPath}/person/list">Customer List</a>      
	    </security:authorize>	
    </body>
</html>