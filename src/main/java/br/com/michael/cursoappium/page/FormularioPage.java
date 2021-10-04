package br.com.michael.cursoappium.page;

import org.openqa.selenium.By;

import br.com.michael.cursoappium.core.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class FormularioPage extends BasePage {

	private final By campoNomePath = MobileBy.AccessibilityId("nome");
	private final By comboVideoGame = MobileBy.xpath("//android.widget.Spinner[@content-desc='console']");
	private final By checkboxData = MobileBy.className("android.widget.CheckBox");
	private final By switchHorario = MobileBy.AccessibilityId("switch");
	private final By btnSalvar = MobileBy.AccessibilityId("save");
	//private final By seekbar = MobileBy.AccessibilityId("slid");
	private final By seekbar = MobileBy.className("android.widget.SeekBar");
	private final By btnSalvarDemorado = MobileBy.xpath("//android.widget.TextView[@text='SALVAR DEMORADO']");
	private final By validacaoSwitch = MobileBy.xpath("//android.widget.TextView[@text='Switch: Off']");
	private final By validacaoCheckbox = MobileBy.xpath("//android.widget.TextView[@text='Checkbox: Marcado']");
	private final By opcaoVideoGameSelecionada = MobileBy.xpath("//android.widget.Spinner/android.widget.TextView");
	private final By datePicker = MobileBy.xpath("//android.widget.TextView[@text='01/01/2000']");
	private final By timePicker = MobileBy.xpath("//android.widget.TextView[@text='06:00']");
	
	
	private static final String validacaoNomeTemplate = "//android.widget.TextView[@text='Nome: %s']";
	private static final String validacaoVideoGame = "//android.widget.TextView[@text='Console: %s']";
	
	public void escreverNome(String nome) {
		escrever(campoNomePath, nome);
	}
	
	public String obterTextoCampoNome() {
		final String campoNomeText = obterTexto(campoNomePath);
		return campoNomeText;
	}
	
	public void escolherItemCombo(String valor) {
		selecionarItemCombo(comboVideoGame, valor);
	}
	
	public String obterTextoVideoGameSelecionado() {
		return obterTexto(opcaoVideoGameSelecionada);
	}
	
	public void interagirComCheckbox() {
		clicar(checkboxData);
	}
	
	public void interagirComSwitch() {
		clicar(switchHorario);
	}
	
	public void clicarBotaoSalvar() {
		clicar(btnSalvar);
	}
	
	public void clicarBotaoSalvarDemorado() {
		clicar(btnSalvarDemorado);
	}
	
	public void alterarDia() {
		clicar(datePicker);
		clicarPorTexto("20");
		clicarPorTexto("OK");
	}
	
	public void alterarHorario() {
		clicar(timePicker);
		clicar(MobileBy.AccessibilityId("10"));
		clicar(MobileBy.AccessibilityId("40"));
		clicarPorTexto("OK");
	}
	
	public void moverSeekbar(double porcentagem) {
		porcentagem /= 100;
		final int DELTA = 55;
		final MobileElement seek = obterElemento(seekbar);
		final int xinicial = seek.getLocation().getX() + DELTA;
		final int x = (int) (xinicial + ((seek.getSize().getWidth() - 2 * DELTA) * porcentagem));
		final int y = (int) (seek.getLocation().getY() + (int) (seek.getSize().height / 2));
		
		System.out.println(x);
		System.out.println(y);
		
		tap(x, y);
	}
	
	public boolean checkboxEstaSelecionada() {
		return checkboxEstaSelecionada(checkboxData);
	}
	
	public boolean switchEstaAtivado() {
		return switchEstaSelecionado(switchHorario);
	}
	
	public boolean textoValidacaoNomeEstaCorreto(String nome) {
		return obterTexto(getValidacaoNome(nome)).equals("Nome: " + nome);
	}
	
	public boolean textoValidacaoVideoGameEstaCorreto(String videoGame) {
		videoGame = videoGame.toLowerCase();
		return obterTexto(getValidacaoVideoGame(videoGame)).equals("Console: " + videoGame);
	}
	
	public boolean textoValidacaoCheckboxEstaCorreto() {
		return obterTexto(validacaoSwitch).equals("Switch: Off");
	}
	
	public boolean textoValidacaoSwitchEstaCorreto() {
		return obterTexto(validacaoCheckbox).equals("Checkbox: Marcado");
	}
	
	private final By getValidacaoNome(String nome) {
		return MobileBy.xpath(String.format(validacaoNomeTemplate, nome));
	}
	
	private final By getValidacaoVideoGame(String videoGame) {
		return MobileBy.xpath(String.format(validacaoVideoGame, videoGame));
	}

	public boolean dataEstaCorreta() {
		return existeElementoPorTexto("20/2/2000");
	}

	public boolean horaEstaCorreta() {
		return existeElementoPorTexto("10:40");
	}

	public boolean quantiaSliderEstaCorreto(double porcentagem) {
		return obterTexto(seekbar).equals("Slider: " + porcentagem);
	}
}
