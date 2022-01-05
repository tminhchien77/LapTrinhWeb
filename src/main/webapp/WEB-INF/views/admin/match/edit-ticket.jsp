<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/assets/admin/static" var="url"></c:url>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddTickets</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- Date -->
 	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <link href="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/build/css/bootstrap-datetimepicker.css" rel="stylesheet">


		<script type="text/javascript" src="//code.jquery.com/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment-with-locales.js"></script>
		<script src="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/src/js/bootstrap-datetimepicker.js"></script>


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


<script type="text/javascript">

	function loadMatchForId()
	{
		var IdMatch = document.getElementById("tranDau.maTran");		
		document.getElementById("tranDau").value = IdMatch.text +" vs Barcelona";
		}
	function loadPriceForId()
	{
		var Price = document.getElementById("giaApDung.maGiaApDung");
		document.getElementById("maGiaApDung").value = Price.options[Price.selectedIndex].value
		}
	
	function myFunction() {
		  var price = document.getElementById("giaApDung.maGiaApDung").value;		  
		  var number = document.getElementById("soLuongVeBan").value;
		  var date = document.getElementById("ngayPhatHanh").value;
		  
		  submitOK = "true";
		if(isNaN(number))
			{
				alert("Ticket number cannot be empty. Please check again!");		
		    	submitOK = "false";
			}
		if(isNaN(date))
		{
			alert("Date cannot be empty. Please check again!");		
	    	submitOK = "false";
		}
		if(price== 1)
		 {
			if (isNaN(number)||0<number >80000||number<0) {
				alert("Invalid normal tickets number!Maximum number of tickets is 80000");		
			    submitOK = "false";
			}
		 }
		if(price== 2)
		 {
			if (isNaN(number)||0<number||number>1400) {
				alert("Invalid VIP tickets number! Maximum number of tickets is 14000");		
			    submitOK = "false";
			}
		 }
		if(price== 3)
		 {
			if (isNaN(number)||number >1000||number<0) {
				alert("Invalid SUPPERVIP tickets number!Maximum number of tickets is 1000");		
			    submitOK = "false";
			}
		 }
		  if (submitOK == "false") {
		    return false;
		  }
		}
	</script>
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
						<h2>Edit Ticket</h2>
						<h5>You can edit info ticket in here</h5>
						
						
					</div>
				</div>
				<!-- /. ROW  -->
				
				<div class="panel-body">
					${message}	
											<div class="table-responsive">
											<table class="table table-striped table-bordered table-hover text-center"id="dataTables-example">
												<thead>
												 <tr>												 
												
													<th class="text-center" >League</th>
													<th class="text-center" > Match</th>
													<th class="text-center" >Stadium's</th>
													
												</tr>
												</thead>
											<tbody>
												<form:form modelAttribute="match" >
													<tr class="odd gradeX">
													
													<td><img height="70" width="90" src="data:image/png;base64,${match.thamGiaGiai.giaiDau.base64Image}"/>
													<br>${match.thamGiaGiai.giaiDau.tenGiai}</td>
													<td><img width="90" height="70"src="<c:url value="/resources/images/logo-barcelona-fc.png"/>"><label>${match.timeStart}
													<br>${match.ngayThiDau}</label><img width="90" height="70"src="data:image/png;base64,${match.thamGiaGiai.doiBong.base64Image}"/>

													<br class="text-center">Barcelona's Vs ${match.thamGiaGiai.doiBong.tenDoi}</td>			
													
													<td class="text-center" >CampNou</td>
												</tr>
											</form:form>

										</tbody>
									</table>
								</div>

							</div>
				<hr />
				<div class="row">
					<div class="col-md-12">
						<!-- Form Elements -->
						<div class="panel panel-default">
							<div class="panel-heading"> Ticket</div>
							<div class="panel-body">
							
									<div class="form-group row mb-2">		
											${message}				
										<form:form method="post" modelAttribute="ticket" action="${pageContext.request.contextPath }/views/admin/tickets/list-ticket.htm" onsubmit="return myFunction()">
											
											<div class="col-md-6">
												
            										<div class="col-12" >
              												<label for="CampNou" class="form-label text-center">SVĐ CampNou</label>
              												<div class="mx-auto d-block form-group">
              													<img alt="" src="<c:url value="/resources/images/CampNou.png"/>" width="560" height="450" >
              												</div>
     																			
            										</div>                  																			
											</div>	
																					
											<div class="col-md-6 ">
												<h4 class="d-flex justify-content-between align-items-center mb-3" ><span class="text-primary">Information Tickets</span></h4>	
        									 	
         											<div class="row g-3">
            											<div class="col-sm-3">
              												<label  class="form-label">Team</label>
             													 <form:select path="tranDau.maTran" items="${Match}" onchange="loadMatchForId()" 
																	itemValue="maTran" itemLabel="thamGiaGiai.doiBong.tenDoi" 
																	class="form-control form-select-lg mb-6" aria-label="form-select-lg example" >
															 	</form:select> 
              												<div class="invalid-feedback">Please select first name is required.</div>
              													
            											</div>
            											<div class="col-sm-6">
              												<label class="form-label">Match </label>
             													 <input type="text" class="form-control" id="Match" name="Match"  disabled>
             													 
              													
              													<div class="invalid-feedback">Please select last name is required.</div>
            											</div>
            											
            																			            										         											            								
            										</div>
            										     
            										<div class="row g-3">
            											<div class="col-sm-3">
              												<label  class="form-label">Ticket type:</label>
             												  <form:select path="giaApDung.maGiaApDung" items="${PriceCode}" onchange="loadPriceForId()" 
																	itemValue="maGiaApDung" itemLabel="loaiVe.tenLoai" 
																	class="form-control form-select-lg mb-6" aria-label="form-select-lg example">
															</form:select>  
            											</div>
            											<div class="col-sm-3">
              												<label class="form-label">Number:</label>
             														<form:input path="soLuongVeBan" class="form-control" />
            											</div>     
            											<div class="col-sm-3">
            													<label class="form-label">CodePrice:</label>
              												 		<input class="form-control" id="maGiaApDung" name="maGiaApDung" disabled>
             													 	          													 	
            												</div>     											            										         											            								
            										</div>
            										
    											
      												 <div class="row g-3">
      													    	
      													    		<div class="col-sm-6">
              															<label class="form-label">Release date (YYYY/MM/DD):</label>
             												   			<div class=' input-group date' id='dtpickerdemo'>
                  															<form:input class="form-control" path="ngayPhatHanh"/>
                    															<span class="input-group-addon">
                       																 <span class="glyphicon glyphicon-calendar"></span>
                   																</span>
                														</div>
                													</div>
            													
       														 <script type="text/javascript">
           														 $(function () {
              									  					$('#dtpickerdemo').datetimepicker({
            															format: 'YYYY-MM-DD'
            																});
                
            															});
        														</script>
   												 		</div>
   												 		
          											<div class="col-sm-6">
          												<hr>
          												<button name ="${btnStatus}" type="submit" class="btn btn-default">Save</button>
														<button type="reset" class="btn btn-primary">Reset</button>
          											</div> 
            										</div>
            									</form:form>
										      
									</div>
								</div>
							</div>
						</div>
						<!-- End Form Elements -->
					</div>
				</div>
				</div>
				</div>
				<!-- /. ROW  -->
			
			<!-- /. PAGE INNER  -->
		
	<!-- /. WRAPPER  -->
	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script src="${url}/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="${url}/js/bootstrap-min.js"></script>
	<!-- METISMENU SCRIPTS -->
	<script src="${url}/js/jquery-metisMenu.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="${url}/js/custom.js"></script>
	
</body>
</html>