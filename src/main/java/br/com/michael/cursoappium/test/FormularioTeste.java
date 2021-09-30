package br.com.michael.cursoappium.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.com.michael.cursoappium.core.DSL;
import br.com.michael.cursoappium.core.DSLFactory;
import br.com.michael.cursoappium.core.DriverFactory;
import br.com.michael.cursoappium.page.FormularioPage;
import br.com.michael.cursoappium.page.MenuPage;
import io.appium.java_client.MobileBy;

public class FormularioTeste {
	
	private static final String NOME = "Michael";
	private static final String PS4 = "PS4";

	private MenuPage menuPage = new MenuPage(); 
	private FormularioPage formularioPage = new FormularioPage();
	
	@Before
	public void inicializarAppium() {
		menuPage.acessarFormulario();
	}
	
	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}
	
	@Test
	public void devePreencherCampoTexto() {
		formularioPage.escreverNome(NOME);
		final String textoCampoNome = formularioPage.obterTextoCampoNome();
		assertEquals(NOME, textoCampoNome);
	}
	
	@Test
	public void deveInteragirComCombo() {
		formularioPage.escolherItemCombo(PS4);
		assertEquals(PS4, formularioPage.obterTextoVideoGameSelecionado());
	}
	
	@Test
	public void deveInteragirComCheckboxESwitch() {
		formularioPage.interagirComCheckbox();
		formularioPage.interagirComSwitch();
		
		assertFalse(formularioPage.checkboxEstaSelecionada());
		assertFalse(formularioPage.switchEstaAtivado());
		
		formularioPage.interagirComCheckbox();
		formularioPage.interagirComSwitch();
		
		assertFalse(formularioPage.checkboxEstaSelecionada());
		assertTrue(formularioPage.switchEstaAtivado());
	}
	
	@Test
	public void desafioCadastro() {
		formularioPage.escreverNome(NOME);
		formularioPage.escolherItemCombo(PS4);
		formularioPage.interagirComCheckbox();
		formularioPage.interagirComSwitch();
		formularioPage.clicarBotaoSalvar();
		
		assertTrue(formularioPage.textoValidacaoNomeEstaCorreto(NOME));
		assertTrue(formularioPage.textoValidacaoVideoGameEstaCorreto(PS4));
		assertTrue(formularioPage.textoValidacaoCheckboxEstaCorreto());
		assertTrue(formularioPage.textoValidacaoSwitchEstaCorreto());
	}
}
