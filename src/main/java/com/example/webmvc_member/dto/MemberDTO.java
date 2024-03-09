package com.example.webmvc_member.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberDTO {
    private String id;
    private String pw;
    private String name;
    private String email;
}
