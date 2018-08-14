<%--
  Created by IntelliJ IDEA.
  User: kangeroo
  Date: 2018/8/13
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1 style="color:red" align="center">Login</h1>
<form action="${pageContext.request.contextPath}/login" method="post">
    <table style="align:center;float: left;margin-left: 44%">
        <tr>
            <td>name</td>
            <td><input type="text" name="name" /> </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="登录"></td>
        </tr>
    </table>
</form>
</body>
</html>
