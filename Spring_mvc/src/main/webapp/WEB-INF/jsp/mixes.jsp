<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<title>success.jsp</title>
<body>
	Hello who ever you are , you want to visit
	<C:out value="${place.where}"></C:out>
	and you have said that you wanted to vist that place because
	<C:out value="${place.why}"></C:out>
	<p>
		<i><b>Let me tell you one thing, where ever it is , what ever
				the reason may be you are not going to feel any better, you know
				why? it is all in your head and you gotta find peace where ever you
				are. Thats how you find happiness.</b> </i>
	</p>
	<h2>
		And BTW
		<C:out value="${place.where}"></C:out>
		?? LMAO
		<C:out value="${place.custom}"></C:out>
	</h2>
	<h2>
		so when are you going?
		<C:out value="${place.when}"></C:out>
	</h2>
	<h2>
		what all are you carrying btw?
		<C:forEach items="${place.things}" var="items">
		----->${items}<br>
		</C:forEach>
	</h2>
</body>

</html>