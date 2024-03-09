package com.example.webmvc_member.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;

@Log4j2
public class MemberServiceTests {
    private MemberService memberService;

    @BeforeEach
    public void ready() {
        this.memberService = MemberService.INSTANCE;
    }
}
