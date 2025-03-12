package com.example.jobportal.servlet;

import com.example.jobportal.dao.UserDAO;
import com.example.jobportal.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (!password.equals(confirmPassword)) {
            request.setAttribute("errorMessage", "Passwords do not match.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        UserDAO userDAO = new UserDAO();
        boolean success = userDAO.registerUser(user);

        if(success) {
            // After successful registration, redirect to login page
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("errorMessage", "Registration failed. Username might already exist.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
