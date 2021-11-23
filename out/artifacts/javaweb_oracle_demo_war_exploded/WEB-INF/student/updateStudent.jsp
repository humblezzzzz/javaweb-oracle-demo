<%@ page import="com.chen.web.entity.StudentEntity" %><%--
  @author:Chenchenx
  @Date: 2021/11/19
  @Time: 13:29
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生信息</title>
    <link rel="shortcut icon" href="#"/>
    <link rel="stylesheet" href="<% request.getContextPath();%>/resources/css/style.css">
    <link rel="stylesheet" href="<% request.getContextPath();%>/resources/css/index_work.css">
</head>
<style>
    #cont {
        text-align: center;
        margin-left: 250px;
        margin-top: 150px;
    }
    #cont div{
        padding: 20px;
    }
    label{
        color: white;
    }
</style>
<body>
<div>
    <jsp:include page="../top.jsp"/>
    <% StudentEntity studentEntity = (StudentEntity) request.getAttribute("student"); %>
    <div id="cont">
        <form method="post" action="/StudentServlet?type=updateStudent">
            <div>
                <label >
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;编号： <input type="text" name="id" readonly value="<%=studentEntity.getSdi()%>">
                </label>
            </div>
            <div>
                <label>
                    &nbsp;&nbsp;&nbsp;&nbsp;学生姓名： <input type="text" name="name" value="<%=studentEntity.getName()%>">
                </label>
            </div>
            <div>
                <label>
                    &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 学号： <input type="text" name="no" value="<%=studentEntity.getNo()%>">
                </label>
            </div>
            <div>
                <label>
                    生日： <input type="date" name="birthday" value="<%=studentEntity.getDate()%>">
                </label>
            </div>
            <div>
                <input type="submit" value="提交">
            </div>
        </form>
    </div>
    <jsp:include page="../bottom.jsp"/>
</div>

</body>
</html>
