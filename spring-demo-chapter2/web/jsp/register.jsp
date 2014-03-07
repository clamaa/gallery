<%--
  Created by IntelliJ IDEA.
  User: mazhqa
  Date: 14-3-7
  Time: 上午11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>NEW USER</title>
</head>
<body>
    <form method="POST" action="<c:url value="/user.html"/> ">
        <table>
            <tr>
                <td>User Name:</td>
                <td><input type="text" name="userName"/> </td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td>User Real Name:</td>
                <td><input type="text" name="userRealName"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="submit"/></td>
            </tr>
        </table>
    </form>
</body>
</html>