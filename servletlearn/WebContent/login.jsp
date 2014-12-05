<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login</title>
<script type="text/javascript">
    function LoginSubmit() {
    	var user=document.Login.loginName.value;
    	var password=document.Login.password.value;
    	
    	if(user==null||user=="") {
    		alert("userName can't be empty");
    		return;
    	}
    	if(password==null||password=="") {
            alert("password can't be empty");
            return;
        }
    	document.Login.submit();
    }
</script>
</head>
<body>
    <form action="hello" method="post" name="Login">
        <p align="left">userName:&nbsp; <input type="text" name="loginName" size="20"/></p>
        <p align="left">password:&nbsp; <input type="password" name="password" size="20"/></p>
        <p align="left">
            <input type="button" value="login" onclick="LoginSubmit()">
            <input type="reset" value="reset"/>
        </p>
    </form>
</body>
</html>