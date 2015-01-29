<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<jsp:include page="header.jsp" />
			<div id="slideshow"></div>
			<div id="pics_list">
			<c:forEach var="item" items="${pictures}">
				<div class="picblock"><img src="${item.link}"></div>
			</c:forEach> 
			</div>
	<jsp:include page="footer.jsp" />