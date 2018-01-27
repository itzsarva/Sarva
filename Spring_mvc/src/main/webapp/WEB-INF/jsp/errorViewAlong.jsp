<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<title>Error Page</title>
<body>
	so the error that has occurred during the bind for Along is...
	<br>
	<br>
	<form:errors path="place.*" />
</body>
</html>