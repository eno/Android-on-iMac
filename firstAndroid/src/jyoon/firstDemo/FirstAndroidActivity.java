package jyoon.firstDemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FirstAndroidActivity extends Activity {
    /** Called when the activity is first created. */
	TextView myArea;
	EditText myEdit;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        myArea = (TextView) findViewById(R.id.myview);
        myEdit = (EditText) findViewById(R.id.userInput);
        Button myBttn = (Button) findViewById(R.id.mybn1);
        myBttn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String tempTxt = myEdit.getText().toString();
				myArea.setText("What you typed is: " + tempTxt);
			}
		});
        myArea.setText("No, It's YOU....");
        
        for (int i=0; i<3; i++) {
        	Toast.makeText(getApplicationContext(), i+"Hello World",1).show();
        }
        Toast.makeText(getApplicationContext(), "Bye",1).show();
        
    }
}