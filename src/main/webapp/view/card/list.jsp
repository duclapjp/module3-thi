<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/19/2021
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="get">
  <p>tên sách:</p>
  <input type="text" name="name">
  <input type="submit"value="tìm kiếm">
</form>
<center>
  <h1>Danh sách Đang cho Mượn</h1>
  <table border="1">
    <tr>
      <th>Id</th>
      <th>ms</th>
      <th>ms_student</th>
      <th>status</th>
      <th>borrow_day</th>
      <th>back_day</th>
    </tr>
    <c:forEach var="card" items="${cards}">
      <tr>
        <td><c:out value="${card.id}"/></td>
        <td><c:out value="${card.book.id}"/></td>
        <td><c:out value="${card.student.id}"/></td>
        <td><c:out value="${card.status}"/></td>
        <td><c:out value="${card.borrow_day}"/></td>
        <td><c:out value="${card.back_day}"/></td>
        <td>
          <a href="/cards?action=back&id=${card.id}">Trả sách</a>
        </td>
      </tr>
    </c:forEach>
  </table>
</center>
</body>
</html>
