package com.geekbrains.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowProductsServlet", urlPatterns = "/show_products")
public class ShowProductsServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(BasicServlet.class);
    private List<Product> listOfProducts;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().printf("<html><body>");
        for (Product p : listOfProducts) {
            resp.getWriter().printf("<h2>" + p.toString() + "</h2>");
        }
        resp.getWriter().printf("</body></html>");
    }

    @Override
    public void destroy() {
        logger.debug("Destroy");
    }

    @Override
    public void init() throws ServletException {
        listOfProducts = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            listOfProducts.add(new Product(i, "Product" + i, BigDecimal.valueOf(Math.random() * 30).setScale(2,BigDecimal.ROUND_HALF_UP)));

        }


    }
}
