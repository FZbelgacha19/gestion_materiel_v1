<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="aujourdhui" class="java.util.Date" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<r:override name="title">Imprimer Commande</r:override>
<style type="text/css">
@media print {
	#BtnImprimer, #BtnEditing {
		display: none;
	}
}
</style>
</head>
<body>
	<r:override name="pageTitle">
		Imprimer reçu de commande
	</r:override>

	<r:override name="content">
		<div class="container" id="bonCommande">
			<div id="logo" class="d-flex justify-content-start">
				<img alt="" src="assets/img/bts.png" width="150" height="80">
			</div>
			<div class="d-flex justify-content-center mt-5">
				<fmt:formatDate var="annee" value="${aujourdhui}" pattern="yyyy" />
				<h2>bon de commande N° : ${NumCmd}/${annee}</h2>
			</div>
			<div class="d-flex justify-content-end mt-5">
				<fmt:formatDate var="date" value="${aujourdhui}"
					pattern="dd/MM/yyyy" />
				<table>
					<tr>
						<td><b>Kénitra le </b> : ${date}</td>
					</tr>
					<tr>
						<td><b>Client : </b>${Utilisateur.getNom_user()}
							${Utilisateur.getPrenom_user()}</td>
					</tr>
					<tr>
						<td><b>N° téléphone : </b>${Utilisateur.getTele()}</td>
					</tr>
					<tr>
						<td><b>Etablessement : </b>Lycée technique ibn sina - Kénitra</td>
					</tr>
				</table>

			</div>
			<div class="container mt-5">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Type de materiel</th>
							<th scope="col">Quantité commandé</th>
							<th scope="col">Description</th>
							<th scope="col">Etat de commande</th>
						</tr>
					</thead>
					<c:if test="${!empty listCmd }">
						<c:forEach items="${listCmd}" var="c">
							<tr>
								<td>${c.getTypeMat()}</td>
								<td>${c.getQte()}</td>
								<td>${c.getDescription()}</td>
								<td class="text-secondary">${c.getEtat_cmd()}</td>
							</tr>
						</c:forEach>
					</c:if>
					</tbody>
				</table>
			</div>
			<div class="d-flex justify-content-end mt-5">
				<p>Signature</p>
			</div>
		</div>
		<div class="d-flex justify-content-center mt-5">
			<button type="button" class="btn btn-outline-secondary"
				id="BtnImprimer" onclick='printDiv();'>imprimer</button>
			<a role="button" class="btn btn-outline-secondary ms-2" href="Ajouter_Commande">Annuler</a>
		</div>
	</r:override>


	<jsp:include page="/Comp_views/comp_main.jsp" />
	<script>
	function printDiv() 
	{

	  var divToPrint=document.getElementById('bonCommande');

	  var newWin=window.open('','Print-Window');

	  newWin.document.open();

	  newWin.document.write("<html><head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "	  <!-- Vendor CSS Files -->\r\n"
				+ "  <link href=\"assets/vendor/aos/aos.css\" rel=\"stylesheet\">\r\n"
				+ "  <link href=\"assets/vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
				+ "  <link href=\"assets/vendor/bootstrap-icons/bootstrap-icons.css\" rel=\"stylesheet\">\r\n"
				+ "  <link href=\"assets/vendor/boxicons/css/boxicons.min.css\" rel=\"stylesheet\">\r\n"
				+ "  <link href=\"assets/vendor/glightbox/css/glightbox.min.css\" rel=\"stylesheet\">\r\n"
				+ "  <link href=\"assets/vendor/remixicon/remixicon.css\" rel=\"stylesheet\">\r\n"
				+ "  <link href=\"assets/vendor/swiper/swiper-bundle.min.css\" rel=\"stylesheet\">\r\n"
				+ "\r\n"
				+ "  <!-- Template Main CSS File -->\r\n"
				+ "  <link href=\"assets/css/style.css\" rel=\"stylesheet\">\r\n"
				+ "</head><body onload=\"window.print()\">"+divToPrint.innerHTML+"</body></html>");

	  newWin.document.close();

	  setTimeout(function(){newWin.close();},10);

	}
	</script>
</body>
</html>