package com.example.webmvc_member.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

public enum ConnectionUtil {
    INSTANCE;

    private HikariDataSource dataSource;

    ConnectionUtil() {
        HikariConfig config = new HikariConfig();

        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3307/webdb");
        config.setUsername("webuser");
        config.setPassword("1234");

        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        dataSource = new HikariDataSource(config);
    }

    public Connection getConnection() throws Exception {
        return this.dataSource.getConnection();
    }
}
