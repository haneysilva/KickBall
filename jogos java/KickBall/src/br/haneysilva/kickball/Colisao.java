package br.haneysilva.kickball;

public class Colisao {

	public Colisao() {
		
	}
	
	public static boolean verificarColisao (Bola bola, Bola bola2) {
		
		float xB1 = bola.getPosicaoX();
		float xB2 = bola2.getPosicaoX();
		
		float yB1 = bola.getPosicaoY();
		float yB2 = bola2.getPosicaoY();
		
		if ((xB2 >= xB1 && xB2 <= (xB1 + bola.getLargura())) && (yB2 + bola2.getAltura() >= yB1 && yB2 + bola2.getAltura() <= (yB1 + bola.getAltura()))) {
			return true;
		}
		
		if ((xB2 >= xB1 && xB2 <= (xB1 + bola.getLargura())) && (yB2 >= yB1 && yB2 <= (yB1 + bola.getAltura()))) {
			return true;
		}
		
		if ((xB2 + bola2.getLargura() >= xB1 && xB2 + bola2.getLargura() <= (xB1 + bola.getLargura())) && (yB2 + bola2.getAltura() >= yB1 && yB2 + bola2.getAltura() <= (yB1 + bola.getAltura()))) {
			return true;
		}
		
		if ((xB2 + bola2.getLargura() >= xB1 && xB2 + bola2.getLargura() <= (xB1 + bola.getLargura())) && (yB2 >= yB1 && yB2 <= (yB1 + bola.getAltura()))) {
			return true;
		}
		
		return false;
	}		
}
