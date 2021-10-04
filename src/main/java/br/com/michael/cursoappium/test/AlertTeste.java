package br.com.michael.cursoappium.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.michael.cursoappium.core.BaseTest;
import br.com.michael.cursoappium.page.AlertPage;
import br.com.michael.cursoappium.page.MenuPage;

public class AlertTeste extends BaseTest {
	
	private final AlertPage alertPage = new AlertPage();
	private final MenuPage menuPage = new MenuPage();
	
	@Test
	public void deveConfirmarAlerta() {
		menuPage.acessarAlertas();
		alertPage.clicarAlertaConfirm();
		assertEquals("Info", alertPage.obterTituloAlerta());
		assertEquals("Confirma a operação?", alertPage.obterTextoAlerta());
		
		alertPage.clicarConfirm();
		assertEquals("Confirmado", alertPage.obterTextoAlerta());
		
		alertPage.clicarSair();
	}
	
	@Test
	public void deveTentarClicarForaDoAlerta() {
		menuPage.acessarAlertas();
		alertPage.clicarAlertaSimples();
		esperar(500);
		alertPage.tentarClicarForaDoAlert();
	}
}
