<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>CRM</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>
<div id="wrapper">
<div id="header">
<h1>CRM | Customer RelationShip Management</h1>
</div>
</div>

<div id="container">
<dir id="content">
<input type="button" value="Add Customer" onclick="window.location.href='showAddForm'; return false;"
class="add-button"/>
<table>
<tr>
<th>First Name:</th>
<th>Last Name:</th>
<th>Email:</th>
<th>Action:</th>
</tr>
<c:forEach var="tempCustomer" items="${customers}">
<c:url var="updateLink" value="showUpdateForm">
<c:param name="customerId" value="${tempCustomer.id}" />
</c:url>

<c:url var="deleteLink" value="deleteCustomer">
<c:param name="customerId" value="${tempCustomer.id}" />
</c:url>
<tr>
<td>${tempCustomer.firstName}</td>
<td>${tempCustomer.lastName}</td>
<td>${tempCustomer.email}</td>
<td> <a href="${updateLink}"/>Update |<a href="${deleteLink}"
onclick="if(!(confirm('Are you want to delete this customer?'))) return false"/>Delete</td>
</tr>
</c:forEach>
</table>
</dir>
</div>
</body>
</html>