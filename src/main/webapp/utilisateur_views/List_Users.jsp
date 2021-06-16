<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

</style>
</head>
<body>
	<r:override name="pageTitle">
		<h2>Listes des utilisateurs de systemes</h2>
	</r:override>
	<r:override name="message">
		<c:if test="${ !empty success }">
			<div class="alert alert-success" role="alert">
				<c:out value="${ success }" />
			</div>
		</c:if>
	</r:override>
	<r:override name="content">
		<div class="d-flex justify-content-end m-5" id="search">
			<form action="<%=request.getContextPath()%>/Liste_Utilisateurs"
				method="post" class="d-flex justify-content-around">
				<input class="form-control me-2" type="search" placeholder="Search"
					name="value">
				<button class="btn btn-outline-success" type="submit">Search</button>
			</form>
		</div>
		<div class="scrollbar" id="listUtilisateurs">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th scope="col">Nom complete</th>
						<th scope="col">telephone</th>
						<th scope="col">email</th>
						<th scope="col">login</th>
						<th scope="col">type utilisateur</th>
						<th scope="col">Date inscription</th>
						<th scope="col">Date modification</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="u">
						<tr>
							<td>${u.getNom_user()}${u.getPrenom_user()}</td>
							<td>${u.getTele()}</td>
							<td>${u.getEmail()}</td>
							<td>${u.getLogin()}</td>
							<td>${u.getType_user()}</td>
							<td>${u.getCreated_at()}</td>
							<td>${u.getUpdated_at()}</td>
							<td class="d-flex justify-content-around BtnEditing" id="BtnEditing"><a
								href="Modifier_Les_informations?id_user=${u.getId_user()}"
								class="btn btn-outline-primary m-2 btn-sm"><i
									class="bi bi-person-lines-fill"></i></a> <a
								href="Supprime_utilisateur?id_user=${u.getId_user()}"
								class="btn btn-outline-danger m-2 btn-sm"><i
									class="bi bi-person-x-fill"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="d-flex justify-content-end">
			<button type="button" class="btn btn-outline-secondary"
				id="BtnImprimer" onclick='printDiv();'>imprimer</button>
		</div>

	</r:override>

	<jsp:include page="/utilisateur_views/user_main.jsp" />
<script>
	function printDiv() 
	{

	  var divToPrint=document.getElementById('listUtilisateurs');

	  var newWin=window.open('','Print-Window');

	  newWin.document.open();

	  newWin.document.write("<html><head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
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
				+"<style type=\"text/css\">\r\n"
				+ "	.btn {\r\n"
				+ "		display: none;\r\n"
				+ "	}\r\n"
				+ "</style>"
				+ "</head><body onload=\"window.print()\"><h2 class=\"m-5\">Listes des utilisateurs de systemes</h2>"+divToPrint.innerHTML+"</body></html>");

	  newWin.document.close();

	  setTimeout(function(){newWin.close();},10);

	}
	</script>
</body>
</html>