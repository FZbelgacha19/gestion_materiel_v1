<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
	<c:if test="${empty Utilisateur }">
		<c:redirect url="Se_connecter" />
	</c:if>

	<r:override name="navbar">
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#">Materiel</a>
			<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
				<li><a class="dropdown-item" href="Ajouter_Materiel">Ajouter
						Materiel</a></li>
				<li><a class="dropdown-item" href="List_Materiel">Liste des
						materiels</a></li>
				<li><a class="dropdown-item" href="Prete_Materiel">Prête
						materiel</a></li>
				<li><a class="dropdown-item" href="Materiels_preter">Liste
						materiels Prêter</a></li>
			</ul></li>
		<li><a class="nav-link scrollto" href="Valide_Demande">Valide
				Commande</a></li>
		<li class="nav-item"><div
				class="d-flex justify-content-between mx-3">
				<img alt="" src="login_views/img/${Utilisateur.getPhoto()}"
					width="50" height="50" class="rounded-circle"> <a
					class="scrollto fw-bolder login-Name p-1 m-0" href="#">
					${Utilisateur.getLogin()}</a>
			</div></li>
		<li class="nav-item"><a class="nav-link scrollto deconnecter"
			href="Deconnecter">Deconnecter</a>
	</r:override>

	<div class="container">
		<section class="d-flex align-items-center mt-10 pb-0 pb-20">
			<div class="container d-flex justify-content-center">
				<div>
					<h2 class="font-bold col-Russian-violet">
						<r:block name="pageTitle">
						</r:block>
					</h2>
					<hr>
				</div>
			</div>

			<r:block name="message"></r:block>
		</section>
		<r:override name="ContenuIndex">
			<section class="mt-5 mb-0 p-0 h-auto" id="content">
				<div class="d-flex align-content-start row px-5 pb-0 h-auto">
					<r:block name="content">
						<div class="col">
							<img alt="" src="assets/img/magsinier.svg" class="img-decorate"
								width="650">
						</div>
						<div class="col mt-5">
							<p class="fs-1 font-bold col-indigo">Gestion Materiel</p>

							<p class="justify-text">Dans tout secteur d’activité, la
								gestion des équipements ou du matériel, étroitement liée à celle
								de la qualité d’éducation, est essentielle. Elle vise à garantir
								la fiabilité, la disponibilité des équipements techniques
								nécessaires et assurer la confortabilité des étudiants plus que
								les professeurs.</p>
						</div>

					</r:block>
				</div>
			</section>
		</r:override>
	</div>
	<jsp:include page="/index.jsp" />
</body>
</html>