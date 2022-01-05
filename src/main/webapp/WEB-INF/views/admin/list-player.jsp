<%@page import="qlbvsb.Entity.CauThu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
 
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:url value="/assets/admin/static" var="url"></c:url>

<!DOCTYPE html>
<html>
<head>
<title>ListPlayer</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.80.0">
<!-- BOOTSTRAP STYLES-->
<link href="${url}/css/bootstrap.css"  rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="${url}css/font-awsome.css" rel="stylesheet" />
<!-- MORRIS CHART STYLES-->
<link href="${url}/js/morris/morris.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="${url}/css/custom.css"  rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<!-- TABLE STYLES-->
<link href="${url}/js/dataTables/dataTables.bootstrap.css"
	rel="stylesheet" />
	
<!-- Thêm  -->

	<base href="${pageContext.request.contextPath}/">
<link rel="canonical"
	href="https://getbootstrap.com/docs/5.0/examples/starter-template/">

</head>
<body>
	
		<jsp:include page="/WEB-INF/views/admin/nav-bar.jsp"></jsp:include>

		<!-- /. NAV TOP  -->
		<jsp:include page="/WEB-INF/views/admin/slide-bar.jsp"></jsp:include>
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h2>List Player</h2>
						<h5>You can edit , add, delete User</h5>

					</div>
				</div>
				
				<!-- /. ROW- COPY  -->
				
			<div class="bg-light p-5 rounded">
			<jsp:useBean id="pagedListHolder" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />
			<c:url value="/views/admin/list-player.htm" var="pagedLink">
				<c:param name="p" value="~" />
			</c:url>
				<div>
					
					<tg:paging pagedListHolder="${pagedListHolder}"
						pagedLink="${pagedLink}" />
					
				</div>
			</div>
									

			<div class="panel panel-default">
							<div class="panel-heading">Advanced Tables
								
							</div>
							
							<div class="panel-body">
								<div class="table-responsive">
								
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>
												<th class="text-center" >Number</th>
												<th class="text-center" >Image</th>
												<th class="text-center" >User Name</th>
												<th class="text-center" >Shirt Name</th>
												<th class="text-center" >Birthday</th>
												<th class="text-center" >National</th>
												<th class="text-center" > Weight (kg) </th>
												<th class="text-center" >Height (cm)</th>
												<th class="text-center" >Joining Date</th>
												<th class="text-center" >Story</th>
												<th class="text-center" >Location</th>
												<th class="text-center" >Action</th>
											</tr>
										</thead>
						<tbody>
							<c:forEach var="list" items="${pagedListHolder.pageList}">
		
								<tr class="odd gradeX">
													<td>${list.soAo }</td>
													<td><img  src="data:image/png;base64,${list.base64Image}" width="70" height="70" ></td>	
													<td>${list.hoTen }</td>
													<td>${list.tenAoDau }</td>
													<td>${list.ngaySinh }</td>
													<td>${list.noiSinh }</td>
													<td>${list.canNang }</td>
													<td>${list.chieuCao }</td>
													<td>${list.ngayRaMat }</td>
													<td>${list.tieuSu }</td>
													<td class="center">${list.viTri.maViTri}</td>
												
														 <td><a  href="${pageContext.request.contextPath }/views/admin/edit-player/${list.soAo}.htm?linkEdit"><img width="30" height="30"
															src="<c:url value="/resources/images/edit.png"/>"></a>
														<a href="${pageContext.request.contextPath }/views/admin/delete-player/${list.soAo}.htm?linkDelete"role="button"><img width="30" height="30"
															src="<c:url value="/resources/images/delete.png"/>"></a></td>
														

												</tr>
					</c:forEach>
				</tbody>
				</table>
				<tg:paging pagedListHolder="${pagedListHolder}"
					pagedLink="${pagedLink}" />

			</div>
				
				<hr />

				</div>
				</div>
				</div>

			</div>

		</div>
		<!-- /. PAGE INNER  -->

	<!-- /. PAGE WRAPPER  -->
	<!-- /. WRAPPER  -->
	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script src="${url}/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="${url}/js/bootstrap.min.js"></script>
	<!-- METISMENU SCRIPTS -->
	<script src="${url}/js/jquery.metisMenu.js"></script>
	<!-- DATA TABLE SCRIPTS -->
	<script src="${url}/js/dataTables/jquery.dataTables.js"></script>
	<script src="${url}/js/dataTables/dataTables.bootstrap.js"></script>
	<script>
		$(document).ready(function() {
			$('#dataTables-example').dataTable();
		});
	</script>
	<!-- CUSTOM SCRIPTS -->
	<script src="${url}/js/custom.js"></script>
	<script>
		function searchValue() {
			//event.preventDefault();
			var searchPlayer = $("#searchInput").val();
			alert(searchPlayer)
		}
	</script>

</body>
</html>
