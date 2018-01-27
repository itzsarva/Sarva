<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<title>globalMethod.jsp</title>
<body>
	This is the Global Page !!
	
	
	The Excpetion that has occured during the
	process is.
	<C:out value="${errorMessage}"></C:out>

	And The Reason for the Excpetion is.
	<C:out value="${cause}"></C:out>

</body>
</html>