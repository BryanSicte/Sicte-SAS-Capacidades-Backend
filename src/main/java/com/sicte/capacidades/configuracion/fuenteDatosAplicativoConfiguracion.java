package com.sicte.capacidades.configuracion;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        "com.sicte.capacidades.capacidad.repository",
        "com.sicte.capacidades.supervision.repository",
        "com.sicte.capacidades.usuarios.repository",
        "com.sicte.capacidades.reporteMaterialFerretero.repository",
        "com.sicte.capacidades.solicitudMaterial.repository",
        "com.sicte.capacidades.inventarioMaterial.repository"
    },
    entityManagerFactoryRef = "aplicativoEntityManager",
    transactionManagerRef = "aplicativoTransactionManager"
)
public class FuenteDatosAplicativoConfiguracion {

    @Primary
    @Bean(name = "aplicativoDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.aplicativocapacidades")
    public DataSource aplicativoDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "aplicativoEntityManager")
    public LocalContainerEntityManagerFactoryBean aplicativoEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("aplicativoDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.sicte.capacidades.capacidad.entity",
                          "com.sicte.capacidades.supervision.entity",
                          "com.sicte.capacidades.usuarios.entity",
                          "com.sicte.capacidades.reporteMaterialFerretero.entity",
                          "com.sicte.capacidades.solicitudMaterial.entity",
                          "com.sicte.capacidades.inventarioMaterial.entity")
                .persistenceUnit("aplicativo_capacidades")
                .build();
    }

    @Primary
    @Bean(name = "aplicativoTransactionManager")
    public PlatformTransactionManager aplicativoTransactionManager(
            @Qualifier("aplicativoEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
