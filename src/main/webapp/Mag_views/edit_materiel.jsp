<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<r:override name="title">Modifier materiel</r:override>
</head>
<body>
	<r:override name="pageTitle">
		Modifier materiel
	</r:override>

	<r:override name="content">
		<c:if test="${es_dao.MaterielExist(mat.getId_mat()) == 0}">
			<%
			response.sendRedirect(request.getContextPath() + "/List_Materiel");
			%>
		</c:if>
		<div class="container px-200 mt-2">
		<form class="mx-5"
			action="<%= request.getContextPath() %>/Modifier_Materiel?id_mat=${mat.getId_mat()}"
			method="post">

			<div class="mb-3 row row">
				<label class="form-label col-3" for="Num_Serie">Num Serie</label> <input
					id="Num_Serie" name="Num_Serie" type="text"
					class="form-control col" required="required"
					value="${mat.getNum_Serie()}">
			</div>
			<div class="mb-3 row">
				<label for="Date_garantie" class="form-label col-3">Date
					garantie</label> <input id="Date_garantie" name="Date_garantie" type="date"
					class="form-control col" required="required"
					value="${mat.getDate_garantie()}">
			</div>

			<div class="mb-3 row">
				<label for="Designation" class="form-label col-3">Designation</label>
				<select id="Designation" name="Designation" class="form-select col"
					required="required">
					<option value="">Choisie un type</option>
					<c:forEach items="${listtype}" var="l">
						<option value="${l.getId_Typemat()}"
							${mat.getDesignation() == l.getId_Typemat() ? 'selected' : ''}>${l.getNom_mat()}</option>
					</c:forEach>
				</select> <input id="newDesignation" name="newDesignation"
					class="form-control col" type="text" value="" />

				<button type="button" class="btn btn-outline-PastelPink col-1" id="add">
					&#43;</button>
				<button type="button" class="btn btn-outline-CandyPink col-1"
					id="remove">&#8722;</button>
			</div>

			<div class="mb-3 row">
				<label for="Etat_mat" class="form-label col-3">Etate
					materiel</label> <select id="Etat_mat" name="Etat_mat"
					class="form-select col" required="required">
					<option value="neuf" ${mat.getEtat_mat() == "neuf" ? 'selected':''}>matériel
						neuf</option>
					<option value="remise_neuf"
						${mat.getEtat_mat() == "remise_neuf" ? 'selected':''}>matériel
						remise à neuf</option>
				</select>
			</div>

			<div class="mb-3 row">
				<label for="Mark" class="form-label col-3">Marque</label> <input
					id="Mark" name="Mark" type="text" class="form-control col"
					required="required" value="${mat.getMark()}">
			</div>

			<div class="mb-3 d-flex justify-content-end">
				<button name="submit" type="submit" class="btn btn-outline-Dark-Cornflower-bleu rounded-pill">Modifier</button>
			</div>
		</form>
		</div>
	</r:override>


	<jsp:include page="/Mag_views/mag_main.jsp" />
	<script>
		$(document).ready(function() {
			$("#add").click(function() {
				$("#Designation").hide();
				$("#add").hide();
				$("#Designation").prop('required', false);
				$("#newDesignation").show();
				$("#newDesignation").prop('required', true);
				$("#remove").show();
			});
			$("#remove").click(function() {
				$("#Designation").show();
				$("#Designation").prop('required', true);
				$("#add").show();
				$("#newDesignation").hide();
				$("#newDesignation").prop('required', false);
				$("#remove").hide();
			});
		});
	</script>
</body>
</html>