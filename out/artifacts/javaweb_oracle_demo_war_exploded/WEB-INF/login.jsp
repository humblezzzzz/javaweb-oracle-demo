<%--
  @author:Chenchenx
  @Date: 2021/11/17
  @Time: 11:31
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/index_work.css">
    <style>
        #cont {
            text-align: center;
            margin-left: 240px;
            padding: 20px;
        }
    </style>
</head>
<body>
<jsp:include page="top.jsp"/>
<div id="cont" style="margin-top: 140px ">
    <h1 style="color: red">${mes}</h1>
    <form method="post" action="/LoginServlet?type=trueLogin">
        <div style="margin-top: 30px">
            <label style="color: white">
                用户名：&nbsp;
                <input type="text" name="username">
            </label>
        </div>

        <div style="margin-top: 30px">
            <label style="color: white">
                &nbsp; &nbsp;密码：&nbsp;
                <input type="password" name="password">
            </label>
        </div>

        <div style="margin-top:50px">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="submit" value="登录">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" value="清空" onclick="rform()">
        </div>
        <jsp:include page="bottom.jsp"/>
    </form>
</div>
</body>

<script>
    function rform() {
        document.forms[0].reset();
    }
</script>
<%request.getSession().setAttribute("mes",null);%>
</html>
