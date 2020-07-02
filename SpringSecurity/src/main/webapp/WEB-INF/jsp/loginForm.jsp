<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<style>
	.error{color:red;}
</style>
<title>Login to Your Account</title>
</head>
<body>
	<h2>Enter your credentials.!</h2>
	<form:form action="${pageContext.request.contextPath}/auth" method="POST">
		
		<c:if test="${param.error != null}">
			<i class="error">Bad Credentials!</i>
		</c:if>
		
		<c:if test="${param.logout != null}">
			<i>You have been logged out.</i>
		</c:if>
		
		<p>
			Username: <input type="text" name="username" />
		</p>
		<p>
			Password: <input type="password" name="password" />
		</p>
		<p>
			<input type="submit" value="Login" />
		</p>
	</form:form>
</body>
</html>