package com.ota.olingojpatest.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ota.olingojpatest.entities.Employee;
import com.ota.olingojpatest.models.HelloWorldResponse;

@RestController
@RequestMapping( "/hello" )
public class HelloWorldController
{
	@Autowired
	private EntityManagerFactory emf;
	
    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @RequestMapping( method = RequestMethod.GET )
    public ResponseEntity<HelloWorldResponse> getHello( @RequestParam( defaultValue = "world" ) final String name )
    {
        logger.info("I am running!");
        
        EntityManager em = emf.createEntityManager();
        Employee emp = em.find(Employee.class, "001");
        String empstr = emp.toString();
        
        
        return ResponseEntity.ok(new HelloWorldResponse(empstr));
    }
}
