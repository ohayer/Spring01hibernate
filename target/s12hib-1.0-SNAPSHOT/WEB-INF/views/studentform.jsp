<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student</title>
</head>
<body>

<form:form method="post" modelAttribute="student">
    IMIĘ: <form:input path="firstName" /><br>
    NAZWISKO:<form:input path="lastName"/><br>
    PŁEĆ: <form:radiobutton  path="gender" value="M" label="Mężczyzna"/>
    <form:radiobutton path="gender" value="K" label="Kobieta"/><br>
    KRAJ: <form:select path="country" items="${countries}" >

<%--    <c:forEach items="${countries}" var="country">--%>
<%--        <option value="${country}">${country}</option>--%>
<%--    </c:forEach>--%>
</form:select>
    <br><br>
    NOTES: <form:textarea path="notes" id="notes" name="notes"></form:textarea><br>
    Mailing List: <form:checkbox path="mailingList" id="mailingList"/><br>
    Umiejętności programowania <form:select path="programmingSkills" name="programmingSkills" >
    <c:forEach items="${program}" var="program">
        <option value="${program}">${program}</option>
    </c:forEach>
</form:select>
    <br><br>
    Hobbies:<form:checkboxes items="${hobbies}" path="hobbies"/>
    <br><br>
    <input type="submit" placeholder="Wyślij">

</form:form>

</body>
</html>