<%--
  Created by IntelliJ IDEA.
  User: Vladimir
  Date: 023 23.12.20
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Save Customer</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">
    <title>Save Customer</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>
<div id="container">
    <h3>Save Customer</h3>
    <form:form action="saveCustomer" modelAttribute="customer" method="post">
        <form:hidden path="id"/>
        <table>
            <tbody>
            <tr>
                <td><label>First name: </label></td>
                <td><form:input path="firstName"/></td>
            </tr>
            <tr>
                <td><label>Last name: </label></td>
                <td><form:input path="lastName"/></td>
            </tr>
            <tr>
                <td><label>Email: </label></td>
                <td><form:input path="email"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"></td>
            </tr>
            </tbody>
        </table>
    </form:form>
    <p>
        <a href="${pageContext.request.contextPath}/customer/list">Back To List</a>
    </p>
</div>
</body>
</html>
