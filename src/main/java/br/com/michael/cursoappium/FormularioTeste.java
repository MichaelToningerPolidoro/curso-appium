package br.com.michael.cursoappium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.michael.cursoappium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class FormularioTeste {
	
	private static final int FORMULARIO_INDEX = 1;
	private static final String NOME = "Michael";
	private static final String PS4 = "PS4";
	
	private static AndroidDriver<MobileElement> driver;

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
	private static void inicializarAppium() throws MalformedURLException {
		driver = DriverFactory.getDriver();
		
		driver.findElement(formularioHome).click();
	}
	
	@After
	private static void tearDown() {
		DriverFactory.killDriver();
	}
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		final List<MobileElement> elementosEncontrados = driver.findElements(textClass);
		elementosEncontrados.get(FORMULARIO_INDEX).click();
		
		final MobileElement campoNome = driver.findElement(campoNomePath);
		
		campoNome.sendKeys(NOME);
		
		final String campoNomeText = campoNome.getText();
		assertEquals(NOME, campoNomeText);
	}
	
	@Test
	public void deveInteragirComCombo() throws MalformedURLException {
		driver.findElement(comboVideoGame).click();
		driver.findElement(comboOpcaoPS4).click();
		
		final String textoVideoGameSelecionado = driver.findElement(opcaoVideoGameSelecionada).getText();
		assertEquals(PS4, textoVideoGameSelecionado);
	}
	
	@Test
	public void deveInteragirComCheckboxESwitch() throws MalformedURLException {
		MobileElement checkbox = driver.findElement(checkboxData);
		MobileElement switchHora = driver.findElement(switchHorario);
		
		assertFalse(checkbox.isSelected());
		assertTrue(switchHora.getAttribute("checked").equals("true"));
		
		checkbox.click();
		switchHora.click();
		
		assertFalse(checkbox.isSelected());
		assertTrue(switchHora.getAttribute("checked").equals("false"));
	}
	
	@Test
	public void desafioCadastro() throws MalformedURLException {
		MobileElement inputNome = driver.findElement(campoNomePath);
		MobileElement combo = driver.findElement(comboVideoGame);
		MobileElement checkbox = driver.findElement(checkboxData);
		MobileElement switchh = driver.findElement(switchHorario);
		MobileElement botaoSalvar = driver.findElement(btnSalvar);
		
		inputNome.sendKeys(NOME);
		combo.click();
		
		MobileElement opcaoCombo = driver.findElement(comboOpcaoPS4);
		opcaoCombo.click();
		
		checkbox.click();
		switchh.click();
		botaoSalvar.click();
		
		MobileElement nomeValidacao = driver.findElement(validacaoNome);
		MobileElement videoGameValidacao = driver.findElement(validacaoVideoGame);
		MobileElement switchValidacao = driver.findElement(validacaoSwitch);
		MobileElement checkboxValidacao = driver.findElement(validacaoCheckbox);
		
		assertTrue(nomeValidacao.getText().equals("Nome: " + NOME));
		assertTrue(videoGameValidacao.getText().equals("Console: ps4"));
		assertTrue(switchValidacao.getText().equals("Switch: Off"));
		assertTrue(checkboxValidacao.getText().equals("Checkbox: Marcado"));
	}
}
