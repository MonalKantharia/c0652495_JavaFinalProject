

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Add Products </title>
    </head>
    
    <body>
        
        <form name="addproducts" action="uploadproductdetails" method="post">
            <table>
                <tr>
                    <td> Product ID </td>
                    <td> <input type="text" name="productId" required/> </td>
                </tr>
                
                <tr>
                    <td> Product Company </td>
                    <td> <input type="text" name="productCompany" required/> </td>
                </tr>
                
                <tr>
                    <td> Product Name </td>
                    <td> <input type="text" name="productName" required/> </td>
                </tr>
                
                <tr>
                    <td> Product Category </td>
                    <td>
                    <select name="productCategory" required>
                        <option value="default"> Category </option>
                        <option value="jeans"> Jeans </option>
                        <option value="shirt"> Shirts </option>
                        <option value="tshirt"> T-Shirts </option>
                        <option value="shoes"> Shoes </option>
                        <option value="watch"> Watches </option>
                    </select>
                    </td>
                </tr>
                <tr>
                    <td> Summary </td>
                    <td><textarea rows="5" cols="25" style="resize: none;" name="productSummary"></textarea></td>
                </tr>
                
                <tr>
                    <td> Tags </td>
                    <td><input type="text" name="productTags" /></td>
                </tr>
                
                
                <tr>
                    <td> Quantity </td>
                    <td><input type="number" name="productQty" required/></td>
                </tr>
                 
                <tr>
                    <td>Price</td>
                    <td><input type="text" name="productPrice" required/></td>
                </tr>
                
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" name="submit" value="Next"/>
                    </td>
                </tr>
            </table>
        </form>
        
    </body>
</html>
