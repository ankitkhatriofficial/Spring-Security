<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<title>HomePage</title>
</head>
<body>

	<h2>Khatri Company HomePage - Yahoo!</h2>
<hr>
	<p>
		Welcome to this Project.!
	</p>
<hr>
	<p>
		User: <security:authentication property="principal.username"/>
	</p>
	<p>
		Roles: <security:authentication property="principal.authorities"/>
	</p>
	
	<security:authorize access="hasRole('MANAGER')">
		<a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a> (Only for Manager peeps)
	</security:authorize>
	<p>
		<security:authorize access="hasRole('ADMIN')">
			<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a> (Only for Admin peeps)
		</security:authorize>
	</p>
	<hr>
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout"/>	
	</form:form>
	
</body>
	
</html>