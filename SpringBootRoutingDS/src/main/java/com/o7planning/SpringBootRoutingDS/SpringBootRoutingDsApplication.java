package com.o7planning.SpringBootRoutingDS;

import java.sql.SQLException;

import javax.sql.DataSource;

import com.o7planning.SpringBootRoutingDS.routing.MyRoutingDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication

//11 Disable Auto Config DataSource & DataSourceTransactionManager
@EnableAutoConfiguration(exclude = { //
	DataSourceAutoConfiguration.class, //
	DataSourceTransactionManagerAutoConfiguration.class })

// Load to Environment
// (@see resources/application.properties).
@PropertySources({ @PropertySource("classpath:application.properties") })
public class SpringBootRoutingDsApplication {
	
	// Lưu trữ các giá thuộc tính load bởi @PropertySource.
	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRoutingDsApplication.class, args);
	}

	// Returns Routing DataSource (MyRoutingDataSource)
	@Autowired
	@Bean(name = "dataSource")
	public DataSource getDataSource(DataSource dataSource1, DataSource dataSource2){
	  
		System.out.println("##1 Create DataSource from dataSource1 & dataSource2");
		MyRoutingDataSource dataSource = new MyRoutingDataSource();
 
		dataSource.initDataSources(dataSource1, dataSource2);

	   return dataSource;
	}

	@Bean(name = "dataSource1")
	public DataSource getDataSource1() throws SQLException {
	   DriverManagerDataSource dataSource = new DriverManagerDataSource();

	   // See: application.properties
	//    dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	//    dataSource.setUrl("jdbc:sqlserver://LAPTOP-8P4AAT2B\\SERVER1;databaseName=nganhang");
	//    dataSource.setUsername("sa");
	//    dataSource.setPassword("123456");
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name.1"));
		dataSource.setUrl(env.getProperty("spring.datasource.url.1"));
		dataSource.setUsername(env.getProperty("spring.datasource.username.1"));
		dataSource.setPassword(env.getProperty("spring.datasource.password.1"));
	
		// System.out.println("## DataSource1: " + dataSource);
		return dataSource;
	}

	@Bean(name = "dataSource2")
	public DataSource getDataSource2() throws SQLException {
	   DriverManagerDataSource dataSource = new DriverManagerDataSource();
 
	   // See: application.properties
	   dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name.2"));
	   dataSource.setUrl(env.getProperty("spring.datasource.url.2"));
	   dataSource.setUsername(env.getProperty("spring.datasource.username.2"));
	   dataSource.setPassword(env.getProperty("spring.datasource.password.2"));

	//    System.out.println("## DataSource2: " + dataSource);
	   return dataSource;
	}

	@Autowired
	@Bean(name = "transactionManager")
	public DataSourceTransactionManager getTransactionManager(DataSource dataSource) {
	   DataSourceTransactionManager txManager = new DataSourceTransactionManager();
 
	   txManager.setDataSource(dataSource);
 
	   return txManager;
	}

}
