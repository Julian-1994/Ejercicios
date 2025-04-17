package com.Ejercicio6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
public class EclipseLinkConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.Ejercicio6.model");
        em.setJpaVendorAdapter(new EclipseLinkJpaVendorAdapter());
        
        // Configuración de propiedades específicas de EclipseLink
        em.getJpaPropertyMap().put("eclipselink.logging.level", "FINE");
        em.getJpaPropertyMap().put("eclipselink.ddl-generation", "create-tables");
        em.getJpaPropertyMap().put("javax.persistence.jdbc.driver", "oracle.jdbc.OracleDriver");
        em.getJpaPropertyMap().put("javax.persistence.jdbc.url", "jdbc:oracle:thin:@localhost:1521:xe");
        em.getJpaPropertyMap().put("javax.persistence.jdbc.user", "system");
        em.getJpaPropertyMap().put("javax.persistence.jdbc.password", "admin");

        return em;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}