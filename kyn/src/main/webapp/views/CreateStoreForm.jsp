<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>

<!--  Enable Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>


	<div class="container">
	
		<div class="row">
		
			<h1> Submit Store Form </h1>
		</div>

		<div class="row">

			<div class="col-md-6">

				<form:form action="save_store" method="post" modelAttribute="store">
				
				<!-- for form update -->
						<form:hidden path="id" class="form-control" required="true" />
					<!-- -->
					
					<div class="form-group">
						<label for="name">Store Name</label>
						<form:input path="name" class="form-control" required="true" />
					</div>



					<div class="form-group">
						<label for="phoneNumber">Store Phone Number</label>
						<form:input path="phoneNumber" class="form-control"
							required="true" />
					</div>
					
					
					<div class="form-group">
						<label for="localities">Store location</label>
						<form:input path="localities" class="form-control" required="true" />

					</div>

					<input type="submit" value="Submit" class="btn btn-primary" />

				</form:form>
			</div>
		</div>

	</div>
</body>
</html>