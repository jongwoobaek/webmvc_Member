package com.example.webmvc_member.dao;

import com.example.webmvc_member.domain.MemberVO;
import com.example.webmvc_member.dto.MemberDTO;
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
        memberDAO.delete(memberVO.getId());
    }

    @Test
    public void selectTest() throws Exception {
        log.info("selectTest...!");

        memberDAO.insert(memberVO);

        MemberDTO memberDTO = memberDAO.select(memberVO.getId());

        Assertions.assertEquals(memberDTO.getId(), memberVO.getId());
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
    public void deleteTest() throws Exception {
        log.info("deleteTest...!");

        memberDAO.insert(memberVO);

        int result = memberDAO.delete(memberVO.getId());

        Assertions.assertEquals(1, result);
    }

    @Test
    public void updateTest() throws Exception {
        log.info("updateTest...!");

        memberDAO.insert(memberVO);

        String newPassword = "newPassword";
        String newName = "newName";
        String newEmail = "newEmail";

        MemberDTO memberDTO = MemberDTO.builder()
                .id(memberVO.getId())
                .pw(newPassword)
                .name(newName)
                .email(newEmail)
                .build();

        int result = memberDAO.update(memberDTO);

        Assertions.assertEquals(1, result);

        MemberDTO updatedMember = memberDAO.select(memberVO.getId());

        Assertions.assertEquals(updatedMember.getPw(), newPassword);
        Assertions.assertEquals(updatedMember.getName(), newName);
        Assertions.assertEquals(updatedMember.getEmail(), newEmail);
    }
}
