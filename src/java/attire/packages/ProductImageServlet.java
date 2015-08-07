/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attire.packages;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Monal
 */

@MultipartConfig(maxFileSize = 16177215) 

public class ProductImageServlet extends HttpServlet{

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
        
        InputStream inputStream = null;
        
        Part filePart = request.getPart("productImage");
        
        if(filePart !=null){
        
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            
            inputStream = filePart.getInputStream();
        }
        
        Products products = new Products(productId, inputStream);
        
        boolean check = products.uploadProductImage();
        
        
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        
        if(check)
        {
            out.println("<center>");
            out.println("<h3> SUCCESS: Product Image Uploaded. </h3>");
            out.println("<a href=\"manageProducts.jsp\"> Manage Products </a>");
            out.println("<a href=\"adminHome.jsp\"> Home </a>");
            out.println("</center>");
        }
        
        else
        {
            out.println("<center>");
            out.println("<h3> ERROR: Product Image Not Uploaded. Try Again </h3>");
            out.println("<a href=\"manageProducts.jsp\"> Manage Products </a>");
            out.println("<a href=\"adminHome.jsp\"> Home </a>");
            out.println("</center>");
        }
    }
       
}
