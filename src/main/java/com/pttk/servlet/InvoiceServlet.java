package com.pttk.servlet;

import com.pttk.dao.InvoiceDAO;
import com.pttk.model.Invoice;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/invoice")
public class InvoiceServlet extends HttpServlet {
    private InvoiceDAO invoiceDAO;

    @Override
    public void init() {
        invoiceDAO = new InvoiceDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String sCustomerId = request.getParameter("customerId");

        try {
            int customerId = Integer.parseInt(sCustomerId);

            HttpSession session = request.getSession();

            String startStr = (String) session.getAttribute("startDate");
            String endStr = (String) session.getAttribute("endDate");

            Date startDate = Date.valueOf(startStr);
            Date endDate = Date.valueOf(endStr);

            List<Invoice> invoices = invoiceDAO.getExpense(customerId, startDate, endDate);

            request.setAttribute("invoices", invoices);

            request.getRequestDispatcher("/view/management/uiExpenseDetail.jsp")
                    .forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        doGet(req, resp);
    }
}
