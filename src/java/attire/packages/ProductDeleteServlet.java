/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attire.packages;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Monal
 */
public class ProductDeleteServlet extends HttpServlet{

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
        
        String productName = request.getParameter("productName");
        
        boolean check = new Products().deleteProduct(productId, productName);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        if(check)
        {
            out.println("<h3 align=\"center\"> Product record found and deleted. </h3>");
            response.sendRedirect("manageProducts.jsp");
        }
        
        else
        {
            out.println("<h3 align=\"center\"> Product record not found. </h3>");
        }
    }
}
