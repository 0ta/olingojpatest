package com.ota.olingojpatest.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.apache.olingo.odata2.core.servlet.ODataServlet;

public class EmployeeOdataServlet extends ODataServlet {

	private static final long serialVersionUID = 1L;

	private final ODataServiceFactory serviceFactory;

	public EmployeeOdataServlet(ODataServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		req.setAttribute(ODataServiceFactory.FACTORY_INSTANCE_LABEL, serviceFactory);
		super.service(req, res);
	}

}
