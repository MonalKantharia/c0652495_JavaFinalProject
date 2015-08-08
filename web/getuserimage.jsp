


<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:useBean id="userimage" class="attire.packages.GetUserImage" scope="session"/>

<%  Class.forName("com.mysql.jdbc.Driver");
    
    String userId;
    
    Connection connect = null;        

    if(request.getParameter("userId") != null)
    
    {
        userId = request.getParameter("userId");
        
        try
        {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/attiredb", "root", "");
            
            byte[] imageData = userimage.getImage(connect, userId);
            
            response.setContentType("image/jpeg");
            OutputStream os = response.getOutputStream();
            os.write(imageData);
            
            os.flush();
            os.close();
        }
        
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        finally
        {
            connect.close();
        }
    }
%>