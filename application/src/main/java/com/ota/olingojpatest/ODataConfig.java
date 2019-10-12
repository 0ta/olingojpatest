package com.ota.olingojpatest;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ota.olingojpatest.servlets.EmployeeOdataServlet;

@Configuration
public class ODataConfig {

	public static final String NAMESPACE = "Spring_Boot_OData";
	public static final String SERVICE_URL_EMPLOYEE = "/odata.svc/";
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Bean
	ServletRegistrationBean<EmployeeOdataServlet> employeeOdataServlet() {
		return new ServletRegistrationBean<EmployeeOdataServlet>(
				new EmployeeOdataServlet(new JPAODataServiceFactory(entityManagerFactory, NAMESPACE)), SERVICE_URL_EMPLOYEE + "*");
	}
	
}