<%--
  Created by IntelliJ IDEA.
  User: kangeroo
  Date: 2018/8/13
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
</head>
<body>
<script type="text/javascript" >
    function validateNull(e){
        var flag = true;
        var value = e.value;
        if(value == "" ||value == null){
            alert("title is null!");
            flag = false;
        }
        return flag;
    };
</script>
<form action="${pageContext.request.contextPath}/add" method="post">
    <table>
        <tr>
            <td>title</td>
            <td><input type="text" name="title" id="i" value="titlename" onblur="if (!validateNull(i)) i.value='titlename' "></td>
        </tr>
        <tr>
            <td>description</td>
            <td><textarea name="description" style="width: 500px;height: 100px"></textarea></td>
        </tr>
        <tr>
            <td>language</td>
            <td><select name="language">
                <option value="1">English</option>
                <option value="2">Italian</option>
                <option value="3">Japanese</option>
                <option value="4">Mandarin</option>
                <option value="5">French</option>
                <option value="6">German</option>
            </select>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="add"></td>
        </tr>
    </table>
</form>
</body>
</html>
