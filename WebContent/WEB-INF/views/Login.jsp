<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<style type="text/css">
.form-signin {
	max-width: 300px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
</style>
<tags:PlainTemplate>

	<form name="f" action="j_spring_security_check" class="form-signin"
		method="POST">
		<h2 class="form-signin-heading">
			<spring:message code="login.h1" />
		</h2>

		<c:if test="${param.error == 'loginFailure' }">
			<p class="alert alert-error">
				<spring:message code="login.failure_error" />
			</p>
		</c:if>

		<input type="text" class="input-block-level" name="j_username"
			placeholder="<spring:message code="login.username" />" required autofocus/>
			 <input required
			type="password" class="input-block-level" name="j_password"
			placeholder="<spring:message code="login.password" />" /> <input
			type="submit" name="login" class="btn btn-large btn-primary"
			value="<spring:message code="login.login" />" />
	</form>

</tags:PlainTemplate>