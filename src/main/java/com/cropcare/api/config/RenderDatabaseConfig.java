package com.cropcare.api.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
@Profile("production")
public class RenderDatabaseConfig {

    @Bean
    @Primary
    public DataSource dataSource(Environment environment) {
        String databaseUrl = environment.getProperty("DATABASE_URL");

        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.postgresql.Driver");

        if (databaseUrl != null && isPostgresConnectionUrl(databaseUrl)) {
            config.setJdbcUrl(toJdbcUrl(databaseUrl));
            config.setUsername(environment.getRequiredProperty("DATABASE_USERNAME"));
            config.setPassword(environment.getRequiredProperty("DATABASE_PASSWORD"));
        } else {
            config.setJdbcUrl(environment.getRequiredProperty("spring.datasource.url"));
            config.setUsername(environment.getRequiredProperty("spring.datasource.username"));
            config.setPassword(environment.getProperty("spring.datasource.password", ""));
        }

        return new HikariDataSource(config);
    }

    private boolean isPostgresConnectionUrl(String url) {
        return url.startsWith("postgres://") || url.startsWith("postgresql://");
    }

    private String toJdbcUrl(String url) {
        if (url.startsWith("jdbc:")) {
            return url;
        }
        return "jdbc:" + url;
    }
}
