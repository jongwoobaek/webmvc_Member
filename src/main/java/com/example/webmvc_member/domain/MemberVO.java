package com.example.webmvc_member.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
    private String id;
    private String pw;
    private String name;
    private String email;
    private LocalDate signupDate;
}
