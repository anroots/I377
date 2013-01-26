<%@ taglib tagdir="/WEB-INF/tags" prefix="pr"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<pr:MainTemplate>
	
		<h3>
			<spring:message code="nav.guards" />
		</h3>

		<table class="table table-striped table-hover">
		<tbody>
			<tr>
				<th><spring:message code="ID" /></th>
				<th><spring:message code="guard.code" /></th>
				<th><spring:message code="firstName" /></th>
				<th><spring:message code="lastName" /></th>
				<sec:authorize access="hasAnyRole('ROLE_SUPERVISOR, ROLE_ADMIN')">
				<th></th>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
				<th></th>
				</sec:authorize>
			</tr>
			<c:forEach items="${guards}" var="guard">
				<tr>
					<td>
					<c:out value="${guard.id}" />
					</td>
					<td><c:out value="${guard.code }" /></td>
					<td>
					<c:out value="${guard.firstName}" />
					</td>
					<td>
					<c:out value="${guard.lastName}" />
					</td>
						<sec:authorize access="hasAnyRole('ROLE_SUPERVISOR, ROLE_ADMIN')">
					<td>
							<a href="<c:url value="/guards/edit?id=${guard.id}" ></c:url>">
								<spring:message code="Edit" />
							</a>
					</td>
						</sec:authorize>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
					<td>
							<a href="<c:url value="/guards/delete?id=${guard.id}"/>">
								<spring:message code="Delete" />
							</a>
					</td>
					</sec:authorize>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
			<sec:authorize access="hasAnyRole('ROLE_SUPERVISOR, ROLE_ADMIN')">
				<a class="btn btn-primary" href="<c:url value="/guards/add"/>"><spring:message code="guards.add" /></a>
			</sec:authorize>
	
</pr:MainTemplate>