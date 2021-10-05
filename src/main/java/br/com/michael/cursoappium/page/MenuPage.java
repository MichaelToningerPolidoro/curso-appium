package br.com.michael.cursoappium.page;

import org.openqa.selenium.By;

import br.com.michael.cursoappium.core.BasePage;
import io.appium.java_client.MobileBy;

public class MenuPage extends BasePage {
	
	private static final String botoesTemplateXpath = "//android.widget.TextView[@text='%s']";
	private static final By formulario = getXpath("Formulário");
	private static final By splash = getXpath("Splash");
	private static final By alertas = getXpath("Alertas");
	private static final By seuBarrigaNativo = getXpath("SeuBarriga Nativo");
	private static final By seuBarrigaHibrido = getXpath("SeuBarriga Híbrido");
	private static final By accordion = getXpath("Accordion");
	private static final By abas = getXpath("Abas");
	private static final By cliques = getXpath("Cliques");
	private static final By opcaoEscondida = getXpath("Opção bem escondida");
	private static final By swip = getXpath("Swipe");
	private static final By swipList = getXpath("Swipe List");
	private static final By dragNDrop = getXpath("Drag and drop");
	
	public void acessarFormulario() {
		clicar(formulario);
	}
	
	public void acessarSplash() {
		clicar(splash);
	}
	
	public void acessarAlertas() {
		clicar(alertas);
	}
	
	public void acessarSeuBarrigaNativo() {
		clicar(seuBarrigaNativo);
	}
	
	public void acessarSeuBarrigaHibrido() {
		clicar(seuBarrigaHibrido);
	}
	
	public void acessarAccordion() {
		clicar(accordion);
	}
	
	public void acessarAbas() {
		clicar(abas);
	}
	
	public void acessarCliques() {
		clicar(cliques);
	}
	
	public void acessarOpcaoEscondida() {
		clicar(opcaoEscondida);
	}
	
	public void acessarSwipe() {
		clicar(swip);
	}
	
	public void acessarSwipeList() {
		scrollDown(0.9, 0.2);
		clicar(swipList);
	}
	
	public void acessarDragNDrop() {
		scrollDown(0.9, 0.2);
		clicar(dragNDrop);
	}
	
	public void realizarScrollUp(double inicio, double fim) {
		scrollUp(inicio, fim);
	}
	
	public void realizarScrollDown(double inicio, double fim) {
		scrollDown(inicio, fim);
	}
	
	public boolean estaNaTelaInicial() {
		return existeElementoPorTexto("About...");
	}
	
	private static final By getXpath(String opcao) {
		return MobileBy.xpath(String.format(botoesTemplateXpath, opcao));
	}
}
