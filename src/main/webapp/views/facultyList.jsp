<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<html  xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="ISO-8859-1">
    <title> Faculty List</title>

    <link href=" /../resources/css/button_style.css"   rel="stylesheet"/>
    <!-- JQuery to provide plugins to change looks of table -->
    <link  href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>

    <script src="/../resources/js/tableUpdation.js" rel="script"></script>


</head>
<body  >

<h1 style="color:red;text-align:center"  > Faculty List</h1>


<!--${facultyLists}-->

<c:choose>
    <c:when test="${!empty facultyLists}">
        <table   bgcolor="cyan" border="1" id="listTableCast">
            <thead style="color:maroon">
            <tr>
                <th>Sr no</th> <th>Faculty Name</th> <th> Username</th> <th>Subject</th> <th>Mobile No</th> <th>DeptNo</th><th>Created Date</th> <th> Status</th><th>Action</th>
            </tr>
            </thead>

            <tbody>
                <c:forEach var="fac" items="${facultyLists}" varStatus="index">
                    <tr>
                        <td>${index.count}</td>
                        <td>${fac.fname}</td>
                        <td>${fac.username}</td>
                        <td>${fac.subject}</td>
                        <td>${fac.mobileNo}</td>
                        <td>${fac.deptno}</td>
                        <td>${fac.createdDate}</td>
                        <td>${fac.status}</td>
                        <td>
                            <a href="editPptById?fid=${fac.fid} ">Edit</a>
                            <a href="deleteFacultyById?fid=${fac.fid} " onclick="deleteConfirm()">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>


    </c:when>

    <c:otherwise>
        <h1 style="color:red;text-align:center"> NO Faculty Data Found</h1>
    </c:otherwise>
</c:choose>

<p style="text-align:center">
    <font color="green"></b> ${facSucMsg}</font>

    <font color="red"> ${facErrMsg}</font>
</p>

<br>
<br>
<br>
<center>
    <div style="float:center">

        <a href="classroom" ><button id="btn1">Change Role</button></a> <br> <br>
        <a href="loginAsAdmin" ><button id="btn2">To Admin Login</button></a> <br> <br>
        <a href="toDashBoard" ><button id="btn3">Back </button></a>
    </div>
</center>


    </body>
    </html>