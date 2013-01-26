<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib tagdir="/WEB-INF/tags/Forms" prefix="forms" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<tags:MainTemplate>

	<h3>
		<spring:message code="guards.add" />
	</h3>

	<form:form action="add" method="POST" modelAttribute="guard">

	<forms:Guard />


		<input type="submit" value="<spring:message code="Save" />"
			class="btn btn-primary" />
		<a class="btn" href="<c:url value="/guards/list"/>"><spring:message
				code="Cancel" /></a>

	</form:form>

</tags:MainTemplate>