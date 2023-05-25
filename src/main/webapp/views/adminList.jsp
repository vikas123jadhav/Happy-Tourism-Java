<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<html  xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="ISO-8859-1">
    <title> Admin List</title>


    <link href=" /../resources/css/button_style.css"   rel="stylesheet"/>
    <!-- JQuery to provide plugins to change looks of table -->
    <link  href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>

    <script src="/../resources/js/tableUpdation.js" rel="script"></script>
<!--    <link href="<c:url value="/../resources/css/adminLogin_style.css" />" rel="stylesheet">-->


</head>
<body>
<h1 style="color:red;text-align:center" > Admin List</h1>

<c:choose>
    <c:when test="${!empty adminList}">
        <table  bgcolor="cyan" border="1" id="listTableCast">
            <thead style="color:maroon">
            <tr>
                <th>Sr no</th> <th>Admin Name</th> <th> Username</th> <th>Mobile No</th><th>Created Date</th> <th> Status</th><th>Action</th>
            </tr>
            </thead>

            <tbody>
                <c:forEach var="admin" items="${adminList}" varStatus="index">
                    <tr>
                        <td>${index.count}</td>
                        <td>${admin.name}</td>
                        <td>${admin.username}</td>
                        <td>${admin.mobileNo}</td>
                        <td>${admin.createdDate}</td>
                        <td>${admin.status}</td>
                        <td>
<!--                          <a href="editAdminById?aid=${admin.aid}">Edit</a>-->
                            <a href="deleteAdminById?aid=${admin.aid}" onclick="deleteConfirm()">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        <h1 style="color:red;text-align:center"> NO Admin Data Found</h1>
    </c:otherwise>
</c:choose>

    <p style="text-align:center">
        <h4 Style="color:green;text-align:center"></b> ${adminSucMsg}</h4>
        <h4 Style="color:red;text-align:center"> ${adminErrMsg}</h4>
    </p>

<br>
<br>
<br>
<p>
    <div style="text-align:center">
        <a href="classroom" ><button id="btn1">Change Role</button> </a>    <br> <br>
        <a href="loginAsAdmin" ><button id="btn2">To Admin Login</button> </button> </a> <br> <br>
        <a href="toDashBoard" ><button id="btn3"> Back</button> </a>
    </div>
</p>

</body>
</html>