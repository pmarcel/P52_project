<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp" />
	<div id = "content">
		<h3>Recherche avanc�e</h3>
		<form action="advancedsearch" method="post">
			<label>Mot-cl�</label> <input type="text" name="keyword">
			<label>Auteur</label> <input type="text" name="author">
			<input type="submit" value="Rechercher">
		</form>
	</div>
<jsp:include page="footer.jsp" />