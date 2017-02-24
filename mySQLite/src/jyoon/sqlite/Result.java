package jyoon.sqlite;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Result extends Activity {
	
	//private static final String TABLE_NAME = "cars";
	String carMaker;
	String carModel;
	String carYear;
	EditText carMaker1;
	EditText carModel1;
	EditText carYear1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Button insert1 = (Button) findViewById(R.id.insert1);
		carMaker1 = (EditText) findViewById(R.id.editMaker1);
		carModel1 = (EditText) findViewById(R.id.editModel1);
		carYear1 = (EditText) findViewById(R.id.editYear1);
		
		insert1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				carMaker = carMaker1.getText().toString();
				carModel = carModel1.getText().toString();
				carYear = carYear1.getText().toString();;
				
				insertCar(carMaker, carModel, carYear);
				startActivity(new Intent("android.intent.action.MAIN"));
			}
		});
				
	}
	
	private void insertCar(String make, String model, String year) {
		DatabaseHelper dbHelper = new DatabaseHelper(this);
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		
		ContentValues cv = new ContentValues();
		cv.put(DatabaseHelper.ColID, 1);
		cv.put(DatabaseHelper.ColMAKE, make);
		cv.put(DatabaseHelper.ColMODEL, model);
		cv.put(DatabaseHelper.ColYEAR, year);
		
		//db.insert("cars", DatabaseHelper.MAKE, cv);
		
		db.insert(DatabaseHelper.TABLE_NAME, DatabaseHelper.ColID, cv);
		TextView tv = (TextView) findViewById(R.id.txtInserted);
		tv.setText("inserted!");
		db.close();
	}
	

}
