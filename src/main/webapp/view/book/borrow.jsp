<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/19/2021
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Borrow Book</h1>
<div align="center">
    <form action="" method="post">
        <table>
            <caption>
                <h2>Borrow Book</h2>
            </caption>
            <tr>
                <th>Mã Mượn sách:</th>
                <td><input type="text" name="ms" value="${book.id}"  size="45"></td>
            </tr>
            <tr>
                <th>Tên sách:</th>
                <td><input type="text" value="${book.name}"  readonly size="45"></td>
            </tr>
            <tr>
                <th>Tên Học sinh:</th>
                <td>
                    <select name="name" id="">
                        <c:forEach items="${students}" var="student">
                            <option value="${student.id}">${student.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Ngày mượn:</th>
                <td><input type="text" name="borrowDay"  size="45"></td>
            </tr>
            <tr>
                <th>Ngày trả sách:</th>
                <td><input type="text" name="backDay"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Mượn">
                </td>

                <td><button><a href="/books">Hủy</a></button></td>
            </tr>
            
        </table>
    </form>
</div>
</body>
</html>
