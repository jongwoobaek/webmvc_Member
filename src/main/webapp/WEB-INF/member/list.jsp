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
        table {
            border-collapse: collapse;
        }

        th, td {
            width: 200px;
            height: 50px;
            text-align: center;
            border: 1px solid black;
        }

        /* 수정 및 삭제 버튼에 대한 스타일 */
        .btn {
            display: inline-block;
            padding: 10px 20px;
            font-size: 16px;
            text-align: center;
            cursor: pointer;
            background-color: #007bff; /* 버튼 배경색 */
            color: #fff; /* 버튼 텍스트 색상 */
            border: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        .btn:hover {
            background-color: #0056b3; /* 호버 시 배경색 변경 */
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
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        function modifyMember(memberId) {
            const url = "/member/modMember.do?id=" + memberId;

            $.ajax({
                type: "GET",
                url: url,
                success: function (response) {
                    // 페이지 이동
                    window.location.href = url;
                },
                error: function (xhr, status, error) {
                    // 오류 처리
                    console.error(xhr.responseText);
                }
            });
        }

        function deleteMember(memberId) {
            const url = "/member/delMember.do?id=" + memberId;

            $.ajax({
                type: "POST",
                url: url,
                success: function (response) {
                    // 페이지 새로고침 또는 회원 목록에서 해당 항목 제거
                    location.reload(); // 예: 페이지 새로고침
                },
                error: function (xhr, status, error) {
                    // 오류 처리
                    console.error(xhr.responseText);
                }
            });
        }
    </script>
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
                    <a href="#" class="link" onclick="modifyMember('${member.id}')">수정</a>
                </td>
                <td>
                    <a href="#" class="link" onclick="deleteMember('${member.id}')">삭제</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
<a href="/member/addMember.do" class="btn">회원 가입하기</a>
</body>
</html>
