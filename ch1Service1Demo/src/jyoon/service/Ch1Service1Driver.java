package jyoon.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Ch1Service1Driver extends Activity {
	@Override
	public void onCreate (Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Intent service1Intent = new Intent(this, Ch1Service1DemoActivity.class);
		startService(service1Intent);
		
	}

}
