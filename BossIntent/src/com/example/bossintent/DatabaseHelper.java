package com.example.bossintent;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseHelper extends SQLiteOpenHelper {

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	/*public MySQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}*/
	public static final String TABLE_NAME = "myTab";
	public static final String COLUMN_GIFT = "item";
	public static final String COLUMN_APPBY = "appBy"; //COLUMN_ID
	public static final String COLUMN_CMT = "cmt";//COLUMN_COMMENT
	public static final String COLUMN_MGT = "mgtBy";//
	
	private static final String DATABASE_NAME = "comments.db";
	private static final int DATABASE_VERSION = 1;
	
	//Database creation sql statement
	private static final String DATABASE_CREATE = "create table "
			+ TABLE_NAME + "(" + COLUMN_GIFT
			+ " text not null, " + COLUMN_APPBY
			+ " text not null, " + COLUMN_CMT
			+ " text not null, " + COLUMN_MGT
			+ " text not null);";
	
	
	
	@Override
	  public void onCreate(SQLiteDatabase database) {
	    database.execSQL(DATABASE_CREATE);
	  }

	@Override
	  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	    Log.w(DatabaseHelper.class.getName(),
	        "Upgrading database from version " + oldVersion + " to "
	            + newVersion + ", which will destroy all old data");
	    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
	    onCreate(db);
	  }
}
