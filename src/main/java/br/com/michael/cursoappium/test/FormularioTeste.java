package br.com.michael.cursoappium.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.com.michael.cursoappium.core.DSL;
import br.com.michael.cursoappium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class FormularioTeste {
	
	private static final int FORMULARIO_INDEX = 1;
	private static final String NOME = "Michael";
	private static final String PS4 = "PS4";
	
	private static AndroidDriver<MobileElement> driver;
	private static DSL dsl = new DSL(); 

	private static final By textClass = MobileBy.className("android.widget.TextView");
	private static final By campoNomePath = MobileBy.AccessibilityId("nome");
	private static final By formularioHome = MobileBy.xpath("//android.widget.TextView[@text='Formulário']");
	private static final By comboVideoGame = MobileBy.xpath("//android.widget.Spinner[@content-desc='console']");
	private static final By comboOpcaoPS4 = MobileBy.xpath("//android.widget.CheckedTextView[@text='PS4']");
	private static final By opcaoVideoGameSelecionada = MobileBy.xpath("//android.widget.Spinner/android.widget.TextView");
	private static final By checkboxData = MobileBy.className("android.widget.CheckBox");
	private static final By switchHorario = MobileBy.AccessibilityId("switch");
	private static final By btnSalvar = MobileBy.AccessibilityId("save");
	private static final By validacaoNome = MobileBy.xpath("//android.widget.TextView[@text='Nome: " + NOME + "']");
	private static final By validacaoVideoGame = MobileBy.xpath("//android.widget.TextView[@text='Console: ps4']");
	private static final By validacaoSwitch = MobileBy.xpath("//android.widget.TextView[@text='Switch: Off']");
	private static final By validacaoCheckbox = MobileBy.xpath("//android.widget.TextView[@text='Checkbox: Marcado']");
	
	@Before
	public void inicializarAppium() {
		driver = DriverFactory.getDriver();
		
		dsl.clicar(formularioHome);
	}
	
	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}
	
	@Test
	public void devePreencherCampoTexto() {
		dsl.escrever(campoNomePath, NOME);
		
		final String campoNomeText = dsl.obterTexto(campoNomePath);
		assertEquals(NOME, campoNomeText);
	}
	
	@Test
	public void deveInteragirComCombo() {
		dsl.selecionarItemCombo(comboVideoGame, PS4);
		
		final String textoVideoGameSelecionado = dsl.obterTexto(opcaoVideoGameSelecionada);
		assertEquals(PS4, textoVideoGameSelecionado);
	}
	
	@Test
	public void deveInteragirComCheckboxESwitch() {
		dsl.clicar(checkboxData);
		dsl.clicar(switchHorario);
		
		assertFalse(dsl.checkboxEstaSelecionada(checkboxData));
		assertFalse(dsl.switchEstaSelecionado(switchHorario));
		
		dsl.clicar(checkboxData);
		dsl.clicar(switchHorario);
		
		assertFalse(dsl.checkboxEstaSelecionada(checkboxData));
		assertTrue(dsl.switchEstaSelecionado(switchHorario));
	}
	
	@Test
	public void desafioCadastro() {
		dsl.escrever(campoNomePath, NOME);
		dsl.selecionarItemCombo(comboVideoGame, PS4);
		dsl.clicar(checkboxData);
		dsl.clicar(switchHorario);
		dsl.clicar(btnSalvar);
		
		final boolean nomeValidado = dsl.obterTexto(validacaoNome).equals("Nome: " + NOME);
		final boolean videoGameValidado = dsl.obterTexto(validacaoVideoGame).equals("Console: ps4");
		final boolean switchValidado = dsl.obterTexto(validacaoSwitch).equals("Switch: Off");
		final boolean checkboxValidada = dsl.obterTexto(validacaoCheckbox).equals("Checkbox: Marcado");
		
		assertTrue(nomeValidado);
		assertTrue(videoGameValidado);
		assertTrue(switchValidado);
		assertTrue(checkboxValidada);
	}
}
