package com.pttk.servlet;

import com.pttk.dao.OrderDAO;
import com.pttk.model.Order;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    private OrderDAO orderDAO;

    public void init() {
        orderDAO = new OrderDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String invoiceId = request.getParameter("invoiceId");

        if (invoiceId != null) {
            Order order = orderDAO.getOrder(Integer.parseInt(invoiceId));

            request.setAttribute("order", order);
            request.getRequestDispatcher("/view/management/uiOrderDetail.jsp")
                    .forward(request, response);
        }
    }
}
