package com.collaboration.collaborationbackend.db;



import java.util.Properties;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.collaboration.collaborationbackend")
@EnableTransactionManagement
public class DBConfig {

	@Bean
	DataSource myDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		basicDataSource.setUsername("system");
		basicDataSource.setPassword("password");

		return basicDataSource;
	}

	@Bean
	Properties myProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate-dialect", "org.hibernate.dialect.OracleDialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");

		return properties;

	}

	@Bean("sessionFactory")
	LocalSessionFactoryBean localSessionFactoryBean() {
		LocalSessionFactoryBean lSessionFactoryBean = new LocalSessionFactoryBean();
		lSessionFactoryBean.setDataSource(myDataSource());
		lSessionFactoryBean.setHibernateProperties(myProperties());
		lSessionFactoryBean.setPackagesToScan("com.collaboration.collaborationbackend.model");
		return lSessionFactoryBean;
	}

	@Autowired
	@Bean
	HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager htManager = new HibernateTransactionManager();
		htManager.setSessionFactory(sessionFactory);
		return htManager;
	}

}
