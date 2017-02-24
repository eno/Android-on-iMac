//MainActivity.java
//author: Eno Udo
//date: Nov 13, 2013
//Copyrights Reserved
//learning asyncTask and translating Unicode java exercise into an andorid app.
//todo : done

package com.example.unicodeandroid;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView unicodeText;
	Button unicodeButton;
	TextUpdater textGen;
	String uniString = "";
	int i = 32;
	String x = "";
	int sentinel = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		unicodeText = (TextView) findViewById(R.id.textView1);
		unicodeButton = (Button) findViewById(R.id.unicodeButton);
		unicodeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (sentinel == 1) {
					textGen = new TextUpdater();
					unicodeButton.setText("Clear");
					textGen.execute(x);
					// disable the button until the task is done
					sentinel = 2;
					// unicodeButton.setVisibility(View.INVISIBLE);
					unicodeButton.setEnabled(false);

				} else {
					textGen.cancel(true);
					unicodeButton.setText("Show Unicode");
					unicodeText.setText("cleared");
					sentinel = 1;
				}

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class TextUpdater extends AsyncTask<String, String, String> {
		@Override
		protected String doInBackground(String... params) {
			uniString = "";
			i = 32;
			// nested loop t print entries five to a line
			while (i < 127) {
				for (int j = 0; j < 5; j++) {

					if (isCancelled())
						break;

					uniString += (char) i + "\t";

					publishProgress(uniString);

					i++;
					try {// must be done in asynctask due to thread. this is the
							// main reason I use
							// asynctask
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				uniString += "\n";
				// newline to keep 5 entries per line
			}
			uniString = "";// initialize instance data
			i = 32;

			return null;
		}

		@Override
		protected void onProgressUpdate(String... values) {
			// append to textField
			unicodeText.setText(values[0]);
		}

		@Override
		protected void onPostExecute(String string) {
			// unicodeButton.setVisibility(View.VISIBLE);
			unicodeButton.setEnabled(true);
		}
	}

}
