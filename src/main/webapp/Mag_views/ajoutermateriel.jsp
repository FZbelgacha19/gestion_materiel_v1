<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<r:override name="title">Ajouter materiel</r:override>
</head>
<body>
	<r:override name="pageTitle">
		<h2>Ajouter nouveau materiel</h2>
	</r:override>
	<r:override name="message">
		<c:choose>
			<c:when test="${ !empty erreur }">
				<div class="alert alert-danger" role="alert">
					<c:out value="${ erreur }" />
				</div>
			</c:when>
			<c:when test="${ !empty success }">
				<div class="alert alert-success" role="alert">
					<c:out value="${ success }" />
				</div>
			</c:when>
		</c:choose>
	</r:override>
	<r:override name="content">
		<form class="mx-5" action="<%= request.getContextPath() %>/Ajouter_Materiel" method="post">

			<div class="mb-3 row row">
				<label class="form-label col-2" for="Num_Serie">Num Serie</label> <input
					id="Num_Serie" name="Num_Serie" type="text"
					class="form-control col" required="required">
			</div>
			<div class="mb-3 row">
				<label for="Date_garantie" class="form-label col-2">Date
					garantie</label> <input id="Date_garantie" name="Date_garantie" type="date"
					class="form-control col" required="required">
			</div>

			<div class="mb-3 row">
				<label for="Designation" class="form-label col-2">Designation</label>
				<select id="Designation" name="Designation" class="form-control col"
					required="required">
					<option value="">Choisie un type</option>
					<c:forEach items="${listtype}" var="l">
						<option value="${l.getId_Typemat()}">${l.getNom_mat()}</option>
					</c:forEach>
				</select> <input id="newDesignation" name="newDesignation"
					class="form-control col" type="text" value="" />

				<button type="button" class="btn btn-outline-success col-1" id="add">
					&#43;</button>
				<button type="button" class="btn btn-outline-danger col-1" id="remove">
					&#8722;</button>
			</div>

			<div class="mb-3 row">
				<label for="Etat_mat" class="form-label col-2">Etate materiel</label> <select
					id="Etat_mat" name="Etat_mat" class="form-control col"
					required="required">
					<option value="neuf">matériel neuf</option>
					<option value="remise_neuf">matériel remise à neuf</option>
				</select>
			</div>

			<div class="mb-3 row">
				<label for="Mark" class="form-label col-2">Marque</label> <input id="Mark"
					name="Mark" type="text" class="form-control col" required="required">
			</div>

			<div class="mb-3 d-flex justify-content-end">
					<button name="submit" type="submit" class="btn btn-outline-primary">Ajouter</button>
			</div>
		</form>
	</r:override>


	<jsp:include page="/Mag_views/mag_main.jsp" />
	<script>
		$(document).ready(function() {
			$("#add").click(function() {
				$("#Designation").hide();
				$("#add").hide();
				$("#Designation").prop('required',false);
				$("#newDesignation").show();
				$("#newDesignation").prop('required',true);
				$("#remove").show();
			});
			$("#remove").click(function() {
				$("#Designation").show();
				$("#Designation").prop('required',true);
				$("#add").show();
				$("#newDesignation").hide();
				$("#newDesignation").prop('required',false);
				$("#remove").hide();
			});
		});
	</script>
</body>
</html>