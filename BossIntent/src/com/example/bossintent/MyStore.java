package com.example.bossintent;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import android.app.Activity;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;


	public class MyStore extends ListActivity {

		String itemName;
        String appName;
        String cmtName;
        String mgtName;
		EditText yourName;
		Cursor cs;
		String giftRet = "", commentB = "", apprB = "";
		TextView storeText, display;
		Button btn4f, btn4s, btn2f, btn2s;
		String nameInput = "", toSave;
		String fname = "myFsaved.txt";
		DataOutputStream out;
		DataInputStream in;
		StringBuilder sbF;
		List<String> results = new LinkedList<String>();
		SQLiteDatabase db = null;
		private final String MY_DB_NAME = "myDBcreated";
		private final String MY_DB_TBL = "myTab";
		String VALS;
		String database = "myDBcreated";
		
		String[] fields={"item", "appBy", "cmt", "mgtBy"};
		String[] rez={ itemName, appName, cmtName, mgtName};
	
		  
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			//
			super.onCreate(savedInstanceState);
			setContentView(R.layout.view2store);
			sbF = new StringBuilder();
			//results = new StringBuilder();
			/*btn4f = (Button)findViewById(R.id.btnRet4file);
			btn4s = (Button)findViewById(R.id.btnRet4sqlite);
			btn2f = (Button)findViewById(R.id.btn2file);
			btn2s = (Button)findViewById(R.id.btn2sqlite);*/
			display = (TextView)findViewById(R.id.return2Disp);
			Bundle extraStore = getIntent().getExtras();
			giftRet = extraStore.getString("itemStorage");
			commentB =extraStore.getString("cmtStorage");
			apprB = extraStore.getString("appvStorage");
			storeText = (TextView)findViewById(R.id.txt2store);
			//storeText.setText(giftRet+commentB+apprB);
			yourName = (EditText)findViewById(R.id.edit2store);
			
			
			
		}
		public void click2Store1 (View v) {//update bundle to file
			try{in = new DataInputStream(openFileInput(fname));
			int ch;
			while ((ch=in.read()) !=-1)
				sbF.append((char) ch);
			in.close();
			}catch (FileNotFoundException fnf){
	         } catch (IOException ie){
	             Log.i("Data input sample", "I/O Error");
	          }
			
				nameInput = yourName.getText().toString();
				toSave = (sbF+nameInput+" stored: "+giftRet+" by "+apprB+", with comment: "+commentB+"\n");
				//storeText.setText(toSave);
				try{

					out = new DataOutputStream(openFileOutput(fname, Context.MODE_PRIVATE));

					out.write(toSave.getBytes());

					out.close();
					sbF.setLength(0);
					
				
			}
				catch (Exception ioe){

					ioe.printStackTrace();

				}
				Toast.makeText(this, "File was updated", Toast.LENGTH_SHORT).show();		
		}
				
		public void click2Store2 (View v) {//void to textview(listview)
			//APPEND TO TEXTVIEW
			
				try{
					display.setText("");
					in = new DataInputStream(openFileInput(fname));
					int ch;
					while ((ch=in.read()) !=-1)
						sbF.append((char) ch);
					display.setText(sbF);
					in.close();
					sbF.setLength(0);
				}catch (FileNotFoundException fnf){
		         } catch (IOException ie){
		             Log.i("Data input sample", "I/O Error");
		          }
				
	
			}
		
		public void click2Store3 (View v) {//sqlite update
			
			
			
				
				VALS =" VALUES ('"+nameInput+"', '"+giftRet+"', '"+apprB+"', '"+commentB+"');";
				
				try {db= SQLiteDatabase.openDatabase(
	    				"data/data/com.example.bossintent/"+database, 
	    				null,
	    				SQLiteDatabase.CREATE_IF_NECESSARY);
						
				}catch (SQLiteException e) {
		    		
		    	}
				db.beginTransaction();
				try{
					db.execSQL("CREATE TABLE IF NOT EXISTS "                        
                        + MY_DB_NAME 
                        + " (item TEXT, appBy TEXT, " 
                        + "cmt TEXT, mgtBy TEXT);");
				//add new data 
				db.execSQL("INSERT INTO "                                              
                        + MY_DB_TBL
                        + " ('item', 'appBy', 'cmt', 'mgtBy')"
                        + VALS);
				


			}catch (SQLException e1) {
	    	    //Toast.makeText(this, e1.getMessage(),1).show();
	    	} finally{
	    	    //finish transaction processing
	    	    db.endTransaction();
	    	}
				Toast.makeText(this, "SQLite was updated", Toast.LENGTH_SHORT).show();
		}
		
		
		public void click2Store4 (View v) {//sqlite read & diplay
			//db.getlast
			//add to textview
			
			try {db= SQLiteDatabase.openDatabase(
    				"data/data/com.example.bossintent/"+database, 
    				null,
    				SQLiteDatabase.CREATE_IF_NECESSARY);
					
			//create table
			}catch (SQLiteException e) {
	    
	    	}	
			
			try {
			cs = db.rawQuery("SELECT 'item', 'appBy', 'cmt', 'mgtBy'" +
					"FROM"+MY_DB_TBL+";", null);
			// Get the indices of the Columns we will need 
            int itemColumn = cs.getColumnIndex("item");
            int appColumn = cs.getColumnIndex("appBy");
            int cmtColumn = cs.getColumnIndex("cmt");
            int mgtColumn = cs.getColumnIndex("mgtBy");
            
            /* Check if our result was valid. */
            if (cs != null) {
                    /* Check if at least one Result was returned. */
                    if (cs.isFirst()) { 
                            /* Loop through all Results */
                            do {
                                    
                      // Retrieve the values of the Entry the Cursor is pointing to. 
                                    String itemName = cs.getString(itemColumn);
                                    String appName = cs.getString(appColumn);
                                    String cmtName = cs.getString(cmtColumn);
                                    String mgtName = cs.getString(mgtColumn);
                                 
                                    /* Add current Entry to results. */
                                    results.add("( " + itemName + " " + appName
                                            + " " + cmtName + " " + mgtName + ")\n");
                                    
                            } while (cs.moveToNext());   
                            
                    }
            }
    } catch (SQLiteException e) {
    } finally {
            if (db != null)
                    db.close();
            
    }		
			this.setListAdapter(new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1, results));
			
			
			//doesnt work
			/*this.setListAdapter (new ArrayAdapter <String> (
					this, 
					R.layout.list_view, 
					rez));*/
		
			//doesnt work		
			/*ListView myList =(ListView)findViewById(android.R.layout.simple_list_item_1);
			setContentView(R.layout.list_view);
			this.setListAdapter(new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1));*/
			
			//doesnt work
		/*	@SuppressWarnings("deprecation")
			SimpleCursorAdapter dataSource = new SimpleCursorAdapter(this, R.layout.list_view, cs, fields,
					new int[] {R.id.Item, R.id.ApprovedBy, R.id.Comment, R.id.Managed});*/
			
			//doesnt work
			//ListView view = getListView();
			//this.setListAdapter(dataSource);
			//dataSource.notifyDataSetChanged();
			//display.setText(results);
  /* this.setListAdapter(new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1_small, results));*/
}


		}
		



		

	
	