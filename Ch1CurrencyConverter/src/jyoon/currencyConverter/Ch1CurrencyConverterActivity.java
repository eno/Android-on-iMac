package jyoon.currencyConverter;

import android.app.Activity;
import android.os.Bundle;

public class Ch1CurrencyConverterActivity extends Activity {
    /** Called when the activity is first created. */
	final double EURO2USD = 1.4533;
	final double COLON2USD=0.002;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}