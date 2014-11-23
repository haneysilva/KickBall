package com.haney.andandonatela1;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public abstract class Controlador extends SurfaceView implements Runnable {

	private Thread thread;
	private boolean running = false;
	private SurfaceHolder holder;
	
	public Controlador(Context context) {
		super(context);
		
		holder = getHolder();
	}
	
	public abstract void stepObjects(Canvas canvas);
	public abstract void drawObjects(Canvas canvas);

	public void resume() {
		
		thread = new Thread(this);
		thread.start();	
		running = true;
	}
	
	public void stop () {
		
		running = false;
	}
	
	@Override
	public void run() {

		while(running) {
			
			if(!holder.getSurface().isValid())
				continue;
			
			Canvas canvas = holder.lockCanvas(); 
			
			stepObjects(canvas);
			drawObjects(canvas);
		
			holder.unlockCanvasAndPost(canvas);
		}
	}
	
}
