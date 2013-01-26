<%@ taglib tagdir="/WEB-INF/tags" prefix="pr"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<pr:PlainTemplate>
	<div class="hero-unit">
		<p class="alert alert-error">
			<spring:message code="login.accessDenied.h1" />
		</p>
	</div>
	
</pr:PlainTemplate>