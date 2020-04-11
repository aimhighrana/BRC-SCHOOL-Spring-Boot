<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>Sign Up | BRC School </title>
<!-- Favicon-->
<link rel="icon" href="../../favicon.ico" type="image/x-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet" type="text/css">

<!-- Bootstrap Core Css -->
<link href="material/plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

<!-- Waves Effect Css -->
<link href="material/plugins/node-waves/waves.css" rel="stylesheet" />

<!-- Animation Css -->
<link href="material/plugins/animate-css/animate.css" rel="stylesheet" />

<!-- Custom Css -->
<link href="material/css/style.css" rel="stylesheet">
</head>

<body class="signup-page">
	<div class="signup-box">
		<div class="logo">
			<a href="javascript:void(0);">brc<b>SCHOOL</b></a>
            <small>Smart tools </small>
		</div>
		<div class="card">
			<div class="body">
				<form id="sign_up" action="/signup" method="POST">
					<div class="msg">Register a new membership</div>
					<div class="input-group">
						<span class="input-group-addon"> <i class="material-icons">person</i>
						</span>
						<div class="form-line">
							<input type="text" class="form-control" name="firstName"
								placeholder="First Name" required autofocus>
						</div>
					</div>
					
					<div class="input-group">
						<span class="input-group-addon"> <i class="material-icons">person</i>
						</span>
						<div class="form-line">
							<input type="text" class="form-control" name="lastName"
								placeholder="Last Name" required autofocus>
						</div>
					</div>
					
					
					<div class="input-group">
						<span class="input-group-addon"> <i class="material-icons">email</i>
						</span>
						<div class="form-line">
							<input type="email" class="form-control" name="email"
								placeholder="Email Address" required>
						</div>
					</div>
					
					<div class="input-group">
						<span class="input-group-addon"> <i class="material-icons">phone</i>
						</span>
						<div class="form-line">
							<input type="email" class="form-control" name="phone"
								placeholder="Phone" required>
						</div>
					</div>
					
					 
					<div class="input-group">
						<span class="input-group-addon"> <i class="material-icons">person_add</i>
						</span>
						<div class="form-line">
							<input type="password" class="form-control" name="userName"
								 placeholder="User Name" required>
						</div>
					</div>
					<div class="input-group">
						<span class="input-group-addon"> <i class="material-icons">lock</i>
						</span>
						<div class="form-line">
							<input type="password" class="form-control" name="password"
								placeholder="Password" required>
						</div>
					</div>
					
					<div class="input-group">
						<span class="input-group-addon"> <i class="material-icons">accessibility</i>
						</span>
						<div class="form-line">
							<select class="form-control show-tick" name="role">
                                   <option value="USER">User</option>
									<option value="ADMIN">Admin</option>
                            </select>
						</div>
					</div>
					
					 
					<div class="form-group">
						<input type="checkbox" name="terms" id="terms"
							class="filled-in chk-col-pink"> <label for="terms">I
							read and agree to the <a href="javascript:void(0);">terms of
								usage</a>.
						</label>
					</div>

					<button class="btn btn-block btn-lg bg-pink waves-effect"
						type="submit">SIGN UP</button>

					<div class="m-t-25 m-b--5 align-center">
						<a href="${pageContext.request.contextPath}/login">You already have a membership?</a>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- Jquery Core Js -->
	<script src="material/plugins/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core Js -->
	<script src="material/plugins/bootstrap/js/bootstrap.js"></script>

	<!-- Waves Effect Plugin Js -->
	<script src="material/plugins/node-waves/waves.js"></script>

	<!-- Validation Plugin Js -->
	<script src="material/plugins/jquery-validation/jquery.validate.js"></script>

	<!-- Custom Js -->
	<script src="material/js/admin.js"></script>
	<script src="material/js/pages/examples/sign-up.js"></script>
</body>

</html>