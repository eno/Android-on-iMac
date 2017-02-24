package jyoon.receipt;

import java.text.NumberFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ReceiptActivity extends Activity {
    /** Called when the activity is first created. */
	
	double sub_tot = 0.0;
	final double tax_rate = 0.087;
	double cur_total = 0.0;
	String itemItem ="";
	Button btnAddItem, btnTip, reset;
	EditText itemInput, tipInput;
	TextView itemLst, addTax, subTotal, tipShow, finTotal;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //as add items to the list
        itemInput = (EditText) findViewById(R.id.itemInput);
        tipInput = (EditText) findViewById(R.id.tipInput);
        itemLst = (TextView) findViewById(R.id.itemList);
        addTax = (TextView) findViewById(R.id.tax);
        subTotal = (TextView) findViewById(R.id.subTot);
        tipShow = (TextView) findViewById(R.id.tipShow);
        finTotal = (TextView) findViewById(R.id.total);
        btnAddItem = (Button) findViewById(R.id.btnItem);
        btnAddItem.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				double itemTemp = 0.0;
				double taxTemp = 0.0;
				NumberFormat itemTempNF = NumberFormat.getCurrencyInstance();
				NumberFormat taxTempNF = NumberFormat.getCurrencyInstance();
				long s,t;
				itemTemp = Double.parseDouble(itemInput.getText().toString());
				itemItem = itemItem+" \n"+String.valueOf(itemTemp);
				itemLst.setText(itemItem);
				sub_tot += itemTemp;
				s = ((int)Math.round(sub_tot * 100));
				sub_tot = s/100;
				taxTemp = sub_tot * tax_rate;
				t = ((int)Math.round(taxTemp * 100));
				taxTemp = t/100;
				addTax.setText(String.valueOf(taxTemp)+"  tax");
				subTotal.setText(String.valueOf(taxTemp+sub_tot)+"  subtotal");
				cur_total = sub_tot+taxTemp;
				finTotal.setText(String.valueOf(cur_total));
			}
		});
        
        btnTip = (Button) findViewById(R.id.btnTip);
        btnTip.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				double tipTemp = 0.0;
				long l,c;
				tipTemp = Double.parseDouble(tipInput.getText().toString());
				l = ((int)Math.round(tipTemp*100));
				tipTemp = l/100;
				tipShow.setText(String.valueOf(tipTemp));
				cur_total += tipTemp;
				c = ((int)Math.round(cur_total*100));
				cur_total = c/100;
				finTotal.setText(String.valueOf(cur_total));
			}
		});
        
        reset = (Button) findViewById(R.id.reset1);
        reset.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub

				itemLst.setText("");
				addTax.setText("");
				subTotal.setText("");
				finTotal.setText("");
			}
		});
    }
}