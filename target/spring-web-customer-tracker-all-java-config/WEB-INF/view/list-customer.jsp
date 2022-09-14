<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.luv2code.springdemo.utils.SortUtil"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cutomer Relational Mapping</title>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/fontawesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/solid.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/brands.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/v5-font-face.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">CRM</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarColor03"
				aria-controls="navbarColor03" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarColor03">
				<ul class="navbar-nav me-auto">
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/customer/list">Customer
							list</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container mt-4 mb-4">
		<h2>All customers</h2>
		<div class="row">
			<div class="col-6">
				<a href="${pageContext.request.contextPath}/customer/add"
					class="text-decoration-none">
					<button type="button" class="btn btn-success">
						<i class="fa fa-plus"></i>Add
					</button>
				</a>
			</div>

			<div class="col-6">
				<form action="${ pageContext.request.contextPath }/customer/search" method="get">
					<div class="row">
						<div class="col-10">
							<div class="form-group pull-right">
								<input type="text" class="search form-control" name="filter"
									placeholder="What you looking for?" value="${ filter }">
							</div>
						</div>
						<div class="col-2">
							<button type="submit" class="btn btn-default">Search</button>
						</div>
					</div>
				</form>
			</div>
		</div>

		<div class="row">
			<table class="table table-hover">
				<thead>
					<c:url var="searchFirstNameUrl" value="/customer/list">
						<c:param name="sort"
							value="<%=Integer.toString(SortUtil.FIRST_NAME)%>" />
					</c:url>
					<c:url var="searchLastNameUrl" value="/customer/list">
						<c:param name="sort"
							value="<%=Integer.toString(SortUtil.LAST_NAME)%>" />
					</c:url>
					<c:url var="searchEmailUrl" value="/customer/list">
						<c:param name="sort" value="<%=Integer.toString(SortUtil.EMAIL)%>" />
					</c:url>
					<tr>
						<th scope="col">#</th>
						<th scope="col"><a href="${ searchFirstNameUrl }">First
								Name</a></th>
						<th scope="col"><a href="${ searchLastNameUrl }">Last
								Name</a></th>
						<th scope="col"><a href="${ searchEmailUrl }">Email</a></th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ customers }" var="customer">

						<c:url var="updateLink" value="/customer/${customer.id}/edit" />
						<c:url var="deleteLink" value="/customer/${customer.id}/delete" />

						<tr class="table-dark">
							<th scope="row">${ customer.id }</th>
							<td>${ customer.firstName }</td>
							<td>${ customer.lastName }</td>
							<td>${ customer.email }</td>
							<td>
								<div class="row">
									<div class="col-2">
										<a href="${updateLink}">
											<button type="button" class="btn btn-primary">
												<i class="fa fa-edit"></i>
											</button>
										</a>
									</div>
									<div class="col-2">
										<a href="${deleteLink}"
											onclick="return confirm('Are you sure you want to delete this customer ?');">
											<button type="button" class="btn btn-danger">
												<i class="fa fa-trash"></i>
											</button>
										</a>
									</div>
									<div class="col-8"></div>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/fontawesome.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/solid.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/brands.min.js"></script>
</body>
</html>