package pl.application.reservation.tables.restaurant.configuration;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


@EnableJpaRepositories("pl.application.reservation.tables.restaurant.repository")
public class JPAConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        Map<String, Object> jpaProperties = new HashMap<>();
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

        emf.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        emf.setJpaPropertyMap(jpaProperties);
        emf.setPackagesToScan("pl.application.reservation.tables.restaurant.model");
        return emf;
    }
}



