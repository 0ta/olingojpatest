package com.ota.olingojpatest;

import javax.persistence.EntityManagerFactory;

import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAServiceFactory;
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPARuntimeException;

public class JPAODataServiceFactory extends ODataJPAServiceFactory {

	private final EntityManagerFactory entityManagerFactory;
	private final String namespace;

	public JPAODataServiceFactory(EntityManagerFactory entityManagerFactory, String namespace) {
		this.entityManagerFactory = entityManagerFactory;
		this.namespace = namespace;
	}

	@Override
	public ODataJPAContext initializeODataJPAContext() throws ODataJPARuntimeException {
		ODataJPAContext context = getODataJPAContext();
		context.setEntityManagerFactory(entityManagerFactory);
		context.setPersistenceUnitName(namespace);
		return context;
	}
}
