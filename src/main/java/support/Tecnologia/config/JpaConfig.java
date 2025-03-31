package support.Tecnologia.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.activation.DataSource;

@Configuration
@EnableTransactionManagement
    @EnableJpaRepositories(basePackages = "com.example.repository")//no es necesario ya que se ocupaspring-boot-starter-data-jpa
public class JpaConfig {
    @Bean
    public DataSource dataSource() {
        return (DataSource) DataSourceBuilder.create()
                .url("jdbc:postgresql://dpg-cvgr59qj1k6c738p6lt0-a.oregon-postgres.render.com:5432/support_ge19?sslmode=require")
                .username("user")
                .password("G2LYxb1g5HZtvrWG1ZoMAUR1GbQpWjsA")
                .driverClassName("org.postgresql.Driver")
                .build();
    }
}