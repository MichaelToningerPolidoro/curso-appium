package br.com.michael.cursoappium.test;

import org.junit.Test;

import br.com.michael.cursoappium.core.BaseTest;
import br.com.michael.cursoappium.page.MenuPage;

public class SplashTeste extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();

	@Test
	public void deveAguardarSplashSumir() {
		// acessar menu splash
		menuPage.acessarSplash();
		// verificar que splash esta sendo exibido
		// aguardar saida do splash
		// verificar que menu esta aparecendo
	}
}
