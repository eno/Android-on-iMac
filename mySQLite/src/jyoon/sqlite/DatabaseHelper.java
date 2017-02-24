package jyoon.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	static final String DATABASE_NAME = "auto.db";
	static final String TABLE_NAME = "cars";
	static final String ColID = "_id";
	static final String ColMAKE = "maker";
	static final String ColMODEL = "model";
	static final String ColYEAR = "year";

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE "+ TABLE_NAME + 
				" ( " + ColID +
				" INTEGER PRIMARY KEY AUTOINCREMENT, " +
				ColMAKE + " TEXT, " +
				ColMODEL + " TEXT, " + ColYEAR + " TEXT);" );
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);
	}

	
	
	

}
