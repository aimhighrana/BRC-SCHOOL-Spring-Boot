<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>Sign In | BRC School</title>
    <!-- Favicon-->
    <link rel="icon" href="../../favicon.ico" type="image/x-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">

    <!-- Bootstrap Core Css -->
    <link href="material/plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Waves Effect Css -->
    <link href="material/plugins/node-waves/waves.css" rel="stylesheet" />

    <!-- Animation Css -->
    <link href="material/plugins/animate-css/animate.css" rel="stylesheet" />

    <!-- Custom Css -->
    <link href="material/css/style.css" rel="stylesheet">
</head>

<body class="login-page">
    <div class="login-box">
        <div class="logo">
            <a href="javascript:void(0);">brc<b>SCHOOL</b></a>
            <small>Smart tools </small>
        </div>
        <div class="card">
            <div class="body">
                <form id="sign_in" method="POST" action="/login" >
                    <div class="msg">Sign in to start your session</div>
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">person</i>
                        </span>
                        <div class="form-line">
                            <input type="text" class="form-control" name="user_name"  placeholder="Username" required autofocus>
                        </div>
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">lock</i>
                        </span>
                        <div class="form-line">
                            <input type="password" class="form-control" name="password" placeholder="Password" required>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-8 p-t-5">
                            <input type="checkbox" name="rememberme" id="rememberme" class="filled-in chk-col-pink">
                            <label for="rememberme">Remember Me</label>
                        </div>
                        <div class="col-xs-4">
                            <button class="btn btn-block bg-pink waves-effect" type="submit">SIGN IN</button>
                        </div>
                    </div>
                    
                    <brc:if test="${not empty errorMsg}">
                    	<div class="row">
	                        <div class="col-xs-12 p-t-5">
	                            <p style="color: red">${errorMsg}</p>
	                        </div>
                    	</div>
                    </brc:if>
                    
                    <div class="row m-t-15 m-b--20">
                        <div class="col-xs-6">
                            <a href="${pageContext.request.contextPath}/signup">Register Now!</a>
                        </div>
                        <div class="col-xs-6 align-right">
                            <a href="forgot-password.html">Forgot Password?</a>
                        </div>
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
    <script src="material/js/pages/examples/sign-in.js"></script>
</body>

</html>