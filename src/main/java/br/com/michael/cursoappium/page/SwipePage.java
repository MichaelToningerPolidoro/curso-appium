package br.com.michael.cursoappium.page;

import br.com.michael.cursoappium.core.BasePage;

public class SwipePage extends BasePage {

	public boolean elementoAEsquerdaEstaPresente() {
		return existeElementoPorTexto("a esquerda");
	}
	
	public boolean elementoEVejaSeEstaPresente() {
		return existeElementoPorTexto("E veja se");
	}
	
	public void realizarSwipeRight(double inicio, double fim) {
		swipeRight(inicio, fim);
	}
	
	public void realizarSwipeLeft(double inicio, double fim) {
		swipeLeft(inicio, fim);
	}
}
