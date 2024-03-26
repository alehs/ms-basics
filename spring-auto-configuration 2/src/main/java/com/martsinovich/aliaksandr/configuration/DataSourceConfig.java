package com.martsinovich.aliaksandr.configuration;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DataSourceConfig {

  @Bean
  @Profile("qa")
  @Qualifier("dataSource")
  @ConditionalOnMissingBean(DataSource.class)
  public DataSource customDataSource() {
    DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
    dataSourceBuilder.driverClassName("org.h2.Driver");
    dataSourceBuilder.url("jdbc:h2:mem:customDb;DB_CLOSE_ON_EXIT=FALSE");
    dataSourceBuilder.username("user");
    dataSourceBuilder.password("password");

    return dataSourceBuilder.build();
  }

  @Bean
  @Profile("dev")
  @Qualifier("dataSource")
  public DataSource defaultDataSource() {
    DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
    dataSourceBuilder.driverClassName("org.h2.Driver");
    dataSourceBuilder.url("jdbc:h2:mem:defaultDb;DB_CLOSE_ON_EXIT=FALSE");
    dataSourceBuilder.username("sa");
    dataSourceBuilder.password("");

    return dataSourceBuilder.build();
  }
}
