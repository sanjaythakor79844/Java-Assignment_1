<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Job</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light d-flex justify-content-center align-items-center vh-100">
<div class="card shadow p-4" style="width: 500px;">
    <h2 class="text-center mb-4">Create a New Job</h2>
    <form method="post" action="JobServlet">
        <div class="mb-3">
            <label class="form-label">Title:</label>
            <input type="text" name="title" class="form-control" required/>
        </div>
        <div class="mb-3">
            <label class="form-label">Description:</label>
            <textarea name="description" class="form-control" required></textarea>
        </div>
        <div class="mb-3">
            <label class="form-label">Company:</label>
            <input type="text" name="company" class="form-control" required/>
        </div>
        <div class="text-center">
            <input type="submit" value="Create Job" class="btn btn-success w-100"/>
        </div>
    </form>
    <c:if test="${not empty errorMessage}">
        <p class="text-danger text-center mt-3">${errorMessage}</p>
    </c:if>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
