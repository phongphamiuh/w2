<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html >
<html>
<head>

<title>Person</title>
</head>
<body>

<h1>Create New Record</h1>
<c:url var="saveUrl" value="/person/save" />

<form:form modelAttribute="person" method="POST" action="${saveUrl}">
	 <form:hidden path="id" />
	 <table>
	  <tr>
	   <td><form:label path="firstName">First Name:</form:label></td>
	   <td><form:input path="firstName"/></td>
	  </tr>
	
	  <tr>
	   <td><form:label path="lastName">Last Name</form:label></td>
	   <td><form:input path="lastName"/></td>
	  </tr>
	  
	  <tr>
	   <td><form:label path="money">Money</form:label></td>
	   <td><form:input path="money"/></td>
	  </tr>
	  
	  
	 </table>
	 <input type="submit" value="Save" />
</form:form>

</body>
</html>
