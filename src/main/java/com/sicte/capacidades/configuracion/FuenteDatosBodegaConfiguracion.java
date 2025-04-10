package com.sicte.capacidades.configuracion;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = {"com.sicte.capacidades.bodega.repository"},
    entityManagerFactoryRef = "bodegaEntityManager",
    transactionManagerRef = "bodegaTransactionManager"
)
public class FuenteDatosBodegaConfiguracion {

    @Bean(name = "bodegaDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.bodega")
    public DataSource bodegaDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "bodegaEntityManager")
    public LocalContainerEntityManagerFactoryBean bodegaEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("bodegaDataSource") DataSource dataSource) {

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

        return builder
                .dataSource(dataSource)
                .packages("com.sicte.capacidades.bodega.entity")
                .persistenceUnit("bodega")
                .properties(properties)
                .build();
    }

    @Bean(name = "bodegaTransactionManager")
    public PlatformTransactionManager bodegaTransactionManager(
            @Qualifier("bodegaEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
