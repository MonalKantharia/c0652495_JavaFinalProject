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
public class UserContactUpdateServlet extends HttpServlet{

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String countryCode = request.getParameter("countryCode");
        String contactNum = request.getParameter("contactNum");
        
        String loginId = request.getParameter("loginId");
        String userMob = countryCode+"-"+contactNum;
        
        User user = new User();
        
        boolean check = user.updateUserContact(userMob, loginId);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        if(check)
        {
            out.println("<h3> Contact Number Updated </h3>");
            out.println("<a href=\"userAccountSettings.jsp\"> Account Settings </a>");
        }
        else
        {
            out.println("<h3> Contact Number NOT Updated </h3>");
            out.println("<a href=\"userAccountSettings.jsp\"> Account Settings </a>");
        }
    }
    
}