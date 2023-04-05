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
    TYTUŁ:<form:input path="title"/>
    <form:errors path="title"/><br/>
    DESCIPTION:<form:textarea path="description"/>
    <form:errors path="description"/><br/>
    AUTORZY:  <form:checkboxes path="authors" items="${authors}" itemLabel="firstName" itemValue="id"/><br/>
    <form:errors path="authors"/><br/>
    WYDAWCA:<form:select path="publisher" items="${publishers}" itemLabel="name" itemValue="id"/>
    <form:errors path="publisher"/><br/>
    <input type="submit" value="Zapisz">
</form:form>
</body>
</body>
</html>
