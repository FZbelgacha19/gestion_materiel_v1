<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<r:override name="title">Modifier salle</r:override>
</head>
<body>
	<r:override name="pageTitle">
		Modifier Salle
	</r:override>

	<r:override name="content">
	<div class="container px-200 mt-2">
		<form class="mx-5"
			action="<%=request.getContextPath()%>/Modifier_Salle?id_s=${s.getId_salle()}" method="post">

			<div class="mb-3 row">
				<label for="Num_salle" class="form-label col-4">Numero de
					salle</label> <input id="Num_salle" name="Num_salle" type="number"
					class="form-control col" required="required" value="${s.getNum_salle()}">
			</div>
			<div class="mb-3 row">
				<label for="Bloc" class="form-label col-4">Bloc</label> <input
					id="Bloc" name="Bloc" type="text" class="form-control col"
					required="required" value="${s.getBloc()}">
			</div>
			<div class="mb-3 d-flex justify-content-end">
				<button name="submit" type="submit" class="btn btn-outline-Dark-Cornflower-bleu rounded-pill m-1">Modifier</button>
			</div>
		</form>
		</div>
	</r:override>


	<jsp:include page="/prof_views/prof_main.jsp" />

</body>
</html>