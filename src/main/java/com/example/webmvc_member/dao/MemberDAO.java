package com.example.webmvc_member.dao;

import com.example.webmvc_member.domain.MemberVO;
import com.example.webmvc_member.dto.MemberDTO;
import com.example.webmvc_member.util.ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    public MemberDTO selectOne(String id) throws Exception {
        String sql = "SELECT id, pw, name, email FROM tbl_member WHERE id = ?";

        MemberDTO memberDTO = null;

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, id);

        @Cleanup ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            memberDTO = MemberDTO.builder()
                    .id(rs.getString("id"))
                    .pw(rs.getString("pw"))
                    .name(rs.getString("name"))
                    .email(rs.getString("email"))
                    .build();
        }

        return memberDTO;
    }

    public List<MemberVO> selectAll() throws Exception {
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

    public int insert(MemberVO memberVO) throws Exception {
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

    public int delete(String id) throws Exception {
        String sql = "DELETE FROM tbl_member WHERE id = ?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, id);

        int row = pstmt.executeUpdate();

        return row;
    }

    public int update(MemberDTO memberDTO) throws Exception {
        String sql = "UPDATE tbl_member SET pw = ?, name = ?, email = ? WHERE id = ?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, memberDTO.getPw());
        pstmt.setString(2, memberDTO.getName());
        pstmt.setString(3, memberDTO.getEmail());
        pstmt.setString(4, memberDTO.getId());

        int row = pstmt.executeUpdate();

        return row;
    }
}
