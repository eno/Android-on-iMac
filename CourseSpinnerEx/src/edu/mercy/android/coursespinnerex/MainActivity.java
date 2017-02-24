package edu.mercy.android.coursespinnerex;

import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity implements
		AdapterView.OnItemSelectedListener {

	Spinner mySpin;
	TextView toDisplay;
	String[] crsList = { "Artificial Intelligence", "Database", "Java",
			"Linear Algebra", "Operating System", "Software Engineering",
			"Unix", "Website Administration" };

	HashMap myCrsCrdit = new HashMap<String, Integer>();

	@Override
	// building the spinner, and string adapter
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		toDisplay = (TextView) findViewById(R.id.textView2);
		mySpin = (Spinner) findViewById(R.id.spinner1);
		mySpin.setOnItemSelectedListener(this);
		ArrayAdapter<String> crsAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, crsList);
		crsAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mySpin.setAdapter(crsAdapter);
		readyHashMap();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
			long arg3) {
		// display on lower text
		toDisplay.setText(crsList[position] + "\t"
				+ myCrsCrdit.get(crsList[position]) + "credits");

	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

	private void readyHashMap() {
		for (String a : crsList) {
			myCrsCrdit.put(a, (int) (Math.random() * 3) + 2);
		}
	}
}
