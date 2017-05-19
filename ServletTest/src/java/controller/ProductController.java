package controller;

import entity.Product;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProductModel;

@WebServlet(name = "ProductController", urlPatterns = {"/ProductController"})
public class ProductController extends HttpServlet {

    ProductModel productModel;
    RequestDispatcher requestDispatcher = null;

    public ProductController() {
        productModel = new ProductModel();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            List<Product> listProduct = productModel.findAll();
            request.setAttribute("msgListProduct", listProduct);
            RequestDispatcher rd = request.getRequestDispatcher("view/products.jsp");
            rd.forward(request, response);
        }

        switch (action) {
            case "insert": {
                requestDispatcher = request.getRequestDispatcher("view/add-product.jsp");
                requestDispatcher.forward(request, response);
            }
            break;

            case "edit": {
                int id = Integer.parseInt(request.getParameter("id"));
                Product product = productModel.findById(id);
                request.setAttribute("msgProduct", product);
                requestDispatcher = request.getRequestDispatcher("view/edit-product.jsp");
                requestDispatcher.forward(request, response);
            }
            break;

            case "delete": {
                String id = request.getParameter("id");
                boolean result = productModel.delete(Integer.parseInt(id));
                response.sendRedirect("ProductController");
            }
            break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {
            case "insert": {
                String name = request.getParameter("name");
                int price = Integer.parseInt(request.getParameter("price"));
                int idCategory = Integer.parseInt(request.getParameter("category"));
                Product product = new Product(name, price, idCategory);
                boolean result = productModel.insert(product);
                response.sendRedirect("ProductController");
            }
            break;

            case "edit": {
                
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                int price = Integer.parseInt(request.getParameter("price"));
                int idCategory = Integer.parseInt(request.getParameter("category"));
                boolean result = productModel.update(new Product(id, name, price, idCategory));
                response.sendRedirect("ProductController");
            }
            break;
        }
    }

}
