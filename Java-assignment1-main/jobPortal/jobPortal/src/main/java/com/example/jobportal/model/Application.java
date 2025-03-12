package com.example.jobportal.model;

import java.util.Date;

public class Application {
    private int id;
    private int jobId;
    private int userId;
    private Date applicationDate;
    private String resumePath; // New field for resume

    public Application() {}

    public Application(int id, int jobId, int userId, Date applicationDate, String resumePath) {
        this.id = id;
        this.jobId = jobId;
        this.userId = userId;
        this.applicationDate = applicationDate;
        this.resumePath = resumePath;
    }

    // Getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getJobId() {
        return jobId;
    }
    public void setJobId(int jobId) {
        this.jobId = jobId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public Date getApplicationDate() {
        return applicationDate;
    }
    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }
    public String getResumePath() {
        return resumePath;
    }
    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }
}
