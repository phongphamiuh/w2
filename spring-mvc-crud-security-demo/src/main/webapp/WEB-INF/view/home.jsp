<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
    <head>
        <title>SE Company Home Page</title>
    </head>
    <body>
        <h2> SE Company Home Page</h2>
        <hr>
        Welcome to the SE company home page yoyo!
        <!-- display user name and role -->
	
<%--    <p>
        User: <security:authentication property="principal.username" />

        Role(s): <security:authentication property="principal.authorities" />
    </p>--%>
    <p>
        <a href="${pageContext.request.contextPath}/register/showRegistrationForm">Register New User</a>
        (for All)
    </p>
    
    <security:authorize access="hasAnyRole('EMPLOYEE','MANAGER', 'ADMIN')">
            <!-- Add a link to point to /leaders ... this is for the managers -->
            <p>
                    <a href="${pageContext.request.contextPath}/customer/list">Customer List</a>
                    (Only for Employee, Manager and Admin)
            </p>
    </security:authorize>	
    
        <!-- Add a logout button -->
    
    </body>
</html>