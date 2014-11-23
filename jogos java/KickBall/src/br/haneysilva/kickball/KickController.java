package br.haneysilva.kickball;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;

public class KickController extends GameController {

	//Objetos do Jogo
	
	Bola bola;
	Bola bola2;
	Fundo fundo;
	
	public KickController(Context context) {
		super(context);
	
		bola = new Bola(context, 5, 5);
		bola2 = new Bola(context, 500, 500);
		bola2.inverteX();
		bola2.inverteY();
		fundo = new Fundo(context);
	}

	@Override
	public void stepObjects(Canvas canvas) {

		//posiciona
		bola.step(canvas);
		bola2.step(canvas);	
		
		boolean teste = Colisao.verificarColisao(bola, bola2);
		
		//verifica-se a colisao aqui
		if (teste == true) {
			bola.inverteX();
			bola2.inverteX();
		}
	}

	@Override
	public void drawObjects(Canvas canvas) {

		fundo.draw(canvas);
		bola.draw(canvas);
		bola2.draw(canvas);
	}

	
	public boolean onTouchEvent(MotionEvent event) {
	
		bola.onTouchEvent(event);
		bola2.onTouchEvent(event);
		return super.onTouchEvent(event);
	}
}
