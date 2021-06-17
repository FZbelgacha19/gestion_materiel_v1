<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="r" uri="http://www.rapid-framework.org.cn/rapid"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body class="bg-indigo">

	<r:override name="ContenuIndex">
		<div
			class="container row d-flex justify-content-center position-absolute top-50 start-50 translate-middle px-5">
			<div class="row login-form">

				<div class="col">
					<img alt="" src="assets/img/login.svg" class="img-300-px">
				</div>
				<div class="col">
					<form action="<%=request.getContextPath()%>/Se_connecter"
						method="post">
						<div class="mb-3 px-5">
							<label class="form-label">Email : </label> <input type="email"
								class="form-control rounded-pill" name="email">
						</div>
						<div class="mb-3 px-5">
							<label class="form-label">Mot de pass : </label> <input
								type="password" class="form-control rounded-pill" name="motPass">
						</div>

						<div class="d-flex justify-content-end px-5">
							<button type="submit" class="btn m-2 rounded-pill btn-outline-mauve">Se
								connecter</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</r:override>

	<jsp:include page="/index.jsp" />
</body>
</html>