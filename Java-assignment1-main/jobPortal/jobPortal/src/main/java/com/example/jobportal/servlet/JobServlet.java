package com.example.jobportal.servlet;

import com.example.jobportal.dao.JobDAO;
import com.example.jobportal.model.Job;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class JobServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JobDAO jobDAO = new JobDAO();
        request.setAttribute("jobs", jobDAO.getAllJobs());
        request.getRequestDispatcher("listJobs.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String company = request.getParameter("company");

        Job job = new Job();
        job.setTitle(title);
        job.setDescription(description);
        job.setCompany(company);

        JobDAO jobDAO = new JobDAO();
        if(jobDAO.addJob(job)) {
            response.sendRedirect("JobServlet");
        } else {
            request.setAttribute("errorMessage", "Job creation failed");
            request.getRequestDispatcher("createJob.jsp").forward(request, response);
        }
    }
}
