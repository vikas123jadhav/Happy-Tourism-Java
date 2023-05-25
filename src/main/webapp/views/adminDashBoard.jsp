<!DOCTYPE html>
<html xmlns:c="http://www.w3.org/1999/XSL/Transform" xmlns:form="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="ISO-8859-1">
    <title> Admin DashBord     </title>


    <link href=" /../resources/css/button_style.css"   rel="stylesheet"/>
    <style>
        table{
              border-collapse: separate;
              border-spacing: 0 1em;
        }
        .btnList{
              width:170px ;
              height:25px;
              font-size:13px;
              border: none;
        }
    </style>
</head>
<body  bgcolor="gray" >

<h1 STYLE="text-align:center; color:red"> Welcome to Admin Dashboard </h1>
<br><br>
<div >
    <div style="width: 50%; height: 400px; float: left;align-items: center;">
        <div style=" width: 330px;
    margin-top: 30px;
    float:outside ;
    padding: 20px 30px 25px;">

     <p style="text-align:center">
         <table align="center">
            <tr>
                <td>
                    <a href="./showAllAdmin" > <button class="btnList"> Show Admin List </button></a>
                </td>
            </tr>

            <tr>
                <td>
                    <a href="./showAllFaculties" > <button class="btnList"> Show Faculty List </button></a>
                </td>
            </tr>

            <tr>
                <td>
                    <a href="./showAllStudents" > <button class="btnList"> Show Student List </button></a>
                </td>
            </tr>

            <tr>
                <td>
                    <a href="./showAllPpts" > <button class="btnList"> Show PPT's List </button></a>
                </td>
            </tr>

            <tr>
                <td>
                    <a href="./showAllVideos" > <button class="btnList"> Show Video's List </button></a>
                </td>
            </tr>

            <tr>
                <td>
                    <a href="./showPptAndVideo" > <button class="btnList"> Show PPT's&Videos List </button></a>
                </td>
            </tr>
        </table>
     </p>
        </div>
    </div>

    <div style="width: 50%; height: 400px; float: right ;align-items: center;">
    <div style=" width: 330px;
    margin-top: 80px;
    float:outside ;
    padding: 20px 30px 25px;">
        <p style="text-align:center">

        <a href="./createAdmin" > <button class="btnList"> Create Admin Acc </button></a>
        <br> <br>
        <a href="./createFaculty" > <button class="btnList"> Create Faculty Acc </button></a>
        <br> <br>
        <a href="./storePpt" > <button class="btnList"> Store PPT </button></a>
        <br> <br>
        <a href="./storeVideo" > <button class="btnList"> Store Video </button></a>
        <br> <br>
        </p>
    </div>
    </div>

</div>

<br><br>
<p>
    <div style="text-align:center">
       <a href="classroom" ><button id="btn1" >Change Role</button> </a> <br><br>
       <a href="loginAsAdmin" ><button id="btn2" >To Admin Login </button> </a>
    </div>
</p>

</body>
</html>
