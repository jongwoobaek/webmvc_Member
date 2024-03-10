package com.example.webmvc_member.controller;

import com.example.webmvc_member.dto.MemberDTO;
import com.example.webmvc_member.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@Log4j2
@WebServlet(name = "MemberAddController", urlPatterns = "/member/addMember.do")
public class MemberAddController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/member/signup.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        log.info("MemberAddController doPost called...!");

        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        if (isDuplicateId(id)) {
            req.setAttribute("error", "이미 사용중인 아이디 입니다.");
            req.getRequestDispatcher("/WEB-INF/member/signup.jsp").forward(req, res);

            return;
        }

        MemberDTO memberDTO = MemberDTO.builder()
                .id(id)
                .pw(pw)
                .name(name)
                .email(email)
                .build();

        try {
            MemberService.INSTANCE.addMember(memberDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        res.sendRedirect("/member/listMembers.do");
    }

    private boolean isDuplicateId(String id) {
        MemberDTO memberDTO = null;

        try {
            memberDTO = MemberService.INSTANCE.getMember(id);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return memberDTO != null;
    }
}
