<%--
  Created by IntelliJ IDEA.
  User: jongwoobaek
  Date: 2024-03-08
  Time: 오후 6:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Signup</title>
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

        input[type="submit"],
        input[type="reset"] {
            width: calc(50% - 20px); /* 버튼의 너비를 반으로 설정하고, 여백을 고려하여 계산합니다 */
            margin: 20px auto; /* 버튼을 수평 가운데로 정렬합니다 */
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #007bff;
            color: #fff;
            cursor: pointer;
            display: block; /* 버튼을 블록 요소로 설정하여 한 줄에 하나씩 표시됩니다 */
        }

        input[type="submit"]:hover,
        input[type="reset"]:hover {
            background-color: #0056b3;
            color: white;
        }

        input[type="reset"] {
            background-color: #ccc;
            color: #333;
        }
    </style>
</head>
<body>
<h1>회원 가입</h1>
<form action="/member/addMember.do" method="post">
    <label>
        아이디 : <input type="text" name="id" required autocomplete="off" placeholder="아이디를 입력하세요.">
    </label>
    <label>
        비밀번호 : <input type="password" name="pw" required autocomplete="off" placeholder="비밀번호를 입력하세요.">
    </label>
    <label>
        이름 : <input type="text" name="name" required autocomplete="off" placeholder="이름을 입력하세요.">
    </label>
    <label>
        이메일 : <input type="email" name="email" required autocomplete="off" placeholder="example@example.com">
    </label>
    <input type="submit" value="가입하기">
    <input type="reset" value="다시입력">
</form>
</body>
</html>
