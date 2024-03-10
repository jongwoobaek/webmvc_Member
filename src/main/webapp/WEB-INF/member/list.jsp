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

        .container {
            width: 80%;
            margin: 0 auto;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            height: 50px;
            text-align: center;
            border: 1px solid black;
        }

        th {
            background-color: #007bff;
            color: #fff;
        }

        td {
            background-color: #fff;
        }

        /* 수정 및 삭제 버튼에 대한 스타일 */
        .btn {
            display: block; /* 버튼을 블록 요소로 설정하여 한 줄에 하나씩 표시됩니다 */
            width: 120px; /* 버튼의 너비를 지정합니다 */
            margin: 0 auto; /* 버튼을 가운데 정렬합니다 */
            padding: 10px 20px;
            font-size: 16px;
            text-align: center;
            cursor: pointer;
            background-color: #007bff; /* 버튼 배경색 */
            color: #fff; /* 버튼 텍스트 색상 */
            border: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
            text-decoration: none; /* 텍스트에 밑줄 추가 */
        }

        .btn:hover {
            background-color: #0056b3; /* 호버 시 배경색 변경 */
        }

        form {
            display: inline;
        }

        .link {
            display: inline-block;
            padding: 10px 20px;
            font-size: 16px;
            text-align: center;
            cursor: pointer;
            background-color: transparent; /* 버튼 배경색 투명 */
            color: black; /* 버튼 텍스트 색상 검정색으로 변경 */
            border: none;
            border-radius: 5px;
            transition: none; /* 호버 시 색상 변경 없음 */
            text-decoration: none; /* 텍스트에 밑줄 추가 */
        }

        .link:hover {
            text-decoration: underline; /* 호버 시 밑줄 유지 */
        }

        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<h1>회원 정보</h1>
<div class="container">
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
                    <form method="get" action="/member/modMember.do">
                        <input type="hidden" name="id" value="${member.id}">
                        <input type="submit" value="수정" class="link">
                    </form>
                </td>
                <td>
                    <form method="post" action="/member/delMember.do">
                        <input type="hidden" name="id" value="${member.id}">
                        <input type="submit" value="삭제" class="link">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<a href="/member/addMember.do" class="btn">회원 가입하기</a>
</body>
</html>
