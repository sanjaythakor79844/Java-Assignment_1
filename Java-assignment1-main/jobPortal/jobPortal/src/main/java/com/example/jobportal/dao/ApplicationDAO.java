package com.example.jobportal.dao;

import com.example.jobportal.model.Application;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ApplicationDAO {
    public boolean applyForJob(Application application) {
        String sql = "INSERT INTO applications (job_id, user_id, application_date, resume_path) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, application.getJobId());
            stmt.setInt(2, application.getUserId());
            stmt.setDate(3, new java.sql.Date(application.getApplicationDate().getTime()));
            stmt.setString(4, application.getResumePath()); // Save resume path in DB
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}