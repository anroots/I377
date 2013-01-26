<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<!-- START Of First Column -->
		<div class="span4">

			<div class="control-group">
				<form:label path="code">
					<spring:message code="guard.code" />
				</form:label>
				<div class="controls">
					<form:input path="code" />
					<form:errors path="code" element="p" cssClass="alert alert-error" />
				</div>
			</div>

			<div class="control-group">
				<form:label path="socialSecurityNumber">
					<spring:message code="guard.socialSecurityNumber" />
				</form:label>
				<div class="controls">
					<form:input path="socialSecurityNumber" />
					<form:errors path="socialSecurityNumber" element="p" 
					cssClass="alert alert-error" />
				</div>
			</div>

			<div class="control-group">
				<form:label path="firstName">
					<spring:message code="firstName" />
				</form:label>
				<div class="controls">
					<form:input path="firstName" />
					<form:errors path="firstName" element="p" cssClass="alert alert-error" />
				</div>
			</div>

			<div class="control-group">
				<form:label path="lastName">
					<spring:message code="lastName" />
				</form:label>
				<div class="controls">
					<form:input path="lastName" />
					<form:errors path="lastName" element="p" cssClass="alert alert-error" />
				</div>
			</div>

			<div class="control-group">
				<form:label path="gender">
					<spring:message code="guard.gender" />
				</form:label>
				<div class="controls">
					<form:select path="gender">
						<form:option value="M">
							<spring:message code="Male" />
						</form:option>
						<form:option value="F">
							<spring:message code="Female" />
						</form:option>
					</form:select>
					<form:errors path="gender" element="p" cssClass="alert alert-error" />
				</div>
			</div>

		</div>
		<!-- END Of First Column -->


		<!-- START Of Second Column -->
		<div class="span4">

			<div class="control-group">
				<form:label path="email">
					<spring:message code="Email" />
				</form:label>
				<div class="controls">
					<form:input path="email" />
					<form:errors path="email" element="p" cssClass="alert alert-error" />
				</div>
			</div>

			<div class="control-group">
				<form:label path="phone">
					<spring:message code="Phone" />
				</form:label>
				<div class="controls">
					<form:input path="phone" />
					<form:errors path="phone" element="p" cssClass="alert alert-error" />
				</div>
			</div>

			<div class="control-group">
				<form:label path="address">
					<spring:message code="Address" />
				</form:label>
				<div class="controls">
					<form:input path="address" />
					<form:errors path="address" element="p" cssClass="alert alert-error" />
				</div>
			</div>

			<div class="control-group">
				<form:label path="comment">
					<spring:message code="Comment" />
				</form:label>
				<div class="controls">
					<form:textarea path="comment" name="comment" cols="100"
						class="inpit-large" rows="3"></form:textarea>
						<form:errors path="comment" element="p" cssClass="alert alert-error" />
				</div>
			</div>


		</div>
		<!-- END Of Second Column -->
		<div class="clearfix"></div>