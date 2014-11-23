package com.haney.andandonatela1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Personagem extends Objeto {

	int linhas = 4, colunas = 3;
	int lFrame = 32, aFrame = 32;
	int fLinha = 2, fColuna = 0;
	int x = 0, y = 0;
	int passoX = 4, passoY = 4;
	
	Bitmap image;
	
	boolean flag;
	int wait = 0;
	
	public Personagem(Context context) {
		super(context);
		
		image = BitmapFactory.decodeResource(getResources(), R.drawable.bad1);
		lFrame = image.getWidth()/3;
		aFrame = image.getHeight()/4;
		fColuna++;
		flag = true;
	}

	@Override
	public void step(Canvas canvas) {
		
		wait++;
		
		if (wait > 5) {
			
			wait = 0;
		
			if (x <= 0 && y <= 0) {
				
				x = x + passoX;
				fLinha = 2;
			}
			
			if ((x >= 0 && (x <= canvas.getWidth() - image.getWidth()/3)) && y <=0) {
				
				x = x + passoX;
				fLinha = 2;
			}
			
			if (x >= (canvas.getWidth() - image.getWidth()/3) && y <= 0) {
				
				y = y + passoY;
				fLinha = 0;
			}
			
			if (x >= (canvas.getWidth() - image.getWidth()/3) && (y >= 0 && y <= (canvas.getHeight() - image.getHeight()/4))) {
				
				y = y + passoY;
				fLinha = 0;
			}
			
			if (x >= (canvas.getWidth() - image.getWidth()/3) && y >= (canvas.getHeight() - image.getHeight()/4))  {
				
				x = x - passoX;
				fLinha = 1;
			}
			
			if ((x <= (canvas.getWidth() - image.getWidth()/3) && x >= 0) && y >= (canvas.getHeight() - image.getHeight()/4))  {
				
				x = x - passoX;
				fLinha = 1;
			}
			
			if (x <= 0 && y >= (canvas.getHeight() - image.getHeight()/4)) {
				
				y = y - passoY;
				fLinha = 3;
			}
			
			if (x <= 0 && (y <= (canvas.getHeight() - image.getHeight()/4) && y >= 0)) {
				
				y = y - passoY;
				fLinha = 3;
			}
	
			if (fColuna <= 0) {
				
				fColuna++;
				flag = true;
			}
			
			if ((fColuna > 0) && (flag == true)) {
				
				fColuna++;
			}
			
			if ((fColuna > 0) && (flag == false)) {
				
				fColuna--;
			}
			
			if (fColuna > 2) {
				
				fColuna--;
				flag = false;
			}
		
		}
	}

	@Override
	public void draw(Canvas canvas) {

		int top  = fLinha*aFrame;
		int left = fColuna*lFrame;
		int right = left + lFrame;
		int bottom  = top + aFrame;

		Rect src = new Rect(left, top, right, bottom);
		
		Rect dst = new Rect(x, y, x + aFrame, y + lFrame);
		
		canvas.drawBitmap(image, src, dst, null);
		
		//canvas.drawBitmap(image, x, y, null);
	}

}
