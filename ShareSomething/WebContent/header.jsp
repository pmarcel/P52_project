<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<style>
			body {
				margin: 0;
				background-color: #222222;
				min-height: 100%;
			}
			#header1 {
				padding-top: 0.5%;
				padding-bottom: 0.5%;
				padding-left: 0.5%;
				background-color: #000000;
				width: 99.5%;
			}
			#header2 {
				padding-top: 0.5%;
				padding-bottom: 0.5%;
				padding-left: 0.5%;
				background-color: #111111;
				width: 99.5%;
			}
			#header1 a:link, a:hover, a:active, a:visited
			{
				color: white;
				text-shadow: #000000 1px 1px, #000000 -1px 1px, #000000 -1px -1px, #000000 1px -1px;
				text-decoration: none;
			}
			#header2 a:link, a:hover, a:active, a:visited
			{
				color: white;
				text-shadow: #000000 1px 1px, #000000 -1px 1px, #000000 -1px -1px, #000000 1px -1px;
				text-decoration: none;
			}
			#content
			{
				background-color: #222222;
				text-align: center;
				width: 100%;
			}
			#footer
			{
				margin-left: 30%;
				margin-right: 30%;
				height: 5%;
				-webkit-border-radius: 6px;
				-moz-border-radius: 6px;
				border-radius: 6px;
				text-align: center;
				background-color: #111111;
				color: #999999;
				padding-right: 0.5%;
				padding-left: 0.5%;
				padding-top: 0.5%;
				padding-bottom: 0.5%;
				
			}
			#footer span
			{
				color: #800;
				font-size: 1em;
				text-shadow: 1px 1px #000, -1px 1px #000, -1px -1px #000, 1px -1px #000;
			}
			
			#logo
			{
				display: inline-block;
				color: white;
				font-size: 2rem;
				width: auto;
				padding-right: 10px;
				border-right: 1px solid #333333;
			}
			#logo span
			{
				color: #880000;
				font-weight: bold;
				margin-right: 0.5%;
			}
			.menu_element span
			{
				color: #880000;
				font-weight: bold;
				font-size: 0.5em;
			}
			.menu_element
			{
				margin-left: 0.5%;
				display: inline-block;
				color: white;
				font-size: 1.2em;
				width: auto;
			}
			.fear
			{
				margin-left: 0.5%;
				display: inline-block;
				width: auto;
				height: 38px;
				float: right;
				margin-right: 1%;
			}
			#search
			{
				display: inline-block;
				color: white;
				font-size: 1em;
				width: auto;
				float: right;
				margin-right: 1%;
				margin-top: 0.5%;
			}
			#login
			{
				display: inline-block;
				color: white;
				font-size: 1em;
				width: auto;
				float: right;
				margin-right: 1%;
			}
			#slideshow
			{
				width: 34%;
				background-color: #555555;
				height: 250px;
				margin-left: 33%;
				margin-right: 33%;
				margin-top: 1%;
				margin-bottom: 1%;
				border: 4px double;
			}
			#pics_list
			{
				margin-top: 1%;
				margin-bottom: 1%;
				text-align: center;
			}
			.picblock
			{
				height: 175px;
				width: 175px;
				background-color: grey;
				border: 1px solid black;
				display: inline-block;
				margin-left: 1%;
				margin-right: 1%;
				margin-top: 1%;
			}
			.picblock img
			{
				width: 100%;
				height: 100%;
			}
			h2{
				color: white;
				font-weight: 1.8em;
			}
			#header1 u
			{
				text-decoration: underline;
				color: #AAAAAA;
			}
			#search_input
			{
				background-color: #777777;
				color: #000000;
				border-color: #333333;
			}
			#footer p
			{
				margin: 0;
			}
			#popup{
				float: center;
			}
			.popup-ok {
				display: block;
				position: absolute;
				top: 15%;
				left: 88%;
				width: 10%;
				height: 3%;
				padding-bottom: 16px;
				border: 1px solid black;
				background-color: #AAAAAA;
				overflow: auto;
				-webkit-border-radius: 4px;
				-moz-border-radius: 4px;
				border-radius: 4px;
				color: #FFF;
				background: linear-gradient(#006600, #002200) repeat scroll 0% 0% transparent;
				border-radius: 10px;
			}
			.popup-error {
				display: block;
				position: absolute;
				top: 15%;
				left: 75%;
				width: 10%;
				height: 3%;
				padding-bottom: 16px;
				border: 1px solid black;
				background-color: #FF5757;
				overflow: auto;
				-webkit-border-radius: 4px;
				-moz-border-radius: 4px;
				border-radius: 4px;
				color: #FFF;
				background: linear-gradient(#660000, #220000) repeat scroll 0% 0% transparent;
				border-radius: 10px;
			}
			.popup-default {
				display: block;
				position: absolute;
				top: 12%;
				left: 88%;
				width: 10%;
				height: 3%;
				padding-bottom: 16px;
				border: 1px solid black;
				background-color: #AAAAAA;
				overflow: auto;
				-webkit-border-radius: 4px;
				-moz-border-radius: 4px;
				border-radius: 4px;
				color: #FFF;
				background: linear-gradient(#000066, #000022) repeat scroll 0% 0% transparent;
				border-radius: 10px;
			}
		</style>
		
<style>
#menu-accordeon {
  padding:0;
  margin:0;
  margin-top: -1.3%;
  list-style:none;
  text-align: center;
  width: 180px;
  display: block;
position: absolute;
}
#menu-accordeon ul {
  padding:0;
  margin:0;
  list-style:none;
  text-align: center;
}
#menu-accordeon li {
   margin-bottom:2px;
}
#menu-accordeon li li {
   max-height:0;
   overflow: hidden;
   transition: all .5s;
   border-radius:0;
   background: #000;
   box-shadow: none;
   border:none;
   margin:0
}
#menu-accordeon a {
  display:block;
  text-decoration: none;
  color: #fff;
  font-family: verdana;
  font-size:1.2em
}
#menu-accordeon ul li a, #menu-accordeon li:hover li a {
  font-size:1em
}
#menu-accordeon li:hover {
}
#menu-accordeon li li:hover {
}
#menu-accordeon ul li:last-child {
}
#menu-accordeon li:hover li {
  max-height: 15em;
}
</style>
		<title>ArtAcademy - N°1 sur les talents artistiques !</title>
	</head>
	<body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
		
		<div id="header1">
			<div id="logo"><a href="home"><span>#</span>ArtAcademy</a></div>
			<div class="menu_element">
					<ul id="menu-accordeon">
					   <li><a href="">Catégories <span>v</span></a>
						  <ul>
						  	<c:forEach var="item" items="${categories}">
								<li><a href="category?id=${item.id}">${item.name}</a></li>
							</c:forEach>
						  </ul>
					   </li>
					</ul>
			</div>
			<div id="search">
			<form action="advancedsearch" method="post">
				<input type="text" name="search_input" placeholder="Artiste, mot-clé"/>&nbsp; 
				<input type="submit" value="Rechercher"/>
			</form>
				<a href="advancedsearch"><u>Recherche avancée</u></a>
				</div>
			<div class="fear"><img src="images/fear_explode.png" alt="FEAR"></div>
		</div>
		<div id="header2">
			<div class="menu_element"><a href="newpics">Nouveautées <span>+</span></a></div>
			<div class="menu_element"><a href="seepics">Les plus vues <span>+</span></a></div>
			<div class="menu_element"><a href="bestpics">Les mieux notées <span>+</span></a></div>
			<div id="login"><a href="basket"><img width="24" height="24"  src="images/basket.svg"></a><span style="font-size: 0.8em;">44</span></div>
			<% if(session.getAttribute("login") == null) { %><div id="login"><a href="user?action=connect">Connexion</a>&nbsp; | &nbsp;<a href="user?action=register">Inscription</a></div><% } %>
			<div id="login"><% if(session.getAttribute("login") != null) {%><input type="button" value="Upload" onclick="window.location.assign('upload');">&nbsp;&nbsp;Bonjour <%= session.getAttribute("login")%>! <a href =user?action=disconnect> Deconnexion</a><% } %> &nbsp;&nbsp;</div>
		</div>
		
	<% if (request.getAttribute("error")!=null) { %>
			<div id="popuperr" class="popup-error"><%=request.getAttribute("error") %></div> 
				<script>
					setTimeout('cacheDiverr()', 2000);
							 
					function cacheDiverr() {
						 $("#popuperr").fadeOut("slow");
					}
				</script>		
	<%} %>
	<% if (request.getAttribute("message")!=null) { %>
	
			<div id="popupok" class="popup-ok"> <%=request.getAttribute("message") %></div> 
				<script>
					setTimeout('cacheDiv()', 3000);

					function cacheDiv() {
						$("#popupok").fadeOut("slow");
					}
				</script>
	<%} %>
	
		