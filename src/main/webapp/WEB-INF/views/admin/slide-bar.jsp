<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url value="/assets/admin/static" var="url"></c:url>
<nav class="navbar-default navbar-side" role="navigation">
	<div class="sidebar-collapse">
		<ul class="nav" id="main-menu">
			<li class="text-center"><img src="${url}/img/find_user.png"
				class="user-image img-responsive" /></li>


			<li><a class="active-menu" href="#"><i
					class="fa fa-dashboard fa-3x"></i>Dashboard</a></li>
			<li><a
				href="${pageContext.request.contextPath }/views/admin/match/list-match.htm"><i
					class="fa fa-desktop fa-3x"></i> Matches Management</a>
				<ul class="nav nav-second-level">
					<li><a href="${pageContext.request.contextPath }/views/admin/match/list-match.htm">Add New Match</a></li>
					<li><a href="${pageContext.request.contextPath }/views/admin/match/list-match.htm">List All Matches</a></li>
				</ul></li>
				
				
			<li><a
				href="${pageContext.request.contextPath }/admin/player/list-player.htm"><i
					class="fa fa-qrcode fa-3x"></i> PLAYER Management</a>
					<ul class="nav nav-second-level">
					<li><a href="${pageContext.request.contextPath }/views/admin/add-player.htm">Add New Player</a></li>
					<li><a href="${pageContext.request.contextPath }/views/admin/list-player.htm">List All Players</a></li>
				</ul>
					</li>
			<li><a
				href="${pageContext.request.contextPath }/views/admin/tickets/list-ticket.htm"><i
					class="fa fa-bar-chart-o fa-3x"></i> Tickets Management</a></li>
					
			<li><a href="table.html"><i class="fa fa-table fa-3x"></i>
					Table Examples</a></li>
			<li><a href="form.html"><i class="fa fa-edit fa-3x"></i>
					Barca Clubs </a></li>


			
			<li><a href="blank.html"><i class="fa fa-square-o fa-3x"></i>
					Blank Page</a></li>
		</ul>

	</div>

</nav>