<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Todo List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e0f7fa;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .header {
            width: 100%;
            background-color: #007BFF;
            color: white;
            padding: 10px 0;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .header h1 {
            margin: 0;
            padding-left: 20px;
        }
        .header .userid {
            padding-right: 20px;
        }
        .container {
            background-color: white;
            padding: 20px;
            margin-top: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 80%;
            max-width: 800px;
        }
        .form-group {
            margin-bottom: 15px;
            margin-right: 10px;	
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        .form-group input, .form-group textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .form-group textarea {
            resize: vertical;
            height: 100px;
        }
        .form-buttons {
            display: flex;
            justify-content: space-between;
        }
        .form-buttons button {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            color: white;
            background-color: #007BFF;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .form-buttons button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Todo List</h1>
        <div class="userid">
           <input name='writer' value='<sec:authentication property="principal.username"/> 님' readonly="readonly">
        </div>
    </div>
    <div class="container">
        <form action="/todo/register" method="post">
            <div class="form-group">
                <label for="title">할 일</label>
                <input type="text" id="title" name="title" required>
            </div>
            <div class="form-buttons">
                <button type="submit">저장</button>
                <button type="reset">리셋</button>
            </div>
        </form>
    </div>
</body>
</html>
