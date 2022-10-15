<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		
		<form action="/signup" method="POST">
			<pre>
				User Name : 
				<input type="text" name="userName"/>
				
				First Name : 
				<input type="text" name="firstName"/>
				
				Last Name : 
				<input type="text" name="lastName"/>
				
				Email : 
				<input type="email" name="email"/>
				
				Phone : 
				<input type="tel" name="phone"/>
				
				Password:
				<input type="password" name="password"/>
				
				Role:
				<select name="role">
					<option value="USER">User</option>
					<option value="ADMIN">Admin</option>
				</select>
				
				<input type="submit" value="Submit">
			
			
			</pre>
			
		</form>
		

</body>
</html>