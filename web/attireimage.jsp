


<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="image" class="attire.packages.GetProductImage" scope="session"/>


<%  Class.forName("com.mysql.jdbc.Driver");
    
    String productId;
    Connection connect = null;        

    if(request.getParameter("productId") != null)
    {
        
        productId = request.getParameter("productId");
        
        try
        {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/attiredb", "root", "");
            
            byte[] imageData = image.getImage(connect, productId);
            
            
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