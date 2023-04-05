<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: olik0
  Date: 04.04.2023
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Books</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
            margin-bottom: 20px;
            border: 2px solid #ddd;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
            color: #444;
        }

        td:nth-child(odd) {
            background-color: #f9f9f9;
        }

        .circle {
            display: inline-block;
            width: 30px;
            height: 30px;
            border-radius: 50%;
            background-color: #f44336;
        }
    </style>

</head>
<body>
<a href="http://localhost:8080/books/form">Dodaj książkę</a>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>AUTOR</th>
        <th>TYTUŁ</th>
        <th>WYDAWNICTWO</th>
        <th>DESCRIPTION</th>
        <th>ACTIONS</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.author}</td>
            <td>${book.title}</td>
            <td>${book.publisher.name}</td>
            <td>${book.description}</td>
            <td><a href="http://localhost:8080/book/delete/${book.id}" class="delete">USUŃ </a>
            <a href="http://localhost:8080/book/update/${book.id}/Ksieżczniczka"> EDYTUJ NA TYTUŁ KSIĘŻCZNICZKA</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script defer>
    let deleteCheck = document.querySelectorAll(".delete");
    for (let deletes of  deleteCheck){
    deletes.onclick = function(e) {
        e.preventDefault();
        let ids = this.getAttribute('href');
        let result = confirm("Czy na pewno chcesz usunąć ten element?");
        if (result) {
            window.location.replace(ids);
        }
    }
    }
</script>


</body>
</html>
