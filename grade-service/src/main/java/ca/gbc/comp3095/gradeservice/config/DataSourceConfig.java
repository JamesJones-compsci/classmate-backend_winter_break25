package ca.gbc.comp3095.gradeservice.config;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;  // <-- changed from jakarta.sql.DataSource
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

    @Bean
    @ConditionalOnProperty(name = "POSTGRES_URL")
    public DataSource postgresDataSource(
            @Value("${POSTGRES_URL}") String url,
            @Value("${POSTGRES_USERNAME}") String username,
            @Value("${POSTGRES_PASSWORD}") String password) {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setDriverClassName("org.postgresql.Driver");
        return ds;
    }

    @Bean
    @ConditionalOnMissingBean(DataSource.class)
    public DataSource h2DataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:h2:mem:gradedb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
        ds.setUsername("sa");
        ds.setPassword("");
        ds.setDriverClassName("org.h2.Driver");
        return ds;
    }
}