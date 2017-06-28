<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/27 0027
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改界面</title>

</head>
<body>
    <form action="alterone" method="post" enctype="multipart/form-data">
        编&nbsp&nbsp号&nbsp<input type="text" name="empid" value="${emps.empid}" readonly/><br>
        姓&nbsp&nbsp名&nbsp<input type="text" name="ename"/><br>
        入职日期&nbsp<input type="date" name="hiredate"/><br>
        照&nbsp&nbsp片&nbsp<input type="file" name="file"/><br>
        <input type="submit" value="保存">
    </form>
</body>
</html>
