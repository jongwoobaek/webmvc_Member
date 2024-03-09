package com.example.webmvc_member.service;

import com.example.webmvc_member.domain.MemberVO;
import com.example.webmvc_member.dto.MemberDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

@Log4j2
public class MemberServiceTests {
    private MemberService memberService;
    private MemberDTO memberDTO;

    @BeforeEach
    public void ready() {
        this.memberService = MemberService.INSTANCE;
        this.memberDTO = MemberDTO.builder()
                .id("test-id")
                .pw("test - pw")
                .name("test - name")
                .email("test - email")
                .build();
    }

    @AfterEach
    public void afterEach() throws Exception {
        memberService.deleteMember(memberDTO.getId());
    }

    @Test
    public void getMemberTest() throws Exception {
        log.info("getMemberTest...!");

        memberService.addMember(memberDTO);

        String id = memberService.getMember(memberDTO.getId()).getId();

        Assertions.assertEquals(memberDTO.getId(), id);
    }

    @Test
    public void listMembersTest() throws Exception {
        log.info("listMembersTest...!");

        memberService.addMember(memberDTO);

        List<MemberVO> memberVOList = memberService.listMembers();

        Assertions.assertEquals(1, memberVOList.size());
    }

    @Test
    public void addMemberTest() throws Exception {
        log.info("addMemberTest...!");

        int result = memberService.addMember(memberDTO);

        Assertions.assertEquals(1, result);
    }

    @Test
    public void deleteMemberTest() throws Exception {
        log.info("deleteMemberTest...!");

        memberService.addMember(memberDTO);

        int result = memberService.deleteMember(memberDTO.getId());

        Assertions.assertEquals(1, result);
    }
}
