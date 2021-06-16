<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<r:override name="title">Liste Demande</r:override>
</head>
<body>
	<r:override name="pageTitle">
		<h2>Listes des demandes</h2>
	</r:override>

	<r:override name="content">
		<div class="d-flex justify-content-end m-5" id="search">
			<form action="<%=request.getContextPath()%>/List_Demande"
				method="post" class="d-flex justify-content-around">
				<select  class="form-select" name="value">
					<option value="" disabled="disabled" selected="selected"></option>
					<option value="no_valide">Demande no valide</option>
					<option value="valide">Demande valide</option>
				</select>
				<div class="btn-group ms-2">
				<button class="btn btn-outline-success btn-sm" type="submit"><i class="bi bi-search"></i></button>
				<button class="btn btn-outline-danger btn-sm" type="button" onclick="location.href='List_Demande'">
				<b>X</b>
				</button>
				</div>
			</form>
		</div>
		<div class="scrollbar">
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">Numero de commande</th>
						<th scope="col">Date</th>
						<th scope="col">Designation</th>
						<th scope="col">Filiere</th>
						<th scope="col">Salle</th>
						<th scope="col">Quantite</th>
						<th scope="col">Etat</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty ListDmd }">
						<c:forEach items="${ListDmd}" var="d">
							<tr>
								<td>${d.getId_dmd()}</td>
								<td>${d.getDate_dmd()}</td>
								<td>${tp.NameTypeMateriel(d.getType())}</td>
								<td>${f.SelectNameFiliere(d.getFiliere())}</td>
								<td>${s.SelectNumSalle(d.getSalle())}</td>
								<td>${d.getQte()}</td>
								<td>${d.getValide()}</td>
								<c:if test="${ fn:contains(d.getValide(),'no_valide') }">
									<td id="BtnEditing"><a
										class="btn btn-outline-primary m-2 btn-sm"
										href="<%=request.getContextPath()%>/Modif_Demander?id_dmd=${d.getId_dmd()}"><i
											class="bi bi-pencil-square"></i></a> <a
										class="btn btn-outline-danger m-2 btn-sm"
										href="<%=request.getContextPath()%>/Delete_Demander?id_dmd=${d.getId_dmd()}"><i
											class="bi bi-x-square"></i></a></td>
								</c:if>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</r:override>


	<jsp:include page="/prof_views/prof_main.jsp" />

</body>
</html>