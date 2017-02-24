package com.example.bossintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MyBoss extends Activity implements OnClickListener {
	TextView dispHere;
	Button btn2back;
	String gift;
	EditText bossComm;
	EditText apprvBy;


	/* (non-Javadoc)
	 * @see android.app.Activity#finish()
	 */
	@Override
	public void finish() {
		// TODO Auto-generated method stub
		Intent i = new Intent ();
		i.putExtra("return1", gift + " is approved");
		i.putExtra("comment1", "Good Job!");
		i.putExtra("ApprovedBy", apprvBy.getText().toString());
		i.putExtra("bossComment", bossComm.getText().toString());
		setResult(RESULT_OK,i);
		super.finish();
	}
	@Override
    protected void onResume() {
        super.onResume();
        // The activity has become visible (it is now "resumed").
    }

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.boss_view);
		Bundle extras = getIntent().getExtras();
		gift = extras.getString("myInquiry1");
		bossComm = (EditText)findViewById(R.id.boss2comment);
		apprvBy = (EditText)findViewById(R.id.boss2approve);
		dispHere = (TextView)findViewById(R.id.bossTxt1);
		btn2back = (Button)findViewById(R.id.btn2origin);
		btn2back.setOnClickListener(this);
	}

	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		finish();
	}

}
