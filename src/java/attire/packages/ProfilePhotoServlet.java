/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attire.packages;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Monal
 */

@MultipartConfig(maxFileSize = 16177215) 

public class ProfilePhotoServlet extends HttpServlet {

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
        InputStream inputStream = null;
        
        Part filePart = request.getPart("userImage");
        
        if(filePart !=null){
            
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            
            inputStream = filePart.getInputStream();
        }
        
        User user = new User();
        
        boolean check = user.setUserImage(loginId, inputStream);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        if(check)
        {
            response.sendRedirect("userAccountSettings.jsp");
            out.println("<h3> Image Uploaded Successfully </h3>");
            out.println("<a href=\"UserAccountSettings.jsp\"> Manage Account </a>");
        }
        else
        {
            out.println("<h3> ERROR: Image Not Uploaded </h3>");
            out.println("<a href=\"userAccountSettings.jsp\"> Manage Account </a>");
        }
    }
    
}
