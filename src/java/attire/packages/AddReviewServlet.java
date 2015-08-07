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
public class AddReviewServlet extends HttpServlet{

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String loginId = request.getParameter("loginId");
        String productId = request.getParameter("productId");
        String review = request.getParameter("review");
        

        
        Review revw = new Review(productId, loginId, review);
        boolean check = revw.saveReview();
        
        if(check){
            response.sendRedirect("product.jsp?productId="+productId);
        }
        
        else{
            response.sendRedirect("product.jsp?productId="+productId);
        }
    }
    
}
