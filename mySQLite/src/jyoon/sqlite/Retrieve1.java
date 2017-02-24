package jyoon.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class Retrieve1 extends Activity {

	
	TextView tv1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		
		tv1 = (TextView) findViewById(R.id.textResult);
		Cursor cur = getAllItems();
		cur.moveToFirst();
		while (cur.isAfterLast() == false) {
			tv1.append("\n" + cur.getString(1) +
					" \t" + cur.getString(2) + "\t" + cur.getString(3));
			cur.moveToNext();
		}
	}
	
	public Cursor getAllItems() {
		DatabaseHelper dbHelper = new DatabaseHelper(this);
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cur = db.rawQuery("SELECT " + DatabaseHelper.ColID + " as _id, "
				+ DatabaseHelper.ColMAKE + ", "
				+ DatabaseHelper.ColMODEL + ", "
				+ DatabaseHelper.ColYEAR + " FROM " 
				+ DatabaseHelper.TABLE_NAME, new String[] {});
		return cur;
	}

}
