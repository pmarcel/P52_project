<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<<<<<<< HEAD
	<jsp:include page="header.jsp" />
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
	        Catégorie : <select><option>COUCOU</option></select><br>
	        Description :<br><textarea rows="4" cols="50" name ="description"></textarea><br>
	        <input type="submit" value="Envoyer">
	    </form>
    </div>
	<jsp:include page="footer.jsp" />
=======
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload</title>
</head>
<body>
	<jsp:include page="header.jsp" />

<center>
    <h1>Upload</h1>
    <form method="post" action="UploadServlet"
        enctype="multipart/form-data">
        Choisisez un fichier a télécharger: <input type="file" name="file" size="60" /><br />
        Décrivez votre oeuvre <input type="text" name ="description"/>
        <br /> <input type="submit" value="Upload" />
    </form>
</center>
	<jsp:include page="footer.jsp" />

</body>

</html>
>>>>>>> origin/master
