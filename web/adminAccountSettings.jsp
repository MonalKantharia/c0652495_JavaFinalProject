
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String adminEmail=(String)session.getAttribute("adminEmail");
    
    if(session.getAttribute("adminEmail")==null){
        response.sendRedirect("adminLogin.jsp");
    }

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Admin Account Settings </title>
                <script type="text/javascript">
                    
            function passwordRematch(){
                
                var acceptColor = "#77cc77";
                var rejectColor = "#ff7777";
                
                var message = document.getElementById("confirmMessage");

                password1 = document.getElementById("newpass1");
                password2 = document.getElementById("newpass2");
                
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
                password1 = document.adminChangePasswordForm.newAdminPassword.value;
                password2 = document.userRegisterForm.adminRePassword.value;
                
                if( password1 === password2 )
                
                    return true;
                
                else
                {
                    document.getElementById("confirmMessage").innerHTML="Passwords Do Not Match!!";
                    return false;
                }
            }
            
        </script>
    </head>
    
    
    <body>
        <h2> Admin Account Settings </h2>
        <h3> Change Password </h3>
        <form action="adminPassChange" name="adminChangePasswordForm" method="post" onsubmit="return checkForSubmission()">
            
            <table>
                <tr>
                    <td>
                        <input type="hidden" name="adminEmail" value="<%=adminEmail%>" >
                    </td>
                </tr>
                
                <tr>
                    <td> Current Password </td>
                    <td>
                        <input type="password" name="adminPassword" id="currentpass" required/>
                    </td>
                </tr>
                
                <tr>
                    <td> New Password </td>
                    <td><input type="password" name="newAdminPassword" id="newpassword1" required/></td>
                </tr>
                
                <tr>
                    <td> Re-Enter Password </td>
                    <td>
                        <input type="password" name="adminRePassword" id="newpassword2"  onkeyup="passwordRematch(); return false;" required/>
                    </td>
                    
                    <td>
                        <span id="confirmMessage" class="confirmMessage"></span></td>
                </tr>
                
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Change Password"/>
                    </td>
                    
            </table>
        </form>
    </body>
</html>
