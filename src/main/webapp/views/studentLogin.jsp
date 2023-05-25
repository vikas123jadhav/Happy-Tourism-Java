<!DOCTYPE html>

<%@ page language="java" isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html xmlns:form="http://www.w3.org/1999/xhtml" xmlns="http://www.w3.org/1999/html" lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Admin Login</title>


    <link href=" /../resources/css/button_style.css"   rel="stylesheet"/>

    <link href="<c:url value="/../resources/css/adminLogin_style.css" />" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css"/>


</head>
<body  >

<center>
    <br>
    <h1 style="text-align:center"> Welcome to Visual Class-Room</h1>

    <blink>
            <h4 Style="color:green;text-align:center"> ${successCreation} </h4>
            <h4 Style="color:red;text-align:center"> ${resultLogin} </h4>
            <h4 style="color:red;text-align:center"> ${blockedAccount}</h4>

    </blink>


    <div class="container">
        <div class="main">

            <form:form modelAttribute="studentEntity">
                <h2  align="center" style="color:red" > Student Login </h2>
                <!--             <h2 align="center"> <img src="src/main/webapp/resources/css/adminLogo.jpg" class="logo" > </h2> -->

                <table cellspacing="2" align="center" cellpadding="8"   border="0"  >
                    <tr>
                        <td style="color:black ;">UserName  </td>
                        <td> <form:input path="username" class="tb"/></td>
                    </tr>

                    <tr>
                        <td style="color:black">Password  </td>
                        <td>
                            <form:input type="password" path="password" name="password" autocomplete="current-password" required="" id="id_password"/>
                            <i class="far fa-eye" id="togglePassword" style="margin-left: -30px; cursor: pointer; color:black"></i>
                        </td>
                    </tr>

                    <tr>
                        <td></td>

                        <td>
                            <input type="reset" value="Reset" class="btn" id="reset" />
                            <input type="submit" value="Login" name="login" class="btn" id="login"> </td>
                        </td>


                    </tr>

                </table>
            </form:form>
        </div>
    </div>


    <a href="classroom" ><button style="background-color:#29b6f6 ; width:100px ;">Change Role</button> </a>&nbsp;&nbsp;
    <a href="newStudentSignUp" ><button style="background-color:#29b6f6 ; width:100px ;">Sign Up</button> </a>



</center>

<script src="/../resources/js/hideShowPassword.js" rel="script"></script>

</body>
</html>