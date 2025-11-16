package com.pttk.servlet;

import com.pttk.dao.DishDAO;
import com.pttk.model.Dish;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/dish")
public class DishServlet extends HttpServlet {

    private DishDAO dishDAO;

    @Override
    public void init() {
        dishDAO = new DishDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("txtDish");
        String description = request.getParameter("description");
        String priceStr = request.getParameter("price");
        String discountStr = request.getParameter("discount");
        if (description == null) {
            description = "";
        }

        float discount = 0.0f;
        if (discountStr != null && !discountStr.trim().isEmpty()) {
            try {
                discount = Float.parseFloat(discountStr);
            } catch (NumberFormatException e) {
                discount = 0.0f;
            }
        }

        if (dishDAO.isDishNameExists(name)) {
            request.setAttribute("message", "Eror: The name '" + name + "' existed.");

            request.setAttribute("name", name);
            request.setAttribute("description", description);
            request.setAttribute("price", priceStr);
            request.setAttribute("discount", discountStr);

            request.getRequestDispatcher("/view/management/uiAddDish.jsp").forward(request, response);
            return;
        }

        float price = 0.0f;
        try {
            price = Float.parseFloat(priceStr);
        } catch (NumberFormatException e) {
            request.setAttribute("message", "Eror: Price must be a number.");

            request.setAttribute("name", name);
            request.setAttribute("description", description);
            request.setAttribute("discount", 0);

            request.getRequestDispatcher("/view/management/uiAddDish.jsp").forward(request, response);
            return;
        }

        Dish dish = new Dish();
        dish.setName(name);
        dish.setDescription(description);
        dish.setPrice(price);
        dish.setDiscount(discount);

        boolean success = dishDAO.addDish(dish);

        if (success) {
            request.setAttribute("message", "Add dish successfully!");
        } else {
            request.setAttribute("message", "Add dish failed!");
        }
        RequestDispatcher rd = request.getRequestDispatcher("/view/management/uiAddDish.jsp");
        rd.forward(request, response);

    }
}