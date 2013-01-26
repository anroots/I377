<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib
	prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	
<c:set var="currentLocale" value="${pageContext.response.locale}" />

<!-- START Of Navbar -->
<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">

			<a class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a> <a class="brand" href="<c:url value="/"/>"> <img
				src="<c:url value="/img/logo.png" />" height="32" width="32"
				alt="logo" /> <spring:message code="template.title" /></a>
			<div class="nav-collapse collapse">

				<ul class="nav pull-right">
					<c:choose>
						<c:when test="${currentLocale == 'et' }">
							<li><a href="<c:url value="?siteLanguage=en" />"><i
									class="icon-flag"></i> EN</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="<c:url value="?siteLanguage=et" />"><i
									class="icon-flag"></i> ET</a></li>
						</c:otherwise>
					</c:choose>

					<sec:authorize access="isAuthenticated()">

						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="icon-user"></i> <sec:authentication
									property="principal.username" /> <b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
							<sec:authorize access="hasRole('ROLE_ADMIN')">
							<!-- <li><a href="<c:url value="/admin/resetDb"/>">
										<i class="icon-trash"></i> <spring:message code="nav.resetDb" />
								</a></li> -->
							</sec:authorize>
								<li><a href="<c:url value="/j_spring_security_logout"/>">
										<i class="icon-remove"></i> <spring:message code="nav.logout" />
								</a></li>
							</ul></li>
					</sec:authorize>
				</ul>
			</div>
		</div>
	</div>
</div>
<!-- END Of Navbar -->