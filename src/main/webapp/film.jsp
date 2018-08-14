<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kangeroo
  Date: 2018/8/13
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>film</title>
</head>
<body>
<a href="add.jsp">add</a>
<br>
<table id="t_film" border="1px">
    <tr>
        <th>film_id</th>
        <th>title</th>
        <th>description</th>
        <th>language</th>
        <th>todo</th>
    </tr>
    <c:forEach items="${film_list}" var="film" varStatus="idx">
        <tr>
            <td>${film.film_id}</td>
            <td>${film.title}</td>
            <td>${film.description}</td>
            <td>${film.name}</td>
            <td><a href="update.jsp?filmid=${film.film_id}&title=${film.title}&description=${film.description}">update</a>
                <a href="delete?filmid=${film.film_id}" onclick="javascript:return confirm('确认删除吗？');">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<div class="gridItem" style="padding: 5px; width: 250px; float: left; text-align: left; height: 20px; font-size: 15px;" >
    共有 <span id="spanTotalInfor"></span> 条记录
    当前第<span id="spanPageNum"></span>页
    共<span id="spanTotalPage"></span>页
</div>
<div class="gridItem" style="margin-left:50px;  padding: 5px; width: 400px; float: left; text-align: center; height: 20px; vertical-align: middle; font-size: 15px;">
    <span id="spanFirst" >首页</span>
    <span id="spanPre">上一页</span>
    <span id="spanInput" style="margin: 0px; padding: 0px 0px 4px 0px; height:100%; ">
                第<input id="Text1" type="text" class="TextBox" onkeyup="changepage()"   style="height:20px; text-align: center;width:50px" />页
            </span>
    <span id="spanNext">下一页</span>
    <span  id="spanLast">尾页</span>
</div>

<script type="text/javascript">
    var theTable = document.getElementById("t_film");
    var txtValue = document.getElementById("Text1").value;
    function changepage() {
        var txtValue2 = document.getElementById("Text1").value;
        if (txtValue != txtValue2) {
            if (txtValue2 > pageCount()) {

            }
            else if (txtValue2 <= 0) {

            }
            else if (txtValue2 == 1) {
                first();
            }
            else if (txtValue2 == pageCount()) {
                last();
            }
            else {
                hideTable();
                page = txtValue2;
                pageNum2.value = page;

                currentRow = pageSize * page;
                maxRow = currentRow - pageSize;
                if (currentRow > numberRowsInTable) currentRow = numberRowsInTable;
                for (var i = maxRow; i < currentRow; i++) {
                    theTable.rows[i].style.display = '';
                }
                if (maxRow == 0) { preText(); firstText(); }
                showPage();
                nextLink();
                lastLink();
                preLink();
                firstLink();
            }

            txtValue = txtValue2;
        }
    }

</script>
<script type="text/javascript" src="Pagging.js"></script>
</body>
</html>
