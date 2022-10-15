<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
    
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 
</head>
<body>
 
 <form action="/login" method="POST">
 
 		<input type="text" id="user_name" name="user_name" placeholder="User Name"
               class="form-control"/> <br/>
        <input type="password" placeholder="Password"
               id="password" name="password" class="form-control"/> <br/>
               
         <input type="submit" name="Login" value="Login">      
 		
 
 </form>
 
 <p>Don't have account click on <a href="${pageContext.request.contextPath}/signup"> Sign up </a> </p> 

</body>
</html>