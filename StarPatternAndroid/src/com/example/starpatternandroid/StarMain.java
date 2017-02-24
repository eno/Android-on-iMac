package com.example.starpatternandroid;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class StarMain extends Activity implements OnItemSelectedListener {
	// todo: a bit primitive but it works. spaces in java command line are
	// larger than spaces in android textView.
	Spinner starSpinner;
	String starstring = "";
	int pSelect = 0;
	String x = "";
	TextView starText;
	String[] starArray = { "make a selection", "leftDecline", "rightDecline",
			"innerLeftDecline", "DiamondPattern" };
	TextUpdater textGen;

	// HashMap myStarArray = new HashMap<String, Integer>();

	// builde spinner and String adapter.
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_star_main);
		starText = (TextView) findViewById(R.id.textView1);
		starSpinner = (Spinner) findViewById(R.id.spinner1);
		starSpinner.setOnItemSelectedListener(this);
		ArrayAdapter<String> starArrayAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, starArray);
		starArrayAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		starSpinner.setAdapter(starArrayAdapter);
		// readyHashMap();
	}

	private void readyHashMap() {
		// not needed
		// TODO Auto-generated method stub
		// for (String a : starArray)
		// myStarArray.put(a, value)

	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
			long arg3) {
		// TODO Auto-generated method stub
		switch (position) {
		// spinner always calls the same method but uses a sentinel value so the
		// method knows which action to perform.
		case 1:
			pSelect = 1;
			textGen = new TextUpdater();
			textGen.execute(x);
			break;
		case 2:
			pSelect = 2;
			textGen = new TextUpdater();
			textGen.execute(x);
			break;
		case 3:
			pSelect = 3;
			textGen = new TextUpdater();
			textGen.execute(x);
			break;
		case 4:
			pSelect = 4;
			textGen = new TextUpdater();
			textGen.execute(x);
			break;
		default:
			pSelect = 0;
			break;
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.star_main, menu);
		return true;
	}

	private class TextUpdater extends AsyncTask<String, String, String> {

		/*
		 * textupdater uses switch based on pSelect sentinel value to decide
		 * which action to perform maybe there is a way to encapsulate each of
		 * these switch cases in their own method that may be accessible to the
		 * private textUpdater class. (non-Javadoc)
		 * 
		 * @see android.os.AsyncTask#doInBackground(Params[])
		 */
		@Override
		protected String doInBackground(String... arg0) {

			// TODO Auto-generated method stub
			switch (pSelect) {

			case 1:
				for (int i = 10; i > 0; i--) {
					for (int stars = i; stars >= 1; stars--) {
						starstring += ("*");
						publishProgress(starstring);
						try {// must be done in asynctask due to thread. this is
								// the
								// main reason I use
								// asynctask
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					starstring += "\n";
				}
				starstring = "";
				break;
			case 2:
				for (int i = 0; i < 10; i++) {
					for (int j = 9; j >= i; j--)
						starstring += ("  ");
					for (int stars = 0; stars <= i; stars++)
						starstring += ("*");
					publishProgress(starstring);
					try {// must be done in asynctask due to thread. this is
							// the
							// main reason I use
							// asynctask
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					starstring += "\n";

				}
				starstring = "";
				break;
			case 3:
				for (int i = 10; i > 0; i--) {
					for (int j = (10 - i); j > 0; j--)
						starstring += ("  ");
					for (int stars = i; stars >= 1; stars--) {
						starstring += ("*");
						publishProgress(starstring);
						try {// must be done in asynctask due to thread. this is
								// the
								// main reason I use
								// asynctask
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					// max -= 1;
					// stars = max;
					starstring += "\n";
				}
				starstring = "";
				break;
			case 4:
				for (int i = 1; i < 10; i += 2) {
					for (int j = 9; j >= i; j -= 2)
						starstring += ("  ");
					for (int stars = 1; stars <= i; stars++)
						starstring += ("*");
					publishProgress(starstring);
					try {// must be done in asynctask due to thread. this is
							// the
							// main reason I use
							// asynctask
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					starstring += "\n";
				}
				for (int i = 10; i > 1; i -= 2) {
					for (int j = 20 - i; j >= i; j -= 4)
						starstring += ("  ");
					for (int stars = 1; stars <= i - 1; stars++)
						starstring += ("*");
					publishProgress(starstring);
					try {// must be done in asynctask due to thread. this is
							// the
							// main reason I use
							// asynctask
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					starstring += "\n";
				}
				starstring = "";
				break;
			}
			return null;
		}

		@Override
		protected void onProgressUpdate(String... values) {
			// append to textField
			starText.setText(values[0]);
		}

		@Override
		protected void onPostExecute(String string) {
			// unused.
			starText.setVisibility(View.VISIBLE);
		}
	}

}
