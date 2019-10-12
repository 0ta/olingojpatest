package com.ota.olingojpatest;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class HDINameStrategy extends PhysicalNamingStrategyStandardImpl {

	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
		return Identifier.toIdentifier("\"ZDBPrj.testdbm::" + name.getText() + "\"", name.isQuoted());
	}

	@Override
	public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
		return Identifier.toIdentifier("\"" + name.getText() + "\"", name.isQuoted());
	}

    
}
