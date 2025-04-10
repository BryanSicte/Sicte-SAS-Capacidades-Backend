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
@EnableJpaRepositories(
        basePackages = {
            "com.sicte.capacidades.chatbot.repository",
            "com.sicte.capacidades.carnetizacion.repository"
        },
        entityManagerFactoryRef = "gestionHumanaEntityManager",
        transactionManagerRef = "gestionHumanaTransactionManager"
)
public class FuenteDatosGestionHumanaConfiguracion {

    @Bean(name = "gestionHumanaDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.gestionhumana")
    public DataSource gestionHumanaDataSourceDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "gestionHumanaEntityManager")
    public LocalContainerEntityManagerFactoryBean gestionHumanaDataSourceEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("gestionHumanaDataSource") DataSource dataSource) {

        return builder
                .dataSource(dataSource)
                .packages("com.sicte.capacidades.chatbot.entity",
                        "com.sicte.capacidades.carnetizacion.entity")
                .persistenceUnit("gestion_humana")
                .build();
    }

    @Bean(name = "gestionHumanaTransactionManager")
    public PlatformTransactionManager gestionHumanaDataSourceTransactionManager(
            @Qualifier("gestionHumanaEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
