<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/27 0027
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新建界面</title>

    <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="js/jquery.validate.js"></script>
    <script type="text/javascript" src="js/layer/layer.js"></script>
    <script type="text/javascript">
        $().ready(function() {
            $("#a1").validate({
                rules: {
                    ename: {
                        required: true,
                        minlength: 2
                    }
                },
                messages: {
                    ename: "最小长度为2"
                }
            })
        })
        function f() {
            $.getJSON('/ssm/hello', function(data) {
                alert(data.ename + ":" + data.photo)
                $("#aa").val(data.ename)
            })
        }
    </script>
</head>
<body>
    <form id="a1" action="newone" method="post" enctype="multipart/form-data">
        编&nbsp&nbsp号&nbsp<input type="text" name="empid" value="${eid}" readonly/><br>
        姓&nbsp&nbsp名&nbsp<input type="text" name="ename"/><br>
        入职日期&nbsp<input type="date" name="hiredate"/><br>
        照&nbsp&nbsp片&nbsp<input type="file" name="file"/><br>
        <input type="submit" value="保存">
    </form>

</body>
</html>
