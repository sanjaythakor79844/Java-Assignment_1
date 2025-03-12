package com.example.jobportal.servlet;//package com.example.jobportal.servlet;

import com.example.jobportal.dao.ApplicationDAO;
import com.example.jobportal.model.Application;
import com.example.jobportal.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.Paths;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,        // 10MB
        maxRequestSize = 1024 * 1024 * 50,       // 50MB
        location = "C:/Users/meet1/OneDrive/Desktop/studyCollege/Java/jobPortal/src/main/webapp/resumes"
)
public class ApplicationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int jobId = Integer.parseInt(request.getParameter("jobId"));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        int userId = user.getId();

        // Get the uploaded file
        Part filePart = request.getPart("resume");
        String resumePath = null;
        if (filePart != null && filePart.getSize() > 0) {
            // Extract file extension and generate a unique file name
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String fileExtension = fileName.substring(fileName.lastIndexOf("."));
            String newFileName = userId + "_" + System.currentTimeMillis() + fileExtension;

            // Write using only the relative file name
            filePart.write(newFileName);
            // Since the location is defined in @MultipartConfig, the file is saved there.
            resumePath = "resumes/" + newFileName;
        }

        // Create application object and save to DB
        Application application = new Application();
        application.setJobId(jobId);
        application.setUserId(userId);
        application.setApplicationDate(new Date());
        application.setResumePath(resumePath);

        ApplicationDAO appDAO = new ApplicationDAO();
        if (appDAO.applyForJob(application)) {
            response.sendRedirect("JobServlet");
        } else {
            request.setAttribute("errorMessage", "Application failed");
            request.getRequestDispatcher("applyJob.jsp").forward(request, response);
        }
    }
}

