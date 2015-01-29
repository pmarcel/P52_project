<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<jsp:include page="header.jsp" />
    	<style>
    		#basket_items
    		{
    		}
    		#basket_items li
    		{
    			display: inline-block;
    		}
    	</style>
			<div id="basket">
				<div id="basket_items">
					<ul>
						<li>IMG1</li>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="x"><br>
						<li>IMG2</li>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="x"><br>
						<li>IMG3</li>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="x"><br>
					</ul>
				</div>
				<a href="basket?download">Télécharger</a>
			</div>
	<jsp:include page="footer.jsp" />