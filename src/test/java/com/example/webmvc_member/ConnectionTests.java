package com.example.webmvc_member;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Log4j2
public class ConnectionTests {
    @Test
    public void testConnection() {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3307/webdb", "webuser", "1234")
        ) {

            Class.forName("org.mariadb.jdbc.Driver");
            Assertions.assertNotNull(conn);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
