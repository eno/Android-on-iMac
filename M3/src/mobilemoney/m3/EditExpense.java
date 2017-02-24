package mobilemoney.m3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.NumberFormat;

import android.os.Bundle;
import android.provider.BaseColumns;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class EditExpense extends Activity {
	EditText itemTxt, priceTxt, payMethodTxt, noteTxt, itemDate;
	TextView toLimTxt2, toMonth;
	double cost, costSum,costAdd=0.0, costPrev, inc0, spendL;
	String sentMonth, sentLimit, sentMonth2;
	String costSumString;
	Bundle exPack;
	int req_code=10;
	String strRead, strRead2, wMonth;
	
	NumberFormat nfInc = NumberFormat.getCurrencyInstance();
	
	private SQLiteDatabase database;
	private static final String fields[] = { "Item", "Price", "PayMethod", "TransDate", "note", BaseColumns._ID };
	private CursorAdapter dataSource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_expense);
        
        
        
        Bundle extras = getIntent().getExtras();
		sentMonth = extras.getString("sendMonth");
		sentMonth2 = extras.getString("sendMonth2");
		sentLimit = extras.getString("sendIncome");
		spendL = Double.parseDouble(sentLimit);
		
		DatabaseHelper helper = new DatabaseHelper(this);
		database = helper.getWritableDatabase();
		Cursor data = database.query("names", fields, null, null, null, null,
				null);

		dataSource = new SimpleCursorAdapter(this, R.layout.row, data, fields,
				new int[] { R.id.Item, R.id.Price, R.id.PayMethod, R.id.TransDate, R.id.note });
		
		
        //trying to set itemdate
        toLimTxt2 = (TextView)findViewById(R.id.limTxt2);
        itemDate = (EditText)findViewById(R.id.itemDate);
        itemDate.setText(sentMonth2);
        toMonth = (TextView)findViewById(R.id.remindMonth);
        toMonth.setText(sentMonth);
        itemTxt = (EditText)findViewById(R.id.itemName);
        
        priceTxt = (EditText)findViewById(R.id.itemPrice);
        payMethodTxt = (EditText)findViewById(R.id.paymentMethod);
        noteTxt = (EditText)findViewById(R.id.itemNote);
        itemDate.setText(sentMonth, TextView.BufferType.EDITABLE);

        
 //filin    	
        try{
    		FileInputStream fis = openFileInput("UserInput.txt");
    	
    	InputStreamReader isr = new InputStreamReader(fis);
    	char[]inputBuffer = new char [20];
    	isr.read(inputBuffer);
    	strRead = new String(inputBuffer);
    	toLimTxt2.setText(strRead.trim());
    	
    	FileInputStream fis2 = openFileInput("UserInput2.txt");
    	
    	InputStreamReader isr2 = new InputStreamReader(fis2);
    	char[]inputBuffer2 = new char [20];
    	isr2.read(inputBuffer2);
    	strRead2 = new String(inputBuffer2);
    	costPrev = Double.parseDouble(strRead2);
    	
    	
    	}
    	catch (Exception ioe){

			ioe.printStackTrace();

			}
    	
//filein 
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_expense, menu);
        return true;
    }
    @Override
    protected void onResume() {
        super.onResume();
        itemTxt.setText(" ");
        priceTxt.setText("0");
        payMethodTxt.setText(" ");
        itemDate.setText(" ");
        noteTxt.setText(" ");
        
        if ((Double.parseDouble(strRead)) > .85) { 
    		toLimTxt2.setTextColor(Color.RED);
    	
    	}
    	if ((Double.parseDouble(strRead)) < .86) { 
    		toLimTxt2.setTextColor(Color.BLUE);
    	
    	}
  //filin    	
    	try{
    		FileInputStream fis = openFileInput("UserInput.txt");
    	
    	InputStreamReader isr = new InputStreamReader(fis);
    	char[]inputBuffer = new char [20];
    	isr.read(inputBuffer);
    	strRead = new String(inputBuffer);
    	toLimTxt2.setText(strRead.trim());
    	
    	FileInputStream fis2 = openFileInput("UserInput2.txt");
    	
    	InputStreamReader isr2 = new InputStreamReader(fis2);
    	char[]inputBuffer2 = new char [20];
    	isr2.read(inputBuffer2);
    	strRead2 = new String(inputBuffer2);
    	costPrev = Double.parseDouble(strRead2);
    	
    	
    	}
    	catch (Exception ioe){

			ioe.printStackTrace();

			}
    	
    	
    	
//filein
    	if ((Double.parseDouble(strRead)) > .85) { 
    		toLimTxt2.setTextColor(Color.RED);
    	
    	}
    	if ((Double.parseDouble(strRead)) < .86) { 
    		toLimTxt2.setTextColor(Color.BLUE);
    	
    	}
    }
    public void addBtn (View v){
    	costAdd = Double.parseDouble(priceTxt.getText().toString());
    	inc0 = ((costAdd += costPrev) / spendL);
    	
   //fileout
    	try{

			FileOutputStream fOut = openFileOutput("UserInput.txt", MODE_WORLD_READABLE);

			OutputStreamWriter osw = new OutputStreamWriter(fOut);

			osw.write(Double.toString(inc0));

			osw.flush();

			osw.close();
			FileOutputStream fOut2 = openFileOutput("UserInput2.txt", MODE_WORLD_READABLE);

			OutputStreamWriter osw2 = new OutputStreamWriter(fOut2);

			osw2.write(Double.toString(costAdd += costPrev));

			osw2.flush();

			osw2.close();

			
		
	}
		catch (Exception ioe){

			ioe.printStackTrace();

			}
    	
   //fileout
    	
    	//********not using bundle
     /*exPack = new Bundle();
    	exPack.putString("newItem", itemTxt.getText().toString());
    	exPack.putString("newPrice", priceTxt.getText().toString());
    	exPack.putString("newTransDate", itemDate.getText().toString());
    	exPack.putString("newPayMethod", payMethodTxt.getText().toString());
    	exPack.putString("newNote", noteTxt.getText().toString());
    	exPack.putString("sendMonth", toMonth.getText().toString());
    	exPack.putInt("reqSend", req_code);
    	//might cause a problem when I try the same trick from mainactivity*/
    	ContentValues values = new ContentValues();
		values.put("Item", itemTxt.getText().toString());
		values.put("Price", priceTxt.getText().toString());
		values.put("PayMethod", payMethodTxt.getText().toString());
		values.put("TransDate", itemDate.getText().toString());
		values.put("note", noteTxt.getText().toString());
		database.insert("names", null, values);
		dataSource.notifyDataSetChanged();
		dataSource.getCursor().requery();
     
    	Intent i2 = new Intent(EditExpense.this, ListExpenses.class);
    	      
  	   startActivityForResult(i2, 1);
    }
    
    public void cancelBtn (View v){
    	Intent i = new Intent(EditExpense.this, MainActivity.class);
 	   startActivityForResult(i, 1);
    }
}
