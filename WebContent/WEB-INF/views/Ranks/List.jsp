<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<tags:MainTemplate>
	<h3>
		<spring:message code="nav.ranks" />
	</h3>

	<table class="table table-striped table-hover">
		<tr>
			<th><spring:message code="ID" /></th>
			<th><spring:message code="Code" /></th>
			<th><spring:message code="Name" /></th>
			<th><spring:message code="rank.type" /></th>
			<sec:authorize access="hasAnyRole('ROLE_SUPERVISOR, ROLE_ADMIN')">
				<th></th>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<th></th>
			</sec:authorize>
		</tr>
		<c:forEach items="${ranks}" var="rank">
			<tr>
				<td>${rank.id}</td>
				<td><c:out value="${rank.code}" /></td>
				<td><c:out value="${rank.name}" /></td>
				<td><c:out value="${rank.type.name }" /></td>
				<sec:authorize access="hasAnyRole('ROLE_SUPERVISOR, ROLE_ADMIN')">
					<td><a href="<c:url value="/ranks/edit?id=${rank.id}" />">
							<spring:message code="Edit" />
					</a></td>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<td><a href="<c:url value="/ranks/delete?id=${rank.id}"/>">
							<spring:message code="Delete" />
					</a></td>
				</sec:authorize>
			</tr>
		</c:forEach>
	</table>

	<sec:authorize access="hasAnyRole('ROLE_SUPERVISOR, ROLE_ADMIN')">
		<a class="btn btn-primary" href="<c:url value="/ranks/add"/>"><spring:message
				code="ranks.add" /></a>
	</sec:authorize>

</tags:MainTemplate>