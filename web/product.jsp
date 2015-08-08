
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String productId=null;
    
    if(request.getParameter("productId")!= null)
        productId = request.getParameter("productId");
    else
        response.sendRedirect("index.jsp");
    
    String productCompany=null;
    String productName=null;
    String productCategory=null;
    int productQty=0;
    double price=0.00;
    
    Class.forName("com.mysql.jdbc.Driver");
    
    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/attiredb", "root", "");
    
    PreparedStatement prst = connect.prepareStatement("SELECT * FROM product WHERE productId=?");
    prst.setString(1, productId);
    
    ResultSet result = prst.executeQuery();
    
    if(result.next()){
        productCompany = result.getString("productCompany");
        productName = result.getString("productName");
        productCategory = result.getString("productCategory");
        productQty = result.getInt("productQty");
        price = result.getDouble("productPrice");
    }
    
    String loginId=null;
    
    boolean check = false;
    
    if(session.getAttribute("loginId")!=null){
        loginId = (String)session.getAttribute("loginId");
        check = true;
    }
    
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Product Page </title>
    </head>
    
    <body>
        <%@include file="searchheader.jsp" %>
        <div align="right">
            <%
                if(!check){
            %>
            <a href="userLoginRegister.jsp"> Login/Register </a>
            <%
                }
                else{
            %>
            
            <div align="right">
                Welcome, <%=loginId%>
                <img src="getuserimage.jsp?userId=<%=loginId%>" width="50" border="0"/>
            </div>
            <div align="right"><a href="userCart.jsp"> Your Cart </a></div>
            <div align="right"><a href="userAccountSettings.jsp"> Account Settings </a></div>
            <div align="right"><a href="logout.jsp"> Logout </a></div>
            <%
                }
            %>
        </div>
        <h1>Product Page</h1>
        <div>
            <img src="attireimage.jsp?productId=<%=productId%>" width="115" border="0"/>
        </div>
        <div>
            Company: <%=productCompany%>
        </div>
        <div>
            Name: <%=productName%>
        </div>
        
        <div>
            Price: <%=price%>
        </div>
        
        <div>
            <%
                if(productQty>0){
            %>
             Available in Stock<br>
             <%
                if(loginId != null){
             %>
             
             <form action="addtocart" method="post" name="addtocartform">
                <input type="hidden" name="loginId" value="<%=loginId%>"/>
                <input type="hidden" name="productId" value="<%=productId%>"/>
                <input type="number" name="productQty" min="1" max="10" value="1"/>
                <input type="submit" name="addtocart" value="Add to Cart"/>
             </form>
                
             <%
                }
             %>
             
            <%
                }
                else{
            %>
            Sold Out.Not Available.
            <%
                
                }
            %>
        </div>
        
        <br><hr><br>
        
        <div>
            <%
            if(loginId != null){
            %>
            
            <form name="addreviewForm" action="review" method="post">
                <input type="hidden" name="loginId" value="<%=loginId%>"/>
                <input type="hidden" name="productId" value="<%=productId%>"/>
                <textarea name="review" style="resize:none" rows="5" cols="40"></textarea>
                <input type="submit" value="Add Review"/>
            </form>
            <%
            }
            %>
        </div>
        <div>
            <%
            
            String username=null;
            String review=null;
            
            String userId=null;
            
            
            PreparedStatement stRev = connect.prepareStatement("SELECT * FROM review WHERE productId=?");
            stRev.setString(1, productId);
            ResultSet rsRev = stRev.executeQuery();
            while(rsRev.next()){
                
                userId = rsRev.getString("userId");
                review = rsRev.getString("review");
                
                PreparedStatement stUser = connect.prepareStatement("SELECT * FROM userdetails WHERE userId=?");
                stUser.setString(1, userId);
                
                ResultSet rsUser = stUser.executeQuery();
                
                if(rsUser == null){
                    PreparedStatement stUser1 = connect.prepareStatement("SELECT * FROM userlogin WHERE userEmail=?");
                    stUser1.setString(1,userId);
                    ResultSet rsUser1 = stUser1.executeQuery();
                    
                    while(rsUser1.next()){
                        userId = rsUser1.getString("userId");
                        PreparedStatement stUser2 = connect.prepareStatement("SELECT * FROM userdetails WHERE userId=?");
                        stUser2.setString(1, userId);
                        ResultSet rsUser2 = stUser2.executeQuery();
                        
                        while(rsUser2.next()){
                            username = rsUser2.getString("userName");
            %>
                            <br><hr><br>    
                            <table>
                                <tr>
                                    <td><%=review%></td>
                                    <td><%=username%></td>
                                </tr>
                            </table>
            
            <%
                        }
                    }
                }
                
                else
                {
                    while(rsUser.next())
                    {
                        username = rsUser.getString("userName");
            %>
                    <br><hr><br>    
                            <table cellspacing="10" cellpadding="10w">
                                <tr>
                                    <td><%=review%></td>
                                    <td>-<%=username%></td>
                                </tr>
                            </table>
            <%
                    }
                }
            
            }
            %>
        </div>
        
    </body>
    
</html>
