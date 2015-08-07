/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attire.packages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Monal
 */
public class ProductInfoUPServlet extends HttpServlet {
    Connection connect;

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String productId = request.getParameter("productId");
        String productCompany = request.getParameter("productCompany");
        String productName = request.getParameter("productName");
        String productCategory = request.getParameter("productCategory");
        String productSummary = request.getParameter("productSummary");
        String productTags = request.getParameter("productTags");
        
            String productQt = request.getParameter("productQty");
            int productQty = Integer.parseInt(productQt);
            
            
            
        String price = request.getParameter("productPrice");
            double productPrice = Double.parseDouble(price);
        
        
        
        Products products = new Products(productId, productCompany, productName, productCategory, productSummary, productTags ,productQty, productPrice);
        
        boolean check = products.uploadProducts();
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession();
        
        if(check)
        {
            session.setAttribute("productId", productId);
            response.sendRedirect("addProductImage.jsp");
        }
        
        else
        {
            out.println("<center>");
            out.println("<h3> Product Not Uploaded. Try Again </h3>");
            out.println("<a href=\"manageProducts.jsp\"> Manage Products </a>");
            out.println("</center>");
        }
    }
}
