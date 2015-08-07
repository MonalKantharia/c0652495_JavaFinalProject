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
public class UserLoginServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        
        String loginId = request.getParameter("loginId");
        String userPassword = request.getParameter("userPassword");
        
        User user = new User();
        boolean check = user.checkUserLogin(loginId, userPassword);
        
        
        
        if(check)
        {
            session.setAttribute("loginId", loginId);
            response.sendRedirect("index.jsp");
        }
        else
        {
            out.print("Login Failed");
        }
        
    }
    }
