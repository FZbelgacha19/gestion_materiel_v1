<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<r:override name="title">Modifier Demande</r:override>
</head>
<body>
	<r:override name="pageTitle">
		Modifier Demande
	</r:override>

	<r:override name="content">
	<div class="container px-200">
	<c:if test="${d.getValide() == 'valide'}">
				<%
				response.sendRedirect(request.getContextPath() + "/List_Demande");
				%>
			</c:if>
		<form class="mx-5"
			action="<%= request.getContextPath() %>/Modif_Demander?id_dmd=${d.getId_dmd()}"
			method="post">
  			<c:set var="now" value="<%=new java.util.Date()%>" />
			<div class="mb-3 row">
				<label for="Date_dmd" class="form-label col-3">Date Demande</label>
				<input id="Date_dmd" name="Date_dmd" type="date"
					class="form-control col" value="${d.getDate_dmd()}"
					disabled="disabled">
			</div>
			<div class="mb-3 row">
				<label for="Designation" class="form-label col-3">Designation</label>
				<select id="Designation" name="Designation" class="form-select col"
					required="required">
					<option value=""></option>
					<c:forEach items="${listtype}" var="l">
						<option value="${l.getId_Typemat()}" ${l.getId_Typemat() ==d.getType()? 'selected':''}>${l.getNom_mat()}</option>
					</c:forEach>
				</select>
			</div>
			<div class="mb-3 row">
				<label for="Salle" class="form-label col-3">Salles</label> <select
					id="Salle" name="Salle" class="form-select col"
					required="required">
					<option value=""></option>
					<c:forEach items="${Salles}" var="s">
						<option value="${s.getId_salle()}" ${s.getId_salle() ==d.getSalle()? 'selected':''}>${s.getNum_salle()}</option>
					</c:forEach>
				</select> <small><a href="nouvel_salle" target="_blank" class="col-Candy-Pink">Ajouter nouvel Salle</a></small>
			</div>

			<div class="mb-3 row">
				<label for="filiere" class="form-label col-3">Filier</label> <select
					id="filiere" name="filiere" class="form-select col"
					required="required">
					<option value=""></option>
					<c:forEach items="${filiere}" var="f">
						<option value="${f.getId_fil()}" ${f.getId_fil() ==d.getFiliere()? 'selected':''}>${f.getNom_fil()}</option>
					</c:forEach>
				</select> <small><a href="nouvel_filier" target="_blank" class="col-Candy-Pink">Ajouter nouvel filiere</a></small>
			</div>
			<div class="mb-3 row">
				<label for="Qte" class="form-label col-3">Quantite</label> <input
					id="Qte" name="Qte" type="number" class="form-control col"
					required="required" value="${d.getQte()}">
			</div>

			<div class="mb-3 d-flex justify-content-end">
				<button name="submit" type="submit" class="btn btn-outline-Dark-Cornflower-bleu rounded-pill">Confirmer</button>
			</div>
		</form>
		</div>
	</r:override>


	<jsp:include page="/prof_views/prof_main.jsp" />

</body>
</html>