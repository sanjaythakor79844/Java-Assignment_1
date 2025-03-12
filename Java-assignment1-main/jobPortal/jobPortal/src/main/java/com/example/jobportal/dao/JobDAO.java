package com.example.jobportal.dao;

import com.example.jobportal.model.Job;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JobDAO {
    public List<Job> getAllJobs() {
        List<Job> jobs = new ArrayList<>();
        String sql = "SELECT id, title, description, company FROM jobs";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Job job = new Job();
                job.setId(rs.getInt("id"));
                job.setTitle(rs.getString("title"));
                job.setDescription(rs.getString("description"));
                job.setCompany(rs.getString("company"));
                jobs.add(job);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return jobs;
    }

    public boolean addJob(Job job) {
        String sql = "INSERT INTO jobs (title, description, company) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, job.getTitle());
            stmt.setString(2, job.getDescription());
            stmt.setString(3, job.getCompany());
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
