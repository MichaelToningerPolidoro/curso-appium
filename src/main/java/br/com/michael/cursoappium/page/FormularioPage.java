package br.com.michael.cursoappium.page;

import org.openqa.selenium.By;

import br.com.michael.cursoappium.core.BasePage;
import io.appium.java_client.MobileBy;

public class FormularioPage extends BasePage {

	private static final By campoNomePath = MobileBy.AccessibilityId("nome");
	private static final By comboVideoGame = MobileBy.xpath("//android.widget.Spinner[@content-desc='console']");
	private static final By checkboxData = MobileBy.className("android.widget.CheckBox");
	private static final By switchHorario = MobileBy.AccessibilityId("switch");
	private static final By btnSalvar = MobileBy.AccessibilityId("save");
	private static final By btnSalvarDemorado = MobileBy.xpath("//android.widget.TextView[@text='SALVAR DEMORADO']");
	private static final By validacaoSwitch = MobileBy.xpath("//android.widget.TextView[@text='Switch: Off']");
	private static final By validacaoCheckbox = MobileBy.xpath("//android.widget.TextView[@text='Checkbox: Marcado']");
	private static final By opcaoVideoGameSelecionada = MobileBy.xpath("//android.widget.Spinner/android.widget.TextView");
	
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
}
