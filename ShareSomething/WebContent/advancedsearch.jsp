<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp" />
	<h3>Recherche avanc�e</h3>
	<form action="" method="post">
		<label>Mots-cl�s</label> <input type="text" name="login">
		<label>Description</label> <input type="text" name="password">
		<label>Auteur</label> <input type="text" name="auteur">
		<input type ="hidden" name ="action" value = "search"/>
		<input type="submit" value="Rechercher">
	</form>
	<jsp:include page="footer.jsp" />