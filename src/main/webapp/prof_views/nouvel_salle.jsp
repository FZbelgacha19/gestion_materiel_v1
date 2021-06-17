<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<r:override name="title">Ajouter salle</r:override>
</head>
<body>
	<r:override name="pageTitle">
		<h2>Ajouter nouveau Salle</h2>
	</r:override>

	<r:override name="content">
		<form class="mx-5"
			action="<%=request.getContextPath()%>/nouvel_salle" method="post">

			<div class="mb-3 row">
				<label for="Num_salle" class="form-label col-2">Numero de
					salle</label> <input id="Num_salle" name="Num_salle" type="number"
					class="form-control col" required="required">
			</div>
			<div class="mb-3 row">
				<label for="Bloc" class="form-label col-2">Bloc</label> <input
					id="Bloc" name="Bloc" type="text" class="form-control col"
					required="required">
			</div>
			<div class="mb-3 d-flex justify-content-end">
				<button name="submit" type="submit" class="btn btn-outline-primary">ajouter</button>
			</div>
		</form>
	</r:override>


	<jsp:include page="/prof_views/prof_main.jsp" />

</body>
</html>