
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String loginId = (String)session.getAttribute("loginId");
    
%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> User Account Settings </title>
        
        <script type="text/javascript">
             function passwordRematch(){
                
        
                var acceptColor = "#77cc77";
                var rejectColor = "#ff7777";
                
                var message = document.getElementById("confirmMessage");

                password1 = document.getElementById("password1");
                password2 = document.getElementById("password2");
                
                if( password1.value === password2.value )
                {
                    password2.style.backgroundColor = acceptColor;
                    message.style.color = acceptColor;
                    message.innerHTML = "Passwords Match!!";
                }
                else
                {
                    password2.style.backgroundColor = rejectColor;
                    message.style.color = rejectColor;
                    message.innerHTML = "Passwords Do Not Match!!";
                }
            }
            
            function checkForSubmission()
            {
                password1 = document.updatepasswordForm.userPassword.value;
                password2 = document.updatepasswordForm.confirmuserPassword.value;
                
                if( password1 === password2 )
                {
                    return true;
                }
                else
                {
                    document.getElementById("confirmMessage").innerHTML="Passwords Do Not Match!";
                    return false;
                }
            }
            
        </script>
        
    </head>
    <body>
        <h1> User Account Settings </h1>
        
        <table>
            <tr>
                <td> Welcome <%=loginId%>!</td>
            </tr>
            <tr>
                <td><img src="getuserimage.jsp?userId=<%=loginId%>" width="70" border="0"/></td>
            </tr>
            
        </table>
        
        <h3> Change Image </h3>
        <form action="profilephoto" name="uploaduserimageForm" method="post" enctype="multipart/form-data">
            
            <table>
                <tr>
                    
                    <td colspan="2">
                        <input type="hidden" name="loginId" value="<%=loginId%>" />
                    </td>
                </tr>
                
                <tr>
                    <td> Choose Image </td>
                    <td>
                        <input type="file" accept="image/*" name="userImage" size="25"/>
                    </td>
                </tr>
                
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" name="uploadImage" value="Upload"/>
                    </td>
                </tr>
                
            </table>
        </form>
         
        <h3> Update Address </h3>
        <form action="updateuseraddress" name="updateaddressForm" method="post">
            <table>
                <tr>
                    
                    <td colspan="2">
                        <input type="hidden" name="loginId" value="<%=loginId%>" />
                    </td>
                </tr>
                
                <tr>
                    <td> Street Address Line1 </td>
                    <td>
                        <input type="text" name="line1" required/>
                    </td>
                </tr>
                <tr>
                    <td> Street Address Line2 </td>
                    <td>
                        <input type="text" name="line2" />
                    </td>
                </tr>
                
                <tr>
                    <td> City* </td>
                    <td>
                        <input type="text" name="city" required>
                    </td>
                </tr>
                
                <tr>
                    <td> State* </td>
                    <td>
                        <input type="text" name="state" required>
                    </td>
                </tr>
                
                <tr>
                    <td> Country* </td>
                    <td>
                        <input type="text" name="country" required>
                    </td>
                </tr>
                
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" name="updateAddress" value="Update"/>
                    </td>
                </tr>
                
            </table>
        </form>
                
                
        <h3> Update Contact Number </h3>
        <form action="updateusercontact" name="updatecontactForm" method="post">
            <table>
                <tr>
                    
                    <td colspan="2"><input type="hidden" name="loginId" value="<%=loginId%>" /></td>
                </tr>
                
                <tr>
                    <td> Contact Number </td>
                    <td>
                        <input type="text" name="countryCode" maxlength="3" size="3"/> - 
                        <input type="text" name="contactNum" maxlength="10" size="10"/>
                    </td>
                </tr>
                
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" name="updateContact" value="Update"/>
                    </td>
                </tr>
                
            </table>
        </form>
                
                
        <h3> Update Password </h3>
                
                
        <form action="updateUserPassword" name="updatepasswordForm" method="post" onsubmit="return checkForSubmission()">
            <table>
                <tr>
                    
                    <td colspan="2">
                        <input type="hidden" name="loginId" value="<%=loginId%>" />
                    </td>
                </tr>
                
                <tr>
                    <td> New Password </td>
                    <td>
                        <input type="password" name="userPassword" id="pass1"/>
                    </td>
                </tr>
                
                <tr>
                    <td> Confirm Password </td>
                    <td>
                        <input type="password" name="confirmuserPassword" id="pass2" onkeyup="passwordRematch(); return false;"/>
                        <span id="confirmMessage" class="confirmMessage">
                            
                        </span>
                    </td>
                    
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" name="updateAddress" value="Update"/>
                        
                    </td>
                </tr>
                
            </table>
                    
        </form>
        
        <a href="index.jsp"> Shop Now!! </a>
                
                
      
    </body>
</html>

