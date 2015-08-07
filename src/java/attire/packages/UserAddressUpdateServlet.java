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
public class UserAddressUpdateServlet extends HttpServlet{

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String line1 = request.getParameter("line1");
        String line2 = request.getParameter("line2");
        
        if(line2==null)
        {
            line2="";
        }
        
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        
        
        String loginId = request.getParameter("loginId");
        String userAddress = line1+", "+line2+", "+city+", "+state+", "+country;
            
        User user = new User();
        
        boolean check = user.updateUserAddress(loginId, userAddress);
        
        if(check)
        {
            out.println("<h3> Address Updated </h3>");
            out.println("<a href=\"userAccountSettings.jsp\"> Account Settings </a>");
        }
        else
        {
            out.println("<h3> Address NOT Updated </h3>");
            out.println("<a href=\"userAccountSettings.jsp\"> Account Settings </a>");
        }
    }
    
}
