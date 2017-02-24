package mobilemoney.m3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DatabaseHelper extends SQLiteOpenHelper {

	public DatabaseHelper(Context context) {
		super(context, "ListExpenses", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE IF NOT EXISTS names ("
				+ BaseColumns._ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, Item VARCHAR, Price VARCHAR, PayMethod VARCHAR, TransDate VARCHAR, note VARCHAR)");
		db.execSQL("INSERT INTO names (Item, Price, PayMethod, TransDate, note) VALUES ('Apples', '4.99', 'Cash', '12-2012', 'food')");
		db.execSQL("INSERT INTO names (Item, Price, PayMethod, TransDate, note) VALUES ('Macbook', '899.00', 'Credit', '11-2012', 'computer')");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Steps to upgrade the database for the new version ...
	}
}