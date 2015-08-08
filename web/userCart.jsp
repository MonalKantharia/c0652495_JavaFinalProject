
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="dbconn" class="attire.packages.DB_Connection" scope="session"/>

<%
    String loginId="";
    String productId="";
    
    int productCartQty=0;
    int cartId=0;
    
    String productName="";
    double pPrice=0.0;
    double productPrice=0.0;
    double totalPrice=0.0;
    
    if(session.getAttribute("loginId")!= null)
    {
        loginId = (String)session.getAttribute("loginId");
    }
    else
    {
        response.sendRedirect("index.jsp");
    }
    
    Connection connect = dbconn.getConnection();
    PreparedStatement prst = connect.prepareStatement("SELECT * FROM cart_items WHERE loginId=? AND purchased=?");
    prst.setString(1, loginId);
    prst.setString(2, "NO");
    
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> User Cart </title>
    </head>
    
    <body>
        <a href="index.jsp"> Go shopping </a> 
        <h1> Hello <%=loginId%>! </h1>
        
        <h3> Your cart </h3>
        
        <table border="1">
            <tr>
                <th colspan="2">
                    Product
                </th>
                
                <th>
                    Unit Price
                </th>
                
                <th>
                    Quantity
                </th>
                
                <th>
                    Total
                </th>
                
            </tr>
            
            <%
            ResultSet result = prst.executeQuery();
            
            while(result.next())
            {
                productId = result.getString("productId");
                productCartQty = result.getInt("productQty");
                cartId = result.getInt("cartItemsId");
                
                PreparedStatement prst1 = connect.prepareStatement("SELECT * FROM product WHERE productId=?");
                prst1.setString(1, productId);
                ResultSet result1 = prst1.executeQuery();
                while(result1.next()){
                    productName = result1.getString("productName");
                    productPrice = result1.getDouble("productPrice");
                    
                    productPrice = productCartQty * productPrice;
                    
                    totalPrice += productPrice;
            %>
            
            <tr>
                <td><img src="attireimage.jsp?productId=<%=productId%>" width="20" border="0"/></td>
                
                <td><%=productName%></td>
                <td>$ <%=productPrice%></td>
                <td><%=productCartQty%></td>
                <td>$ <%=productPrice%></td>
                <td>
                    <form name="deletecartitem" method="post" action="deleteitem">
                        <input type="hidden" value="<%=cartId%>" name="cartId"/>
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
            
            <%
                }
            }
            
            %>
            
            <tr>
                <td colspan="5" align="right">$ <%=totalPrice%></td>
            </tr>
        </table>
        
            
    </body>
</html>
