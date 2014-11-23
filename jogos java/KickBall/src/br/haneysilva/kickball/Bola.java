package br.haneysilva.kickball;

import android.R.integer;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

public class Bola extends GameObject {

	Paint paint = new Paint();
	Bitmap imagem;
	
	private int passoX = 4, passoY = 4;
	
	public Bola(Context context, float x, float y) {
		super(context);
		
		imagem = BitmapFactory.decodeResource(getResources(), R.drawable.bola);
		altura = imagem.getHeight();
		largura = imagem.getWidth();
		this.x = x;
		this.y = y;
	}

	@Override
	public void step(Canvas canvas) {

		if(x >= (canvas.getWidth() - largura) || x <= 1)
			passoX = passoX * (-1);
		
		if(y >= (canvas.getHeight() - altura) || y <= 1)
			passoY = passoY * (-1);
		
		x = x + passoX;
		y = y + passoY;
	}

	@Override
	public void draw(Canvas canvas) {

		canvas.drawBitmap(imagem, x, y, null);
	}
	
	public void inverteY () {
		
		passoY = passoY * (-1);
	}
	
	public void inverteX () {
		
		passoX = passoX * (-1);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		float xEvent = event.getX();
		float yEvent = event.getY();
		
		float xBottom = x + largura;
		float yBottom = y + altura;
		
		if((xEvent >= x && xEvent <= xBottom) && (yEvent >= y && yEvent <= yBottom)){
			
			inverteY();
			return true;
		} else return false;
	}
	
	public float getPosicaoX () {
		return x;
	}
	
	public float getPosicaoY () {
		return y;
	}
	
	public float getAltura () {
		return altura;
	}
	
	public float getLargura () {
		return largura;
	}
}
