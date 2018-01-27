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
		And who is tagging along? is it?
		<C:out value="${along.name}"></C:out>
		who is only
		<C:out value="${place.along.age}"></C:out>
		years old! cmon man.
	</h2>

	<h3>
		IMPORTANTEEE STUFEEE
		<C:if test="${along.kiss eq null}">
			<C:out value="it is null"></C:out>
		</C:if>
		<C:out value="${place.along.kiss}"></C:out>
	</h3>
	And the Drum rolls the value which was set in before the view was rendered is <C:out value="${sarva}"></C:out>
</body>

</html>