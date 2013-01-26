<%@ taglib tagdir="/WEB-INF/tags" prefix="pr"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<pr:MainTemplate>
	<div class="jumbotron">
		<h1>
			<spring:message code="template.title" />
		</h1>
		<p class="lead">
			<spring:message code="dash.lead" /> <a href="https://github.com/anroots/I377">GitHub</a>
		</p>

	</div>
</pr:MainTemplate>