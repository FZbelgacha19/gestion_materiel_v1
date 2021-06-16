<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<r:override name="title">Modifier utilisateur ${user.getLogin()}</r:override>
</head>
<body>
	<r:override name="pageTitle">
		<h2>Modifier les information d'utilisateur ${user.getLogin()}</h2>
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
	<form action="<%= request.getContextPath() %>/Modifier_Les_informations?id_user=${user.getId_user()}" method="post">
			<div class="row align-items-start">
				<div class="col mb-3">
					<label class="form-label">Nom : </label>
					<input type="text" class="form-control" name="nom" value="${user.getNom_user()}">
				</div>
				<div class="col mb-3">
					<label class="form-label">Prenom : </label> <input type="text"
						class="form-control" name="prenom" value="${user.getPrenom_user() }">
				</div>
			</div>
			<div class="mb-3">
				<label class="form-label">Telephone : </label> <input type="text"
					class="form-control" name="tele" value="${user.getTele() }">
			</div>
			<div class="row align-items-start">
				<div class="col mb-3">
					<label class="form-label">Email : </label> <input type="email"
						class="form-control" name="email" value="${user.getEmail() }">
				</div>
				<div class="col mb-3">
					<label class="form-label">Mot de pass : </label> <input
						type="text" class="form-control" name="motPass" value="${user.getMotpassConfirmation() }">
				</div>
			</div>
			<div class="row align-items-start">
				<div class="col mb-3">
					<label class="form-label">Login : </label> <input type="text"
						class="form-control" name="login" value="${user.getLogin()}">
				</div>
				<div class="col mb-3">
					<label class="form-label">type utilisateur : </label> 
					<select class="form-select" name="type_user">
						<option  disabled>Choisi type</option>
						<option value="Magasinier" ${user.getType_user() == "Magasinier" ? 'selected' : ''}>Magasinier</option>
						<option value="Professeur" ${user.getType_user() == "Professeur" ? 'selected' : ''}>Professeur</option>
						<option value="Technicien" ${user.getType_user() == "Technicien" ? 'selected' : ''}>Technicien</option>
						<option value="Comptable" ${user.getType_user() == "Comptable" ? 'selected' : ''}>Comptable</option>
					</select>
				</div>
			</div>
		<div class="d-flex flex-row-reverse bd-highlight">
			<a class="btn btn-outline-danger m-2" href="<%=request.getContextPath()%>/Liste_Utilisateurs">Annuler</a>
			<button type="submit" class="btn btn-outline-success m-2">Modifier</button>
			
		</div>
</form>
	</r:override>


	<jsp:include page="/utilisateur_views/user_main.jsp" />
</body>
</html>