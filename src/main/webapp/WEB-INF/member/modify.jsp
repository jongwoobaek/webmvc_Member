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
    <title>Modify</title>
</head>
<body>
    <h1>회원 정보 수정</h1>
    <form action="/member/modMember.do" method="post">
        <label>
            아이디 : <span>${member.id}</span>
        </label>
        <label>
            비밀번호 : <input type="password" name="pw" value="${member.pw}">
        </label>
        <label>
            이름 : <input type="test" name="name" value="${member.name}">
        </label>
        <label>
            이메일 : <input type="text" name="email" value="${member.email}">
        </label>
        <input type="submit" value="수정 완료">
    </form>
</body>
</html>
