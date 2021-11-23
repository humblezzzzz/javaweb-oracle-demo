<%--@author:Chenchenx--%>
<%--@Date: 2021/11/18--%>
<%--@Time: 16:15--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>学生添加</title>
  <link rel="shortcut icon" href="#"/>
  <link rel="stylesheet" href="<% request.getContextPath();%>/resources/css/style.css">
  <link rel="stylesheet" href="<% request.getContextPath();%>/resources/css/index_work.css">
  <style>
    #cont {
      text-align: center;
      margin-left: 250px;
      margin-top: 150px;
    }
    #cont div{
      padding: 20px;
    }
  </style>
</head>
<body>
<div>
  <jsp:include page="../top.jsp"/>
  <div id="cont">
    <h1 style="color: red">${message}</h1>
    <form method="post" action="/StudentServlet?type=addStudent">
      <div>
        <label style="color: white">
          学生姓名： <input type="text" name="name">
        </label>
      </div>
      <div>
        <label style="color: white">
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 学号： <input type="text" name="no">
        </label>
      </div>
      <div style="padding-right: 100px">
        <label style="color: white" >
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;生日： <input type="date" name="birthday">
        </label>
      </div>
      <div>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button" onclick="rform()" value="清除">
      </div>
    </form>
  </div>
  <jsp:include page="../bottom.jsp"/>
</div>
</body>
<script>
  function rform() {
    document.forms[0].reset();
  }
</script>
<%request.getSession().setAttribute("message", null);%>
</html>
