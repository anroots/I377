<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib tagdir="/WEB-INF/tags/Forms" prefix="forms"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<tags:MainTemplate>
	<h3>
		<c:out value="${guard.getFullName() }" />
	</h3>
	<form:form action="edit" method="POST" modelAttribute="guardRank">
		<forms:GuardRank />

		<input type="hidden" name="id" value="${guardRank.id }" />
		<input type="submit" value="<spring:message code="Save" />"
			class="btn btn-primary " />
		<a class="btn" href="<c:url value="/guardranks/list"/>"> <spring:message
				code="Cancel" /></a>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<a class="btn btn-danger"
				href="<c:url value="/guardranks/delete?id=${guardRank.id}"/>"><spring:message
					code="Delete" /></a>
		</sec:authorize>

	</form:form>

</tags:MainTemplate>