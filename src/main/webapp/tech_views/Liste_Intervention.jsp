<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<r:override name="title">List Salles</r:override>
</head>
<body>
	<r:override name="pageTitle">
		<h2>Liste des Salles</h2>
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
		<div class="d-flex justify-content-end m-5" id="search">
			<form action="<%=request.getContextPath()%>/Liste_Intervention"
				method="post" class="d-flex justify-content-around">
				<input class="form-control me-2" type="search"
					placeholder="Tapez N° serie de materiel" name="value">
				<button class="btn btn-outline-success" type="submit">Search</button>
			</form>
		</div>
		<div class="scrollbar">
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">N° materiel</th>
						<th scope="col">Traitement</th>
						<th scope="col">Date intervention</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty listintv }">
						<c:forEach items="${listintv}" var="i">
							<tr>
								<c:set var="m" value="${m_dao.getMateriels(i.getId_mat())}" />
								<td>${m.getNum_Serie()}</td>
								<td>${i.getTraitement()}</td>
								<td>${i.getDate_intervention()}</td>
								<c:if test="${fn:contains(i.getValide(),'no_valide') }">
									<td id="BtnEditing"><a
										class="btn btn-outline-primary m-2 btn-sm"
										href="<%=request.getContextPath()%>/Modifier_Intervention?id_i=${i.getId_intervention()}"><i
											class="bi bi-pencil-square"></i></a> <a
										class="btn btn-outline-primary m-2 btn-sm"
										href="<%=request.getContextPath()%>/Valide_Intervention?id_i=${i.getId_intervention()}"><i
											class="bi bi-check2-square"></i></a> <a
										class="btn btn-outline-danger m-2 btn-sm"
										href="<%=request.getContextPath()%>/Delete_Intervention?id_i=${i.getId_intervention()}"><i
											class="bi bi-x-square"></i></a></td>

								</c:if>


							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</r:override>


	<jsp:include page="/tech_views/tech_main.jsp" />

</body>
</html>