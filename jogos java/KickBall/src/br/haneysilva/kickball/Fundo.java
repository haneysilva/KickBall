package br.haneysilva.kickball;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;

public class Fundo extends GameObject {

	public Fundo(Context context) {
		super(context);
	}

	@Override
	public void step(Canvas canvas) {
		// NULL
	}

	@Override
	public void draw(Canvas canvas) {
		
		canvas.drawColor(Color.BLACK);
		//canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.fundo), 0, 0, null);
		
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

}
