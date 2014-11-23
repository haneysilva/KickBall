package com.haney.andandonatela1;

import android.content.Context;
import android.graphics.Canvas;

public class ControladorDePosicao extends Controlador {

	Fundo fundo;
	Personagem personagem;
	
	public ControladorDePosicao(Context context) {
		super(context);
		
		fundo = new Fundo(context);
		personagem = new Personagem(context);
	}

	@Override
	public void stepObjects(Canvas canvas) {

		fundo.step(canvas);
		personagem.step(canvas);
	}

	@Override
	public void drawObjects(Canvas canvas) {

		fundo.draw(canvas);
		personagem.draw(canvas);
	}

}
