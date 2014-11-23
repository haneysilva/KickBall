package com.haney.andandonatela1;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;


public abstract class Objeto extends View {

	public Objeto(Context context) {
		super(context);
	}
	
	public abstract void step(Canvas canvas);
	public abstract void draw(Canvas canvas);

}
