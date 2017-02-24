package mobilemoney.m3;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListExpenses extends ListActivity {
	private static final int DIALOG_ID = 100;
	
	double gotten;
	
	private SQLiteDatabase database;
	String[] columns;

	private CursorAdapter dataSource;
	String strRead2, strRead;

	
	String deleteClickString;

	private static final String fields[] = { "Item", "Price", "PayMethod", "TransDate", "note", BaseColumns._ID };
	

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		DatabaseHelper helper = new DatabaseHelper(this);
		database = helper.getWritableDatabase();
		
		Cursor data = database.query("names", fields, null, null, null, null,
				null);

		dataSource = new SimpleCursorAdapter(this, R.layout.row, data, fields,
				new int[] { R.id.Item, R.id.Price, R.id.PayMethod, R.id.TransDate, R.id.note });

		ListView view = getListView();
		view.setHeaderDividersEnabled(true);
		view.addHeaderView(getLayoutInflater().inflate(R.layout.row, null));
		
		

		setListAdapter(dataSource);
		
		dataSource.notifyDataSetChanged();


	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, DIALOG_ID, 1, R.string.addItem);
		
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		if (item.getItemId() == DIALOG_ID) {
			showDialog(DIALOG_ID);
		}
		/*if (item.getItemId() == deleter) {
			showDialog(deleter);
			private void Refreshed() {
				Bundle extras = getIntent().getExtras();
			String setItem = extras.getString("newItem");
			String setPrice = extras.getString("newPrice");
			ContentValues values1 = new ContentValues();
			values1.put("Item", setItem);
			values1.put("Price", setPrice);
			
		}}*/
		
		return true;
	
		}

	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		
		Object deleteClick = this.getListAdapter().getItem(position);
		deleteClickString = deleteClick.toString();
		
		AlertDialog  dialBox= createDialogBox();
		dialBox.show();
		
		
	}
	protected AlertDialog createDialogBox(){
		AlertDialog deleter =new AlertDialog.Builder(this)
		.setTitle("Delete stored database?") 
		.setMessage("DELETE THE WHOLE DATABASE")
		.setIcon(R.drawable.ic_launcher)
		.setPositiveButton("Yes",
				new DialogInterface.OnClickListener() {

					
					public void onClick (DialogInterface dialog, int whichButton){
						
						database.delete("names", BaseColumns._ID, null);
						dataSource.notifyDataSetChanged();
						dataSource.getCursor().requery();
						try{
							FileOutputStream fOut = openFileOutput("UserInput.txt", MODE_WORLD_READABLE);

							OutputStreamWriter osw = new OutputStreamWriter(fOut);

							osw.write("0");

							osw.flush();

							osw.close();
							FileOutputStream fOut2 = openFileOutput("UserInput2.txt", MODE_WORLD_READABLE);

							OutputStreamWriter osw2 = new OutputStreamWriter(fOut2);

							osw2.write("0");

							osw2.flush();

							osw2.close();
							
							FileInputStream fis = openFileInput("UserInput.txt");
				    	
				    	InputStreamReader isr = new InputStreamReader(fis);
				    	char[]inputBuffer = new char [20];
				    	isr.read(inputBuffer);
				    	strRead = new String(inputBuffer);
				    	
				    	
				    	FileInputStream fis2 = openFileInput("UserInput2.txt");
				    	
				    	InputStreamReader isr2 = new InputStreamReader(fis2);
				    	char[]inputBuffer2 = new char [20];
				    	isr2.read(inputBuffer2);
				    	strRead2 = new String(inputBuffer2);
				    	
				    	
				    	
				    	}
				    	catch (Exception ioe){

							ioe.printStackTrace();

							}				
						
					}
					})
		
					.setNegativeButton("No",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface deldialog, int which) {
						deldialog.cancel();
					}
				}).create();
		return deleter;
}
	
}