<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<r:override name="title">Liste des commande</r:override>
</head>
<body>
	<r:override name="pageTitle">
		<h2>Liste des commande</h2>
	</r:override>

	<r:override name="content">
	<div class="d-flex justify-content-end m-5"  id="search">
			<form action="<%=request.getContextPath()%>/Liste_Commande"
				method="post" class="d-flex justify-content-around" >
				<input class="form-control me-2" type="search" placeholder="N� commande"
					name="value">
				<button class="btn btn-outline-success" type="submit">Search</button>
			</form>
		</div>
		<c:if test="${!empty listNumCmd }">
		
			<div class="accordion accordion-flush" id="accordionFlushExample">
				<c:forEach items="${listNumCmd}" var="lc">
					<c:set var="numC" value="${lc}" />
					<div class="accordion-item">
						<h2 class="accordion-header" id="flush-heading${numC}">
							<button class="accordion-button collapsed" type="button"
								data-bs-toggle="collapse"
								data-bs-target="#flush-collapse${numC}" aria-expanded="false"
								aria-controls="flush-collapse${numC}">Commande N� :
								${numC}</button>
						</h2>
						


						<div id="flush-collapse${numC}"
							class="accordion-collapse collapse"
							aria-labelledby="flush-heading${numC}"
							data-bs-parent="#accordionFlushExample">
							<div class="accordion-body">
							<div class="d-flex justify-content-end">
							<div class="btn-group" role="group"
							aria-label="Basic outlined example">
							<a class="btn btn-outline-secondary btn-sm" data-bs-toggle="tooltip" data-bs-placement="top" title="Imprimer"
								href="<%=request.getContextPath()%>/Imprimer_Commande?num_c=${numC}"><i
								class="bi bi-printer"></i></a> <a
								class="btn btn-outline-primary btn-sm" data-bs-toggle="tooltip" data-bs-placement="top" title="Valider"
								href="<%=request.getContextPath()%>/Valide_Commande?num_cmd=${numC}"><i
								class="bi bi-check2-square"></i></a> <a
								class="btn btn-outline-dark btn-sm" data-bs-toggle="tooltip" data-bs-placement="top" title="Pay�"
								href="<%=request.getContextPath()%>/Paye_Commande?num_cmd=${numC}"><i
								class="bi bi-cash"></i></a>
						</div>
						</div>
								<table class="table table-hover">
									<thead>
										<tr>
											<th scope="col">Date de commande</th>
											<th scope="col">Type de materiel</th>
											<th scope="col">Quantit� command�</th>
											<th scope="col">Description</th>
											<th scope="col">Etat de commande</th>
											<th scope="col"></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listCmd}" var="c">
											<c:if test="${numC == c.getNum_cmd()}">
												<tr>
													<td>${c.getDate_cmd()}</td>
													<td>${c.getTypeMat()}</td>
													<td>${c.getQte()}</td>
													<td>${c.getDescription()}</td>
													<td class="text-secondary">${c.getEtat_cmd()}</td>
													<c:if
														test="${c.getValider() == 'no_valide' && c.getEtat_cmd() == 'no_paye'}">
														<td id="BtnEditing"><a
															class="btn btn-outline-primary m-2 btn-sm"
															href="<%=request.getContextPath()%>/Modifier_Commande?id_c=${c.getId_cmd()}"><i
																class="bi bi-pencil-square"></i></a> <a
															class="btn btn-outline-danger m-2 btn-sm"
															href="<%=request.getContextPath()%>/Supp_Commande?id_c=${c.getId_cmd()}"><i
																class="bi bi-x-square"></i></a></td>
													</c:if>
												</tr>
											</c:if>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</c:if>
	</r:override>
		<jsp:include page="/Comp_views/comp_main.jsp" />
</body>
</html>