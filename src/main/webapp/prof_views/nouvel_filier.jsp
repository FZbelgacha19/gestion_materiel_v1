<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<r:override name="title">Ajouter filiere</r:override>
</head>
<body>
	<r:override name="pageTitle">
	Ajouter nouveau filiere
	</r:override>

	<r:override name="content">
		<div class="container px-200 mt-2">
		<form class="mx-5"
			action="<%=request.getContextPath()%>/nouvel_filier" method="post">

			<div class="mb-3 row">
				<label for="Nbr_etudiant" class="form-label col-4">Nombere des
					etudiants</label> <input id="Nbr_etudiant" name="Nbr_etudiant" type="number"
					class="form-control col" required="required">
			</div>
			<div class="mb-3 row">
				<label for="Nom_fil" class="form-label col-4">Nom de filiere</label> <input
					id="Nom_fil" name="Nom_fil" type="text" class="form-control col"
					required="required">
			</div>
			<div class="mb-3 d-flex justify-content-end">
				<button name="submit" type="submit" class="btn btn-outline-Dark-Cornflower-bleu rounded-pill m-1">ajouter</button>
			</div>
		</form>
		</div>
	</r:override>


	<jsp:include page="/prof_views/prof_main.jsp" />

</body>
</html>