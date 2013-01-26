<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib
	prefix="spring" uri="http://www.springframework.org/tags"%><%@ taglib
	prefix="sec" uri="http://www.springframework.org/security/tags"%><%@ taglib
	tagdir="/WEB-INF/tags" prefix="tags"%><!DOCTYPE html>
<html>
<head>
<title><spring:message code="template.title" /></title>
<link href="//bootswatch.com/simplex/bootstrap.min.css" rel="stylesheet" />
<link rel="icon" type="image/png"
	href="<c:url value="/img/favicon.ico" />" />
<link href="<c:url value="/css/datepicker.css" />" rel="stylesheet" />
<link href="<c:url value="/css/style.css" />" rel="stylesheet" />

<meta charset="UTF-8" />
</head>
<body>

	<tags:MainNav />

	<!-- Main Container -->
	<div class="container-fluid">
		<div class="row-fluid">

			<!-- START Of Main Nav -->
			<div class="span3">
				<tags:SideNav />
			</div>
			<!-- END Of Main Nav -->

			<!-- START Of Main Content -->
			<div class="span9" id="content-container">
				<jsp:doBody />
			</div>
			<!-- END Of Main Content -->

		</div>
	</div>

	<footer>
		<p class="help-block">
			<spring:message code="template.footer" />
		</p>
	</footer>
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
	<script type="text/javascript"
		src="<c:url value="/js/bootstrap-datepicker.js" />"></script>
	<script type="text/javascript" src="<c:url value="/js/common.js" />"></script>
	<script
		src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js"></script>
</body>
</html>