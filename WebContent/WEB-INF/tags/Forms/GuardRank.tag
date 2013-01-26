<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="span5">

	<div class="control-group">
		<form:label path="rank">
			<spring:message code="Rank" />
		</form:label>
		<div class="controls">
			<form:select path="rank">
				<form:options items="${ranks}" itemValue="id" itemLabel="name" />
			</form:select>
			<form:errors path="rank" element="p" cssClass="alert alert-error" />
		</div>
	</div>


<div class="control-group">
		<form:label path="guard">
			<spring:message code="Guard" />
		</form:label>
		<div class="controls">
			<form:select path="guard">
				<form:options items="${guards}" itemValue="id" itemLabel="fullName" />
			</form:select>
			<form:errors path="guard" element="p" cssClass="alert alert-error" />
		</div>
	</div>


</div>
<div class="span5">


	<div class="control-group">
		<form:label path="start">
			<spring:message code="Start" />
		</form:label>
		<div class="controls">
			<form:input path="start" cssClass="date input-medium"/>
			<form:errors path="start" element="p" cssClass="alert alert-error" />
		</div>
	</div>

	<div class="control-group">
		<form:label path="end">
			<spring:message code="End" />
		</form:label>
		<div class="controls">
			<form:input path="end"  cssClass="date input-medium"/>
			<form:errors path="end" element="p" cssClass="alert alert-error" />
		</div>
	</div>
</div>
<div class="clearfix"></div>

<div class="control-group">
	<form:label path="comment">
		<spring:message code="Comment" />
	</form:label>
	<div class="controls">
		<form:textarea path="comment" name="comment" cols="100"
			class="inpit-large" rows="4" cssClass="input-xxlarge"></form:textarea>
		<form:errors path="comment" element="p" cssClass="alert alert-error" />
	</div>
</div>