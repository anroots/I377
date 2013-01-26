<%@ taglib tagdir="/WEB-INF/tags" prefix="pr"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<pr:MainTemplate>

	<h3>
		<spring:message code="nav.guardRanks" />
	</h3>

	<table class="table table-striped table-hover">
		<tbody>
			<tr>
				<th><spring:message code="Name" /></th>
				<th><spring:message code="Rank" /></th>
				<th><spring:message code="Start" /></th>
				<th><spring:message code="End" /></th>
				<sec:authorize access="hasAnyRole('ROLE_SUPERVISOR, ROLE_ADMIN')">
					<th></th>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<th></th>
				</sec:authorize>
			</tr>
			<c:forEach items="${guardRanks}" var="guardRank">
				<tr>
					<td><c:out value="${guardRank.getGuard().getFullName()}" /></td>
					<td><c:out value="${guardRank.getRank().getName() }" /></td>
					<td><c:out value="${guardRank.getStartAsString()}" /></td>
					<td><c:out value="${guardRank.getEndAsString()}" /></td>
					<sec:authorize access="hasAnyRole('ROLE_SUPERVISOR, ROLE_ADMIN')">
						<td><a
							href="<c:url value="/guardranks/edit?id=${guardRank.id}" ></c:url>">
								<spring:message code="Edit" />
						</a></td>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<td><a
							href="<c:url value="/guardranks/delete?id=${guardRank.id}"/>">
								<spring:message code="Delete" />
						</a></td>
					</sec:authorize>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<sec:authorize access="hasAnyRole('ROLE_SUPERVISOR, ROLE_ADMIN')">
		<a class="btn btn-primary" href="<c:url value="/guardranks/add"/>"><spring:message
				code="ranks.add" /></a>
	</sec:authorize>

</pr:MainTemplate>