package com.haney.andandonatela1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;

public class Fundo extends Objeto {

	public Fundo(Context context) {
		super(context);
	}

	@Override
	public void step(Canvas canvas) {
		// NULL
	}

	@Override
	public void draw(Canvas canvas) {

		canvas.drawColor(Color.YELLOW);
	}
}
