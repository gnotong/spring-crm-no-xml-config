<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Add customer</title>
<link rel="stylesheet" type="text/css"
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

	<div class="container">
		<h1>Save customer</h1>
		<form:form action="${pageContext.request.contextPath}/customer/save"
			modelAttribute="customer" method="POST">

			<!-- Bind id to the customer if exists -->
			<form:hidden path="id"/>

			<div class="form-group">
				<label for="firstName">First Name</label>
				<form:input path="firstName" cssClass="form-control"/>
			</div>
			<div class="form-group">
				<label for="lastName">Last Name</label>
				<form:input path="lastName" cssClass="form-control"/>
			</div>
			<div class="form-group">
				<label for="email">Email</label>
				<form:input path="email" cssClass="form-control"/>
			</div>
			<button type="submit" class="btn btn-primary">Save</button>
		</form:form>
	</div>
</body>
</html>