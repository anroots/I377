<%@ taglib tagdir="/WEB-INF/tags" prefix="pr"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<pr:PlainTemplate>
	<div class="jumbotron">
		<h1>
			<spring:message code="welcome.h1" />
		</h1>
		<p class="lead">
			<spring:message code="welcome.lead" />
		</p>
		<a class="btn btn-large btn-primary" href="<c:url value="login" />">
		 <spring:message
				code="welcome.login" />
		</a>
	</div>
</pr:PlainTemplate>