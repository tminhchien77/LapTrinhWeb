<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/assets/admin/static" var="url"></c:url>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title> Môn LTW </title>
<base href="${pageContext.servletContext.contextPath}/">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap styles -->
<link href="<c:url value="/assets/user/css/bootstrap.css" />" rel="stylesheet" />
<!-- Customize styles -->
<link href="<c:url value="/assets/user/style.css" />" rel="stylesheet" />
<!-- font awesome styles -->
<link href="<c:url value="/assets/user/font-awesome/css/font-awesome.css" />" rel="stylesheet">

<!-- Favicons -->
<link rel="shortcut icon" href="<c:url value="/assets/user/ico/favicon.ico" />">

</head>
<body>
	<!-- 
	Upper Header Section 
-->
	<div class="navbar navbar-inverse navbar-fixed-top">
		
		<div class="topNav">
			<div class="container">
				<div class="alignR">	
					<div class="pull-left socialNw">
						<a href="#"><span class="icon-twitter"></span></a> <a href="#"><span
							class="icon-facebook"></span></a> <a href="#"><span
							class="icon-youtube"></span></a> <a href="#"><span
							class="icon-tumblr"></span></a>
					</div>
					<a class="active" href="index.html"> <span class="icon-home"></span>
						Home
					</a> <a href="#"><span class="icon-user"></span> My Account</a> <a
						href="register.html"><span class="icon-edit"></span> Free
						Register </a> <a href="contact.html"><span class="icon-envelope"></span>
						Contact us</a> <a href="cart.html"><span
						class="icon-shopping-cart"></span> 2 Item(s) - <span
						class="badge badge-warning"> $448.42</span></a>
				</div>
			</div>
		</div>
	</div>

	<!--
Lower Header Section 
-->
	<div class="container">
		<div id="gototop"></div>
		
		<%@include file="/WEB-INF/views/layouts/user/header.jsp" %>
		<div class="row">
			<%@include file="/WEB-INF/views/layouts/user/navigationList.jsp" %>
			<div class="span9">
				<div class="row">
					<div class="col-md-12">
						<!-- Advanced Tables -->
						<div class="panel panel-default">
							<div class="panel-heading">Matches</div>
							<div class="panel-body">
								<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover "id="dataTables-example">
									<thead>
									 <tr>
									 	<th class="text-center">TimeStart</th>
										<th class="text-center">Match day</th>
										<th class="text-center">League</th>
										<th class="text-center" style="width: 250px;text-align: center;">Match</th>
										<th class="text-center">Stadium</th>
										<th class="text-center">Buy Tickets</th>
									</tr>
									</thead>
									<tbody >
										<c:forEach items="${tranDau}" var="list">
											<tr class="odd gradeX text-center " >
												<td>${list.thoiGianBD}</td>
												<td>${list.ngayThiDau}</td>
												
												<td><img height="70" width="90" src="data:image/png;base64,${list.thamGiaGiai.giaiDau.base64Image}"/>
												</td>
												<td>
													<div style="display: flex;">
														<div>
															<div style="line-height: 150px">
																<img width="90" height="90"src="<c:url value="/resources/images/logo-barcelona-fc.png"/>">
															</div>
															<div style="text-align: center;">Barcelona</div>		
														</div>
														<div style="padding: 0 12px; line-height: 150px;font-size: 32px;">
															<span>vs</span>
														</div>
														<div>
															<div style="line-height: 150px">
																<img height="90" width="90" src="data:image/png;base64,${list.thamGiaGiai.doiBong.base64Image}"/>
															</div>
															<div style="text-align: center;">${list.thamGiaGiai.doiBong.tenDoi}</div>
																
														</div>
													</div>
												</td>
												<td>Nou camp stadium</td>
												<td><a href="/QLBV/tickets/buyTicket/${list.maTran}.htm">Buy</a></td>
											</tr>
										</c:forEach>

									</tbody>
								</table>
								</div>
							</div>
						</div>
						<!--End Advanced Tables -->
					</div>
				</div>
			</div>
		</div>
		
		
		<%@include file="/WEB-INF/views/layouts/user/footer.jsp" %>
		
	</div>
	<!-- /container -->

	<div class="copyright">
		<div class="container">
			<p class="pull-right">
				<a href="#"><img src="<c:url value="/assets/user/img/maestro.png"/>" alt="payment"></a>
				<a href="#"><img src="<c:url value="/assets/user/img/mc.png"/>" alt="payment"></a> <a
					href="#"><img src="<c:url value="/assets/user/img/pp.png"/>" alt="payment"></a> <a
					href="#"><img src="<c:url value="/assets/user/img/visa.png"/>" alt="payment"></a> <a
					href="#"><img src="<c:url value="/assets/user/img/disc.png"/>" alt="payment"></a>
			</p>
			<span>Copyright &copy; 2013<br> bootstrap ecommerce
				shopping template
			</span>
		</div>
	</div>
	<a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>
	<!-- Placed at the end of the document so the pages load faster -->
	<script src=" <c:url value="/assets/user/js/jquery.js" />"></script>
	<script src="<c:url value="/assets/user/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/assets/user/js/jquery.easing-1.3.min.js" />"></script>
	<script src="<c:url value="/assets/user/js/jquery.scrollTo-1.4.3.1-min.js" />"></script>
	<script src="<c:url value="/assets/user/js/shop.js" /> "></script>
	<!-- DATA TABLE SCRIPTS -->
	<script src="${url}/js/dataTables/jquery.dataTables.js"></script>
	<script src="${url}/js/dataTables/dataTables.bootstrap.js"></script>
	<script>
		$(document).ready(function() {
			$('#dataTables-example').dataTable();
		});
	</script>
</body>
</html>