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
public class AddtoCartServlet extends HttpServlet{

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginId=request.getParameter("loginId");
        String productId=request.getParameter("productId");
        
        int productQty;
        
        try{
            productQty= Integer.parseInt(request.getParameter("productQty"));
        }
        
        catch(Exception ex){
            productQty = 1;
        }
        
        Cart cart = new Cart(productId, loginId, productQty);
        
        boolean check = cart.addtoCart();
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        if(check){
            out.println("Item added to cart");
            out.println("<a href=\"index.jsp\"> Continue Shopping?? </a>");
        }
        
        
        else
        {
            out.println("Sorry! Item could not be added to cart!!");
            out.println("<a href=\"index.jsp\"> Continue Shopping?? </a>");
        }
    }
    
}

