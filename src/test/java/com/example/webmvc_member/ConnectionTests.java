package com.example.webmvc_member;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
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

    @Test
    public void testHikariCP() {
        HikariConfig config = new HikariConfig();

        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3307/webdb");
        config.setUsername("webuser");
        config.setPassword("1234");

        config.addDataSourceProperty("cachePrepStmts", true);
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource dataSource = new HikariDataSource(config);

        try (
                Connection conn = dataSource.getConnection()
        ) {

            log.info(conn);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
