<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Expense Details</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/expense.css">
</head>
<body>
<div class="container">
    <h1>Customer Expense Details</h1>

    <c:if test="${not empty invoices}">
        <div class="customer-info">
            <p><b>Expense Detail of Customer: ${invoices[0].customer.name}</b>
            </p>
            <p><b>Period:</b> ${sessionScope.startDate} – ${sessionScope.endDate}</p>
        </div>

        <table class="expense-table">
            <thead>
            <tr>
                <th>No</th>
                <th>Invoice ID</th>
                <th>Date</th>
                <th>Total Item</th>
                <th class="money-column">Total Amount ($)</th>
                <th class="action-column">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:set var="total" value="0"/>
            <c:forEach var="invoice" items="${invoices}" varStatus="loop">
                <tr>
                    <td>${loop.index + 1}</td>
                    <td>${invoice.id}</td>
                    <td>${invoice.date}</td>
                    <td class="money-column">
                        <fmt:formatNumber value="${invoice.totalItem}" type="number" groupingUsed="true" minFractionDigits="0" maxFractionDigits="0"/>                        <c:set var="total" value="${total + invoice.totalAmount}"/>
                    </td>
                    <td class="money-column">
                        <fmt:formatNumber value="${invoice.totalAmount}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2"/>                        <c:set var="total" value="${total + invoice.totalAmount}"/>
                    </td>
                    <td class="action-column">
                        <a href="${pageContext.request.contextPath}/order?invoiceId=${invoice.id}"
                           class="btn-view-detail">View Detail</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot>
            <tr>
                <td style="text-align:center;"
                    colspan="4" class="right"><b>Total Revenue</b></td>
                <td class="highlight money-column">${total}</td>
                <td class="action-column"></td>
            </tr>
            </tfoot>
        </table>
    </c:if>

    <a href="javascript:history.back()" class="btn btn-back" style="display: inline-block; background-color: #6c757d; border: none; color: white; padding: 10px 20px; font-size: 15px; border-radius: 8px; cursor: pointer; margin: 10px; text-decoration: none;">Back</a></div>
</body>
</html>