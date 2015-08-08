


<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%  boolean check = false;
    
    String loginId =null;
    String adminEmail =null;
    String productId="";
    String productName="";
    String productSummary="";
        
    Double productPrice=0.0;
    
    int productQty=0;
    
    if(session.getAttribute("loginId")!= null || session.getAttribute("adminEmail") != null)
    {
        check = true;
        loginId = (String)session.getAttribute("loginId");
        adminEmail = (String)session.getAttribute("adminEmail");
    }
    
    
    Class.forName("com.mysql.jdbc.Driver");
    
%>









<!---------------------------------------------------------------------------------------->


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">


<head>	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

	<title> Online Attire </title>

    <link rel="shortcut icon" href="images/favicon.ico" />
    <script src="js/jquery-1.4.1.min.js" type="text/javascript"></script>
    <script src="js/jquery.jcarousel.pack.js" type="text/javascript"></script>
    <script src="js/jquery-func.js" type="text/javascript"></script>

	<link href="style.css" rel="stylesheet" type="text/css" /><!--[if lte IE 7]>
	<style>
	.content { margin-right: -1px; } /* this 1px negative margin can be placed on any of the columns in this layout with the same corrective effect. */
	ul.nav a { zoom: 1; }  /* the zoom property gives IE the hasLayout trigger it needs to correct extra whiltespace between the links */
	</style>
	<![endif]-->
</head>

<body>

<div class="container">


  <div class="header">
  <a href="#"><img src="images/logo.png" alt="Insert Logo Here" name="Insert_logo" width="20%" height="100" id="Insert_logo" style="background-color: #8090AB; display:block;" /></a> 
   <!-- end .header --></div>
  
  
  
  <div class="sidebar1">
    <ul class="nav">
      <li><a href="">Home</a></li>
      <li><a href="contact.jsp">Contact Us</a></li>
      <%if(check){%>
        <li><a href="userAccountSettings.jsp">My Account</a></li>
      <%}%>
    </ul>
    <p> Search here:
    
    <%@include file="searchheader.jsp" %>
    </p>
    <p>&nbsp;</p>
    <!-- end .sidebar1 --></div>
    
    
    
  <div class="content">
  
  
  <table align="center" width="95%" border="0">
  	<tr>
    	<td>
		<img style="display:block;" width="100%" height="300px" src="images/filler1.jpg" />
		</td>
    </tr>
  </table>
  
  
  
	  
	  
	  
	  
  
  <!--insert content here-->
    
        <%
        int counter =0;
    
        
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/attiredb", "root", "");
    
        PreparedStatement prst = connect.prepareStatement("SELECT * FROM product");

        ResultSet result = prst.executeQuery();

        while(result.next())
        {   
        
        
            productId = result.getString("productId");
            productName = result.getString("productName");
            productPrice = result.getDouble("productPrice");
            productSummary = result.getString("productSummary");
            productQty = result.getInt("productQty");

        %>
        
        <div style="border: 1px solid black;"> 
        <table border="0" cellspacing="10">
            
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
                    <%
                    }
                    %>
                </td>
            </tr>
            
        </table></div>
        
            <br>
                
        <%
                    
        }
        %>
        
    <!--insert content here-->
    
    <!-- end .content --></div>
    
    
    
    
  <div class="sidebar2">
    <p>
    
            <%
    
        if(check)
        {
            if(loginId != null){
            %>
            <div align="center">
                Welcome, <%=loginId%>
                <img src="getuserimage.jsp?userId=<%=loginId%>" width="50" border="0"/>
            </div>
            
            <div align="center"><a href="userCart.jsp"> Your Cart </a></div>
            <div align="center"><a href="userAccountSettings.jsp"> Account Settings </a></div>
            <div align="center"><a href="logout.jsp"> Logout </a></div>
            <%
            }

            if(adminEmail != null)
            {
            %>
            
            <div align="center"> Welcome, <%=adminEmail%> </div>
            <div align="center"><a href="adminHome.jsp"> Admin Home </a></div>
            <div align="center"><a href="logout.jsp"> Logout </a></div>
            
            <%
            }
        }
        else{
            %>
            
            <div align="center"><a href="userLoginRegister.jsp"> Login/Register </a></div>
            <div align="center"><a href="adminLogin.jsp">Admin Login </a></div>
            
            <%
        }
        %>

        
    
    </p>
    <!-- end .sidebar2 --></div>
  
  
  
  <div class="footer">
    <p>Copyright @ Monal Kantharia. 2015</p>
    <!-- end .footer --></div>
  <!-- end .container --></div>
</body>
</html>













