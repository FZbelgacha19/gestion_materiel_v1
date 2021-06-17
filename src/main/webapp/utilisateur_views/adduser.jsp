<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<r:override name="title">Ajouter utilisateur</r:override>
</head>
<body>
	<r:override name="pageTitle">
		<div>
			<h2 class="font-bold col-Russian-violet">Ajouter nouveau
				utilisateur</h2>
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
		<div class="container px-200">
			<form action="<%=request.getContextPath()%>/Ajouter_utilisateur"
				method="post">
				<div class="row align-items-start">
					<div class="col mb-3">
						<label class="form-label">Nom : </label> <input type="text"
							class="form-control" name="nom">
					</div>
					<div class="col mb-3">
						<label class="form-label">Prenom : </label> <input type="text"
							class="form-control" name="prenom">
					</div>
				</div>
				<div class="mb-3">
					<label class="form-label">Telephone : </label> <input type="text"
						class="form-control" name="tele">
				</div>
				<div class="row align-items-start">
					<div class="col mb-3">
						<label class="form-label">Email : </label> <input type="email"
							class="form-control" name="email">
					</div>
					<div class="col mb-3">
						<label class="form-label">Mot de pass : </label> <input
							type="password" class="form-control" name="motPass">
					</div>
				</div>
				<div class="row align-items-start">
					<div class="col mb-3">
						<label class="form-label">Login : </label> <input type="text"
							class="form-control" name="login">
					</div>
					<div class="col mb-3">
						<label class="form-label">type utilisateur : </label> <select
							class="form-select" name="type_user">
							<option selected disabled="disabled">Choisi type</option>
							<option value="Magasinier">Magasinier</option>
							<option value="Professeur">Professeur</option>
							<option value="Technicien">Technicien</option>
							<option value="Comptable">Comptable</option>
						</select>
					</div>
				</div>
				<div class="d-flex justify-content-end">

					<button type="submit" class="btn btn-outline-Dark-Cornflower-bleu rounded-pill m-1">Ajouter</button>
						<button type="reset" class="btn btn-outline-CandyPink rounded-pill m-1"
							onClick="window.location.href=window.location.href">Annuler</button>
						
	
				</div>
			</form>
		</div>
	</r:override>


	<jsp:include page="/utilisateur_views/user_main.jsp" />
</body>
</html>