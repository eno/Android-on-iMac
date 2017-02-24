package com.example.fileintentex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MyBoss extends Activity implements OnClickListener {
	TextView dispHere;
	Button btn2back;
	String gift;


	/* (non-Javadoc)
	 * @see android.app.Activity#finish()
	 */
	@Override
	public void finish() {
		// TODO Auto-generated method stub
		Intent i = new Intent ();
		i.putExtra("return1", gift + "is approved");
		i.putExtra("comment1", "Good Job!");
		setResult(RESULT_OK,i);
		super.finish();
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
		dispHere = (TextView)findViewById(R.id.text4boss);
		btn2back = (Button)findViewById(R.id.fromBossBtn);
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
