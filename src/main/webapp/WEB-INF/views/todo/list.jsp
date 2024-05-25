<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
            display: flex;
            align-items: center;
        }
        .userid input {
            background: none;
            border: none;
            color: white;
            font-size: 16px;
            cursor: default;
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
        .title {
            font-size: 40px;
            margin-bottom: 20px;
            color: #007BFF;
        }
        .add-form {
            text-align: right;
            margin-bottom: 20px;
        }
        .add-form button {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            background-color: #007BFF;
            color: #fff;
            cursor: pointer;
        }
        .add-form button:hover {
            background-color: #0056b3;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #007BFF;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ddd;
        }
        .action-buttons button {
            padding: 5px 10px;
            margin-right: 5px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .delete-button {
            background-color: #FF4136;
            color: white;
        }
        .complete-button {
            background-color: #2ECC40;
            color: white;
        }
        .logout-button {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            background-color: #0056b3;
            color: #fff;
            cursor: pointer;
            margin-left: 10px;
        }
        .logout-button:hover {
            background-color: #004494;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Todo List</h1>
        <div class="userid">
            <input name='writer' value='환영합니다, <sec:authentication property="principal.username"/> 님' readonly="readonly">
            <button class="logout-button" onclick="location.href='/todoLogout'">로그아웃</button>
        </div>
    </div>
    <div class="container">
        <div class="title">할일 목록</div>

        <table>
            <thead>
                <tr>
                	<th>번호</th>
                    <th>할 일</th>
                    <th>등록일</th>
                    <th>완료일</th>
                    <th>비 고</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="todo" varStatus="loop"> 
                    <tr>
                    	<td>${loop.index + 1}</td>
                        <td><c:out value="${todo.title}"/></td>
						<td><fmt:formatDate value="${todo.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		       			<td><fmt:formatDate value="${todo.enddate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td class="action-buttons">
							<form action="/todo/remove" method="post">
					            <input type="hidden" name="tno" value="${todo.tno}">
					            <button class="delete-button" type="submit">삭제</button>
					        </form>
					        <form action="/todo/complete" method="post">
					            <input type="hidden" name="tno" value="${todo.tno}">
					            <button class="complete-button" type="submit">완료</button>
					        </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
         <div class="add-form">
            <button onclick="location.href='/todo/register'">할일 추가</button>
        </div>
    </div>
</body>
</html>