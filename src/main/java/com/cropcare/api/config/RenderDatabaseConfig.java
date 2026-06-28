package com.cropcare.api.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Configuration
@Profile("production")
@EnableConfigurationProperties(DataSourceProperties.class)
public class RenderDatabaseConfig {

    @Bean
    @Primary
    public DataSource dataSource(Environment environment, DataSourceProperties properties) {
        String databaseUrl = environment.getProperty("DATABASE_URL");
        if (databaseUrl != null && databaseUrl.startsWith("postgres://")) {
            return buildDataSourceFromRenderUrl(databaseUrl);
        }

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(properties.getUrl());
        config.setUsername(properties.getUsername());
        config.setPassword(properties.getPassword());
        config.setDriverClassName("org.postgresql.Driver");
        return new HikariDataSource(config);
    }

    private DataSource buildDataSourceFromRenderUrl(String databaseUrl) {
        URI uri = URI.create(databaseUrl.replace("postgres://", "http://"));

        String username = uri.getUserInfo().split(":")[0];
        String password = URLDecoder.decode(uri.getUserInfo().split(":")[1], StandardCharsets.UTF_8);
        String jdbcUrl = "jdbc:postgresql://" + uri.getHost() + ':' + uri.getPort() + uri.getPath()
                + (uri.getQuery() != null ? "?" + uri.getQuery() : "");

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName("org.postgresql.Driver");
        return new HikariDataSource(config);
    }
}
