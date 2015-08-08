
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    if(session.getAttribute("adminEmail")==null){
        response.sendRedirect("adminLogin.jsp");
    }
    
    String sessionID = (String)session.getAttribute("sessionId");
    
    String email = (String)session.getAttribute("adminEmail");

%>


<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Admin Home </title>
        
    </head>
    
    <body>
        <div align="right" ><a href="logout.jsp"> Logout </a></div>
        <h1> !!Welcome Administrator!! </h1>
        
        <table>
            <tr>
                <td><a href="manageProducts.jsp"> Manage Products </a></td>
            </tr>
            
            
            <tr>
                <td><a href="adminAccountSettings.jsp"> Account Settings </a></td>
            </tr>
            
            <tr>
                <td><a href="index.jsp"> Shop Now!! </a></td>
            </tr>
            
        </table>
        
    </body>
</html>
