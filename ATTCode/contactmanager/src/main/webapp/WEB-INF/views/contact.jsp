<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
	<title>Spring 3 MVC - Contact Manager</title>
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
	<script type="text/javascript" src="resources/myscript.js"></script>	
</head>
<body>

	<h2>Contact Manager</h2>

	<form:form id="form" action="add.html" method="post" modelAttribute="contact">

		<spring:bind path="*">
			<c:if test="${status.error}">
				<div id="message" class="error">Form has errors</div>
			</c:if>
		</spring:bind>
		<form:errors path="*" />
		
		<table>
			<tr>
				<td><form:label path="firstName">
						<spring:message code="label.firstname" /><form:errors path="firstName" />
					</form:label></td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">
						<spring:message code="label.lastname" /><form:errors path="lastName" />
					</form:label></td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td><form:label path="birthDate">
						<spring:message code="label.birthDate" /><form:errors path="birthDate" />
					</form:label></td>
				<td><form:input path="birthDate" /></td>
			</tr>
			<tr>
				<td><form:label path="ssNumber">
						<spring:message code="label.ssNumber" /><form:errors path="ssNumber" />
					</form:label></td>
				<td><form:input path="ssNumber" /></td>
			</tr>
			<tr>
				<td><form:label path="street">
						<spring:message code="label.street" /><form:errors path="street" />
					</form:label></td>
				<td><form:input path="street" /></td>
			</tr>
			<tr>
				<td><form:label path="city">
						<spring:message code="label.city" /><form:errors path="city" />
					</form:label></td>
				<td><form:input path="city" /></td>
			</tr>
			<tr>
				<td><form:label path="state">
						<spring:message code="label.state" /><form:errors path="state" />
					</form:label></td>
				<td><form:input path="state" /></td>
			</tr>
			<tr>
				<td><form:label path="zipCode">
						<spring:message code="label.zipCode" /><form:errors path="zipCode" />
					</form:label></td>
				<td><form:input path="zipCode" /></td>
			</tr>			

			<tr class="input_fields_wrap">
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message code="label.addcontact"/>" /></td>
			</tr>
		</table>
	</form:form>


	<h3>Contacts</h3>

	<c:if test="${!empty contacts}">
		<table class="data">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Birth Date</th>
				<th>SSN</th>
				<th>Street</th>
				<th>City</th>
				<th>State</th>
				<th>Zip</th>
				<th>&nbsp;</th>
			</tr>

			<c:forEach items="${contacts}" var="contact">

				<tr>
					<td>${contact.lastName},${contact.firstName}</td>
					<td>${contact.birthDate}</td>
					<td>${contact.ssNumber}</td>
					<td>${contact.ssNumber}</td>
					<td>${contact.street}</td>
					<td>${contact.state}</td>					
					<td>${contact.city}</td>
					<td>${contact.zipCode}</td>
					<td><a href="delete/${contact.id}">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>