<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib
	prefix="spring" uri="http://www.springframework.org/tags"%><%@ taglib
	tagdir="/WEB-INF/tags" prefix="tags"%><!DOCTYPE html>
<html>
<head>
<title><spring:message code="template.title" /></title>
<link href="//bootswatch.com/simplex/bootstrap.min.css" rel="stylesheet" />
<link rel="icon" type="image/png"
	href="<c:url value="/img/favicon.ico" />" />
<link href="<c:url value="/css/style.css" />" rel="stylesheet" />

<meta charset="UTF-8" />
<style type="text/css">
body {
	padding-top: 20px;
	padding-bottom: 40px;
}

/* Custom container */
.container-narrow {
	margin: 0 auto;
	max-width: 700px;
}

.container-narrow>hr {
	margin: 30px 0;
}

/* Main marketing message and sign up button */
.jumbotron {
	margin: 60px 0;
	text-align: center;
}

.jumbotron h1 {
	font-size: 72px;
	line-height: 1;
}

.jumbotron .btn {
	font-size: 21px;
	padding: 14px 24px;
}
</style>
</head>
<body>

	<tags:MainNav />
	<!-- START Of Main Content -->
	<div class="container-narrow">
		<jsp:doBody />
	</div>

	<footer>
		<p class="help-block">
			<spring:message code="template.footer" />
		</p>
	</footer>
</body>
</html>