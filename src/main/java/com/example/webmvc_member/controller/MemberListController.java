package com.example.webmvc_member.controller;

import com.example.webmvc_member.domain.MemberVO;
import com.example.webmvc_member.service.MemberService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MemberListController", urlPatterns = "/member/listMembers.do")
public class MemberListController extends HttpServlet {
    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<MemberVO> memberVOList = null;

        try {
            memberVOList = memberService.listMembers();

            req.setAttribute("memberList", memberVOList);
            req.getRequestDispatcher("/WEB-INF/member/list.jsp").forward(req, res);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
