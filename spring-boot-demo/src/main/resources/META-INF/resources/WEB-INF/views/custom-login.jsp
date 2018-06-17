<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
    <head>
        <title> Spring Boot MVC Security using Thymeleaf </title>
        <link rel="stylesheet" href="/css/styles.css"/>
    </head>
    <body>
        <h3> Spring Boot MVC Security using Thymeleaf </h3> 
        <p th:if="${param.error}" class="error">
            Bad Credentials  
        </p>
        <form th:action="@{/app-login}" method="POST">
            User Name : <input type="text" name="app_username"/> <br/><br/>
            Password: <input type="password" name="app_password"/> <br/><br/>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>