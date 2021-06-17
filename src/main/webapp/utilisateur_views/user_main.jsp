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

	<r:override name="navbar">
		<li class="nav-item"><a class="nav-link scrollto"
			href="Ajouter_utilisateur">Ajouter utilisateur</a></li>
		<li class="nav-item"><a class="nav-link scrollto"
			href="Liste_Utilisateurs">Liste des utilisateurs</a></li>
		<li class="nav-item"><a class="nav-link scrollto fw-bolder"
			href="#"> ${Utilisateur.getLogin()}</a></li>
		<li class="nav-item"><a class="nav-link scrollto"
			href="Deconnecter">Deconnecter</a></li>
	</r:override>

	<div class="container">
		<section class="d-flex align-items-center mt-10 pb-0 pb-20">
			<div class="container d-flex justify-content-center">
				<r:block name="pageTitle">
				</r:block>
				
			</div>
			
			<r:block name="message"></r:block>
		</section>
		<r:override name="ContenuIndex">
			<section class="mt-5 mb-0 p-0 h-auto" id="content">
				<div class="d-flex align-content-start row px-5 pb-0 h-auto">
					<r:block name="content">
					<div class="col">
								<img alt="" src="assets/img/add_user.svg"
									class="img-decorate">
							</div>
							<div class="col mt-5">
								<p class="fs-1 font-bold col-indigo">Gestion Materiel</p>

								<p class="justify-text">Dans tout secteur d’activité, la
									gestion des équipements ou du matériel, étroitement liée à
									celle de la qualité d’éducation, est essentielle. Elle vise à
									garantir la fiabilité, la disponibilité des équipements
									techniques nécessaires et assurer la confortabilité des
									étudiants plus que les professeurs.</p>
							</div>
							
					</r:block>
				</div>
			</section>
		</r:override>
	</div>
	<jsp:include page="/index.jsp" />
</body>
</html>