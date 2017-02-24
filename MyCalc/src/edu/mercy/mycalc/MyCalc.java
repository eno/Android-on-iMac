package edu.mercy.mycalc;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyCalc extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	private EditText editNumb1;
	private EditText editNumb2;
	private Button buttonPlus;
	private Button buttonMinus;
	private Button buttonMultiply;
	private Button buttonDivide;
	private TextView textViewResult;
	private double calcResult = 0.0;
	private double numb1 = 0.0, numb2 = 0.0;
	private String TAG = "--- MyCalc: ";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Log.d(TAG, "onCreated begins");
		allUIcomponents();
		Log.d(TAG, "onCreated after all UI components");
		initializeTextView();
		Log.d(TAG, "onCreated after initialization");
		buttonListener();
		Log.d(TAG, "onCreated done after listener");
	}

	// To have all UI components in the Java memory here
	private void allUIcomponents() {
		editNumb1 = (EditText) findViewById(R.id.editNumb1);
		editNumb2 = (EditText) findViewById(R.id.editNumb2);
		buttonPlus = (Button) findViewById(R.id.buttonPlus);
		buttonMinus = (Button) findViewById(R.id.buttonMinus);
		buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
		buttonDivide = (Button) findViewById(R.id.buttonDivide);
		textViewResult = (TextView) findViewById(R.id.textViewResult);
	}

	// To initialize text views
	private void initializeTextView() {

		textViewResult.setText("");
	}

	// To define button listener
	private void buttonListener() {
		buttonPlus.setOnClickListener((View.OnClickListener) this);
		buttonMinus.setOnClickListener((View.OnClickListener) this);
		buttonMultiply.setOnClickListener((View.OnClickListener) this);
		buttonDivide.setOnClickListener((View.OnClickListener) this);
	}

	// @Override
	public void onClick(View src) {
		numb1 = Double.parseDouble(editNumb1.getText().toString());
		numb2 = Double.parseDouble(editNumb2.getText().toString());
		switch (src.getId()) {
		case R.id.buttonPlus:
			calcResult = numb1 + numb2;
			textViewResult.append("\n" + String.valueOf(numb1) + "+"
					+ String.valueOf(numb2) + "=" + String.valueOf(calcResult));
			break;
		case R.id.buttonMinus:
			calcResult = numb1 - numb2;
			textViewResult.append("\n" + String.valueOf(numb1) + "-"
					+ String.valueOf(numb2) + "=" + String.valueOf(calcResult));
			break;
		case R.id.buttonMultiply:
			calcResult = numb1 * numb2;
			textViewResult.append("\n" + String.valueOf(numb1) + "*"
					+ String.valueOf(numb2) + "=" + String.valueOf(calcResult));
			break;
		case R.id.buttonDivide:
			calcResult = numb1 / numb2;
			textViewResult.append("\n" + String.valueOf(numb1) + "/"
					+ String.valueOf(numb2) + "=" + String.valueOf(calcResult));
			break;
		}

	}
}