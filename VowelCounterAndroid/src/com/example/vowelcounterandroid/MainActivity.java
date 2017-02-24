package com.example.vowelcounterandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.vowelcount.VowelCounter;

public class MainActivity extends Activity {
	// string from userInput, countVowels, send toString to outText
	// use a paper texture
	// todo: hide the keyboard when button is pressed so user can see his
	// output.
	TextView outText;
	EditText userInput;
	Button button;
	VowelCounter myVowelCounter;
	String fromInput;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		outText = (TextView) findViewById(R.id.textView2);
		userInput = (EditText) findViewById(R.id.editText1);
		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				myVowelCounter = new VowelCounter();
				fromInput = userInput.getText().toString();
				myVowelCounter.countVowels(fromInput);
				outText.setText(myVowelCounter.toString());

				// ******close the softKeyboard.
				InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
				imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
				// ******
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
