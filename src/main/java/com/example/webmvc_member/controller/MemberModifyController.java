package com.example.webmvc_member.controller;

import com.example.webmvc_member.dto.MemberDTO;
import com.example.webmvc_member.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@Log4j2
@WebServlet(name = "MemberModifyController", urlPatterns = "/member/modMember.do")
public class MemberModifyController extends HttpServlet {
    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        log.info("MemberModifyController doGet called...!");

        String id = req.getParameter("id");

        log.info(id);

        MemberDTO memberDTO = null;

        try {
            memberDTO = memberService.getMember(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("member", memberDTO);

        req.getRequestDispatcher("/WEB-INF/member/modify.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
