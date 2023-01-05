<%@ page language="java" isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1 style="color:red;text-align:center" xmlns:form="http://www.w3.org/1999/xhtml"> Edit PPT <h1>

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
                   <td> <button type="reset"> Cancel </button></td>
                   <td> <input type="submit" value="Update"> </td>
               </tr>
           </table>


</form:form>

    <blink>
        <h4 Style="color:green;text-align:center"> ${editSucMsg} </h4><br>
        <h4 Style="color:red;text-align:center"> ${editErrMsg} </h4>
    </blink>

 <center>
    <div style="float:center">

        <a href="classroom" ><h4>Change Role</h4> </a>
        <a href="loginAsAdmin" ><h4>To Admin Login</h4> </a>
        <a href="showAllPpts" ><h4>Back </h4> </a>
    </div>
 </center>
