<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/19/2021
  Time: 10:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Danh sách sách</h1>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Author</th>
            <th>Description</th>
            <th>Quantity</th>
            <th>Borrow</th>
        </tr>
        <c:forEach var="book" items="${books}">
            <tr>
                <td><c:out value="${book.id}"/></td>
                <td><c:out value="${book.name}"/></td>
                <td><c:out value="${book.author}"/></td>
                <td><c:out value="${book.description}"/></td>
                <td><c:out value="${book.quantity}"/></td>
                <td>
                    <a href="/books?action=borrow&id=${book.id}">Borrow</a>
                </td>

            </tr>
        </c:forEach>
    </table>
</center>

</body>
</html>
