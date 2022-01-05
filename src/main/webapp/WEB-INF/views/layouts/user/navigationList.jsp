<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<!-- 
Body Section 
-->
	
	<div id="sidebar" class="span3">
		<div class="well well-small">
			<ul class="nav nav-list">
				<li><a href="match.html"><span class="icon-chevron-right"></span>Matchs</a></li>
				<li><a href="Tournaments.html"><span class="icon-chevron-right"></span>Champions League</a></li>
				<li><a href="Tournaments.html"><span class="icon-chevron-right"></span>LaLiga</a></li>
				<li><a href="Tournaments.html"><span class="icon-chevron-right"></span>Copa del Rey</a></li>
				<li><a href="photos-team.html"><span class="icon-chevron-right"></span>Photos Teams</a></li>
				<li><a href="player.html"><span class="icon-chevron-right"></span>Player</a></li>
				
				<li style="border:0"> &nbsp;</li>
				<li> <a class="totalInCart" href="cart.html"><strong>Total Amount  <span class="badge badge-warning pull-right" style="line-height:18px;">$448.42</span></strong></a></li>
			</ul>
		</div>

		<div class="well well-small alert alert-warning cntr">
			  <h2>50% Discount</h2>
			  <p> 
				 only valid for online order. <br><br><a class="defaultBtn" href="#">Click here </a>
			  </p>
		</div>
		<div class="well well-small" ><a href="#"><img src="assets/user/img/paypal.jpg" alt="payment method paypal"></a></div>
			
			<a class="shopBtn btn-block" href="#">Upcoming products <br><small>Click to view</small></a>
			<br>
			<br>
			<ul class="nav nav-list promowrapper">
			<li>
			  <div class="thumbnail">
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<img alt="bootstrap ecommerce templates" src="assets/user/img/image1.png">
				
				<div class="caption">
				  <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span class="pull-right">$22.00</span></h4>
				</div>
			  </div>
			</li>
			<li style="border:0"> &nbsp;</li>
			<li>
			  <div class="thumbnail">
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<img src="assets/user/img/shopping-cart-template.PNG" alt="shopping cart template">
				<div class="caption">
				  <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span class="pull-right">$22.00</span></h4>
				</div>
			  </div>
			</li>
			<li style="border:0"> &nbsp;</li>
			<li>
			  <div class="thumbnail">
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<img src="assets/user/img/bootstrap-template.png" alt="bootstrap template">
				<div class="caption">
				  <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span class="pull-right">$22.00</span></h4>
				</div>
			  </div>
			</li>
		  </ul>

	</div>
	
<!-- Slides
	 -->
	<div class="span9">
			<div class="well np">
				<div id="myCarousel" class="carousel slide homCar">
					<div class="carousel-inner">
						<c:forEach var="item" items="${ slides }" varStatus="index">
							<c:if test="${ index.first }">
								<div class="item active">
							</c:if>
							<c:if test="${ not index.first }">
								<div class="item">
							</c:if>
							<img style="width: 100%"
								src="<c:url value="/assets/user/img/slide/${item.img }"/>"
								alt="bootstrap ecommerce templates">
							<div class="carousel-caption">
								<h4>${ item.caption }</h4>
								<p>
									<span>${ item.content }</span>
								</p>
							</div>
					</div>
					</c:forEach>
				</div>

				<a class="left carousel-control" href="#myCarousel"
					data-slide="prev">&lsaquo;</a> <a class="right carousel-control"
					href="#myCarousel" data-slide="next">&rsaquo;</a>
			</div>
	</div>
  </div>