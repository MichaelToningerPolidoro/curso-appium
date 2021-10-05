package br.com.michael.cursoappium.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.michael.cursoappium.core.BaseTest;
import br.com.michael.cursoappium.page.MenuPage;
import br.com.michael.cursoappium.page.SwipePage;

public class SwipeTeste extends BaseTest {

	private final MenuPage menuPage = new MenuPage();
	private final SwipePage swipePage = new SwipePage();
	
	@Test
	public void deveInteragirComSwipe() {
		esperar(1500);
		menuPage.realizarScrollDown(0.9, 0.2);
		menuPage.acessarSwipe();
		
		esperar(1000);
		assertTrue(swipePage.elementoAEsquerdaEstaPresente());
		swipePage.realizarSwipeLeft(0.9, 0.2);
		esperar(500);
		swipePage.realizarSwipeRight(0.9, 0.2);
		esperar(1000);
		//assertTrue(swipePage.elementoEVejaSeEstaPresente());
	}
}
