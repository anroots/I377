<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib
	prefix="spring" uri="http://www.springframework.org/tags"%><%@ taglib
	prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="isAuthenticated()">
	<div class="well sidebar-nav">

		<ul class="nav nav-list">


			<li><a href="<c:url value="/guards/list"/>"> <i
					class="icon-user"></i> <spring:message code="nav.guards" /></a></li>
			<li><a href="<c:url value="/ranktypes/list"/>"> <i
					class="icon-tasks"></i> <spring:message code="nav.rankTypes" /></a></li>
			<li><a href="<c:url value="/ranks/list"/>"><i
					class="icon-leaf"></i> <spring:message code="nav.ranks" /></a></li>
		</ul>
	</div>
</sec:authorize>