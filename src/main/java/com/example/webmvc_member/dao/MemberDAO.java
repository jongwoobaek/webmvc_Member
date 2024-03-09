package com.example.webmvc_member.dao;

import com.example.webmvc_member.domain.MemberVO;
import com.example.webmvc_member.util.ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    public List<MemberVO> listMembers() throws Exception {
        List<MemberVO> memberVOList = new ArrayList<>();
        String sql = "SELECT * from tbl_member";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            MemberVO memberVO = MemberVO.builder()
                    .id(rs.getString("id"))
                    .pw(rs.getString("pw"))
                    .name(rs.getString("name"))
                    .email(rs.getString("email"))
                    .signupDate(rs.getDate("signupDate").toLocalDate())
                    .build();

            memberVOList.add(memberVO);
        }

        return memberVOList;
    }

    public int addMember(MemberVO memberVO) throws Exception {
        String sql = "INSERT INTO tbl_member (id, pw, name, email) values (?, ?, ?, ?)";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, memberVO.getId());
        pstmt.setString(2, memberVO.getPw());
        pstmt.setString(3, memberVO.getName());
        pstmt.setString(4, memberVO.getEmail());

        int row = pstmt.executeUpdate();

        return row;
    }

    public int deleteMember(MemberVO memberVO) throws Exception {
        String sql = "DELETE FROM tbl_member WHERE id = ?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, memberVO.getId());

        int row = pstmt.executeUpdate();

        return row;
    }
}
