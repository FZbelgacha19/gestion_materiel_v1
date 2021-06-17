<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
<c:if test="${sessionScope.Utilisateur == null }">
<c:redirect url="Se_connecter"/>
</c:if>

<r:override name="navbar">
          <li class="nav-item"><a class="nav-link scrollto" href="Ajouter_Commande">Ajouter Commande</a></li>
          <li class="nav-item"><a class="nav-link scrollto" href="Liste_Commande">Liste des Commandes</a></li>
          <li class="nav-item"><a class="nav-link scrollto fw-bolder" href="#">${Utilisateur.getLogin()}</a></li>
          <li class="nav-item"><a class="nav-link scrollto" href="Deconnecter">Deconnecter</a>
  </r:override>

  <div class="container">
 	<section class="d-flex align-items-center mt-5 pb-0">
	 	<div class="container">
	   <r:block name="pageTitle"> 
	   </r:block>
	  </div>

	</section>
	<section class=" d-flex align-items-center">
		<div class="container">
	   <r:block name="content">
	   </r:block>
	  </div> 
	</section>
</div>
    <jsp:include page="/index.jsp"/>
</body>
</html>