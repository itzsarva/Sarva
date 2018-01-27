<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<title>errorMethod.jsp</title>
<body>
	The Excpetion that has occured during the process is.
	<C:out value="${errorMessage}"></C:out>

	And The Reason for the Excpetion is.
	<C:out value="${cause}"></C:out>

	And The class is.
	<C:out value="${classs}"></C:out>

	And the stack trace is.
	<C:out value="${exception}"></C:out>

</body>
</html>