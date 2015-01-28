<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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