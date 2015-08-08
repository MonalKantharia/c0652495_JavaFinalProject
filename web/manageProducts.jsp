
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title> Manage Products </title>
        
        <script type="text/javascript">
            
        function confirmDelete(){
            var check = confirm("Do you want to delete this product?");
                
            if(check === true)
                {
                    return true;
                }
            else{
                    return false;
                }
            }
            
        </script>
        
    </head>
    
    <body>
        <h1> Manage Products </h1>
        
        <h3> Add Product: </h3>
        <a href="addProduct.jsp"> Add </a>
        
        
        <h3> View Product </h3>
        
        <table border="1" width="95%" align="center">
            
            <tr>
                <th> Image </th>
                <th> Name </th>
                <th> Company </th>
                <th> Product ID </th>
                <th> Quantity </th>
                <th> Category </th>
                <th> Summary </th>
                <th> Tags </th>
                <th> Price </th>
            </tr>
            
            <%  Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/attiredb", "root", "");
            PreparedStatement prst = connect.prepareStatement("select * from product");

            ResultSet result = prst.executeQuery();
            
            while(result.next())
            {

                String productId = result.getString("productId");
                String productName = result.getString("productName");
                String productCategory = result.getString("productCategory");
                String productSummary = result.getString("productSummary");
                String productTags = result.getString("productTags");
                int productQty = result.getInt("productQty");
                String productCompany = result.getString("productCompany");
                double price = result.getDouble("productPrice");
                
            %>
            
            <tr>
                <td><img src="attireimage.jsp?productId=<%=productId%>" width="115" border="0"/></td>
                <td><%=productName%></td>
                <td><%=productCompany%></td>
                <td><%=productId%></td>
                <td><%=productQty%></td>
                <td><%=productCategory%></td>
                <td><%=productSummary%></td>
                <td><%=productTags%></td>
                <td><%=price%></td>
                
                <td>
                    <form name="productdeleteform" action="deleteproduct" method="post" onsubmit="return confirmDelete()">
                        <input type="hidden" name="productId" value="<%=productId%>"/>
                        <input type="hidden" name="productName" value="<%=productName%>"/>
                        <input type="submit" name="delete" value="Delete"/>
                    </form>
                        
                </td>
            </tr>
            
            <%
                }
            %>
            
        </table>
        
        <h3> Update Product Image </h3>
        <form action="uploadProductImage" method="post" enctype="multipart/form-data">
            
            <table>
                <tr>
                    <td> Product Id </td>
                    <td>
                        <input type="text" name="productId"/>
                    </td>
                </tr>
                
                <tr>
                    <td> Image </td>
                    <td><input type="file" accept="image/*" name="productImage" size="43"/></td>
                </tr>
                
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" name="imageupdate" value="Update"/>
                    </td>
                </tr>
                
            </table>
        </form>
    </body>
    
    
</html>
