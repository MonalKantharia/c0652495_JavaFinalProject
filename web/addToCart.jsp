
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="attire.packages.DB_Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String loginId = null;
    String productId = request.getParameter("productId");
    int defaultProductQty = 1;
    
    int productQty=0;
    int newProductQty=0;
    
    
    if(session.getAttribute("loginId") == null){
        response.sendRedirect("userLoginRegister.jsp");
    }
    else{
        loginId = (String)session.getAttribute("loginId");
        
        DB_Connection db = new DB_Connection();
        Connection connect = db.getConnection();
        
        PreparedStatement st = connect.prepareStatement("INSERT INTO cart_items (loginId, productId, productQty, purchased) values(?,?,?,?)");
        st.setString(1, loginId);
        st.setString(2, productId);
        st.setInt(3, defaultProductQty);
        st.setString(4, "NO");
        
        int row = st.executeUpdate();
        if(row>0){
                
                PreparedStatement prst1 = connect.prepareStatement("SELECT productQty FROM product WHERE productId=?");
                prst1.setString(1, productId);
                ResultSet result = prst1.executeQuery();
                while(result.next()){
                    productQty = result.getInt("productQty");
                    
                    newProductQty = productQty - defaultProductQty;
                    
                    PreparedStatement prst2 = connect.prepareStatement("UPDATE product SET productQty=? WHERE productId=?");
                    prst2.setInt(1, newProductQty);
                    prst2.setString(2, productId);
                    
                    int row1 = prst2.executeUpdate();
                    if(row1>0)
                    {
                        out.print("Item added to cart");
                        response.sendRedirect("index.jsp"); 
                    }
                }
            
        }
        else
        {
            out.println("Item not added to cart");
            response.sendRedirect("index.jsp");

        }
    }
%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> AddToCart </title>
    </head>
    <body>
        <h2> Add to Cart </h2>
        <%=productId%>+<%=defaultProductQty%>
    </body>
    
</html>
