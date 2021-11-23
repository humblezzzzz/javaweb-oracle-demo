package com.chen.web.servlet;

import com.chen.web.entity.StudentEntity;
import com.chen.web.service.StudentService;
import com.chen.web.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Chenchenx
 * @version v1.0
 * @date 2021/11/18 16:20
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String type = request.getParameter("type");
        if (type.equals("studentMes")) {
            StudentService studentService = new StudentServiceImpl();
            List<StudentEntity> list = studentService.studentList();
            request.setAttribute("studentList", list);
            request.getRequestDispatcher("/WEB-INF/student/student.jsp").forward(request, response);

        } else if (type.equals("deleteStudent")) {
            String id = request.getParameter("id");
            StudentServiceImpl studentService = new StudentServiceImpl();
            boolean b = studentService.deleteStudent(id);
            if (b) {
                request.getSession().setAttribute("msg", "删除成功");
                response.sendRedirect("/StudentServlet?type=studentMes");
            } else {
                request.getSession().setAttribute("msg", "删除失败");
                response.sendRedirect("/StudentServlet?type=studentMes");
            }
        } else if (type.equals("toAddStudent")) {
            request.getRequestDispatcher("/WEB-INF/student/addStudent.jsp").forward(request, response);
        } else if (type.equals("addStudent")) {
            String name = request.getParameter("name");
            String no = request.getParameter("no");
            String birthday = request.getParameter("birthday");
            Date date = null;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if(name.equals("")||no.equals("")||birthday==null||birthday.equals("")){
                request.getSession().setAttribute("message", "信息不能为空");
                response.sendRedirect("/StudentServlet?type=toAddStudent");
                return;
            }else {
                try {
                    date = simpleDateFormat.parse(birthday);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            StudentService studentService = new StudentServiceImpl();
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setName(name);
            studentEntity.setNo(no);
            studentEntity.setDate(date);
            boolean b = studentService.addStudent(studentEntity);
            if (b) {
                request.getSession().setAttribute("msg", "添加成功");
                response.sendRedirect("/StudentServlet?type=studentMes");
            } else {
                request.getSession().setAttribute("msg", "添加失败");
                response.sendRedirect("/StudentServlet?type=studentMes");
            }
        } else if (type.equals("GetStudentMes")) {
            String name = request.getParameter("name");
            StudentService studentService = new StudentServiceImpl();
            List<StudentEntity> list = studentService.getStudentList(name);
            request.setAttribute("studentList", list);
            request.getRequestDispatcher("/WEB-INF/student/student.jsp").forward(request, response);
        } else if (type.equals("toUpdateStudent")) {
            String id = request.getParameter("id");
            StudentService studentService = new StudentServiceImpl();
            StudentEntity studentEntity = studentService.getById(id);
            request.setAttribute("student",studentEntity);
            request.getRequestDispatcher("/WEB-INF/student/updateStudent.jsp").forward(request, response);
        } else if (type.equals("updateStudent")) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String no = request.getParameter("no");
            String birthday = request.getParameter("birthday");
            Date date = null;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
            try {
                date = simpleDateFormat.parse(birthday);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            StudentService studentService = new StudentServiceImpl();
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setSdi(Integer.valueOf(id));
            studentEntity.setName(name);
            studentEntity.setNo(no);
            studentEntity.setDate(date);
            boolean b = studentService.updateStudent(studentEntity);
            if(b){
                request.getSession().setAttribute("msg", "修改成功");
                response.sendRedirect("/StudentServlet?type=studentMes");
            }else{
                request.getSession().setAttribute("msg", "修改失败");
                response.sendRedirect("/StudentServlet?type=studentMes");
            }
        }
    }
}
