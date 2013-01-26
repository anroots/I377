<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<tags:MainTemplate>
	<h3>
		<spring:message code="nav.rankTypes" />
	</h3>

	<table class="table table-striped table-hover">
		<tr>
			<th><spring:message code="ID" /></th>
			<th><spring:message code="Code" /></th>
			<th><spring:message code="Name" /></th>
			<sec:authorize access="hasAnyRole('ROLE_SUPERVISOR, ROLE_ADMIN')">
				<th></th>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<th></th>
			</sec:authorize>
		</tr>
		<c:forEach items="${rankTypes}" var="rankType">
			<tr>
				<td>${rankType.id}</td>
				<td><c:out value="${rankType.code}" /></td>
				<td><c:out value="${rankType.name}" /></td>
				<sec:authorize access="hasAnyRole('ROLE_SUPERVISOR, ROLE_ADMIN')">
					<td><a href="<c:url value="/ranktypes/edit?id=${rankType.id}" />">
							<spring:message code="Edit" />
					</a></td>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<td><a href="<c:url value="/ranktypes/delete?id=${rankType.id}"/>">
							<spring:message code="Delete" />
					</a></td>
				</sec:authorize>
			</tr>
		</c:forEach>
	</table>

	<sec:authorize access="hasAnyRole('ROLE_SUPERVISOR, ROLE_ADMIN')">
		<a class="btn btn-primary" href="<c:url value="/ranktypes/add"/>"><spring:message
				code="rankTypes.add" /></a>
	</sec:authorize>

</tags:MainTemplate>