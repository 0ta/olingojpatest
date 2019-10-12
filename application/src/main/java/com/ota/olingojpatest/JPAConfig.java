package com.ota.olingojpatest;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class JPAConfig {
	
//	@Bean(destroyMethod = "")
//	public DataSource jndiDataSource() throws IllegalArgumentException, NamingException {
//		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
//////		DataSource ds = dataSourceLookup.getDataSource("java:comp/env/jdbc/DefaultDB");
//		DataSource ds = dataSourceLookup.getDataSource("java:comp/env/jdbc/hdi_SCSK_SAMPLE_HANA");
//		return ds;
//	}
	
	@Bean(destroyMethod = "")
	public DataSource dataSource(@Value("${hana.url}")final String url,
			@Value("${hana.user}")final String user,
			@Value("${hana.password}")final String password) {
		return DataSourceBuilder.create()
				.type(HikariDataSource.class)
				.driverClassName(com.sap.db.jdbc.Driver.class.getName())
				.url(url)
				.username(user)
				.password(password)
				.build();	
	}
	
	
	
}