
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean class="attire.packages.DB_Connection" id="dbconn" scope="session"/>
<%
    String category = request.getParameter("productCategory");
    String searchKeyword = request.getParameter("searchKeyword");
    
    if(category==null && searchKeyword==null){
        response.sendRedirect("index.jsp");
    }
    
    
    Connection connect = dbconn.getConnection();
     
    
    
    
    
    PreparedStatement prst = connect.prepareStatement("SELECT * FROM product WHERE productName LIKE ? OR productTags LIKE ?");
    prst.setString(1, "%"+searchKeyword+"%");
    prst.setString(2, "%"+searchKeyword+"%");
     
            
    ResultSet result = prst.executeQuery();
    
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Search Results </title>
    </head>
    
    <body>
        <%@include file="searchheader.jsp" %>
        
        <%
            while(result.next()){
                String productId = result.getString("productId");
                String productName = result.getString("productName");
                double productPrice = result.getDouble("productPrice");
                String productSummary = result.getString("productSummary");
                int productQty = result.getInt("productQty");

        %>
        
        <div align="center">
        <table border="1">
            <tr>
                <td rowspan="3">
                    
                    <a href="product.jsp?productId=<%=productId%>">
                    <img src="attireimage.jsp?productId=<%=productId%>" width="115" border="0"/>
                    </a>
                    
                </td>
                
                <td colspan="2"><%=productName%></td>
            </tr>
            
            <tr>
                <td><%=productPrice%></td>
                <td>
                    <%
                    if(productQty>0){
                    %>
                    <a href="addToCart.jsp?productId=<%=productId%>"> Add to cart </a>
                    <%}
                    else{%>
                    
                    Sold Out
                    <%}%>
                </td>
            </tr>
            
            <tr>
                <td colspan="2"><%=productSummary%></td>
            </tr>
            
        </table>
        </div>
            <br>
        <%
        }
        %>
        
        
        
        
        
        
        
        <%if(category == "jeans" || category == "shirt" || category == "tshirt" || category == "shoes" || category == "watch"){
        PreparedStatement prst1 = connect.prepareStatement("SELECT * FROM product WHERE productCategory=?");
        prst1.setString(1, category);
        
        ResultSet result1 = prst1.executeQuery();
    
            while(result1.next()){
                String productId = result1.getString("productId");
                String productName = result1.getString("productName");
                double productPrice = result1.getDouble("productPrice");
                String productSummary = result1.getString("productSummary");
                int productQty = result1.getInt("productQty");

        %>
        
        <div align="center">
        <table border="1">
            <tr>
                <td rowspan="3">
                    
                    <a href="product.jsp?productId=<%=productId%>">
                    <img src="attireimage.jsp?productId=<%=productId%>" width="115" border="0"/>
                    </a>
                    
                </td>
                
                <td colspan="2"><%=productName%></td>
            </tr>
            
            <tr>
                <td><%=productPrice%></td>
                <td>
                    <%
                    if(productQty>0){
                    %>
                    <a href="addToCart.jsp?productId=<%=productId%>"> Add to cart </a>
                    <%}
                    else{%>
                    
                    Sold Out
                    <%}%>
                </td>
            </tr>
            
            <tr>
                <td colspan="2"><%=productSummary%></td>
            </tr>
            
        </table>
        </div>
            <br>
        <%
            }
        }
        %>
        
    </body>
</html>

