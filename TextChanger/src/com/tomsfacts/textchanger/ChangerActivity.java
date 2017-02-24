package com.tomsfacts.textchanger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChangerActivity extends Activity {
	
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final TextView tvMain = (TextView) findViewById(R.id.textView01);
    	final EditText etMain = (EditText) findViewById(R.id.editText1); 
    	final Button bMain = (Button) findViewById(R.id.button1);
    	try{
    		FileInputStream fis = openFileInput("UserInput.txt");
    	
    	InputStreamReader isr = new InputStreamReader(fis);
    	char[]inputBuffer = new char [20];
    	isr.read(inputBuffer);
    	String strRead = new String(inputBuffer);
    	tvMain.setText(strRead.trim());}
    	catch (Exception ioe){

			ioe.printStackTrace();

			}
    	bMain.setOnClickListener (new View.OnClickListener() {
    		
    		@Override
    		public void onClick (View v){
    			//todo
    			try{

    				FileOutputStream fOut = openFileOutput("UserInput.txt", MODE_WORLD_READABLE);

    				OutputStreamWriter osw = new OutputStreamWriter(fOut);

    				osw.write(etMain.getText().toString());

    				osw.flush();

    				osw.close();

    				
    			FileInputStream fis = openFileInput("UserInput.txt");
    	    	InputStreamReader isr = new InputStreamReader(fis);
    	    	char[]inputBuffer = new char [20];
    	    	isr.read(inputBuffer);
    	    	String strRead = new String(inputBuffer);
    	    	tvMain.setText(strRead.trim());
    		}
    			catch (Exception ioe){

    				ioe.printStackTrace();

    				}
    			
    		}
    	});
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
