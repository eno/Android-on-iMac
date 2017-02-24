package com.example.bossintent;
//ENO UDO CISC395
import java.io.DataOutputStream;
import java.io.FileNotFoundException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

	private static final int req_code=10, req_code2=21;
	private EditText edit2send;
	private TextView dispFromBoss;
	SQLiteDatabase db;
	Button btn2request, btn2store, btn2init;
	private Bundle myGift, myGif2;
	String retFromBoss = "default", cmtFromBoss, appvdByBoss;
	String fname = "myFsaved.txt";
	String database = "myDBcreated";
	String tableDesc = "create table myTab (item TEXT, appBy TEXT, cmt TEXT, mgtBy TEXT);";

			
	DataOutputStream out;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edit2send = (EditText)findViewById(R.id.whatIWant);
		dispFromBoss = (TextView)findViewById(R.id.ret4Boss);
		btn2request = (Button)findViewById(R.id.btnRequest);
		btn2store = (Button)findViewById(R.id.btnReques2);
		
		btn2init = (Button)findViewById(R.id.btn2init);
		btn2init.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					out = new DataOutputStream(openFileOutput(fname, Context.MODE_PRIVATE));
					} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				try {
		    		db = SQLiteDatabase.openDatabase(
		    				"data/data/com.example.bossintent/"+database, 
		    				null,
		    				SQLiteDatabase.CREATE_IF_NECESSARY);
		    		//Toast.makeText(this, "DB was opened!", Toast.LENGTH_SHORT).show();
		    		
		    	} catch (SQLiteException e) {
		    		//Toast.makeText(this, e.getMessage(), 1).show();
		    	}
				
				db.beginTransaction();
		    	try{
		    	    db.execSQL(tableDesc);
		    	    //commit your changes
		    	    db.setTransactionSuccessful();
		    	    //Toast.makeText(this, "Table was created",1).show();
		    	} catch (SQLException e1) {
		    	    //Toast.makeText(this, e1.getMessage(),1).show();
		    	} finally{
		    	    //finish transaction processing
		    	    db.endTransaction();
		    	}
			}
		});
	}
	
	public void doThisOnClick(View v){
    	Intent i = null, i2 = null;
    	switch (v.getId()) {
    	case R.id.btnRequest:
    	   i = new Intent(MainActivity.this, MyBoss.class);
    	   myGift = new Bundle();
    	   myGift.putString("myInquiry1", edit2send.getText().toString());
   	       i.putExtras(myGift);
    	   startActivityForResult(i, req_code);
    	   break;
    	case R.id.btnReques2:
     	   i2 = new Intent(MainActivity.this, MyStore.class);
     	   myGif2 = new Bundle();
     	   myGif2.putString("itemStorage", retFromBoss);
     	   myGif2.putString("cmtStorage", cmtFromBoss);
     	   myGif2.putString("appvStorage", appvdByBoss);

    	   i2.putExtras(myGif2);
     	   startActivityForResult(i2, req_code2);
     	   break;
    	
    	}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onActivityResult(int, int, android.content.Intent)
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if ((requestCode == req_code) && (resultCode == RESULT_OK)){
			retFromBoss = data.getExtras().getString("return1");
			cmtFromBoss = data.getExtras().getString("bossComment");
			appvdByBoss = data.getExtras().getString("ApprovedBy");
		}
		dispFromBoss.setText(retFromBoss+", "+cmtFromBoss+", "+appvdByBoss);
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void finish() {
	}
	@Override
    protected void onResume() {
        super.onResume();
        // The activity has become visible (it is now "resumed").
    }
	
	}