<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@page import="java.util.List"%>

<jsp:include page="includes/header.jsp" />
<main>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</main>
<%@ include file="includes/footer.jsp"%>