<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Detail</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/order.css">
</head>
<body>
<div class="container">
    <h1>Order Detail</h1>

    <c:if test="${not empty order}">
        <div class="order-info">
            <p>
                Customer: <b>${order.customer.name}</b><br>
                Order ID: ${order.id}<br>
                Date: ${order.date}<br>
            </p>
        </div>

        <h2>Ordered Items</h2>
        <table>
            <thead>
            <tr>
                <th>No</th>
                <th>Item Type</th>
                <th>Item Name</th>
                <th>Quantity</th>
                <th>Unit Price ($)</th>
                <th>Amount ($)</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="detail" items="${order.detailOrder}" varStatus="status">
                <c:if test="${not empty detail.dishOrder}">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>Dish</td>
                        <td>${detail.dishOrder.dish.name}</td>
                        <td>${detail.quantity}</td>
                        <td class="money-column">
                            <fmt:formatNumber value="${detail.unitPrice}" type="number" minFractionDigits="2" maxFractionDigits="2"/>
                        </td>
                        <td class="money-column">
                            <fmt:formatNumber value="${detail.amount}" type="number" minFractionDigits="2" maxFractionDigits="2"/>
                        </td>
                    </tr>
                </c:if>

                <!-- Nếu có combo -->
                <c:if test="${not empty detail.comboOrder}">
                    <tr class="combo-header">
                        <td>${status.index + 1}</td>
                        <td>Combo</td>
                        <td>${detail.comboOrder.combo.name}</td>
                        <td>${detail.quantity}</td>
                        <td class="money-column">
                            <fmt:formatNumber value="${detail.unitPrice}" type="number" minFractionDigits="2" maxFractionDigits="2"/>
                        </td>
                        <td class="money-column">
                            <fmt:formatNumber value="${detail.amount}" type="number" minFractionDigits="2" maxFractionDigits="2"/>
                        </td>
                    </tr>
                    <c:forEach var="dishCombo" items="${detail.comboOrder.combo.dishCombos}">
                        <tr class="combo-item">
                            <td></td>
                            <td>-</td>
                            <td>${dishCombo.dish.name}</td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </c:forEach>
                </c:if>
            </c:forEach>

            <tr class="total-row">
                <td colspan="5" class="bold">Total Amount</td>
                <td class="bold money-column">
                    <fmt:formatNumber value="${order.totalAmount}" type="number" minFractionDigits="2" maxFractionDigits="2"/>
                </td>
            </tr>
            </tbody>
        </table>
    </c:if>

    <div class="button-group">
        <a href="javascript:history.back()" class="btn btn-back" style="display: inline-block; background-color: #6c757d; border: none; color: white; padding: 10px 20px; font-size: 15px; border-radius: 8px; cursor: pointer; margin: 10px; text-decoration: none;">Back</a>
        <form action="${pageContext.request.contextPath}/view/management/uiManagerHome.jsp" method="get">
            <button type="submit" class="btn btn-home">Home</button>
        </form>
    </div>
</div>
</body>
</html>
