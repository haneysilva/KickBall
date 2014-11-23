package com.haney.andandonatela1;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

	ControladorDePosicao controlador;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		controlador = new ControladorDePosicao(this);
		
		setContentView(controlador);	
	}

	@Override
	protected void onResume() {
		super.onResume();
		
		controlador.resume();
	}
	
	
}
