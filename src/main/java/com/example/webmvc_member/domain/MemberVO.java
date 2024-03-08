package com.example.webmvc_member.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class MemberVO {
    private String id;
    private String pw;
    private String name;
    private String email;
    private LocalDate signupDate;
}
