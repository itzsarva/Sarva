<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">

<head>
<title>Spring Boot MVC Security using Thymeleaf</title>
<link rel="stylesheet" href="/css/styles.css" />
<!-- Spring tag lib for forms -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- JSTL Tag -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<h3>User Articles Details</h3>
	<div>
		Logged in user: <b th:inline="text" class="user"> </b>
		<form:form action="/other/some" method="post">
			<input type="submit" value="sub" />
		</form:form>
	</div>
	<br />
	<table>
		<tr th:each="article : ${userArticles}">
			<td th:text="${article.articleId}">Id</td>
			<td th:text="${article.title}">Title</td>
			<td th:text="${article.category}">Category</td>
		</tr>
	</table>
</body>
</html>
