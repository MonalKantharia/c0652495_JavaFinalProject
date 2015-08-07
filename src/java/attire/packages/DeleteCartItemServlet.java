/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attire.packages;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Monal
 */
public class DeleteCartItemServlet extends HttpServlet{

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int cartId = Integer.parseInt(request.getParameter("cartId"));
        
        Cart cart = new Cart();
        boolean check = cart.deleteCartItem(cartId);
        
        if(check)
        {
            response.sendRedirect("userCart.jsp");
        }
        
        else
        {
            response.sendRedirect("userCart.jsp");
        }
      }
  }
  