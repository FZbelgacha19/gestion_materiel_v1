<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>


	<div class="container position-absolute top-50 start-50 translate-middle px-5">
		<form action="<%=request.getContextPath()%>/Se_connecter"
			method="post">
				<div class="mb-3 px-5">
					<label class="form-label">Email : </label> <input type="email"
						class="form-control" name="email">
				</div>
				<div class="mb-3 px-5">
					<label class="form-label">Mot de pass : </label> <input
						type="password" class="form-control" name="motPass">
				</div>
			
			<div class="d-flex justify-content-end px-5">
			<button type="submit" class="btn btn-outline-success m-2">Se connecter</button>
			<button type="reset" class="btn btn-outline-danger m-2" onClick="window.location.href=window.location.href">Annuler</button>
		</div>
		</form>
	</div>
	<jsp:include page="/index.jsp" />
</body>
</html>