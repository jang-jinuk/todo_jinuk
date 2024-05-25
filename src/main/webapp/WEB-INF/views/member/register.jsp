<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 가입</title>
    <style>
        .container {
            margin: 20px auto;
            width: 300px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .header {
            text-align: center;
            font-weight: bold;
            margin-bottom: 10px;
        }
        .user-info {
            margin-bottom: 10px;
        }
        .user-info div {
            margin-bottom: 5px;
        }
        .user-info input {
            width: 100%;
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .submit-btn {
            text-align: center;
        }
        .submit-btn button {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        .submit-btn button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="member-container">
            <div class="header">
                <div>회원 가입</div>
            </div>
            <form action="/member/register" method="post">
                <div class="user-info">
                    <div class="user-info-id">
                        <div>* 아이디</div>
                        <input type="text" name="userid" />
                    </div>

                    <div class="user-info-pw">
                        <div>* 비밀번호</div>
                        <input type="password" name="userpw" />
                    </div>
                    <div class="user-info-name">
                    <div>* 이름</div>
                        <input type="text" name="username" />
                    </div>                    
                    <div class="user-info-phone">
                        <div>* 전화번호</div>
                        <input type="text" name="phonenumber" />
                    </div>
                </div>
                <div class="submit-btn">
                    <button type="submit">가입하기</button>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </div>
            </form>
        </div>
    </div>
</body>
</html>
