package com.example.webmvc_member.service;

import com.example.webmvc_member.dao.MemberDAO;
import com.example.webmvc_member.util.MapperUtil;
import org.modelmapper.ModelMapper;

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
}
