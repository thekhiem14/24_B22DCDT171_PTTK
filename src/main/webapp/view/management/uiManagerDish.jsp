<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage Dishes - Restaurant Management</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
            <div class="actions">
                <h2>Manage Dishes</h2>
                <a href="${pageContext.request.contextPath}/view/management/uiAddDish.jsp" class="btn btn-primary">Add New Dish</a>            </div>
        </div>
    </div>
</body>
</html>