<%--
  Created by IntelliJ IDEA.
  User: jongwoobaek
  Date: 2024-03-08
  Time: 오후 5:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Member list</title>
    <style>
        table{ border-collapse : collapse; }
        th,td{
            width: 200px;
            height: 50px;
            text-align: center;
            border: 1px solid black;
        }

        form {
            display: inline;
        }
    </style>
</head>
<body>
    <h1>회원 정보</h1>
    <form method="post">
        <table>
            <thead>
                <tr>
                    <th>아이디</th>
                    <th>비밀번호</th>
                    <th>이름</th>
                    <th>이메일</th>
                    <th>가입일</th>
                    <th>수정</th>
                    <th>삭제</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="member" items="${memberList}">
                    <tr>
                        <td>${member.id}</td>
                        <td>${member.pw}</td>
                        <td>${member.name}</td>
                        <td>${member.email}</td>
                        <td>${member.signupDate}</td>
                        <td>
                            <form method="post" action="/member/editMember.do">
                                <input type="hidden" name="id" value="${member.id}">
                                <input type="submit" value="수정">
                            </form>
                        </td>
                        <td>
                            <form method="post" action="/member/delMember.do">
                                <input type="hidden" name="id" value="${member.id}">
                                <input type="submit" value="삭제">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </form>
    <a href="/member/addMember.do">회원 가입하기</a>
</body>
</html>
