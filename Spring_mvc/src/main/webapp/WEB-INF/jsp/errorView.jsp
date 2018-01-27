<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<title>Error Page</title>
<body>
	so the error that has occurred during the bind is.
	<form:errors path="place.*" />
	<form:errors path="along.*" />
	<form:errors></form:errors>
</body>
</html>