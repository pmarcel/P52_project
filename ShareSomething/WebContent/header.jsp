<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<meta charset="utf-8">
		<style>
		#categories a:visited
		{
			color: black;
		}
		body
		{
			margin-left: 15%;
			margin-right: 15%;
		}
		.title
		{
			font-size: 2em;
		}
		#banner
		{
			height: 5%;
			background-color: black;
			border: 1px solid black;
			border-bottom: none;
			color: white;
			font-size: 1em;
			padding-left: 1%;
			text-align: left;
		}
		#banner span
		{
			color: white;
			float: right;
			font-size: 1em;
			padding-top: 1%;
		}
		#banner span a
		{
			color: white;
			font-size: 1em;
			
		}
		#banner span a:visited
		{
			color: white;
			font-size: 1em;
		}
		#menu
		{
			height: 2%;
			border: 1px solid black;
			border-bottom: none;
			padding: 1%;
		}
		#categories
		{
			padding-top: 1%;
			height: 5%;
			border: 1px solid black;
			text-align: center;
			border-bottom: none;
		}
		#content
		{
			height: 75%;
			border: 1px solid black;
			border-bottom: none;
		}
		#footer
		{
			height: 4%;
			border: 1px solid black;
			background-color: black;
			color: white;
			text-align: center;
			padding-top: 1%;
		}
		.menu_icon{
		height: 150%;
		line-height: -50px;
		}
		</style>
	</head>
	<body>
		<div id="banner">
		<a class="title">#ArtAcademy</a>
			<span><input type="text">
			<a href="">Recherche avancée</a></span>
		</div>
		<div id="menu">
			<a href=""><img class="menu_icon" src="images/login.svg"></a>&nbsp; <span class="menu_item">Se connecter</span>
			<a href=""><img class="menu_icon" src="images/create_account.svg"></a>&nbsp; <span class="menu_item">Créer un compte</span>
			<span style="float: right; text-align: right;">
			Bonjour %USER% !
			<a href="">Panier</a>
			</span>
		</div>
		<div id="categories">
			<a href="">Animaux</a>
			<a href="">Arts</a>
			<a href="">Babybel</a>
			<a href="">Histoire</a>
			<a href="">Stanislas</a>
			<a href="">Zorro</a>
		</div>
		<div id="content">