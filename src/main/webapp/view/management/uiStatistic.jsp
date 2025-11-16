<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Statistics - Restaurant Management</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
</head>
<body>
    <div class="container">
        <nav class="card">
            <h1>Restaurant Management</h1>
            <div class="actions">
                <a href="${pageContext.request.contextPath}/view/management/uiManagerHome.jsp" class="btn">Dashboard</a>
            </div>
        </nav>

        <div class="card">
            <h2>Statistics Dashboard</h2>
            <div class="actions">
                <a href="${pageContext.request.contextPath}/view/management/uiCustomerStat.jsp"
                   class="btn btn-submit">Customer Statistics</a>
            </div>
        </div>
    </div>
</body>
</html>
