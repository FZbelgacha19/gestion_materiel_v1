<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><r:block name="title">Gestion Materiel</r:block></title>
<!-- Vendor CSS Files -->
<link href="assets/css/style-edited.css" rel="stylesheet">
<link href="assets/vendor/aos/aos.css" rel="stylesheet">
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="assets/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
<link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet">
</head>
<body>
	<header id="header"
		class="fixed-top d-flex align-items-center shadow p-3 mb-5 bg-body rounded">
		<div
			class="container d-flex align-items-center justify-content-between">

			<div class="logo">

				<c:if test="${sessionScope.redirection != null}">
					<c:set var="redirect" value="/gestion_materiel_v1${redirection}"></c:set>
				</c:if>
				<c:if test="${sessionScope.redirection == null}">
					<c:set var="redirect" value="/gestion_materiel_v1"></c:set>
				</c:if>
				<h1>
					<a href="${redirect}" class="logoApp fw-bold">Gestion Materiel</a>
				</h1>
			</div>

			<nav id="navbar" class="navbar">
				<ul>
					<r:block name="navbar">
						<c:if test="${ sessionScope.Utilisateur == null}">
							<li><a class="nav-link scrollto login-btn" href="Se_connecter">Login</a></li>
						</c:if>

					</r:block>
				</ul>

			</nav>

		</div>
	</header>
	<r:block name="ContenuIndex">
		<section class="mt-10 mb-0 p-0 h-auto">

			<div class="d-flex align-content-start row px-5 pb-0 h-auto">
			
				<div class="col mt-10">
				<p class="fs-1 font-bold col-indigo">Gestion Materiel</p>
				
					<p class="justify-text">Dans tout secteur d’activité, la gestion des équipements ou
						du matériel, étroitement liée à celle de la qualité d’éducation,
						est essentielle. Elle vise à garantir la fiabilité, la
						disponibilité des équipements techniques nécessaires et assurer la
						confortabilité des étudiants plus que les professeurs.</p>
				</div>
				<div class="col">
				<img alt="" src="assets/img/WorkWithTeam.svg" class="img-decorate">
				</div>
			</div>
		</section>
	</r:block>

	<!-- Vendor JS Files -->
	<script src="assets/vendor/aos/aos.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
	<script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script src="assets/vendor/php-email-form/validate.js"></script>
	<script src="assets/vendor/purecounter/purecounter.js"></script>
	<script src="assets/vendor/swiper/swiper-bundle.min.js"></script>

	<!-- Template Main JS File -->
	<script src="assets/js/main.js"></script>
	<script src="assets/js/jquery-3.6.0.min.js"></script>
</body>
</html>