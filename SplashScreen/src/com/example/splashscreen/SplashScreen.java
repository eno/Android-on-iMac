package com.example.splashscreen;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;

public class SplashScreen extends Activity {
	protected boolean _active = true;
	protected int _splashTime = 5000; // time to display the splash screen in ms

  
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        //thread for diplaying SplashScreen
        Thread splashThread = new Thread(){
        	@Override
        	public void run() {
        		try {
        			int waited = 0;
        			while( _active && (waited < _splashTime)) {
        				sleep (100);
        				if (_active) {
        					waited += 100;
        
        				}
        			}
        		}catch(InterruptedException e){
        			//do nothing
        		}finally {
        			finish();
        			Intent i2 = new Intent(SplashScreen.this, MyApp.class);
        			startActivity(i2);
        			//stop();
        		}
        	}
        	
        
        
    };
    splashThread.start();
    } 
    @Override
	public boolean onTouchEvent(MotionEvent event) {
	if (event.getAction()== MotionEvent.ACTION_DOWN){
		_active = false;
	}
	return true;
}
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.splashscreen, menu);
        return true;
    }
}
