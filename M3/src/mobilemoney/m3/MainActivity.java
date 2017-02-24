package mobilemoney.m3;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener
{
	int req_code=10;
	EditText monthView, spendingView, incomeView;
	String limit, wMonth = "yyyy-MM", pickerStr, strRead;
	TextView toLimitTxt2;
	double inc=0.0, incLimit=0.0, color=0;
	NumberFormat nfInc = NumberFormat.getCurrencyInstance();
	DatePicker picker;
	SimpleDateFormat wMonthSdf = new SimpleDateFormat(wMonth, Locale.US);
	Bundle sendBundle;
	int percentVal;
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
     
        toLimitTxt2 = (TextView)findViewById(R.id.limitTxt2);
        spendingView = (EditText)findViewById(R.id.spendingView);
        spendingView.setText("0");
        incomeView = (EditText)findViewById(R.id.incomeView);
        incomeView.setText("0");
    	picker = (DatePicker)findViewById(R.id.monthView);
//*******************filin, this is where I would get from file but there is an err
    	//or that causes a crash when the file is first run with no file to read from.   	
  
    	
    	
    	try {
    	Field f[] = picker.getClass().getDeclaredFields();
    	for (Field field : f) {
    	if (field.getName().equals("mDaySpinner")) {
    	field.setAccessible(true);
    	Object daySpinner = new Object();
    	daySpinner = field.get(picker);
    	((View) daySpinner).setVisibility(View.GONE);
    	}
    	}
    	//Log.d("ERROR", e.getMessage());
    	} 
    	catch (IllegalArgumentException e) {
    	Log.d("ERROR", e.getMessage());
    	} catch (IllegalAccessException e) {
    	Log.d("ERROR", e.getMessage());
    	}
    	
        
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void addClick (View v){
		
		
		
		
  //fileout
    	try{

			FileOutputStream fOut = openFileOutput("UserInput.txt", MODE_WORLD_READABLE);

			OutputStreamWriter osw = new OutputStreamWriter(fOut);

			osw.write(toLimitTxt2.getText().toString());

			osw.flush();

			osw.close();

			
		
	}
		catch (Exception ioe){

			ioe.printStackTrace();

			}
    	
   //fileout
    	
		
		Integer pickerYear = picker.getYear();
        Integer pickerMonth = picker.getMonth();
        pickerMonth +=1;
        StringBuilder sb=new StringBuilder();
        sb.append(pickerYear.toString()).append("-").append(pickerMonth.toString());
        pickerStr=sb.toString();
		
    	
        
        		//, i2 = null;
       sendBundle = new Bundle();
 	   sendBundle.putString("sendMonth", pickerStr);
 	   //sendBundle.putDouble("IncomeLimit", inc);
 	   sendBundle.putString("sendIncome", spendingView.getText().toString());
 	   sendBundle.putString("sendSpend", incomeView.getText().toString());
    
    	  Intent i = new Intent(MainActivity.this, EditExpense.class);
   	       i.putExtras(sendBundle);
    	   startActivityForResult(i, 1);
    	   
    	}
    	
	public void savelistClick (View v){
		Intent i2 = new Intent(MainActivity.this, ListExpenses.class);
		sendBundle = new Bundle();
 	    sendBundle.putString("sendMonth", pickerStr);
 	    sendBundle.putString("sendMonth2", pickerStr);
 	    sendBundle.putString("sendIncome", spendingView.getText().toString());
 	    sendBundle.putString("sendSpend", incomeView.getText().toString());
 	    
	       i2.putExtras(sendBundle);
 	   startActivityForResult(i2, 1);
	}
	public void listClick (View v){
		Intent i2 = new Intent(MainActivity.this, ListExpenses.class);
		sendBundle = new Bundle();
		sendBundle.putString("sendIncome", spendingView.getText().toString());
 	    sendBundle.putString("sendSpend", incomeView.getText().toString());
 	   i2.putExtras(sendBundle);
 	   startActivityForResult(i2, 1);
	}

	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub

		super.onResume();
	}
	
	
	
}
