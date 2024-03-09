package com.example.webmvc_member.service;

import com.example.webmvc_member.dao.MemberDAO;
import com.example.webmvc_member.domain.MemberVO;
import com.example.webmvc_member.dto.MemberDTO;
import com.example.webmvc_member.util.MapperUtil;
import org.modelmapper.ModelMapper;

import java.util.List;

public enum MemberService {
    INSTANCE;

    private MemberDAO memberDAO;
    private ModelMapper modelMapper;

    MemberService() {
        this.memberDAO = new MemberDAO();
        this.modelMapper = MapperUtil.INSTANCE.getModelMapper();
    }

    public MemberDAO getMemberDAO() {
        return memberDAO;
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }

    public MemberDTO getMember(String id) throws Exception {
        MemberDTO memberDTO = memberDAO.select(id);

        return memberDTO;
    }

    public List<MemberVO> listMembers() throws Exception {
        List<MemberVO> memberVOList = memberDAO.selectAll();

        return memberVOList;
    }

    public int addMember(MemberDTO memberDTO) throws Exception {
        MemberVO memberVO = this.modelMapper.map(memberDTO, MemberVO.class);

        int row = this.memberDAO.insert(memberVO);

        return row;
    }

    public int deleteMember(String id) throws Exception {
       int row = this.memberDAO.delete(id);

       return row;
    }

    public int updateMember(MemberDTO memberDTO) throws Exception {
        int row = this.memberDAO.update(memberDTO);

        return row;
    }
}
