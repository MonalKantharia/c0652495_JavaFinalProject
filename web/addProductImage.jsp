
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String productId = (String)session.getAttribute("productId");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Add Products </title>
    </head>
    <body>
        
        
        <h3> Details added to the database. Add Image for the product identification. </h3>
        
        
        <form action="uploadProductImage" method="post" enctype="multipart/form-data">
           
            <table>
                <tr>
                    <td> Product ID </td>
                    <td><%=productId%><input type="hidden" name="productId" value="<%=productId%>" /></td>
                </tr>
                
                <tr>
                    <td> Product Image </td>
                    <td><input type="file" accept="image/*" name="productImage" size="34"/></td>
                </tr>
                
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" name="uploadImage" value="Upload"/>
                    </td>
                </tr>
                
            </table>
                
        </form>
                
                
    </body>
</html>
