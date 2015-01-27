<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    </div>
		<div id="footer"><p>©2015 PixAcademy</p><p><span>Tous droits réservés</span></p></div>

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
	</body>
</html>