package com.example.webmvc_member.controller;

import com.example.webmvc_member.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@Log4j2
@WebServlet(name = "MemberDeleteController", urlPatterns = "/member/delMember.do")
public class MemberDeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        log.info("MemberDeleteController called...!");

        String id = req.getParameter("id");
        log.info(id);

        try {
            MemberService.INSTANCE.deleteMember(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        res.sendRedirect("/member/listMembers.do");
    }
}
