package com.example.myhello;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	//variable declared here is instance variable
    
	EditText userInput;
	TextView toDisplay;
	Button myEcho;
	String userName;//we create objects as needed
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userInput = (EditText) findViewById(R.id.herInput);
        //java var defined                         android xml
        toDisplay = (TextView) findViewById(R.id.textView2);
        myEcho = (Button) findViewById(R.id.hisButton);
        myEcho.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				userName = userInput.getText().toString()+"is very nice!";
				
				
			}
		});//remember semicolon at the end of method
    } //variable declared here is considered local variable

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
