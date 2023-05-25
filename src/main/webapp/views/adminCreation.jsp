<!DOCTYPE html>
<%@ page language="java" isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html xmlns:form="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="ISO-8859-1">
    <title> Admin Creation     </title>
    <link href=" /../resources/css/button_style.css"   rel="stylesheet"/>
    <link href=" /../resources/css/admin_faculty_studentSignUp_creation.css"  rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css"/>


</head>
<body   bgcolor="#FFDEAD">

<h1 style="color:purple;text-align:center"  > Create Admin Account Here... ! </h1>
    <br>
    <br>

<form:form modelAttribute="admin">
     <table align="center"  border="0">

         <tr>
            <td>   Enter Name     :     </td>
<!--             <td style="width:50px"><input type="hidden"></td>-->
            <td> <form:input path="name"   required="true"    /></td>
          </tr>




         <tr>
             <td>   Enter User-Name   :  </td>
<!--             <td style="width:50px"><input type="hidden"></td>-->
             <td> <form:input path="username"   required="true" /></td>
         </tr>
         <tr>
             <td>  Enter MobileNo    :   </b> </td>
<!--             <td style="width:50px"><input type="hidden"></td>-->
             <td> <form:input path="mobileNo"  required="true"  /></td>
         </tr>
          <tr>
              <td>  Enter Password    :  </td>
<!--              <td style="width:50px"><input type="hidden"></td>-->
              <td>
                  <form:input type="password" path="password" name="password" autocomplete="current-password" required="" id="id_password"/>
                  <i class="far fa-eye" id="togglePassword" style="margin-left: -30px; cursor: pointer; color:black"></i>
              </td>
          </tr>
         <tr>
             <td>  Re-Enter Password   : </td>
<!--             <td style="width:50px"><input type="hidden"></td>-->
             <td> <input type="password" name="password2" autocomplete="current-password" required="" id="id_password2"/>
                 <i class="far fa-eye" id="togglePassword2" style="margin-left: -30px; cursor: pointer; color:black"></i>
             </td>
         </tr>

          <tr align="center">

              <td>              </td>
<!--              <td style="width:50px"><input type="hidden"></td>-->
              <td>
                    <button type="reset" class="btn"  id="reset"> Reset </button>
                     <input type="submit" value="Create"  id="signup" class="btn" >
              </td>
           </tr>

     </table>
</form:form>
<br>
    <br>


    <p>
        <h4 Style="color:red;text-align:center">${usernameResult} </h4>
        <h4 Style="color:red;text-align:center"> ${pwdCreation} </h4>
        <h4 Style="color:red;text-align:center"> ${failCreation} </h4>
         <h4 Style="color:green;text-align:center"> ${successCreation} </h4>
         <h4 Style="color:red;text-align:center"> ${userNameAlreadyExist} </h4>
    </p>



        <div style="text-align:center">

            <a href="classroom" ><button id="btn1">Change Role </button></a>  <br> <br>
            <a href="loginAsAdmin" ><button id="btn2">To Admin Login</button> </a>  <br> <br>
            <a href="toDashBoard" ><button id="btn3">Back</button> </a>
        </div>


<script src="/../resources/js/hideShowPassword.js" rel="script"></script>

</body>
</html>