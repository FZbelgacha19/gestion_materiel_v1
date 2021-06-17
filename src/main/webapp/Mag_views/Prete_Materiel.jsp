<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<r:override name="title">Prete materiel</r:override>
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
		<h2>Prete materiel</h2>
	</r:override>
	<r:override name="content">
		<div class="d-flex justify-content-end m-5" id="search">
			<form action="<%=request.getContextPath()%>/Prete_Materiel"
				method="post" class="d-flex justify-content-around">
				<input class="form-control me-2" type="search" placeholder="Search"
					name="value">
				<button class="btn btn-outline-success" type="submit">Search</button>
			</form>
		</div>
		<div class="scrollbar">
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">Numero de serie</th>
						<th scope="col">Date de garantie</th>
						<th scope="col">Designation</th>
						<th scope="col">Etat_mat</th>
						<th scope="col">Marque</th>
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
								<td id="BtnEditing"><a
									class="btn btn-outline-primary m-2 btn-sm"
									href="<%=request.getContextPath()%>/Prete?id_m=${m.getId_mat()}">
									<i class="bi bi-arrow-right-square"></i></a></td>

							</tr>

						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>

	</r:override>


	<jsp:include page="/Mag_views/mag_main.jsp" />

</body>
</html>