<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<title>Home</title>
</head>

<body>
	<h2>Home</h2>
	<hr>
	
	<p>Welcome to the home page!</p>
	<hr>
	
	<p>
		User: <b><security:authentication property="principal.username"/></b><br>
		Role(s): <b><security:authentication property="principal.authorities"/></b>
	</p>
	<hr>
	
	<!-- Add a links for navigation -->
	<security:authorize access="hasRole('MANAGER')">
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
			(Only For Leaders)
		</p>
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${pageContext.request.contextPath}/systems">System Management</a>
			(Only For System Admin)
		</p>
	</security:authorize>
		
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<button type="submit">Logout</button>
	</form:form>
</body>
</html>