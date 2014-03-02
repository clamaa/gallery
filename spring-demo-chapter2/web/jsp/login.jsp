<%--
  Created by IntelliJ IDEA.
  User: clamaa
  Date: 14-3-2
  Time: 下午4:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>BAOBAOTAO Login</title>
</head>
<body>
    <c:if test="${!empty error}">
        <font color="red"<c:out value="${error}"/> />
    </c:if>
    <form action="<c:url value="/loginCheck.html"/> " method="POST">
        User Name:
        <input type="text" name="userName">
        <br/>
        Password:
        <input type="password" name="password">
        <br/>
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
    </form>
</body>
</html>