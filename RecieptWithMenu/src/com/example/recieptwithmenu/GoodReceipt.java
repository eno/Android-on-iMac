package com.example.recieptwithmenu;

import java.text.NumberFormat;
import java.util.HashMap;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.os.Bundle;

public class GoodReceipt extends Activity
  implements AdapterView.OnItemSelectedListener
{
    /** Called when the activity is first created. */
	
	String [] items = {"Sushi", "Sashimi",
			"Oxtails", "Salmon", "Galbi",
			"Kimchi", "Crab"
	};
	
	final double tax = 0.0875;
	TextView itemLst, addTax, subTot, taxInfo;
	double subtotal =0.0, curTax;
	String txt = "";
	
	public static HashMap <String, Double> myHash = new HashMap<String, Double>();
	NumberFormat nf = NumberFormat.getCurrencyInstance();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        itemLst = (TextView) findViewById(R.id.listSelection);
        subTot = (TextView) findViewById(R.id.subTot);
        taxInfo = (TextView) findViewById(R.id.taxInfo);
        Spinner spin = (Spinner) findViewById(R.id.myspinner);
        spin.setOnItemSelectedListener(this);
        putPrice();
        ArrayAdapter <String> aa = new ArrayAdapter (
        		this,
        		android.R.layout.simple_spinner_item,
        		items);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
    }

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1,
			int arg2, long arg3) {
		// TODO Auto-generated method stub
		String tempTxt;
		double tempPrice = myHash.get(items[arg2]);
		tempTxt = items[arg2] + ", " + tempPrice + "\n";
		txt += tempTxt;
		itemLst.setText(txt);
		subtotal += tempPrice;
		curTax = subtotal*tax;
		taxInfo.setText("Tax:" + nf.format(curTax));
		subTot.setText("Subtotal: " + nf.format(subtotal+curTax));
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void putPrice() {
		myHash.put(new String("Sushi"), 9.99);
        myHash.put(new String("Sashimi"), 29.99);
	}
    
    
}
