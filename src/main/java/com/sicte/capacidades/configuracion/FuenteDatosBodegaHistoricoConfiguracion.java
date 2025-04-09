package com.sicte.capacidades.configuracion;

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
@EnableJpaRepositories(basePackages = {
        "com.sicte.capacidades.bodegaHistorico.repository" }, entityManagerFactoryRef = "bodegaHistoricoEntityManager", transactionManagerRef = "bodegaHistoricoTransactionManager")

public class FuenteDatosBodegaHistoricoConfiguracion {

    @Bean(name = "bodegaHistoricoDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.bodegahistorico")
    public DataSource bodegaHistoricoDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "bodegaHistoricoEntityManager")
    public LocalContainerEntityManagerFactoryBean bodegaHistoricoEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("bodegaHistoricoDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.sicte.capacidades.bodegaHistorico.entity")
                .persistenceUnit("bodegaHistorico")
                .build();
    }

    @Bean(name = "bodegaHistoricoTransactionManager")
    public PlatformTransactionManager bodegaHistoricoTransactionManager(
            @Qualifier("bodegaHistoricoEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
