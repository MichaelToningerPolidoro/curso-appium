package br.com.michael.cursoappium.core;

import org.junit.After;

public class BaseTest {
	
	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}
}
