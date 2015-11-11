<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="url">${pageContext.request.requestURL}</c:set>
<base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/"/>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="resources/css/lib/bootstrap/bootstrap.css">
<!-- jQuery 2.1.4 -->
<script src="resources/js/lib/jquery/jquery-2.1.4.js"></script>
<!-- Bootstrap JavaScript -->
<script src="resources/js/lib/bootstrap/bootstrap.js"></script>
<!-- Body style for all pages -->
<link rel="stylesheet" href="resources/css/generic.css">
<!-- Basic script -->
<script src="resources/js/generic.js"></script>