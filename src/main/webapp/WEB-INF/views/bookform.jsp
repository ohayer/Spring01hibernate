<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: olik0
  Date: 04.04.2023
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
    TYTUŁ:<form:input path="title"/>
    AUTOR:<form:input path="author"/>
    <form:select itemValue="id" itemLabel="name" path="publisher.id" items="${publishers}"/>
    <input type="submit">
</form:form>
</body>
</html>
