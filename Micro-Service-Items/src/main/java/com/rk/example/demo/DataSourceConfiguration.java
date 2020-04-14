package com.rk.example.demo;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("com.rk.example.demo.mapper")
@EnableTransactionManagement(proxyTargetClass=true)
public class DataSourceConfiguration {
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setAccessToUnderlyingConnectionAllowed(true);
		basicDataSource.setDefaultAutoCommit(false);
		basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		basicDataSource.setUsername("C##rk_db_user");
		basicDataSource.setPassword("adMin#123");
		return basicDataSource;
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}
	
	@Bean
	public SqlSessionFactoryBean sessionFactoryBean() throws IOException {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource[] mapperLocation = resolver.getResources("classpath:/mappers/*.xml");
		sessionFactoryBean.setMapperLocations(mapperLocation);
		sessionFactoryBean.setDataSource(dataSource());
		return sessionFactoryBean;
	}

}
