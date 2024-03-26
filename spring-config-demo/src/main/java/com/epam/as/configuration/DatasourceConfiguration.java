package com.epam.as.configuration;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories({"com.epam.as.message.ports"})
@EntityScan(basePackages = {"com.epam.as.message.domain"})
@EnableTransactionManagement
public class DatasourceConfiguration {

	@Bean
	@Profile("default")
	@ConditionalOnMissingBean(DataSource.class)
	@ConfigurationProperties(prefix = "spring.datasource")
	DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	@Profile("dev")
	@ConfigurationProperties(prefix = "spring.datasource.dev")
	DataSource defaultDataSource() {
		return DataSourceBuilder.create().build();
	}

}
