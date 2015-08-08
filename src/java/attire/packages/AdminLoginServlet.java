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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Monal
 */
public class AdminLoginServlet extends HttpServlet{

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String adminEmail = request.getParameter("adminEmail");
        String adminPassword = request.getParameter("adminPassword");
        
        HttpSession session = request.getSession();
        String sessionID = session.getId();
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        Admin admin = new Admin(adminEmail, adminPassword);
        boolean check = admin.checkAdminLogin();
        
        if(check)
        {
            session.setAttribute("adminEmail", adminEmail);
            session.setAttribute("sessionId", sessionID);
            response.sendRedirect("adminHome.jsp");
            
        }
        else
        {
            out.println("<h3 align="+"center"+"> You are not logged in. </h3>");
        }
    }
    }
