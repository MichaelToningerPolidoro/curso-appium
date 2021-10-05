package br.com.michael.cursoappium.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import br.com.michael.cursoappium.core.BaseTest;
import br.com.michael.cursoappium.page.DragNDropPage;
import br.com.michael.cursoappium.page.MenuPage;

public class DragNDropTeste extends BaseTest {

	private final MenuPage menuPage = new MenuPage();
	private final DragNDropPage dragNDropPage = new DragNDropPage();
	
	private final List<String> estadoInicial = 
			Arrays.asList("Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado");
	
	@Test
	public void deveInteragirComDragNDrop() {
		esperar(1500);
		menuPage.acessarDragNDrop();
		assertEquals(estadoInicial, dragNDropPage.obterListaDeElementos());
	}
}
