package br.com.michael.cursoappium.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.michael.cursoappium.core.BaseTest;
import br.com.michael.cursoappium.page.AbasPage;
import br.com.michael.cursoappium.page.MenuPage;

public class AbasTeste extends BaseTest {

	MenuPage menuPage = new MenuPage();
	AbasPage abasPage = new AbasPage();
	
	@Test
	public void deveInteragirComAbas() {
		menuPage.acessarAbas();
		
		assertEquals("Este é o conteúdo da Aba 1", abasPage.obterTextoAba());
		
		abasPage.clicarAba2();
		assertEquals("Este é o conteúdo da Aba 2", abasPage.obterTextoAba());
	}
}
