package com.example.webmvc_member.dao;

import com.example.webmvc_member.util.ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MemberDAO {
    public int addMember(String id, String pw, String name, String email) throws Exception {
        String sql = "INSERT INTO tbl_member (id, pw, name, email) values (?, ?, ?, ?)";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, id);
        pstmt.setString(2, pw);
        pstmt.setString(3, name);
        pstmt.setString(4, email);

        int row = pstmt.executeUpdate();

        return row;
    }
}
