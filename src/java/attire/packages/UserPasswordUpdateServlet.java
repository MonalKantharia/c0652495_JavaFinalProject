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
public class UserPasswordUpdateServlet extends HttpServlet{

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
        String password = request.getParameter("userPassword");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        User user = new User();
        
        boolean check = user.updateUserPassword(loginId, password);
        
        if(check)
        {
            out.println("<h3> Password Updated </h3>");
            out.println("<a href=\"userAccountSettings.jsp\"> Account Settings </a>");
        }
        
        
        else
        {
            out.println("<h3> Password NOT Updated </h3>");
            out.println("<a href=\"userAccountSettings.jsp\"> Account Settings </a>");
        }
    }
    }
