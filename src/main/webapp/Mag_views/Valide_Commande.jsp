<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<r:override name="title">Valider Demande</r:override>
</head>
<body>
	<r:override name="pageTitle">
		<h2>Valider demandes</h2>
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
			<form action="<%=request.getContextPath()%>/Valide_Commande"
				method="post" class="d-flex justify-content-around">
				<input name="value" type="search" class="form-control col">
				<button class="btn btn-outline-success" type="submit">Search</button>
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
										href="<%=request.getContextPath()%>/Valider?id_d=${d.getId_dmd()}"><i
											class="bi bi-check2-square"></i></a>
								</td>
								</c:if>
								
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