<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Apply for Job</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light d-flex justify-content-center align-items-center vh-100">
<div class="card shadow p-4" style="width: 400px;">
    <h2 class="text-center mb-4">Apply for Job</h2>
    <form method="post" action="ApplicationServlet" enctype="multipart/form-data">
        <input type="hidden" name="jobId" value="${param.jobId}" />

        <div class="mb-3">
            <label for="resume" class="form-label">Upload Resume (PDF only)</label>
            <input type="file" name="resume" id="resume" class="form-control" accept=".pdf" required />
        </div>

        <div class="text-center">
            <input type="submit" value="Apply" class="btn btn-primary w-100"/>
        </div>
    </form>
    <c:if test="${not empty errorMessage}">
        <p class="text-danger text-center mt-3">${errorMessage}</p>
    </c:if>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>