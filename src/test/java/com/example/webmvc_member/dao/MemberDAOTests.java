package com.example.webmvc_member.dao;

import com.example.webmvc_member.domain.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

@Log4j2
public class MemberDAOTests {
    MemberDAO memberDAO;
    MemberVO memberVO;

    @BeforeEach
    public void ready() {
        memberDAO = new MemberDAO();
        memberVO = MemberVO.builder()
                .id("test-id")
                .pw("test - pw")
                .name("test - name")
                .email("test - email")
                .build();
    }

    @AfterEach
    public void afterEach() throws Exception {
        memberDAO.deleteMember(memberVO);
    }

    @Test
    public void selectAllTest() throws Exception {
        log.info("selectAllTest...!");

        memberDAO.insert(memberVO);

        List<MemberVO> memberVOList = memberDAO.selectAll();

        Assertions.assertEquals(1, memberVOList.size());
    }

    @Test
    public void insertTest() throws Exception {
        log.info("insertTest...!");

        int result = memberDAO.insert(memberVO);

        Assertions.assertEquals(1, result);
    }

    @Test
    public void deleteMemberTest() throws Exception {
        log.info("deleteMemberTest...!");

        memberDAO.insert(memberVO);

        int result = memberDAO.deleteMember(memberVO);

        Assertions.assertEquals(1, result);
    }
}
