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
						<c:forEach var="item" items="${images}">
							<li>
								${item.name}<a href="basket?action=delete&image=${item.id}"><input type="button" value="X" style="float: right" /></a><br/>
								<img src="${item.link}" alt="${item.name}" />${item.id}
							</li>
						</c:forEach> 
					</ul>
				</div>
				<a href="basket?download">Télécharger</a>
			</div>
	<jsp:include page="footer.jsp" />