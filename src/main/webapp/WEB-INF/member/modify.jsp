<%--
  Created by IntelliJ IDEA.
  User: jongwoobaek
  Date: 2024-03-09
  Time: 오후 6:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원 정보 수정</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f2f2f2;
        }

        h1 {
            text-align: center;
            color: #333;
            margin-top: 50px;
        }

        form {
            width: 500px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="text"],
        input[type="password"],
        input[type="email"] {
            width: calc(100% - 22px);
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            width: calc(100% - 22px);
            margin: 20px auto;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #007bff;
            color: #fff;
            cursor: pointer;
            display: block;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<h1>회원 정보 수정</h1>
<form action="/member/modMember.do" method="post">
    <label>
        <h3>아이디 : ${member.id}</h3>
        <input id="userId" type="hidden" name="id" value="${member.id}">
    </label>
    <label>
        비밀번호 : <input type="password" name="pw" value="${member.pw}" required>
    </label>
    <label>
        이름 : <input type="text" name="name" value="${member.name}" required>
    </label>
    <label>
        이메일 : <input type="text" name="email" value="${member.email}" required>
    </label>
    <input type="submit" value="수정 완료">
</form>
</body>
</html>
