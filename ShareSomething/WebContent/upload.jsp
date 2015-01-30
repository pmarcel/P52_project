<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<jsp:include page="header.jsp" />
	
	<div id ="content">
	
		<style>
			#upload_form
			{
				color: white;
				margin-top: 1%;
				margin-bottom: 1%;
				text-align: center;
				width: auto;
				margin-left: 33%;
				margin-right: 33%;
			}
		</style>
		<div id="upload_form">
	    <h1>Upload</h1>
		    <form method="post" action="UploadServlet" enctype="multipart/form-data">
		        Fichier : <input type="file" name="file" size="60" /><br><br>
		        Catégorie : <select name="category">
		        <c:forEach var="item" items="${categories}">
					<option value="${item.id}">${item.name}</option>
				</c:forEach>
		        </select><br>
		        Description :<br><textarea rows="4" cols="50" name ="description"></textarea><br>
		        <input type="submit" value="Envoyer">
		    </form>
	    </div>
    </div>
	<jsp:include page="footer.jsp" />