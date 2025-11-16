package com.pttk.servlet;

import com.pttk.model.CustomerStat;
import com.pttk.dao.CustomerStatDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {
    private CustomerStatDAO customerStatDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        customerStatDAO = new CustomerStatDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "list";

        if (action.equals("stat")) {
            showCustomerStat(request, response);
        } else {
            request.getRequestDispatcher("/view/management/uiCustomerStat.jsp").forward(request, response);
        }
    }

    private void showCustomerStat(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String start = request.getParameter("start");
        Date startDate = java.sql.Date.valueOf(start);
        String end = request.getParameter("end");
        Date endDate = java.sql.Date.valueOf(end);

        HttpSession session = request.getSession();

        if (startDate != null && endDate != null) {
            List<CustomerStat> stats = customerStatDAO.getCustomer(startDate, endDate);

            session.setAttribute("customerStats", stats);
            session.setAttribute("startDate", start);
            session.setAttribute("endDate", end);

            request.setAttribute("customerStats", stats);
            request.setAttribute("start", start);
            request.setAttribute("end", end);
        } else {
            request.setAttribute("customerStats", session.getAttribute("customerStats"));
            request.setAttribute("start", session.getAttribute("startDate"));
            request.setAttribute("end", session.getAttribute("endDate"));
        }

        request.getRequestDispatcher("/view/management/uiCustomerStat.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
