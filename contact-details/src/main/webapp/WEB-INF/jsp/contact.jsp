<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<form:form method="post" modelAttribute="contact">
		<form:hidden path="id" />
		<fieldset class="form-group">
			<form:label path="firstName">First Name</form:label>
			<form:input path="firstName" type="text" class="form-control"
				required="required" />
			<form:errors path="firstName" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="lastName">Last Name</form:label>
			<form:input path="lastName" type="text" class="form-control"
				required="required" />
			<form:errors path="lastName" cssClass="text-warning" />
		</fieldset>
		
		<fieldset class="form-group">
			<form:label path="email">Email</form:label>
			<form:input path="email" type="email" class="form-control"
				required="required" />
			<form:errors path="email" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="phone">Phone Number</form:label>
			<form:input path="phone" type="text" class="form-control"
				required="required" pattern="[0-9]{10}"/>
			<form:errors path="phone" cssClass="text-warning" />
		</fieldset>
		
<%-- 		<fieldset class="form-group">
			<form:label path="status">Status</form:label>
			<form:input path="status" type="text" class="form-control"
				required="required" />
			<form:errors path="status" cssClass="text-warning" />
		</fieldset> --%>
		<button type="submit" class="btn btn-success">Add</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf" %>