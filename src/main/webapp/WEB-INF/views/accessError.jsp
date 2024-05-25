<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Access Denied</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
    }
    .error-container {
    	text-align: center;
        max-width: 600px;
        margin: 50px auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 5px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
    }
    h1 {
        color: #3498db;
    }
    h2 {
        color: #555;
    }
</style>
</head>
<body>
    <div class="error-container">
        <h1>권한이 없는 페이지입니다.</h1>
        <h2><c:out value="${SPRING_SECURITY_403_EXCEPTION.getMessage()}"/></h2>
      	<h2><c:out value="${msg}"}/></h2>
    </div>
</body>
</html>
