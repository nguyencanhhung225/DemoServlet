<%@page import="entity.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        <h1>Edit Product</h1>
        <form action="ProductController?action=edit" method="post">
            <table cellpadding="5">
                <input type="hidden" name="id" value="${msgProduct.id}" />
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" value="${msgProduct.name}" /></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="text" name="price" value="${msgProduct.price}" /></td>
                </tr>
                <tr>
                    <td>Category</td>
                    <td>
                        <select name="category">
                            <option value="1">Mobile</option>
                            <option value="2">Laptop</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
