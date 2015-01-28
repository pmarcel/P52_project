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
			#popuperr, #popupok{
				float: center;
			}
			
			.popup-ok {
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
				background: linear-gradient(#006600, #002200) repeat scroll 0% 0% transparent;
				border-radius: 10px;
			}
			.popup-error {
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
		<title>ArtAcademy - N°1 sur les talents artistiques !</title>
	</head>
	<body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	
		<script type="text/javascript">
		/*
			snow_img = "blood_snow.png";
			snow_no = 150;

			if (typeof(window.pageYOffset) == "number")
			{
				snow_browser_width = window.innerWidth;
				snow_browser_height = window.innerHeight;
			} 
			else if (document.body && (document.body.scrollLeft || document.body.scrollTop))
			{
				snow_browser_width = document.body.offsetWidth;
				snow_browser_height = document.body.offsetHeight;
			}
			else if (document.documentElement && (document.documentElement.scrollLeft || document.documentElement.scrollTop))
			{
				snow_browser_width = document.documentElement.offsetWidth;
				snow_browser_height = document.documentElement.offsetHeight;
			}
			else
			{
				snow_browser_width = 500;
				snow_browser_height = 500;	
			}

			snow_dx = [];
			snow_xp = [];
			snow_yp = [];
			snow_am = [];
			snow_stx = [];
			snow_sty = [];

			for (i = 0; i < snow_no; i++) 
			{ 
				snow_dx[i] = 0; 
				snow_xp[i] = Math.random()*(snow_browser_width-50);
				snow_yp[i] = Math.random()*snow_browser_height;
				snow_am[i] = Math.random()*20; 
				snow_stx[i] = 0.02 + Math.random()/10;
				snow_sty[i] = 0.7 + Math.random();
				if (i > 0) document.write("<\div id=\"snow_flake"+ i +"\" style=\"position:absolute;z-index:"+i+"\"><\img src=\""+snow_img+"\" border=\"0\"><\/div>"); else document.write("<\div id=\"snow_flake0\" style=\"position:absolute;z-index:0\"><\img src=\""+snow_img+"\" border=\"0\"></a><\/div>");
			}

			function SnowStart() 
			{ 
				for (i = 0; i < snow_no; i++) 
				{ 
					snow_yp[i] += snow_sty[i];
					if (snow_yp[i] > snow_browser_height-50) 
					{
						snow_xp[i] = Math.random()*(snow_browser_width-snow_am[i]-30);
						snow_yp[i] = 0;
						snow_stx[i] = 0.02 + Math.random()/10;
						snow_sty[i] = 0.7 + Math.random();
					}
					snow_dx[i] += snow_stx[i];
					document.getElementById("snow_flake"+i).style.top=snow_yp[i]+"px";
					document.getElementById("snow_flake"+i).style.left=snow_xp[i] + snow_am[i]*Math.sin(snow_dx[i])+"px";
				}
				snow_time = setTimeout("SnowStart()", 10);
			}*/
</script>
		
		<div id="header1">
			<div id="logo"><a href=""><span>#</span>ArtAcademy</a></div>
			<div class="menu_element">
					<ul id="menu-accordeon">
					   <li><a href="">Catégories <span>▼</span></a>
						  <ul>
						  	<c:forEach var="item" items="${categories}">
								<li><a href="${item.id}">${item.name}</a></li>
							</c:forEach>
						  </ul>
					   </li>
					</ul>
			</div>
			<div id="search"><input type="text" id="search_input" placeholder="Artiste, mots-clés, etc...">&nbsp; <a href=""><u>Recherche avancée</u></a></div>
			<div class="fear"><img src="images/fear_explode.png" alt="FEAR"></div>
		</div>
		<div id="header2">
			<div class="menu_element"><a href="">Nouveautées <span>+</span></a></div>
			<div class="menu_element"><a href="">Les plus vues <span>+</span></a></div>
			<div class="menu_element"><a href="">Les mieux notées <span>+</span></a></div>
			<div id="login">
				<a href="http://localhost:8080/ShareSomething/user?action=connect">Connexion</a>
				&nbsp; | &nbsp;
				<a href="http://localhost:8080/ShareSomething/user?action=register">Inscription</a>
				<a href="http://localhost:8080/ShareSomething/user?action=disconnect">Déconnection</a>
			</div>
			<div id="Upload"><input type="button" value="Upload" onclick="alert('COUCOU');">&nbsp; | &nbsp;Bonjour --- !&nbsp; | &nbsp;<a href="">Panier</a></div>
		</div>
		
		<div id="popuperr" class="popup-erreur"><%=request.getAttribute("error") %></div> 
				<script>
					setTimeout('cacheDiv()', 2000);
							 
					function cacheDiv() {
						 $("#popuperr").fadeOut("slow");
					}
				</script>		
				
			<div id="popupok" class="popup-ok"> <%=request.getAttribute("message") %></div> 
				<script>
					setTimeout('cacheDiv()', 3000);
			 
					function cacheDiv() {
						 $("#popupok").fadeOut("slow");
					}
				</script>
			
