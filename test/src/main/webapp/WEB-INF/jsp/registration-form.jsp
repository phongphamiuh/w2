<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!doctype html>
<html lang="en">
<head>
	<title>Register New User Form</title>
	<meta charset="utf-8">
	<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>			
		<form:form action="${pageContext.request.contextPath}/register" 
			  	   modelAttribute="crmUser">
			<table>
				   <tr>
					   <td><form:label path="username">UserName:</form:label></td>
					   <td><form:input path="username"/></td>
				  </tr>
				
				  <tr>
					   <td><form:label path="password">Password:</form:label></td>
					   <td><form:input path="password"/></td>
				  </tr>
				  
				  <c:if test="${registrationError != null}">	
					<div>
						${registrationError}
					</div>
				  </c:if>
			</table>
			
			<input type="submit" value="Register" />
		</form:form>
</body>
</html>