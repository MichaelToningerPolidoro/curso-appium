package br.com.michael.cursoappium.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.michael.cursoappium.core.BaseTest;
import br.com.michael.cursoappium.page.CliquesPage;
import br.com.michael.cursoappium.page.MenuPage;

public class CliquesTeste extends BaseTest {

	private final MenuPage menuPage = new MenuPage();
	private final CliquesPage cliquesPage = new CliquesPage();
	
	@Test
	public void deveInteragirComCliqueLongo() {
		menuPage.acessarCliques();
		cliquesPage.efetuarCliqueLongo();
		
		assertEquals("Clique Longo", cliquesPage.obterTextoCampo());
	}
	
	@Test
	public void deveRealizarCliqueDuplo() {
		menuPage.acessarCliques();
		cliquesPage.efetuarCliqueDuplo();
		
		assertEquals("Duplo Clique", cliquesPage.obterTextoCampo());
	}
}
