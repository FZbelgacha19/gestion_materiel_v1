<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>
<c:if test="${empty Utilisateur }">
<c:redirect url="Se_connecter"/>
</c:if>

  <r:override name="navbar">
          <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#">demande</a>
           <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <li><a class="dropdown-item" href="Ajouter_Demande">Ajouter Demande</a></li>
            <li><a class="dropdown-item" href="List_Demande">Liste des Demandes</a></li>
          </ul>
          </li>
          <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#">Salle</a>
           <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <li><a class="dropdown-item" href="nouvel_salle">Ajouter Salle</a></li>
            <li><a class="dropdown-item" href="List_Salle">Liste des Salles</a></li>
          </ul>
          </li>
          <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#">Filiere</a>
           <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <li><a class="dropdown-item" href="nouvel_filier">Ajouter Filiere</a></li>
            <li><a class="dropdown-item" href="List_Filiere">Liste des Filieres</a></li>
          </ul>
          </li>
        
          <li class="nav-item"><a class="nav-link scrollto fw-bolder" href="#">${Utilisateur.getLogin()}</a></li>
          <li class="nav-item"><a class="nav-link scrollto" href="Deconnecter">Deconnecter</a>
  </r:override>

  <div class="container">
 	<section class="d-flex align-items-center mt-5 pb-0">
	 	<div class="container">
	   <r:block name="pageTitle"> 
	   </r:block>
	  </div>
	  <r:block name="message"></r:block>
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