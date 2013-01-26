<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="control-group">
	<form:label path="code">
		<spring:message code="Code" />
	</form:label>
	<div class="controls">
		<form:input path="code" />
		<form:errors path="code" element="p" cssClass="alert alert-error" />
	</div>
</div>

<div class="control-group">
	<form:label path="name">
		<spring:message code="Name" />
	</form:label>
	<div class="controls">
		<form:input path="name" />
		<form:errors path="name" element="p" cssClass="alert alert-error" />
	</div>
</div>

<div class="control-group">
	<form:label path="type">
		<spring:message code="rank.type" />
	</form:label>
	<div class="controls">
		<form:select path="type">
			  <form:options items="${rankTypes}" itemValue="id" itemLabel="name"/>
		</form:select>
		<form:errors path="type" element="p" cssClass="alert alert-error" />
	</div>
</div>