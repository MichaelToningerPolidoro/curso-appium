package br.com.michael.cursoappium.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.michael.cursoappium.core.BaseTest;
import br.com.michael.cursoappium.page.FormularioPage;
import br.com.michael.cursoappium.page.MenuPage;

public class FormularioTeste extends BaseTest {
	
	private static final String NOME = "Michael";
	private static final String PS4 = "PS4";

	private MenuPage menuPage = new MenuPage(); 
	private FormularioPage formularioPage = new FormularioPage();
	
	@Before
	public void inicializarAppium() {
		menuPage.acessarFormulario();
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
	
	@Test
	public void deveRealizarCadastroDemorado() {
		formularioPage.escreverNome(NOME);
		formularioPage.clicarBotaoSalvarDemorado();
	}
	
	@Test
	public void deveAlterarData() {
		formularioPage.alterarDia();
		assertTrue(formularioPage.dataEstaCorreta());
	}
	
	@Test
	public void deveAlterarHorario() {
		formularioPage.alterarHorario();
		assertTrue(formularioPage.horaEstaCorreta());
	}
	
	@Test
	public void deveInteragirComSeekbar() {
		final double porcentagem = 65;
		formularioPage.moverSeekbar(porcentagem);
		formularioPage.clicarBotaoSalvar();
		assertTrue(formularioPage.quantiaSliderEstaCorreto(porcentagem));
	}
}
