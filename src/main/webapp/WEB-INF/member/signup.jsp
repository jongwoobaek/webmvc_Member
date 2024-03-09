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
