<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MrLiu
  Date: 2019/11/9
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
<form action="">
<table class="table table-responsive table-striped">
    <thead>
    <tr>
        <td>id</td>
        <td>bid</td>
        <td>rid</td>
        <td>bookingTime</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pageInfo.list}" var="BookBooking" varStatus="status">
        <tr>
            <td>${BookBooking.id}</td>
            <td>${BookBooking.bid}</td>
            <td>${BookBooking.rid}</td>
            <td>${BookBooking.bookingTime}</td>
            <td><button id="dele" value="删除"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</form>
</body>
<script type="text/javascript">
    $("dele").click(function () {
        var rows =$("#list").datagrid("getSelections");


        $.messager.confirm("提示","确认删除数据吗?",function(value){
            if(value){
                var idStr = "";
//遍历数据
                $(rows).each(function(i){
                    idStr+=("id="+rows[i].id+"&");
                });
                idStr = idStr.substring(0,idStr.length-1);
//传递到后台
                $.post("custmer/delete.action",idStr,function(data){
                    if(data.success){
//刷新 datagrid
                        $("#list").datagrid("reload");
                        $.messager.alert("提示","删除成功","info");
                    }else{
                        $.messager.alert("提示","删除失败：
                        "+data.msg,"error");
                    }
                },"json");
            }
        });


</script>
</html>
