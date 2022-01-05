<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url value="/assets/admin/static" var="url"></c:url>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddPlayer</title>
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
<script type="text/javascript" 
    src="<c:url value='/resources/ckeditor/ckeditor.js'/>">
</script>
<script type="text/javascript" 
src="<c:url value='/resources/ckfinder/ckfinder.js' />">
</script>
<script type="text/javascript">

function convertDataURIToBinary(dataURI) {
	var BASE64_MARKER = ';base64,';
	var base64Index = dataURI.indexOf(BASE64_MARKER) + BASE64_MARKER.length;
	var base64 = dataURI.substring(base64Index);
	var raw = window.atob(base64);
	var rawLength = raw.length;
	var array = new Uint8Array(new ArrayBuffer(rawLength));

	for(i = 0; i < rawLength; i++) {
		array[i] = raw.charCodeAt(i);
	}
	return array;
}
function readFile(evt) {
    var f = evt.target.files[0]; 

    if (f) {
		if ( /(jpe?g|png|gif)$/i.test(f.type) ) {
			var r = new FileReader();
			r.onload = function(e) { 
				var base64Img = e.target.result;
				var anh = convertDataURIToBinary(base64Img);
				var blob = new Blob([anh], {type: f.type});
				blobURL = window.URL.createObjectURL(blob);
				fileName = f.name;
				document.getElementById('nameImg').value = fileName;
				document.getElementById('typeImg').value = f.type;
				document.getElementById('sizeImg').value = f.size;
				document.getElementById('base64Url').value = base64Img;
				document.getElementById('blobUrl').value = blobURL;
				document.getElementById('base64Img').src = base64Img;
				document.getElementById('blobImg').src = blobURL;
				document.getElementById('anh').innerHTML = JSON.stringify(binaryImg, null, 2);
			}
			r.readAsDataURL(f);
		} else { 
			alert("Failed file type");
		}
    } else { 
		alert("Failed to load file");
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
						<h2>Edit User</h2>
						<h5>You can edit info user in here</h5>
					</div>
				</div>
				<!-- /. ROW  -->
				<hr />
				<div class="row">
					<div class="col-md-12">
						<!-- Form Elements -->
						<div class="panel panel-default">
							<div class="panel-heading">Add Player</div>
							<div class="panel-body">
							
									<div class="form-group row g-5">		
														
										<form:form method="post"  modelAttribute="player" action="${pageContext.request.contextPath }/views/admin/list-player.htm" enctype="multipart/form-data"  >
											
											<div class="col-md-5 col-lg-4 order-md-last">
												<h4 class="d-flex justify-content-between align-items-center mb-3"><span class="text-primary">Player </span></h4>
													
													<div class="row g-3">
														<div class="col-sm-6">
              												<label class="form-label">Number:</label>            											
     														<form:input class="form-control" path="soAo" />
													        <div class="invalid-feedback">Your number is required.</div>
														</div>
														<div class="col-sm-6">
              												<label  class="form-label">Location:</label>            											
     														<form:select path="viTri.maViTri" items="${ViTri}"
																	itemValue="maViTri" itemLabel="viTri"
																	class="form-control form-select-lg mb-6" aria-label="form-select-lg example">

															</form:select>  												          	
														</div>
            										</div>
            										<div class="col-12" >
            										   		<label for="image" class="form-label">Image:</label>
            										   		
															<p><img id="output" width="350" height="400"/></p>												
															<script>
															var loadFile = function(event) {
																var image = document.getElementById('output');
																image.src = URL.createObjectURL(event.target.files[0]);
															
															};
															</script>
															<form:input type="file" path="fileData" onchange="loadFile(event)()"/>			
	            										   
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
              													<div class="invalid-feedback">Please select name is required.</div>
            											</div>
            											
            											<div class="col-sm-6">
              												<label  class="form-label">ShirtName</label>
             													 <form:input class="form-control" path="tenAoDau" placeholder="Please enter last name"/>
              													<div class="invalid-feedback">Please select shirt's name is required.</div>
            											</div>           											            										         											            								
            										</div>
            										<div class="row g-3">
            											<div class="col-sm-6">
              												<label class="form-label">Birthday</label>             												
     															<form:input class="form-control" path="ngaySinh"/>  
     															<div class="invalid-feedback">Please select a valid.</div>													          
														</div>
														<div class="col-sm-6">
              												<label class="form-label">National</label>             												
     															<form:input class="form-control" path="noiSinh" placeholder="Please enter national"/>													          
														</div>
													</div>
													<div class="row g-3">
            											<div class="col-md-3">
              												<label  class="form-label">Height:</label>
              													<form:input class="form-control" path="chieuCao" placeholder="Please enter height."/>
              													<div class="invalid-feedback">Please select a valid.</div>
              											</div>
           												<div class="col-md-3">
              												<label  class="form-label">Weight:</label>
              													<form:input class="form-control" path="canNang" placeholder="Please enter weight."/>
              													
            											</div>
            											<div class="col-md-3">
															<label  class="form-label">Role:</label>
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
						<!-- End Form Elements -->
					</div>
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
	<script>
		var ckeditor=CKEDITOR.replace('tieuSu');
		CKFinder.setupCKEditor(ckeditor,'${pageContext.request.contextPath}/resources/ckfinder/');
	</script>
</body>
</html>