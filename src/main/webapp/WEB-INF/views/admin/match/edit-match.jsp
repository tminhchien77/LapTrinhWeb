<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/assets/admin/static" var="url"></c:url>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>ListMatch</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
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
</head>
<body>

	<div id="wrapper">
		<jsp:include page="/WEB-INF/views/admin/nav-bar.jsp"></jsp:include>
		<!-- /. NAV TOP  -->
		<jsp:include page="/WEB-INF/views/admin/slide-bar.jsp"></jsp:include>
		<!-- /. NAV SIDE  -->
		
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h2>List Match</h2>
						<h5>You can edit , add, delete Match</h5>
					</div>
				</div>
			<hr />
				<div class="row">
					<div class="col-md-12">
						<!-- Form Elements -->
						<div class="panel panel-default">
							<div class="panel-heading"> MATCH</div>
							<div class="panel-body">
									<div class="form-group row g-5">		
													
										${message}	
										<form:form method="post" modelAttribute="match" action="${pageContext.request.contextPath }/views/admin/match/list-match.htm"  >
										
													<div class="table-responsive">
															<table class="table table-striped table-bordered table-hover text-center"id="dataTables-example">
																<thead>
																 <tr>												 
																	<th class="text-center" >idMatch</th>
																	<th class="text-center" >League</th>
																	<th class="text-center" > Match</th>
																	<th class="text-center" >Stadium's</th>
																	
																</tr>
																</thead>
															<tbody>
																<form:form modelAttribute="match" >
																	<tr class="odd gradeX">
																	<td class="text-center" >${match.maTran}</td>
																	<td><img height="70" width="90" src="data:image/png;base64,${match.thamGiaGiai.giaiDau.base64Image}"/>
																	<br>${match.thamGiaGiai.giaiDau.tenGiai}</td>
																	<td><img width="90" height="70"src="<c:url value="/resources/images/logo-barcelona-fc.png"/>"><label>${match.thoiGianBD}
																	<br>${match.ngayThiDau}</label><img width="90" height="70"src="data:image/png;base64,${match.thamGiaGiai.doiBong.base64Image}"/>
				
																	<br class="text-center">Barcelona's Vs ${match.thamGiaGiai.doiBong.tenDoi}</td>			
																	
																	<td class="text-center" >CampNou</td>
																</tr>
															</form:form>
				
														</tbody>
													</table>
												</div>
							
							
												<div class="col-md-5 col-lg-4 order-md-last">
												<h4 class="d-flex justify-content-between align-items-center mb-3"><span class="text-primary">Matches </span></h4>
													
													<div class="row g-3">
														<div class="col-sm-6">
              												<label  class="form-label">IdMatch:</label>            											
     														<form:input path="maTran" class="form-control" />
													        <div class="invalid-feedback">Your idMatch is required.</div>
														</div>
														<div class="col-sm-6">
              												<label  class="form-label">IdTeam join League:</label>            											
     														<form:input class="form-control" path="thamGiaGiai.maDoiDauGiai"/>
													        <div class="invalid-feedback">Your idMatch is required.</div>
														</div>
														
            										</div>
            										<div class="row g-3">
														<div class="col-sm-3">
              												<label for="home" class="form-label" >Home:</label>            											
     														<form:checkbox path="nhaKhach" value="1" class="form-control"/>
														</div>
														<div class="col-sm-3">
              												<label for="away" class="form-label"> Away:</label>            											
     														<form:checkbox path="nhaKhach" value="0" class="form-control"/>												          	
														</div>
														<div class="col-sm-6">
              												<label class="form-label">TimeStart:</label>            											
     														<form:input path="thoiGianBD" class="form-control"/>		  											          	
														</div>
            										
            										</div>
            									         																			
											</div>	
																					
											<div class="col-md-7 col-lg-8">
												<h4 class="d-flex justify-content-between align-items-center mb-3" ><span class="text-primary">Information</span></h4>	
        									 	
         											<div class="row g-3">
            											<div class="col-sm-6">
              												<label for="lastName" class="form-label">First Team</label>
             													<form:input  class="form-control"  path="" placeholder="Please enter first team " value="Barcelona" />
              													<div class="invalid-feedback">Please select first name is required.</div>
            											</div>
            											<div class="col-sm-6">
              												<label for="lastName" class="form-label">Second Team</label>
             													 	<input  class="form-control"  value="${match.thamGiaGiai.doiBong.tenDoi}" />
              													<div class="invalid-feedback">Please select second team is required.</div>
            											</div>            											            										         											            								
            										</div>
            										<div class="row g-3">
            											<div class="col-sm-6">
              												<label for="birthday" class="form-label">Date Match:</label>             												
     																<form:input  class="form-control" path ="ngayThiDau"/>
     															<div class="invalid-feedback">Please select a valid.</div>													          
														</div>
														<!--  
														<div class="col-sm-6">
              												<label for="national" class="form-label"> Stadium :</label>             												
     															<input type="text" class="form-control" id="stadium" placeholder="" >
     																											          
														</div> 
														-->
													</div>
												
													</div>
          											<div class="col-md-3">
          												<hr>
          												<button name="${btnStatus}" type="submit" class="btn btn-default">Save</button>
														<button type="reset" class="btn btn-primary">Reset</button>
														
          											</div>         										
														
          										</form:form>
    										</div>
									</div>
					
								</div>
							</div>
						</div>
						<!-- End Form Elements -->
					</div>
				</div>
				<!-- /. ROW  -->
				<div class="row">
					<div class="col-md-12"></div>
				</div>
				<!-- /. ROW  -->
				</div>
						

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

</body>
</html>