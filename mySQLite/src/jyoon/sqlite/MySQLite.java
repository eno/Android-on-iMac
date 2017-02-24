package jyoon.sqlite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MySQLite extends Activity {
    /** Called when the activity is first created. */
	Button insert1;
	Button retrieve1;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainfirst);
        
        insert1 = (Button) findViewById(R.id.insert1);
        
        insert1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("jyoon.sqlite.INSERTIONONE"));
				
			}
        } );
        
        retrieve1 = (Button) findViewById(R.id.retrieve1);
        retrieve1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("jyoon.sqlite.RETRIEVEONE"));
				
			}
		});
    }
}