package br.com.michael.cursoappium.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.michael.cursoappium.core.BaseTest;
import br.com.michael.cursoappium.page.MenuPage;
import br.com.michael.cursoappium.page.SwipeListPage;

public class SwipeListTest extends BaseTest {
	
	private final MenuPage menuPage = new MenuPage();
	private final SwipeListPage swipeListPage = new SwipeListPage();

	@Test
	public void deveInteragirComSwipeList() {
		esperar(2000);
		menuPage.acessarSwipeList();
		swipeListPage.swipeElementRight("Opção 1");
		swipeListPage.escolherElemento("(+)");
		esperar(1000);
		assertTrue(swipeListPage.existeElementoNaTela("Opção 1 (+)"));
	}
}
