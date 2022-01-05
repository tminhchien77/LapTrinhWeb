<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/assets/admin/static" var="url"></c:url>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
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
		document.getElementById("tranDau").value = IdMatch.options[IdMatch.selectedIndex].text +" vs Barcelona";
		}
	function loadPriceForId()
	{
		var Price = document.getElementById("giaApDung.maGiaApDung");
		document.getElementById("maGiaApDung").value = Price.options[Price.selectedIndex].value
		}
	
	function myFunction() {
		  var price = document.getElementById("giaApDung.maGiaApDung").value;		  
		  var number = document.getElementById("soLuongVeBan").value;
	
		  let x = document.forms["myForm"]["soLuongVeBan"].value;
		  let date = document.forms["myForm"]["ngayPhatHanh"].value;
		  if (x == "") {
			    alert("Number ticket cannot be empty. Please check again!");
			    return false;
			  }
		
		
		if(price== 1)
 		 {
			if (isNaN(number)||number >80000||number<0) {
				alert("Invalid normal tickets number!Maximum number of tickets is 80000");		
			    submitOK = "false";
			}
			else  submitOK = "true";			
				
		 }
		if(price== 2)
		 {
			if (isNaN(number)||0>number||number>14000) {
				alert("Invalid VIP tickets number! Maximum number of tickets is 14000");		
			    submitOK = "false";
			}	else  submitOK = "true";	
		 }
		if(price== 3)
		 {
			if (isNaN(number)||number >1000||number<0) {
				alert("Invalid SUPPERVIP tickets number!Maximum number of tickets is 1000");		
			    submitOK = "false";
			}	else  submitOK = "true";	
		 }
		  if (submitOK == "false") {
		    return false;
		  }
		}
	</script>
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
						<h2>Ticket</h2>
						<h5>You can add info ticket in here</h5>
						
						
					</div>
				</div>
				<!-- /. ROW  -->
				<div class="panel panel-default">
							
							<div class="panel-body">
							
									<div class="form-group row mb-2">		
											${message}				
										<form:form name="myForm" method="post" modelAttribute="ticket" action="${pageContext.request.contextPath }/views/admin/tickets/list-ticket.htm" onsubmit="return myFunction()">
											
												<div class="col-md-6">
												
            										<div class="col-12" >
              												<label for="CampNou" class="form-label text-center"> Stadium's CampNou</label>
              												<div class="mx-auto d-block form-group">
              													<img alt="" src="<c:url value="/resources/images/CampNou.png"/>" width="500" height="410" >
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
																	class="form-control form-select-lg mb-6" aria-label="form-select-lg example">
															 	</form:select> 
              												<div class="invalid-feedback">Please select first name is required.</div>
              													
            											</div>
            											<div class="col-sm-6">
              												<label class="form-label">Match </label>
             													 <input type="text" class="form-control" id="tranDau" name="tranDau" disabled>
             													 
              													
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
              															<label class="form-label">Release date:(YYYY/MM/DD)</label>           												   			
                  															<input class="form-control" id="ngayPhatHanh" name="ngayPhatHanh">                   													
                													</div>
            													<script type="text/javascript">
           														 $(function () {
              									  					$('#ngayPhatHanh').datetimepicker({
            															format: 'YYYY-MM-DD'
            																});
                
            															});
        														</script>
       														 
   												 		</div> 												 	
         										
            										
         											<div class="col-md-3">
          												<hr>
          												<button name="${btnStatus}" type="submit" class="btn btn-default">Save</button>
														<button type="reset" class="btn btn-primary">Reset</button>
														
          											</div> 
          											</div>
          											
          											        										
													
            							</form:form>
										      
									</div>
								</div>
							</div>
													
							<!-- Advanced Tables -->
								<div class="panel panel-default">
										
										<div class="bg-light p-5 rounded">
											<jsp:useBean id="pagedListHolder" scope="request"
												type="org.springframework.beans.support.PagedListHolder" />
												<c:url value="/views/admin/tickets/list-ticket.htm" var="pagedLink">
													<c:param name="p" value="~" />
												</c:url>
													<div>
														
														<tg:paging pagedListHolder="${pagedListHolder}"
															pagedLink="${pagedLink}" />
														
													</div>
												</div>
									
								<div class="panel-heading">Advanced Tables
								<div class="row g-3">
            						 <div class="col-sm-3">
              									<input class="form-control" placeholder="Nhập mã trận cần tìm" disabled >				            										         											            								
			            					</div>    
            						<div class="col-sm-6">
      										
             							 	<form class="d-inline-flex">
											<input name="searchInput" id="searchInput" class="form-control me-2" type="search"
											placeholder="Search" aria-label="Search">
											</form> 													 	
            						</div>  
            						<div class="col-sm-3">
              				
            						<button name="btnSearch" id="searchTicket"
											class="btn btn-success" type="submit">Search</button>							            										         											            								
            						</div>
            						
            					</div>
							</div>
							<div class="panel-body">
								${message}	
											<div class="table-responsive">											
											<table class="table table-striped table-bordered table-hover text-center"id="dataTables-example">
												<thead>
												 <tr>																						 
													<th class="text-center" >IdMatch</th>													
													<th class="text-center" >League</th>
													<th class="text-center" > Match</th>
													<th class="text-center" >Stadium's</th>
													<th class="text-center" >Type tickets</th>
													<th class="text-center" >Number tickets</th>
													<th class="text-center" >Release date</th>	
													<th class="text-center" >Action</th>													
												
													
												</tr>
												</thead>
											<tbody id="table_tickets">
												
												<c:forEach items="${pagedListHolder.pageList}" var="list">
													<tr class="odd gradeX">													
													<td> ${list.tranDau.maTran}</td>
													<td>${list.tranDau.thamGiaGiai.giaiDau.tenGiai}</td>
													<td><img width="90" height="70"src="<c:url value="/resources/images/logo-barcelona-fc.png"/>"><label>${list.tranDau.thoiGianBD}
													<br>${list.tranDau.ngayThiDau}</label><img width="90" height="70"src="data:image/png;base64,${list.tranDau.thamGiaGiai.doiBong.base64Image}"/>
													<br class="text-center">Barcelona's Vs ${list.tranDau.thamGiaGiai.doiBong.tenDoi}</td>	
													
													<td class="text-center" >CampNou</td>
													<td>${list.giaApDung.loaiVe.tenLoai}</td>
													<td>${list.soLuongVeBan}</td>
													<td>${list.ngayPhatHanh}</td>
													

													<td><a href="${pageContext.request.contextPath }/views/admin/tickets/edit-ticket/${list.maVe_Tran}.htm?linkEdit"><img width="30" height="30"
															src="<c:url value="/resources/images/edit.png"/>"></a>
														<a href="${pageContext.request.contextPath }/views/admin/tickets/list-tickets/${list.maVe_Tran}.htm?linkDelete"role="button"><img width="30" height="30"
															src="<c:url value="/resources/images/delete.png"/>"></a>
														
													
												</tr>
											</c:forEach>

										</tbody>
									</table>
								</div>
								</div>
								</div>
								
								
		
							</div>
				<hr />
				
						</div>
						<!-- End Form Elements -->
					</div>
				</div>
				<!-- /. ROW  -->
				<div class="row">
					<div class="col-md-12"></div>
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
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('#searchTicket').click(function(event) {
				event.preventDefault();
				var searchProductname = $("#searchInput").val();
				alert(searchProductname);
				//searchViaAjax();
				$.ajax({
					type : 'GET',
					//contentType : "application/json",
					url : '/views/admin/tickets/list-ticket.htm',
					//data : JSON.stringify(searchProductname),
					//dataType : 'json',
					success : function(result) {
						alert(result);
						$('#result1').text(result);
						 var result = JSON.parse(result);
						var s = '';
						for (var i = 0; i < result.length; i++) {
							s += '<tr>';
							s += '<td>' + result[i].tranDau.maTran + '</td>';
							s += '<td>' + result[i].tranDau.thamGiaGiai.giaiDau.tenGiai+ '</td>';
							s += '<td>' + "Barcelona Vs"+ result[i].tranDau.thamGiaGiai.doiBong.tenDoi
									+ '</td>';
							s += '<td>' + result[i].giaApDung.loaiVe.tenLoai + '</td>';
							s += '<td>' + result[i].soLuongVeBan + '</td>';
							s += '<td>' + result[i].ngayPhatHanh + '</td>';
							s += '</tr>';
						}
						$('#table_tickets').html(s); 
					}
				});
			});

		});
		
	
	</script>

 
	<!-- <script src="../assets/dist/js/bootstrap.bundle.min.js"></script> -->
	<script
		src="<c:url value='/resources/assets/dist/js/bootstrap.bundle.min.js' />"></script>

	<script>
		function searchValue() {
			//event.preventDefault();
			var searchProductname = $("#searchInput").val();
			alert(searchProductname)
		}
	</script>

</body>
</html>