<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div class="container">
		<table class="table table-striped">
			<caption>Your contacts are</caption>
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Phone Number</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${contacts}" var="contact">
					<tr>
						<td>${contact.firstName}</td>
						<td>${contact.lastName}</td>
						<td>${contact.email}</td>
						<td>${contact.phone}</td>
						<td>${contact.status}</td>
						<td><a type="button" class="btn btn-success"
							href="/update-contact/${contact.id}">Update</a></td>
						<c:choose>
						  <c:when test="${contact.status eq 'Active'}">
						      <td><a type="button" class="btn btn-warning" href="/delete-contact?id=${contact.id}">Delete</a></td>
						  </c:when>
						  <c:otherwise>
							<td></td>
						  </c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/add-contact">Add a Contact</a>
		</div>
	</div>
<%@ include file="common/footer.jspf" %>