<%@ page import="java.util.List" %>
<%@ page import="com.chen.web.entity.StudentEntity" %><%--
  @author:Chenchenx
  @Date: 2021/11/18
  @Time: 16:15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <link rel="shortcut icon" href="#"/>
    <link rel="stylesheet" href="<% request.getContextPath();%>/resources/css/style.css">
    <link rel="stylesheet" href="<% request.getContextPath();%>/resources/css/index_work.css">
    <style>
        #cont {
            text-align: center;
            margin-left: 240px;
            padding: 20px;
        }

        a {
            color: white;
        }
        div {
            color: white;
        }
    </style>
</head>
<body>
<jsp:include page="../top.jsp"/>
<div id="cont">
    <div>
        <a href="#">学生管理</a>
        <a href="#">成绩管理</a>
    </div>
    <div>
        <form action="/StudentServlet?type=GetStudentMes" method="post">
            <div>姓名
                <input type="text" name="name" value="">
                <input type="submit" 查询>
            </div>
        </form>
        <a href="/StudentServlet?type=toAddStudent">学生添加</a>
        <h1 style="color: red">${msg}</h1>
        <table>
            <tr>
                <td>id</td>
                <td>姓名</td>
                <td>学号</td>
                <td>生日</td>
                <td>操作</td>
            </tr>
            <% List<StudentEntity> studentEntities = (List<StudentEntity>) request.getAttribute("studentList");
                for (StudentEntity i : studentEntities) {
                    StudentEntity studentEntity = i;
                    System.out.println(i);
            %>
            <%--            <%  List<StudentEntity> studentEntities = (List<StudentEntity>) request.getAttribute("studentList");--%>
            <%--                for (int i = 0; i < studentEntities.size(); i++) {--%>
            <%--                    System.out.println(studentEntities.size());--%>
            <%--                    StudentEntity studentEntity = studentEntities.get(i);--%>
            <%--            %>--%>
            <tr>
                <td><%=studentEntity.getSdi()%>
                </td>
                <td><%=studentEntity.getName()%>
                </td>
                <td><%=studentEntity.getNo()%>
                </td>
                <td><%=studentEntity.getDate()%>
                </td>
                <td><a style="color: red"
                       href="/StudentServlet?type=deleteStudent&id=<%=studentEntity.getSdi()%>">删除</a>
                    <a style="color: red"
                       href="/StudentServlet?type=toUpdateStudent&id=<%=studentEntity.getSdi()%>">修改</a>
                </td>
            </tr>
            <% } %>
        </table>
    </div>
</div>
<jsp:include page="../bottom.jsp"/>
<%request.getSession().setAttribute("msg", null);%>
</body>
</html>
