<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Dish - Restaurant Management</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/dish.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <div class="container">
        <nav class="card">
            <h1>Restaurant Management</h1>
            <div class="actions">
                <a href="${pageContext.request.contextPath}/view/management/uiManagerDish.jsp" class="btn">Manage Dishes</a>
            </div>
        </nav>

        <div class="card">
            <h2>Add New Dish</h2>

            <% if (request.getAttribute("message") != null) { %>
                <div class="message <%= request.getAttribute("message").toString().contains("success") ? "message-success" : "message-error" %>">
                    <%= request.getAttribute("message") %>
                </div>
            <% } %>

            <form action="${pageContext.request.contextPath}/dish" method="post">
                <div class="form-group">
                    <label for="txtDish">Dish Name*</label>
                    <input type="text" id="txtDish" name="txtDish" required
                           placeholder="Enter dish name">
                </div>

                <div class="form-group">
                    <label for="description">Description</label>
                    <textarea id="description" name="description" rows="3"
                            placeholder="Enter dish description"></textarea>
                </div>

                <div class="form-group">
                    <label for="price">Price ($)*</label>
                    <input type="number" id="price" name="price" step="0.01" required
                           placeholder="Enter price">
                </div>

                <div class="form-group">
                    <label for="discount">Discount (%)</label>
                    <input type="number" id="discount" name="discount" step="0.01" min="0" max="100"
                           placeholder="0">
                </div>

                <input type="hidden" name="action" value="create">

                <div class="actions">
                    <button type="submit" class="btn btn-submit" style="font-family: inherit; font-size: 1rem;">Add Dish</button>                    <a href="${pageContext.request.contextPath}/view/management/uiManagerDish.jsp"
                       class="btn btn-cancel">Cancel</a>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
