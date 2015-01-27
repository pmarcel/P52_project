<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<jsp:include page="header.jsp" />
	<h3>Connexion à votre compte</h3>
	<form action="" method="post">
		<label>Utilisateur</label> <input type="text" name="login"><br>
		<label>Mot de passe</label> <input type="password" name="password"><br>
		<input type ="hidden" name ="action" value = "subscribe"/>
		<input type="submit" value="connect">
	</form>
	<jsp:include page="footer.jsp" />
	</body>
</html>