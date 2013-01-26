<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<!-- START Of First Column -->
		<div class="span4">

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
					<form:errors path="name" element="p" 
					cssClass="alert alert-error" />
				</div>
			</div>
		</div>
		<!-- END Of First Column -->


		<!-- START Of Second Column -->
		<div class="span4">

			<div class="control-group">
				<form:label path="comment">
					<spring:message code="Comment" />
				</form:label>
				<div class="controls">
					<form:textarea path="comment" name="comment" cols="100"
						class="inpit-large" rows="6"></form:textarea>
						<form:errors path="comment" element="p" cssClass="alert alert-error" />
				</div>
			</div>


		</div>
		<!-- END Of Second Column -->
		<div class="clearfix"></div>