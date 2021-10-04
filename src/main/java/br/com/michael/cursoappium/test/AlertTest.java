package br.com.michael.cursoappium.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.michael.cursoappium.core.BaseTest;
import br.com.michael.cursoappium.page.AlertPage;
import br.com.michael.cursoappium.page.MenuPage;

public class AlertTest extends BaseTest {
	
	private final AlertPage alertPage = new AlertPage();
	private final MenuPage menuPage = new MenuPage();
	
	@Test
	public void deveConfirmarAlerta() {
		// acessar menu alerta
		menuPage.acessarAlertas();
		// clicar em alerta confirm
		alertPage.clicarAlertaConfirm();
		// verificar os textos
		assertEquals("Info", alertPage.obterTituloAlerta());
		assertEquals("Confirma a operação?", alertPage.obterTextoAlerta());
		// confirmar alerta
		
		alertPage.clicarConfirm();
		assertEquals("Confirmado", alertPage.obterTextoAlerta());
		
		alertPage.clicarSair();
	}
}
