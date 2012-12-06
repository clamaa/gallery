<%--
  Created by IntelliJ IDEA.
  User: clamaa
  Date: 11/8/12
  Time: 12:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <form action="/gallery/login.do" method="POST">
      UserName:
      <input type="text" name="username"/>
      Password:
      <input type="password" name="password"/>
      <input type="submit" name="submit" value="Submit"/>
  </form>
  </body>
</html>