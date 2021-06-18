<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<r:override name="title">List materiel</r:override>
<style type="text/css">
@media print {
	#BtnImprimer, #BtnEditing {
		display: none;
	}
}
</style>
</head>
<body>
	<r:override name="pageTitle">
		List materiel
	</r:override>
	<r:override name="content">
	<div class="container d-flex justify-content-end mx-5 mt-2 mb-5 pe-5" id="search">
			<form action="<%=request.getContextPath()%>/List_Materiel"
				method="post" class="d-flex justify-content-around" >
				<input class="form-control round-pill-start" type="search" placeholder="Search"
					name="value">
				<button class="btn btn-outline-Dark-Cornflower-bleu round-pill-end" type="submit">Search</button>
			</form>
		</div>
		<div class="scrollbar">
			<table class="table table-hover table-sm">
				<thead>
					<tr>
						<th scope="col">Numero de serie</th>
						<th scope="col">Date de garantie</th>
						<th scope="col">Designation</th>
						<th scope="col">Etat_mat</th>
						<th scope="col">Marque</th>
						<th scope="col">Prêter</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty listmat }">
						<c:forEach items="${listmat}" var="m">
							<tr>
								<td>${m.getNum_Serie() }</td>
								<td>${m.getDate_garantie() }</td>
								<td>${tm_dao.NameTypeMateriel(m.getDesignation())}</td>
								<td>${m.getEtat_mat()}</td>
								<td>${m.getMark()}</td>
								<td>${rm_dao.NbPrete(m.getId_mat())} fois</td>
								<td id="BtnEditing">
								<c:if test="${es_dao.MaterielExist(m.getId_mat()) == 1}">
								<a
									class="btn btn-outline-Dark-Cornflower-bleu m-2 btn-sm"
									href="<%=request.getContextPath()%>/Modifier_Materiel?id_mat=${m.getId_mat()}"><i
										class="bi bi-pencil-square"></i></a> <a
									class="btn btn-outline-CandyPink m-2 btn-sm"
									href="<%=request.getContextPath()%>/Delete_Materiel?id_mat=${m.getId_mat()}"><i
										class="bi bi-x-square"></i></a>
								</c:if>
								<c:if test="${es_dao.MaterielExist(m.getId_mat()) == 0}">
								<p>Déja prêté</p>
								</c:if>	
								</td>

							</tr>

						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
		<div class="d-flex justify-content-end mt-2">
			<button type="button" class="btn btn-outline-secondary"
				onclick="window.print()" id="BtnImprimer">imprimer</button>
		</div>
	</r:override>


	<jsp:include page="/Mag_views/mag_main.jsp" />

</body>
</html>