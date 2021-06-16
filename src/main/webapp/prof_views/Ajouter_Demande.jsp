<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<r:override name="title">Ajouter Demande</r:override>
</head>
<body>
	<r:override name="pageTitle">
		<h2>Ajouter nouveau Demande</h2>
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
		<form class="mx-5"
			action="<%= request.getContextPath() %>/Ajouter_Demande"
			method="post">
  			<c:set var="now" value="<%=new java.util.Date()%>" />
			<div class="mb-3 row">
				<label for="Date_dmd" class="form-label col-2">Date Demande</label>
				<input id="Date_dmd" name="Date_dmd" type="date"
					class="form-control col" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${now}" />"
					disabled="disabled">
			</div>
			<div class="mb-3 row">
				<label for="Designation" class="form-label col-2">Designation</label>
				<select id="Designation" name="Designation" class="form-control col"
					required="required">
					<option value=""></option>
					<c:forEach items="${listtype}" var="l">
						<option value="${l.getId_Typemat()}">${l.getNom_mat()}</option>
					</c:forEach>
				</select>
			</div>
			<div class="mb-3 row">
				<label for="Salle" class="form-label col-2">Salles</label> <select
					id="Salle" name="Salle" class="form-control col"
					required="required">
					<option value=""></option>
					<c:forEach items="${Salles}" var="s">
						<option value="${s.getId_salle()}">${s.getNum_salle()}</option>
					</c:forEach>
				</select> <small><a href="nouvel_salle" target="_blank">Ajouter nouvel Salle</a></small>
			</div>

			<div class="mb-3 row">
				<label for="filiere" class="form-label col-2">Filier</label> <select
					id="filiere" name="filiere" class="form-control col"
					required="required">
					<option value=""></option>
					<c:forEach items="${filiere}" var="f">
						<option value="${f.getId_fil()}">${f.getNom_fil()}</option>
					</c:forEach>
				</select> <small><a href="nouvel_filier" target="_blank">Ajouter nouvel filiere</a></small>
			</div>
			<div class="mb-3 row">
				<label for="Qte" class="form-label col-2">Quantite</label> <input
					id="Qte" name="Qte" type="number" class="form-control col"
					required="required">
			</div>

			<div class="mb-3 d-flex justify-content-end">
				<button name="submit" type="submit" class="btn btn-outline-primary">Confirmer</button>
			</div>
		</form>
	</r:override>


	<jsp:include page="/prof_views/prof_main.jsp" />

</body>
</html>