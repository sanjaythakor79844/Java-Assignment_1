<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Job Listings</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
  <h2 class="text-center mb-4">Job Listings</h2>
  <div class="table-responsive">
    <table class="table table-bordered table-striped shadow-sm">
      <thead class="table-dark">
      <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Company</th>
        <th>Action</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="job" items="${jobs}">
        <tr>
          <td>${job.title}</td>
          <td>${job.description}</td>
          <td>${job.company}</td>
          <td>
            <!-- Updated Form with File Upload -->
            <form method="post" action="ApplicationServlet" enctype="multipart/form-data">
              <input type="hidden" name="jobId" value="${job.id}" />

              <div class="mb-2">
                <label class="form-label">Upload Resume (PDF only)</label>
                <input type="file" name="resume" class="form-control" accept=".pdf" required />
              </div>

              <button type="submit" class="btn btn-primary btn-sm w-100">Apply</button>
            </form>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
  <div class="text-center mt-4">
    <a href="createJob.jsp" class="btn btn-success">Create Job</a>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
