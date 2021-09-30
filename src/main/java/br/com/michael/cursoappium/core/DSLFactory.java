package br.com.michael.cursoappium.core;

public class DSLFactory {

	private static final DSL dslInstance = new DSL();
	
	private DSLFactory() {
	}
	
	public static final DSL getDSL() {
		return dslInstance;
	}
}
