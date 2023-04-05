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
<body>
<form:form method="post" modelAttribute="book">
    TYTUŁ:<form:input path="title"/><br/>
    DESCIPTION:<form:textarea path="description"/><br/>
    AUTOR:  <form:select path="authors" items="${authors}" itemLabel="firstName"/><br/>
    WYDAWCA:<form:select path="publisher" items="${publishers}" itemLabel="name"/><br/>
    <input type="submit" value="Zapisz">
</form:form>
</body>
</body>
</html>
