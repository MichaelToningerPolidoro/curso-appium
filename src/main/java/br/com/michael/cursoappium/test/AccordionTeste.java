package br.com.michael.cursoappium.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.michael.cursoappium.core.BaseTest;
import br.com.michael.cursoappium.page.AccordionPage;
import br.com.michael.cursoappium.page.MenuPage;

public class AccordionTeste extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private AccordionPage accordionPage = new AccordionPage();

	@Test
	public void deveInteragirComAccordion() {
		menuPage.acessarAccordion();
		accordionPage.clicarOpcao1();
		
		assertEquals("Esta é a descrição da opção 1", accordionPage.obterTextoDescricao1());
	}
}
