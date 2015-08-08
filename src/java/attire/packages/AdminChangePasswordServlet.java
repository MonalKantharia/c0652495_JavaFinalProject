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
public class AdminChangePasswordServlet extends HttpServlet {

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
        
        
        String adminEmail = request.getParameter("adminEmail");
        String adminPassword = request.getParameter("adminPassword");
        String newAdminPassword = request.getParameter("newAdminPassword");
        
        Admin admin = new Admin(adminEmail, adminPassword);
        
        boolean check = admin.changePassword(newAdminPassword);
        
        
        if(check)
        {
            out.println("Password Changed now!!");
            out.println("<a href=\"adminHome.jsp\"> Go Home </a>");
        }
        
        
        else
        {
            out.println("Password Not Changed!!");
            out.println("<a href=\"adminHome.jsp\"> Go Home </a>");
        }
    }
    }
