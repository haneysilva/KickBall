package com.haney.andandonatela1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Personagem1 extends Objeto {
	
	public Personagem1(Context context) {
		super(context);
		image = BitmapFactory.decodeResource(getResources(), R.drawable.bad1);
	}

	int linhas  = 4;
	int colunas = 3;
	
	int largura  = 96;
	int altura = 128;
	
	int lFrame = 32;
	int aFrame = 32;

	int fLinha  =  0;
	int fColuna = -1;
	
	int wait = 5;
	int x = 0;
	int y = largura/2;
	int z = 0;
	int w = altura/2;
	int a = 0;
	
	Bitmap image;
	
	@Override
	public void step(Canvas canvas) {
		
		 if(z <= 0 && w <= altura){
		 
			 wait++;
			 fLinha = 2;
			 
			 if(wait == 6 && a == 1){
				 
				 fColuna = -1;
				 a = 0;
			 }
			
			 if(wait >= 6){
				
				 wait = 0;		
				 fColuna++;
				 
				 if(fColuna >= 3){
						
					fColuna = 1;
					a = 1;						
				}
			}	
		}
		
		 if(y >= canvas.getWidth() && x >= canvas.getWidth() - largura){
			
			 wait++;
			 fLinha = 0;
			 
			 if(wait == 6 && a == 1){
				 
				 fColuna = -1;
				 a = 0;
			 }
			 
			 if(wait >= 6){
				
				 wait = 0;		
				 fColuna++;
				 
				 if(fColuna >= 3){
					
					fColuna = 1;
					a = 1;						
				}
			}	
		}
		 
		if(w >= canvas.getHeight() && z >= canvas.getHeight() - altura){
			 
			wait++;
			fLinha = 1;
			 
			if(wait == 6 && a == 1){
				 
				fColuna = -1;
				a = 0;
			 }
			
			if(wait >= 6){
				
				wait = 0;		
				fColuna++;
				
				if(fColuna >= 3){
						
					fColuna = 1;
					a = 1;						
				}
			}	
		}
		
		if(x <= 0 && y <= largura){
		 
			wait++;
			fLinha = 3;
			 
			if(wait == 6 && a == 1){
				 
				fColuna = -1;
				 a = 0;
			}
			
			if(wait >= 6){
				
				wait = 0;		
				fColuna++;
				
				if(fColuna >= 3){
					
					fColuna = 1;
					a = 1;						
				}
			}	
		}
	}

	@Override
	public void draw(Canvas canvas) {
		
		int left = fLinha*lFrame;
		int top = fColuna*aFrame;
		int bottom = top + aFrame;
		int right = left + lFrame;
	
		if(z <= 0 && w <= altura){
				x += 3;
				y += 3;
			}
		 
		if(y >= canvas.getWidth() && x >= canvas.getWidth() - largura){
				y = canvas.getWidth();
				z += 3;
				w += 3;
			}
			
		if(w >= canvas.getHeight() && z >= canvas.getHeight() - altura){
				x -= 3;
				y -= 3;
				w = canvas.getHeight();
			}
		 
		if(x <= 0 && y <= largura){
				w -= 3;
				z -= 3;
			}
		
		Rect src = new Rect(top, left, bottom, right);
		Rect dst = new Rect(x, z, y, w);
		 
		canvas.drawBitmap(image, src, dst, null);
	}

}
