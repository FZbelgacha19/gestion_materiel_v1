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
			href="#">demande</a>
			<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
				<li><a class="dropdown-item" href="Ajouter_Demande">Ajouter
						Demande</a></li>
				<li><a class="dropdown-item" href="List_Demande">Liste des
						Demandes</a></li>
			</ul></li>
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#">Salle</a>
			<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
				<li><a class="dropdown-item" href="nouvel_salle">Ajouter
						Salle</a></li>
				<li><a class="dropdown-item" href="List_Salle">Liste des
						Salles</a></li>
			</ul></li>
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#">Filiere</a>
			<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
				<li><a class="dropdown-item" href="nouvel_filier">Ajouter
						Filiere</a></li>
				<li><a class="dropdown-item" href="List_Filiere">Liste des
						Filieres</a></li>
			</ul></li>

		<li class="nav-item"><div class="d-flex justify-content-between mx-3">
		<img alt="" src="login_views/img/${Utilisateur.getPhoto()}" width="50" height="50" class="rounded-circle">
		<a class="scrollto fw-bolder login-Name p-1 m-0"
			href="#"> ${Utilisateur.getLogin()}</a>
			</div>
			</li>
		<li class="nav-item"><a class="nav-link scrollto deconnecter" href="Deconnecter">Deconnecter</a>
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
							<img alt="" src="assets/img/educate.svg" class="img-decorate">
						</div>
						<div class="col mt-5">
							<p class="fs-1 font-bold col-indigo">Gestion Materiel</p>

							<p class="justify-text">Dans tout secteur d???activit??, la
								gestion des ??quipements ou du mat??riel, ??troitement li??e ?? celle
								de la qualit?? d?????ducation, est essentielle. Elle vise ?? garantir
								la fiabilit??, la disponibilit?? des ??quipements techniques
								n??cessaires et assurer la confortabilit?? des ??tudiants plus que
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