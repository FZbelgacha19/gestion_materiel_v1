<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<r:override name="title">Ajouter Intervention</r:override>
</head>
<body>
	<r:override name="pageTitle">
		<div>
			<h2 class="font-bold col-Russian-violet">Ajouter nouveau
				intervention</h2>

			<hr>
		</div>
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
	<div class="container px-200 m-2">
		<form class="mx-5"
			action="<%=request.getContextPath()%>/Ajouter_Intervention"
			method="post">

			<div class="mb-3 row">
				<label for="Num_Serie" class="form-label col-2">N° serie</label> <input
					id="Num_Serie" name="Num_Serie" type="text"
					class="form-control col" required="required"
					placeholder="Numero de serie de materiel">
			</div>
			<div class="mb-3 row">
				<label for="Traitement" class="form-label col-2">Traitement</label>
				<textarea id="Traitement" name="Traitement" class="form-control col"
					rows="3">...</textarea>
			</div>
			<div class="mb-3 d-flex justify-content-end">
				<button name="submit" type="submit" class="btn btn-outline-Dark-Cornflower-bleu rounded-pill m-1">ajouter</button>
			</div>
		</form>
		</div>
	</r:override>


	<jsp:include page="/tech_views/tech_main.jsp" />

</body>
</html>