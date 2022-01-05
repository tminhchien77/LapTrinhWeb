<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8"%>
<c:url value="/assets/admin/static" var="url"></c:url>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>EditPlayer</title>
<base href="${pageContext.servletContext.contextPath}">
<meta charset="UTF-8">
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
<script type="text/javascript" 
    src="<c:url value='/resources/ckeditor/ckeditor.js'/>">
</script>
<script type="text/javascript" 
src="<c:url value='/resources/ckfinder/ckfinder.js' />">
</script>
<script type="text/javascript">
let base64String = "";

function imageUploaded() {
    var file = document.querySelector(
        'input[type=file]')['files'][0];
  
    var reader = new FileReader();
    console.log("next");
      
    reader.onload = function () {
        base64String = reader.result.replace("data:", "")
            .replace(/^.+,/, "");
  
        imageBase64Stringsep = base64String;
  
        // alert(imageBase64Stringsep);
        console.log(base64String);
    }
    reader.readAsDataURL(file);
}
function displayString() {
    console.log("Base64String about to be printed");
    alert(base64String);
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
						<h2>Edit Player</h2>
						<h5>You can edit info user in here</h5>
					</div>
				</div>
				<!-- /. ROW  -->
				<hr />
				<div class="row">
					<div class="col-md-12">
						<!-- Form Elements -->
						<div class="panel panel-default">
							<div class="panel-heading">Info you can change</div>
							<div class="panel-body">
								<div class="row">
									
									<c:url value="/views/admin/list-player.htm" var="edit"></c:url>
										<div class="form-group row g-5">		
											${message}			
										<form:form  method="post"  modelAttribute="player" action="${pageContext.request.contextPath }/views/admin/list-player.htm">
											
											<div class="col-md-5 col-lg-4 order-md-last">
												<h4 class="d-flex justify-content-between align-items-center mb-3"><span class="text-primary">Player </span></h4>
													<div class="row g-3">
													
														<div class="form-group col-sm-6">
															<label class="form-label"> Number:</label> 
															<form:input path="soAo" class="form-control" />
															
														</div>
														<div class="col-sm-6">
              												<label class="form-label">Location:</label>      
              												<form:input path="viTri.maViTri" class="form-control" />
														</div>
            										</div>
            										<div class="mx-auto d-block form-group">
              													<img src="data:image/png;base64,${player.base64Image}" width="360" height="320" >
              										</div>
            										<div class="form-group">
														<input type="file" name="anh"  onchange="imageUploaded()">
														
													</div>
            										<div class="row col-md-6">
          												<hr>
          												<button name="${btnStatus}" type="submit" class="btn btn-success">Save</button>
														<button type="reset" class="btn btn-primary">Reset</button>
          											</div>        															
											</div>	
																					
											<div class="col-md-7 col-lg-8">
												<h4 class="d-flex justify-content-between align-items-center mb-3" ><span class="text-primary">Information</span></h4>	
        									 	
         											
         											<div class="row g-3">
            											<div class="col-sm-6">
              												<label class="form-label">Name</label>
             													 <form:input class="form-control" path="hoTen" placeholder="Please enter first name "/>
              													<div class="invalid-feedback">Please select first name is required.</div>
            											</div>
            											
            											<div class="col-sm-6">
              												<label  class="form-label">ShirtName</label>
             													 <form:input class="form-control" path="tenAoDau" placeholder="Please enter last name"/>
              													<div class="invalid-feedback">Please select last name is required.</div>
            											</div>           											            										         											            								
            										</div>
            										<div class="row g-3">
            											<div class="col-sm-6">
              												<label class="form-label">Birthday: (yyyy/mm/dd)</label>             												
     															<form:input path="ngaySinh" class="form-control" />										          
														</div>
														
														<div class="col-sm-6">
              												<label class="form-label">National:</label>             												
     															<form:input path="noiSinh" class="form-control" />
     															</div>
													</div>
													<div class="row g-3">
            											<div class="col-md-3">
              												<label class="form-label">Height(cm):</label>
              													<form:input path="chieuCao" class="form-control" />
              											</div>
           												<div class="col-md-3">
              												<label  class="form-label">Weight(kg):</label>
              													<form:input path="canNang" class="form-control" />
            											</div>
            										
            										<div class="col-md-3">
															<label for="chieuCao" class="form-label">Role:</label>
																<form:select path="vaiTro.maVaiTro" items="${VaiTro}"
																	itemValue="maVaiTro" itemLabel="vaiTro"
																	class="form-control form-select-lg mb-6" aria-label="form-select-lg example">

																</form:select>  
            											</div> 
            											<div class="col-md-3">
              												<label class="form-label">DateJoin CLB:</label>
              													<form:input class="form-control" path="ngayRaMat"/>
              													
            											</div>   
            											
            											</div>
            											<div class="form-floating">
															<label  class="form-label">Description: </label>
															  <form:textarea path="tieuSu" class="form-control" rows="5" cols="1" />
														</div> 
            										</div>
            										
            										
            										
																				
												</form:form>
    										</div>							
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
	<script type="text/javascript"
		src="<c:url value='/resources/ckfinder/ckfinder.js' />">
	</script>
	<script>
		var ckeditor=CKEDITOR.replace('tieuSu');
		CKFinder.setupCKEditor(ckeditor,'${pageContext.request.contextPath}/resources/ckfinder/');
	</script>

</body>
</html>