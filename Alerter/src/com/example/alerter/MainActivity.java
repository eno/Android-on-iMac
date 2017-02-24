package com.example.alerter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	Button btnGo;
	EditText txtMsg;
	String msg;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txtMsg = (EditText) findViewById(R.id.txtMsg);
		btnGo = (Button) findViewById(R.id.btnGo);
		btnGo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				AlertDialog dialBox = createDialogBox();
				dialBox.show();
				txtMsg.setText("I am here!");
			}

		});
	}// onCreate

	private AlertDialog createDialogBox() {
		AlertDialog myQuittingDialogBox = new AlertDialog.Builder(this)
				// set message, title, and icon
				.setTitle("What to do???")
				.setMessage("yes no maybe :^)")
				.setIcon(R.drawable.ic_launcher)
				// set three option buttons
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								msg = "YES " + Integer.toString(whichButton);
								txtMsg.setText(msg);
							}
						})// setPositiveButton
				.setNeutralButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								msg = "CANCEL " + Integer.toString(whichButton);
								txtMsg.setText(msg);
							}// OnClick
						})// setNeutralButton

				.setNegativeButton("NO", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						msg = "NO " + Integer.toString(whichButton);
						txtMsg.setText(msg);
					}
				})// setNegativeButton
				.create();
		return myQuittingDialogBox;
	}// createDialogBox
}// class

