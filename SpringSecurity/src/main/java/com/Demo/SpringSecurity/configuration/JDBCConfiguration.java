package com.Demo.SpringSecurity.configuration;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration

/* This is not necessary to add Component Scan but can use if specific packages is available for JDBC only*/
@ComponentScan(basePackages="com.Demo.SpringSecurity")

/*
 * use PropertySource and add classpath of .properties file if JDBC Configuration is in some
 * other properties file instead of application.properties because application.properties is by default
 * added to classpath.
@PropertySource("classpath:mysql-file.properties") */
public class JDBCConfiguration {
	
	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());   

	@Bean
	public DataSource securityDataSource() {
			
		ComboPooledDataSource securityDataSource 
				= new ComboPooledDataSource();
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		
		logger.info(">>> jdbc.url = " + env.getProperty("jdbc.url"));
		logger.info(">>> jdbc.user = " + env.getProperty("jdbc.user"));
		
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		securityDataSource.setInitialPoolSize(
					getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setInitialPoolSize(
				getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setInitialPoolSize(
				getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setInitialPoolSize(
				getIntProperty("connection.pool.maxIdleTime"));
		
		return securityDataSource;
	}
	
	private int getIntProperty(String propName) {
		String propVal = env.getProperty(propName);
		
		int intPropVal = Integer.parseInt(propVal);
		
		return intPropVal;
	}

}
