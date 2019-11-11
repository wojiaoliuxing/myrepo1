<%--
  Created by IntelliJ IDEA.
  User: MrLiu
  Date: 2019/11/9
  Time: 15:48
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
<div id="myVue">
<form action="${pageContext.request.contextPath}/bookBooking/test" method="post">
    图书编号<input type="number" name="bid" id="bid">
    读者编号<input type="number" name="rid" id="rid">
    <input type="submit" value="保存">
</form>
<a href="bookBooking/list">查询所有</a>
</div>
</body>
</html>
