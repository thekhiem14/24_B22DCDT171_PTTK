<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurant Management Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
    <div class="container">
        <nav class="card">
            <h1>Restaurant Management</h1>
        </nav>

        <div class="dashboard-grid">
            <div class="feature-card">
                <i class="fas fa-chart-line"></i>
                <h3>Statistics</h3>
                <p>View detailed reports and analytics</p>
                <a href="${pageContext.request.contextPath}/view/management/uiStatistic.jsp" class="btn btn-primary">View Stats</a>
            </div>

            <div class="feature-card">
                <i class="fas fa-utensils"></i>
                <h3>Manage Dishes</h3>
                <p>Add, edit, and manage menu items</p>
                <a href="${pageContext.request.contextPath}/view/management/uiManagerDish.jsp" class="btn btn-primary">Manage Dish</a>
            </div>
        </div>
    </div>
</body>
</html>
