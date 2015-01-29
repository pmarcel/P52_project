<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<jsp:include page="header.jsp" />
			<div id="slideshow"></div>
			<div id="pics_list">
			<c:forEach var="item" items="${pictures}">
				<div class="picblock"><a href="basket?action=add&image=${item.id}"><img src="${item.link}" title ="${item.description}" alt="${item.name}" /></a></div>
			</c:forEach> 
			</div>
	<jsp:include page="footer.jsp" />