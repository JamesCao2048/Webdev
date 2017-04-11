<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title> Main Page</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

	<!-- Latest compiled and minified JavaScript -->
	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.2.4.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.2.4.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

	<s:url value="/resources/my.css" var="myCss" />
	<link href="${myCss}" rel="stylesheet" />
</head>
<body>
<header>
	<ul class="nav nav-pills nav-justified">
		<li role="presentation" class="active"><a href="<c:url value='/'/>">Home</a></li>
		<li role="presentation"><a href="<c:url value='/book'/>">Book</a></li>
		<li role="presentation"  > <a href="<c:url value='/book/cart/viewcart'/>">Cart</a> </li>
		<li role="presentation"  > <a href="<c:url value='/book/order/vieworder'/>">Order</a> </li>
		<li role="presentation" > <a href="<c:url value='/adm'/>">Adm</a> </li>
	</ul>
</header>
<h1>Welcome To Junming's BookStore! </h1>
<div class="btn-group-vertical" role="group" aria-label="...">
	<button type="button" class="btn btn-default op" data-toggle="modal" data-target="#login">Login</button>
	<button type="button" class="btn btn-default op" data-toggle="modal" data-target="#register">Register</button>
	<a href="<c:url value='/logouter'/>">Logout</a>
</div>
<div class="modal fade" id="login" tabindex="-2" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog modal-sm" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h3>Login</h3>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" method="post" action="<c:url value='/login'/>">
					<div class="form-group">
						<label for="unlg" class="control-label col-sm-3">UserId</label>
						<div class="col-sm-9">
							<input type="text" name="id" id="unlg" class="form-control" placeholder="userid">
						</div>
					</div>
					<div class="form-group">
						<label for="pslg" class="control-label col-sm-3">Password</label>
						<div class="col-sm-9">
							<input type="password" name="password" id="pslg" class="form-control" placeholder="password">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-9">
							<input type="hidden" name="${_csrf.parameterName}"  class="form-control" value="${_csrf.token}">
						</div>
					</div>
					<input type="submit" class="form-control" value="submit" style="background-color:green;color:white">
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn-warning" data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="register" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog modal-sm" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h3>Register</h3>
			</div>
			<div class="modal-body">
				<form class="form" method="post" action="<c:url value='/register'/>">
					<div class="form-group">
						<label for="unre" class="control-label col-sm-4">Username</label>
						<div class="col-sm-8">
							<input type="text" name="id" id="unre" class="form-control" placeholder="userid">
						</div>
					</div>
					<div class="form-group">
						<label for="pwre" class="control-label col-sm-4">Password</label>
						<div class="col-sm-8">
							<input type="password" name="password" id="pwre" class="form-control" placeholder="password">
						</div>
					</div>
					<div class="form-group">
						<label for="nre" class="control-label col-sm-4">Name</label>
						<div class="col-sm-8">
							<input type="text" name="name" id="nre" class="form-control" placeholder="name">
						</div>
					</div>
					<div class="form-group">
						<label for="ere" class="control-label col-sm-4">Email</label>
						<div class="col-sm-8">
							<input type="email" name="email" id="ere" class="form-control" placeholder="email">
						</div>
					</div>
					<div class="form-group">
						<label for="are" class="control-label col-sm-4">Age</label>
						<div class="col-sm-8">
							<input type="number" name="age" id="are" class="form-control" placeholder="age">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-4">Gender </label>
						<div class="col-sm-8">
							<div class="col-sm-6">
								<input type="radio" name="gender" id="male" value="male" class="form-control" checked>
								Male
							</div>
							<div class="col-sm-6">
								<input type="radio" name="gender" id="female" class="form-control" value="female">
								Female
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-9">
								<input type="hidden" name="${_csrf.parameterName}"  class="form-control" value="${_csrf.token}">
							</div>
						</div>
						<input type="submit" class="form-control" value="submit" style="background-color:green;color:white">
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn-warning" data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>
</body>
</html>