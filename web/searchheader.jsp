

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Search Header </title>
    </head>
    
    <body>
    <center>
        <form action="result.jsp" method="post" id="searchform">
        <table>
            <tr>
                <td>
                    <input type="text" name="searchKeyword" size="25"/>
                </td>
            </tr>
            
            <tr>
                <td>
                    <select name="productCategory" form="searchform">
                        <option value="default"> Category </option>
                        <option value="jeans"> Jeans </option>
                        <option value="shirt"> Shirt </option>
                        <option value="tshirt"> T_shirt </option>
                        <option value="shoes"> Shoes </option>
                        <option value="watch"> Watch </option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" name="search" value="Go"/>
                </td>
            </tr>
                
                
            </form>
                
            </tr>
        </table>
        </center>
    

</body>
</html>


