package com.assignment.coursespinner;

//Eno Udo
//10/2012
//CISC 395

import java.util.HashMap;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;

public class CourseSpinner extends Activity implements 
		AdapterView.OnItemSelectedListener, OnSeekBarChangeListener {

    
    TextView toDisplay, toDone, toMax;
    String [] crsList = {"Artificial Intelligence", "Database", "Java", "Linear Algebra", "Operating System", "Software Engineering", "Unix", "Website Admin"};

    int crsTotal = 0;
    int maxTotal = 0;
    String txt = "";
    
    HashMap myCrsCrdit = new HashMap<String,Integer>();
    HashMap myCrsReq = new HashMap<String,String>();
    
    @Override//building the spinner, and string adapter
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_spinner);
        
        SeekBar sb = (SeekBar)findViewById(R.id.seekBar1);
        sb.setMax(17);
        sb.setProgress(1);
        sb.setOnSeekBarChangeListener(this);
        
        final Button doneButton = (Button) findViewById(R.id.button1);
        doneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	            	//implement seekbar enforcement
            	if (crsTotal > maxTotal) {  
            		toDone.setText("Total Credit Hours Selected: "+crsTotal+"\n"+"Over Maximum Credits!");
            		}
            	else {
            		toDone.setText("Total Credit Hours Selected: "+crsTotal);
            	}
            }
        });
        
        toDone = (TextView)findViewById(R.id.textView5);
        toDisplay = (TextView)findViewById(R.id.TextView01);
        toMax = (TextView)findViewById(R.id.textView3);
        
        Spinner mySpin = (Spinner)findViewById(R.id.spinner1);
        mySpin.setOnItemSelectedListener(this);
        readyHashMap();
        ArrayAdapter <String> crsAdapter = new ArrayAdapter <String> (
        		this, 
        		android.R.layout.simple_spinner_item, 
        		crsList);
        crsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpin.setAdapter(crsAdapter);
        
    }

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
			long arg3) {
		// display on lower text 
		String tempTxt;
    	int tempCrsTotal = (Integer) myCrsCrdit.get(crsList[position]);
    	crsTotal += tempCrsTotal;
		tempTxt = crsList[position]+" "+myCrsCrdit.get(crsList[position])
				+" credits "+myCrsReq.get(crsList[position])+"\n------------------------------------------------------\n";
		txt += tempTxt;
		toDisplay.setText(txt);
		//(crsList[position]+"\t"+myCrsCrdit.get(crsList[position])+"\t""credits");
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void readyHashMap(){
		myCrsCrdit.put(new String("Artificial Intelligence"), 3);
		myCrsCrdit.put(new String("Database"), 4);
		myCrsCrdit.put(new String("Java"), 3);
		myCrsCrdit.put(new String("Linear Algebra"), 3);
		myCrsCrdit.put(new String("Operating System"), 2);
		myCrsCrdit.put(new String("Software Engineering"), 2);
		myCrsCrdit.put(new String("Unix"), 2);
		myCrsCrdit.put(new String("Website Admin"), 2);
		myCrsReq.put(new String("Artificial Intelligence"), new String("  requires 'Java'"));
		myCrsReq.put(new String("Database"), new String("  requires 'Unix'"));
		myCrsReq.put(new String("Java"), new String(" "));
		myCrsReq.put(new String("Linear Algebra"), new String(" "));
		myCrsReq.put(new String("Operating System"), new String("  requires 'Java'"));
		myCrsReq.put(new String("Software Engineering"), new String("  requires 'Java'"));
		myCrsReq.put(new String("Unix"), new String(" "));
		myCrsReq.put(new String("Website Admin"), new String("  requires 'Database'"));
	
	}

	@Override
	public void onProgressChanged(SeekBar arg0, int progress, boolean arg2) {
		toMax.setText("Max Credit Hours: "+Integer.toString(progress));
		maxTotal = progress;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}
	
	
			
}
