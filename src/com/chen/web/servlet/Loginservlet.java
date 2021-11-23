package com.chen.web.servlet;

import com.chen.web.entity.AdminEntity;
import com.chen.web.service.AdminService;
import com.chen.web.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Chenchenx
 * @version 1.0
 * @date 2021/11/18 8:52
 */

@WebServlet("/LoginServlet")
public class Loginservlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        if (type == null) {
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
        } else if (type.equals("trueLogin")) {
            String userName = req.getParameter("username");
            String passWord = req.getParameter("password");
            if (userName == null || passWord == null || userName.trim().equals("") || passWord.trim().equals("")) {
                req.getSession().setAttribute("mes", "您的账号或密码不能为空！");
                resp.sendRedirect("/LoginServlet");
                return;
            }
            AdminService adminService = new AdminServiceImpl();
            AdminEntity adminEntity = adminService.getAdminByUserName(userName);

            if (adminEntity == null) {
                req.getSession().setAttribute("mes", "您的账号不存在!请重新输入...");
                resp.sendRedirect("/LoginServlet");
            } else {
                if (adminEntity.getPassword().equals(passWord)) {
                    resp.sendRedirect("/StudentServlet?type=studentMes");
                } else {
                    req.getSession().setAttribute("mes", "您的密码不正确!请重新输入...");
                    resp.sendRedirect("/LoginServlet");
                }
            }
        }
    }
}
