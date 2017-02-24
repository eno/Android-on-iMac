package com.example.intentexplicitex;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void callIntent (View v){
    	Intent i = null;
    	switch (v.getId()){
    	case R.id.button1:
    		String mercyGeo = "geo:41.019997,-73.870179";
    		i = new Intent (Intent.ACTION_VIEW, Uri.parse(mercyGeo));
    		startActivity(i);
    	case R.id.button2:
    		i = new Intent (Intent.ACTION_VIEW, Uri.parse("http://www.cysecure.org"));
    		startActivity(i);
    		break;
    		default:
    		break;
    	}
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
