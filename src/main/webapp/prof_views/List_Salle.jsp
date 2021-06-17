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
		<h2>Liste des Salles</h2>
	</r:override>

	<r:override name="content">
		<div class="scrollbar">
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">Bloc</th>
						<th scope="col">Numero de salle</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty Listsall }">
						<c:forEach items="${Listsall}" var="s">
							<tr>
								<td>${s.getBloc()}</td>
								<td>${s.getNum_salle()}</td>
								
									<td id="BtnEditing"><a
										class="btn btn-outline-primary m-2 btn-sm"
										href="<%=request.getContextPath()%>/Modifier_Salle?id_s=${s.getId_salle()}"><i
											class="bi bi-pencil-square"></i></a> <a
										class="btn btn-outline-danger m-2 btn-sm"
										href="<%=request.getContextPath()%>/Delete_Salle?id_s=${s.getId_salle()}"><i
											class="bi bi-x-square"></i></a></td>
								
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