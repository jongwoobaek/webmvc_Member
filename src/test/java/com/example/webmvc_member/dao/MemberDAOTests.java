package com.example.webmvc_member.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberDAOTests {
    MemberDAO memberDAO;
    @Test
    public void addMemberTest() throws Exception {
        memberDAO = new MemberDAO();

        String id = "testId";
        String pw = "testPw";
        String name = "testName";
        String email = "test@test.test";

        int result = memberDAO.addMember(id, pw, name, email);

        Assertions.assertEquals(1, result);
    }
}
