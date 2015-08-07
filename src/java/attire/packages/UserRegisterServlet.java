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
public class UserRegisterServlet extends HttpServlet{

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
        
        String userName = request.getParameter("userName");
        String userEmail = request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");
        String userId = request.getParameter("userId");
        
        User user = new User(userId, userEmail, userPassword, userName);
       
        boolean check = user.registerUser();
        
        if(check)
        {
            out.println("<h3> YOU ARE A USER NOW.</h3>");
            out.println("<a href=\"userLoginRegister.jsp\"> Go to Login Page </a>");
        }
        else
        {
            out.println("<h3> USER ALREADY EXISTS </h3>");
            out.println("<a href=\"userLoginRegister.jsp\"> Go to Registration Page </a>");
        
        }
    }
    }
