<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html  xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="ISO-8859-1">
    <title> PPT & Video List</title>


    <link href=" /../resources/css/button_style.css"   rel="stylesheet"/>

    <!-- JQuery to provide plugins to change looks of table -->
    <link  href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>

    <script src="/../resources/js/tableUpdation.js" rel="script"></script>

</head>
<body  >


<h1 style="color:red;text-align:center"  >  PPT & Video List</h1>

<c:choose>
    <c:when test="${!empty pptAndvideoLists}">
        <table   bgcolor="cyan" border="1" id="listTableCast">
            <thead style="color:maroon">
            <tr>
                <th>Sr no</th> <th>Subject</th> <th> Path</th> <th>Type</th><th>Created Date</th><th>Updated Date</th> <th> Status</th><th>Action</th>
            </tr>
            </thead>

            <tbody>
                <c:forEach var="pv" items="${pptAndvideoLists}" varStatus="index">
                    <tr>
                        <td>${index.count}</td>
                        <td>${pv.subject}</td>
                        <td>${pv.path}</td>
                        <td>${pv.type}</td>
                        <td>${pv.storedDate}</td>
                        <td>${pv.updatedDate}</td>
                        <td>${pv.status}</td>
                        <td>
                            <a href="editPptandVideoById?pid=${pv.pid} ">Edit</a>
                            <a href="deletePptORVideoById?pid=${pv.pid} " onclick="deleteConfirm()">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>


    </c:when>

    <c:otherwise>
        <h1 style="color:red;text-align:center"> NO Videos & PPT's Found</h1>
    </c:otherwise>
</c:choose>

<p style="text-align:center">
    <font color="green"></b> ${pptVideoSucMsg}</font>

    <font color="red"> ${pptVideoErrMsg}</font>
</p>


<br>
<br>
<br>

<blink>
    <h1 style="color:green;text-align:center"> ${resultInfo}</h1>
</blink>

<blink>
    <h4 Style="color:green;text-align:center"> ${editSucMsg} </h4><br>
    <h4 Style="color:red;text-align:center"> ${editErrMsg} </h4>
    <h4 Style="color:red;text-align:center"> ${validorNottt}</h4>
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