<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

</style>
</head>
<body>
	<r:override name="pageTitle">
		<h2>Listes des utilisateurs de systemes</h2>
	</r:override>
	<r:override name="message">
		<c:if test="${ !empty success }">
			<div class="alert alert-success" role="alert">
				<c:out value="${ success }" />
			</div>
		</c:if>
	</r:override>
	<r:override name="content">
		<div class="d-flex justify-content-end m-5">
			<form action="<%=request.getContextPath()%>/Liste_Utilisateurs"
				method="post" class="d-flex justify-content-around">
				<input class="form-control me-2" type="search" placeholder="Search"
					name="value">
				<button class="btn btn-outline-success" type="submit">Search</button>
			</form>
		</div>
		<div class="scrollbar">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th scope="col">Nom complete</th>
						<th scope="col">telephone</th>
						<th scope="col">email</th>
						<th scope="col">login</th>
						<th scope="col">type utilisateur</th>
						<th scope="col">Date inscription</th>
						<th scope="col">Date modification</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="u">
						<tr>
							<td>${u.getNom_user()}${u.getPrenom_user()}</td>
							<td>${u.getTele()}</td>
							<td>${u.getEmail()}</td>
							<td>${u.getLogin()}</td>
							<td>${u.getType_user()}</td>
							<td>${u.getCreated_at()}</td>
							<td>${u.getUpdated_at()}</td>
							<td class="d-flex justify-content-around" id="BtnEditing"><a
								href="Modifier_Les_informations?id_user=${u.getId_user()}"
								class="btn btn-outline-primary m-2 btn-sm"><i
									class="bi bi-person-lines-fill"></i></a> <a
								href="Supprime_utilisateur?id_user=${u.getId_user()}"
								class="btn btn-outline-danger m-2 btn-sm"><i
									class="bi bi-person-x-fill"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="d-flex justify-content-end">
			<button type="button" class="btn btn-outline-secondary"
				onclick="window.print()" id="BtnImprimer">imprimer</button>
		</div>

	</r:override>

	<jsp:include page="/utilisateur_views/user_main.jsp" />
</body>
</html>