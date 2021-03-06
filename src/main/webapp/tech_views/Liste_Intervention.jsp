<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<r:override name="title">List Salles</r:override>
</head>
<body>
	<r:override name="pageTitle">
		<div>
		<h2 class="font-bold col-Russian-violet">Liste des Salles</h2>
		<hr>
		</div>
	</r:override>
	<r:override name="message">
		<c:choose>
			<c:when test="${param.msg == 0 }">
				<div class="alert alert-danger" role="alert">
					Materiel n'existe pas
				</div>
			</c:when>
			<c:when test="${param.msg == 1 }">
				<div class="alert alert-success" role="alert">
					Modification fait avec success
				</div>
			</c:when>
		</c:choose>
	</r:override>
	<r:override name="content">
		<div class="container d-flex justify-content-end mx-5 mt-2 mb-3 pe-5" id="search">
			<form action="<%=request.getContextPath()%>/Liste_Intervention"
				method="post" class="d-flex justify-content-around">
				<input class="form-control round-pill-start" type="search"
					placeholder="N° serie de materiel" name="value">
				<button class="btn btn-outline-Dark-Cornflower-bleu round-pill-end" type="submit">Search</button>
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
										class="btn btn-outline-Dark-Cornflower-bleu m-2 btn-sm"
										href="<%=request.getContextPath()%>/Modifier_Intervention?id_i=${i.getId_intervention()}"><i
											class="bi bi-pencil-square"></i></a> <a
										class="btn btn-outline-CandyPink m-2 btn-sm"
										href="<%=request.getContextPath()%>/Valide_Intervention?id_i=${i.getId_intervention()}"><i
											class="bi bi-check2-square"></i></a> <a
										class="btn btn-outline-PastelPink m-2 btn-sm"
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