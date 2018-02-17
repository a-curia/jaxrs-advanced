package com.dbbyte.rest;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
public class MyApp extends Application {
	
	@Override
	public Set<Class<?>> getClasses() {
		/**
		 * register only the classes that you need or 
		 */
//		return new HashSet<Class<?>>();
		
		/**
		 * by default all classes in classpath are registered
		 */
		return super.getClasses();
	}

}
