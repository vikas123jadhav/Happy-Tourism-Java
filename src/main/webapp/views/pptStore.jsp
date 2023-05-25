<!DOCTYPE html>
<%@ page language="java" isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html xmlns:c="http://www.w3.org/1999/XSL/Transform" xmlns:form="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="ISO-8859-1">
    <title> Store PPT   </title>


    <link href=" /../resources/css/button_style.css"   rel="stylesheet"/>
<style>
    table,td,tr{
        padding: 20px;
    }
</style>
</head>
<body  >

<h1 style="color:red;text-align:center"  > Upload PPT </h1>

    <form:form modelAttribute="pptAndVideoModel" enctype="multipart/form-data">
           <table align="center" bgcolor="cyan" border="0">
               <tr>
                   <td>Enter Subject :: </td>
                   <td><form:input path="subject"/></td>
               </tr>
               <tr>
                   <td>File Type :: </td>
                   <td><form:input path="type" value="ppt" readonly="true"/> </td>
               </tr>
               <tr>
                   <td>Select PPT :: </td>
                   <td><form:input type="file" path="path"/></td>
               </tr>
               <tr>
                   <td> <button type="reset"> Reset </button></td>
                   <td> <input type="submit" value="Upload"> </td>
               </tr>
           </table>


</form:form>

    <blink>
        <h4 Style="color:green;text-align:center"> ${pptFile}</h4><br>
        <h4 Style="color:green;text-align:center"> ${resultMsg}</h4>
        <h4 Style="color:red;text-align:center"> ${validPPTorNot}</h4>
    </blink>

 <center>
    <div style="float:center">

        <a href="classroom" ><button id="btn1">Change Role </button> </a> <br> <br>
        <a href="loginAsAdmin" ><button id="btn2">To Admin Login </button> </a><br> <br>
        <a href="toDashBoard" ><button id="btn3">Back </button> </a>


    </div>
 </center>

</body>
</html>
