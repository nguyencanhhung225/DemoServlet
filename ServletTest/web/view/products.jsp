<%-- 
    Document   : products
    Created on : May 19, 2017, 9:03:46 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List Product</h1>
        <a href="ProductController?action=insert">Add New</a>
        <table border="1" cellspacing="0" style="margin-top: 5px">
            <thead>
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>PRICE</th>
                <th>CATAGORY</th>
                <th>Action</th>
            </tr>
            </thead>
            
            <tbody>
            <c:forEach var="product" items="${msgListProduct}">
            <c:set var="category" value="${product.idCategory}"/>
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}$</td>
                <td>
                    <c:if test="${category == 1}">
                        <c:out value="Mobile"/>
                    </c:if>
                    
                    <c:if test="${category == 2}">
                        <c:out value="Laptop"/>
                    </c:if>
                </td>
                <td>
                    <a href="ProductController?action=edit&id=${product.id}" style="margin-right: 5px">Edit</a>|
                    <a href="ProductController?action=delete&id=${product.id}" style="margin-left: 5px">Delete</a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
            
        </table>
    </body>
</html>
