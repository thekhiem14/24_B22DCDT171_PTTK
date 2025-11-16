<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Statistics</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/customerStat.css">
</head>
<body>
<div class="container">
    <h1>Customer Statistics</h1>

    <form method="get" action="${pageContext.request.contextPath}/customer">
        <input type="hidden" name="action" value="stat">

        <input type="date" id="startDate" name="start"
               value="${sessionScope.startDate}" required>

        <input type="date" id="endDate" name="end"
               value="${sessionScope.endDate}" required>

        <button type="submit" class="btn btn-submit">View Statistics</button>
    </form>

    <c:if test="${not empty sessionScope.customerStats}">
        <c:set var="customerStats" value="${sessionScope.customerStats}" />
            <h2>Customer Statistics</h2>
            <table class="data-table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Phone number</th>
                    <th>Email</th>
                    <th>Total Revenue ($)</th>
                    <th>    Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="stat" items="${customerStats}">
                    <tr>
                        <td>${stat.id}</td>
                        <td>${stat.name}</td>
                        <td>${stat.phoneNumber}</td>
                        <td>${stat.email}</td>
                        <td><fmt:formatNumber value="${stat.totalRevenue}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2"/></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/invoice?action=expense&customerId=${stat.id}"
                               class="btn btn-edit">View Details</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
    </c:if>

    <a href="${pageContext.request.contextPath}/view/management/uiStatistic.jsp" class="btn btn-cancel">Back to Statistics</a>
</div>
</body>
</html>
