package br.com.michael.cursoappium.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.michael.cursoappium.core.BaseTest;
import br.com.michael.cursoappium.page.MenuPage;
import br.com.michael.cursoappium.page.SplashPage;

public class SplashTeste extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private SplashPage splashPage = new SplashPage();

	@Test
	public void deveAguardarSplashSumir() {
		menuPage.acessarSplash();
		assertTrue(splashPage.telaSplashEstaAparecendo());
		splashPage.aguardarSplashSumir();
		assertTrue(menuPage.estaNaTelaInicial());
	}
}
