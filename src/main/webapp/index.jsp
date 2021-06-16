<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>
<r:block name="title">Gestion Materiel</r:block>
</title>
	  <!-- Vendor CSS Files -->
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">
</head>
<body>
  <header id="header" class="fixed-top d-flex align-items-center">
    <div class="container d-flex align-items-center justify-content-between">

      <div class="logo">
      
      <c:if test="${sessionScope.redirection != null}">
      <c:set var="redirect" value="/gestion_materiel_v1${redirection}"></c:set>
      </c:if>
      <c:if test="${sessionScope.redirection == null}">
      <c:set var="redirect" value="/gestion_materiel_v1"></c:set>
      </c:if>
        <h1><a href="${redirect}">Gestion Materiel</a></h1>
      </div>

      <nav id="navbar" class="navbar">
        <ul>
		    <r:block name="navbar">
		    <c:if test="${ sessionScope.Utilisateur == null}">
		    <li><a class="nav-link scrollto" href="Se_connecter">Login</a></li>
		    </c:if>
		 	
		    </r:block>
        </ul>
        
      </nav>

    </div>
  </header>

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