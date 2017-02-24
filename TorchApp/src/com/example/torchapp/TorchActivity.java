package com.example.torchapp;

//Eno Udo
//2/24/14
//todo: Ads, rename app
//"about" in the settings?

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class TorchActivity extends Activity {
	ImageButton torchButton;
	boolean onState = false;
	Camera light;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_torch);

		light = Camera.open();
		final Parameters p = light.getParameters();

		torchButton = (ImageButton) findViewById(R.id.torchButton);
		torchButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (onState) {
					p.setFlashMode(Parameters.FLASH_MODE_OFF);
					light.setParameters(p);
					torchButton.setImageResource(R.drawable.torchoff);
					onState = false;

				} else {
					p.setFlashMode(Parameters.FLASH_MODE_TORCH);
					light.setParameters(p);
					torchButton.setImageResource(R.drawable.torchon);
					onState = true;

				}

			}
		});

	}

	/*
	 * @Override protected void onStop() { super.onStop(); if (light != null)
	 * light.release(); }
	 * 
	 * @Override protected void onResume() { super.onResume(); if (light ==
	 * null) { torchButton.setImageResource(R.drawable.torchoff); light =
	 * Camera.open(); } }
	 * 
	 * @Override protected void onRestart() { super.onRestart(); if (light ==
	 * null) { torchButton.setImageResource(R.drawable.torchoff); light =
	 * Camera.open(); } }
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.torch, menu);
		return true;
	}

}