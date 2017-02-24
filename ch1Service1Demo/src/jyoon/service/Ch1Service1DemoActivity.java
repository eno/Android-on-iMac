package jyoon.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class Ch1Service1DemoActivity extends Service implements Runnable {
    /** Called when the activity is first created. */
	private int counter=0;
    @Override
    
    public void onCreate() {
        super.onCreate();
        Thread aThread = new Thread(this);
        aThread.start();
    }
    
    public void run() {
    	while (true) {
    		try {
    			Log.i("service1", "service1 firing: # " + counter++);
    			Thread.sleep(10000);
    		} catch (Exception ee){
    			Log.e("Service1", ee.getMessage());
    		}
    	}
    }
    
    @Override
    public IBinder onBind (Intent intent) {
    	return null;
    }
}