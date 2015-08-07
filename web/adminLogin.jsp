
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    
    Cookie[]  cookies = request.getCookies();
    String adminEmail="", adminPassword="";
    
    if(cookies !=null){
        
        for(Cookie cookie: cookies){
            
            if(cookie.getName().equals("cookieEmail"))
            {
                adminEmail=cookie.getValue();
            }
            if(cookie.getName().equals("cookiePassword"))
            {
                adminPassword=cookie.getValue();
            }
        }
    }
    
   
%>




<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Administrator Login </title>
    </head>
    
    <body>
        <form action="adminlogin" method="post">
            
            <table>
                <tr>
                    <td> Email </td>
                    <td><input type="email" name="adminEmail" required/></td>
                </tr>
                
                <tr>
                    <td> Password </td>
                    <td><input type="password" name="adminPassword" required/></td>
                </tr>
                
                <tr>
                    <td colspan="2" align="center"><input type="submit" name="signin" value="Sign In"></td>
                </tr>
                
            </table>
        </form>
    </body>
    
</html>
