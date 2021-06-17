<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<r:override name="title">Modifier commande</r:override>
</head>
<body>
	<r:override name="pageTitle">
		<h2>Modifier commande</h2>
	</r:override>

	<r:override name="content">
		<form class="mx-5"
			action="<%=request.getContextPath()%>/Modifier_Commande?id_c=${c.getId_cmd()}" method="post" id="ajouterCommande">

			<div class="mb-3 row">
				<label for="typeMat" class="form-label col-2">Type de materiel</label> <input
					id="typeMat" name="typeMat" type="text"
					class="form-control col" required="required"
					placeholder="Tapez le type de materiel" value="${c.getTypeMat()}">
			</div>
			<div class="mb-3 row">
				<label for="Qte" class="form-label col-2">Quantite</label> <input
					id="Qte" name="Qte" type="number"
					class="form-control col" required="required"
					placeholder="Quantite de materiels" value="${c.getQte()}">
			</div>
			<div class="mb-3 row">
				<label for="Description" class="form-label col-2">Description</label>
				<textarea id="Description" name="Description"
					class="form-control col" rows="3">${c.getDescription()}</textarea>
			</div>
			
			
			<div class="mb-3 d-flex justify-content-end" id="button">
				<button name="submit" type="submit" class="btn btn-outline-primary">Modifier</button>
			</div>
			
		</form>
	</r:override>


	<jsp:include page="/Comp_views/comp_main.jsp" />

</body>
</html>