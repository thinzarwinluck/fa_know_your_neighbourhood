<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.assignment3.kyn_project.Store" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Store Locations</title>
    <!-- Enable Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div>
        <h1>List of Store Locations</h1>
    </div>
    <table class="table table-sm" border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Phone Number</th>
            <th>Store Location</th>
            <th>Action</th>
        </tr>

<%
ArrayList<Store> stores = (ArrayList<Store>) request.getAttribute("allStores");

for (Store store : stores) {
%>
<tr>
    <td><span><%= store.getId() %></span></td>
    <td><span><%= store.getName() %></span></td>
    <td><span><%= store.getPhoneNumber() %></span></td>
    <td>
        <%
        for (String location : store.getLocalities()) {
        %>
        <span><%= location %></span>
        <%
        }
        %>
    </td>
    <td>
   <a href="store-update?id=<%= store.getId() %>"><button type="button" class="btn btn-warning">Update</button></a>
    <a href="store-delete?id=<%= store.getId() %>"><button type="button" class="btn btn-danger">Delete</button></a>
    </td>
</tr>
<%
}
%>
    </table>
</body>
</html>
