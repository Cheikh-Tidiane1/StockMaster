package com.tid.StockMaster.config;
import com.tid.StockMaster.interceptor.Interceptor;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfig {
    @Bean
    public EntityManagerFactory entityManagerFactory() {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.getProperties().put(AvailableSettings.STATEMENT_INSPECTOR, new Interceptor());
        return configuration.buildSessionFactory();
    }
}
