<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login V3</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link href="<c:url value='/assets/login/images/icons/favicon.ico'/>" rel="icon" type="image/png" >
	<link rel="stylesheet" type="text/css" href="<c:url value='/assets/login/vendor/bootstrap/css/bootstrap.min.css'/>">

	<link rel="stylesheet" type="text/css" href="<c:url value='/assets/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css'/>">

	<link rel="stylesheet" type="text/css" href="<c:url value='/assets/login/fonts/iconic/css/material-design-iconic-font.min.css'/>">

	<link rel="stylesheet" type="text/css" href="<c:url value='/assets/login/vendor/animate/animate.css'/>">

	<link rel="stylesheet" type="text/css" href="<c:url value='/assets/login/vendor/css-hamburgers/hamburgers.min.css'/>">

	<link rel="stylesheet" type="text/css" href="<c:url value='/assets/login/vendor/animsition/css/animsition.min.css'/>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value= '/assets/login/vendor/select2/select2.min.css'/>">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="<c:url value= '/assets/login/vendor/daterangepicker/daterangepicker.css'/>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value= '/assets/login/css/util.css'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value= '/assets/login/css/main.css'/>">
<!--===============================================================================================-->

<style type="text/css">
	.dropdown-toggle, .dropdown-menu { width: 300px }
	.btn-group img { margin-right: 10px }
	.dropdown-toggle { padding-right: 50px }
	.dropdown-toggle .glyphicon { margin-left: 20px; margin-right: -40px }
	.dropdown-menu>li>a:hover { background: #f1f9fd } /* $search-blue */
	.dropdown-header { background: #ccc; font-size: 14px; font-weight: 700; padding-top: 5px; padding-bottom: 5px; margin-top: 10px; margin-bottom: 5px }
</style>
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100" style="background-image:  url('<c:url value= '/assets/login/images/bg-01.jpg'/>');">
			<div class="wrap-login100">
				<form:form action="login.htm" modelAttribute="user" method="POST" class="login100-form validate-form">
				<%-- <form class="login100-form validate-form"> --%>
					<span class="login100-form-logo">
						<i class="zmdi zmdi-landscape"></i>
					</span>

					<span class="login100-form-title p-b-34 p-t-27">
						Log in
					</span>

					<div class="wrap-input100">
						
						<form:input path="id" class="input100" type="text" placeholder="Username"/>
						<span class="focus-input100" data-placeholder="&#xf207;"></span>
						<form:errors path="id" class="error-message"/>
					</div>

					
					<div class="wrap-input100">
						<form:input path="password" class="input100" type="password" placeholder="Password"/>
						<span class="focus-input100" data-placeholder="&#xf191;"></span>
						<form:errors path="password" class="error-message"/>
					</div>

					<div class="contact100-form-checkbox">
						<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
						<label class="label-checkbox100" for="ckb1">
							Remember me
						</label>
					</div>
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Login
						</button>
					</div>

					<div class="text-center p-t-90">
						<a class="txt1" href="#">
							Forgot Password?
						</a>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>