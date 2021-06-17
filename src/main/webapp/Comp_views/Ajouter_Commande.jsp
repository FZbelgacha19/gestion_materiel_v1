<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<r:override name="title">Ajouter commande</r:override>
</head>
<body>
	<r:override name="pageTitle">
		<h2>Ajouter nouveau commande</h2>
	</r:override>
	<r:override name="content">
		<form class="mx-5"
			action="<%=request.getContextPath()%>/Ajouter_Commande" method="post" id="ajouterCommande">

			<div class="mb-3 row">
				<label for="typeMat" class="form-label col-2">Type de materiel</label> <input
					id="typeMat" name="typeMat" type="text"
					class="form-control col" required="required"
					placeholder="Tapez le type de materiel">
			</div>
			<div class="mb-3 row">
				<label for="Qte" class="form-label col-2">Quantite</label> <input
					id="Qte" name="Qte" type="number"
					class="form-control col" required="required"
					placeholder="Quantite de materiels">
			</div>
			<div class="mb-3 row">
				<label for="Description" class="form-label col-2">Description</label>
				<textarea id="Description" name="Description"
					class="form-control col" rows="3">...</textarea>
			</div>
			
			
			<div class="mb-3 d-flex justify-content-end" id="button">
				<button name="button" type="button" id="ajouter" class="btn btn-outline-success me-2">ajouter</button>
				<button name="submit" type="submit" class="btn btn-outline-primary">Confirmer</button>
			</div>
			
		</form>
	</r:override>


	<jsp:include page="/Comp_views/comp_main.jsp" />
<script>
$(document).ready(function(){
	  $("#ajouter").click(function(){
	    $("<div class=\"mb-3 row\">\r\n"
				+ "				<label for=\"typeMat\" class=\"form-label col-2\">Type de materiel</label> <input\r\n"
				+ "					id=\"typeMat\" name=\"typeMat\" type=\"text\"\r\n"
				+ "					class=\"form-control col\" required=\"required\"\r\n"
				+ "					placeholder=\"Tapez le type de materiel\">\r\n"
				+ "			</div>\r\n"
				+ "			<div class=\"mb-3 row\">\r\n"
				+ "				<label for=\"Qte\" class=\"form-label col-2\">Quantite</label> <input\r\n"
				+ "					id=\"Qte\" name=\"Qte\" type=\"number\"\r\n"
				+ "					class=\"form-control col\" required=\"required\"\r\n"
				+ "					placeholder=\"Quantite de materiels\">\r\n"
				+ "			</div>\r\n"
				+ "			<div class=\"mb-3 row\">\r\n"
				+ "				<label for=\"Description\" class=\"form-label col-2\">Description</label>\r\n"
				+ "				<textarea id=\"Description\" name=\"Description\"\r\n"
				+ "					class=\"form-control col\" rows=\"3\">...</textarea>\r\n"
				+ "			</div>").insertBefore("#button");
	  });
	});
</script>
</body>
</html>