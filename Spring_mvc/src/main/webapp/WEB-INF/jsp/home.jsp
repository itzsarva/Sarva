<html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<title>Welcome.jsp</title>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.1/themes/ui-darkness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-2.1.1.js"></script>
<script src="http://code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(function() {
			$("#datepicker").datepicker();
		});
	});
</script>
<body>
	<a href="/welcome?lang=fr">missur</a> or
	<a href="/welcome?lang=en">Sire</a>
	<form action="/formDiffModel" name="homeForm" method="post">
		<table>
			<tr>
				<td><spring:message code="where"></spring:message></td>
				<td><input type="text" name="where"></td>
			</tr>
			<tr>
				<td>Why do you want to go?</td>
				<td><input type="text" name="why"></td>
			</tr>
			<tr>
				<td>when do you want to vist?</td>
				<td><input type="text" name="when" id="datepicker"></td>
			</tr>
			<tr>
				<td>what all will you carry?</td>
				<td><select name="things" size="3" multiple="multiple">
						<option value="bag">bag</option>
						<option value="kit">kit</option>
						<option value="shoes">shoes</option>
				</select></td>
			</tr>
			<tr>
				<td>who is coming with you?</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>whats their age?</td>
				<td><input type="text" name="along.age"></td>
			</tr>
			<tr>
				<td>Okay thats it?</td>
				<td><input type="text" name="along.kiss"></td>
			</tr>
		</table>
		<input type="submit" value="Are you ready to Go Now?"
			name="Are you ready?">
	</form>
</body>
</html>