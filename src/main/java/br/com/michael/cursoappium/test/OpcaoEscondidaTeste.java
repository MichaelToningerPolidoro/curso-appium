package br.com.michael.cursoappium.test;

import org.junit.Test;

import br.com.michael.cursoappium.core.BaseTest;
import br.com.michael.cursoappium.page.MenuPage;

public class OpcaoEscondidaTeste extends BaseTest {

	private final MenuPage menuPage = new MenuPage();
	
	@Test
	public void deveEncontrarOpcaoEscondida() {
		esperar(2000);
		menuPage.realizarScroll(0.9, 0.1);
		menuPage.acessarOpcaoEscondida();
	}
}