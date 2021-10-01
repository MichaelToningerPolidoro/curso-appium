package br.com.michael.cursoappium.test;

import br.com.michael.cursoappium.core.BaseTest;
import br.com.michael.cursoappium.page.AlertPage;
import br.com.michael.cursoappium.page.MenuPage;

public class AlertTest extends BaseTest {
	
	private final AlertPage alertPage = new AlertPage();
	private final MenuPage menuPage = new MenuPage();
	
	public void deveConfirmarAlerta() {
		// acessar menu alerta
		menuPage.acessarAlertas();
		// clicar em alerta confirm
		// verificar os textos
		// confirmar alerta
	}
}
