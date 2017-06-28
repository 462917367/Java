<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/27 0027
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主界面</title>
</head>
<body>
    <form action="selectAll" method="post" enctype="multipart/form-data">
        <input type="text" name="info" placeholder="请输入查询的内容!"/>
        <a href="mainframe">查询</a>
    </form>
    <table border="1" width="600" cellspacing="1" cellpadding="1">
        <tr align="center">
            <th width="120">编号</th>
            <th width="120">姓名</th>
            <th width="120">入职时间</th>
            <th width="120">照片</th>
            <th width="120">操作</th>
        </tr>

        <c:forEach items="${emps}" var="emp">
            <tr>
                <td>${emp.empid}</td>
                <td>${emp.ename}</td>
                <td>${emp.hiredate}</td>
                <td><img src="toLookImage?eid=${emp.empid}" width="200px" height="100px"></td>
                <td width="100">
                    <a href="findById?empid=${emp.empid}">修改</a>
                    <a href="deleteone?empid=${emp.empid}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <a href="getId">新建</a>
</body>
</html>
