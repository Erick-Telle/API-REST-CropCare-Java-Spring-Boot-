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
        String normalized = stripJdbcPrefix(url);
        return normalized.startsWith("postgres://") || normalized.startsWith("postgresql://");
    }

    /**
     * Convierte la URL de Render (postgresql://user:pass@host/db)
     * a formato JDBC sin credenciales embebidas (jdbc:postgresql://host/db).
     * Usuario y contraseña se configuran por separado en HikariCP.
     */
    private String toJdbcUrl(String url) {
        String normalized = stripJdbcPrefix(url);

        if (!normalized.startsWith("postgres://") && !normalized.startsWith("postgresql://")) {
            return "jdbc:" + normalized;
        }

        String withoutScheme = normalized.replaceFirst("^postgresql?://", "");
        int credentialsSeparator = withoutScheme.lastIndexOf('@');
        String hostAndDatabase = credentialsSeparator >= 0
                ? withoutScheme.substring(credentialsSeparator + 1)
                : withoutScheme;

        return "jdbc:postgresql://" + hostAndDatabase;
    }

    private String stripJdbcPrefix(String url) {
        if (url.startsWith("jdbc:")) {
            return url.substring("jdbc:".length());
        }
        return url;
    }
}
