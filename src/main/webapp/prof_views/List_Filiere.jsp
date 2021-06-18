<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<r:override name="title">List Filiere</r:override>
</head>
<body>
	<r:override name="pageTitle">
		Liste des filieres
	</r:override>

	<r:override name="content">
		<div class="scrollbar">
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">Filier</th>
						<th scope="col">Nomber des etudiants</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty Listfil }">
						<c:forEach items="${Listfil}" var="f">
							<tr>
								<td>${f.getNom_fil()}</td>
								<td>${f.getNbr_etudiant()}</td>
								
									<td id="BtnEditing"><a
										class="btn btn-outline-Dark-Cornflower-bleu m-2 btn-sm"
										href="<%=request.getContextPath()%>/Modifier_Filiere?id_f=${f.getId_fil()}"><i
											class="bi bi-pencil-square"></i></a> <a
										class="btn btn-outline-CandyPink m-2 btn-sm"
										href="<%=request.getContextPath()%>/Delete_Filiere?id_f=${f.getId_fil()}"><i
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