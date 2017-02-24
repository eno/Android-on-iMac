package com.golf;

import android.app.Activity;
import android.util.Log;
import android.view.View.OnClickListener;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class GolfScore extends Activity implements OnClickListener {
	Button buttonPlus, buttonMinus, buttonOK, buttonOverall, buttonReset;
	TextView textScore, textScoreCard, textOverall;
	int score = 0;
	private int overall = 0;
	private static final String TAG = "Golf Ya: ";
	private int hno=1;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Log.d(TAG, "onCreated starts");
        
        // Now have all my UI in the Java memory
        buttonOK = (Button) findViewById(R.id.buttonOK);
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        textScore = (TextView)findViewById(R.id.textScore);
        buttonOverall = (Button)findViewById(R.id.buttonOverall);
        buttonReset = (Button)findViewById(R.id.buttonReset);
        textOverall = (TextView)findViewById(R.id.textOverall);
        textScoreCard = (TextView)findViewById(R.id.textScoreCard);
        
        // Initialize text views
        textScore.setText(String.valueOf(score));
        textScoreCard.setText("");
        
        // Define button listeners
        buttonOK.setOnClickListener((OnClickListener)this);
        buttonPlus.setOnClickListener((OnClickListener)this);
        buttonMinus.setOnClickListener((OnClickListener)this);
        buttonOverall.setOnClickListener((OnClickListener)this);
        buttonReset.setOnClickListener((OnClickListener)this);
        
        Log.d(TAG, "onCreated done");
    }
    
   //@Override
    public void onClick(View src){
    	switch (src.getId()) {
    	case R.id.buttonOK:
    		textScoreCard.append("\nYou played "+score+" at hole "+hno);
    		hno++;
    		overall += score;
    		score = 0;
    		textScore.setText(String.valueOf(score));
    		  break;
    	case R.id.buttonPlus:
    		score++;
    		textScore.setText(String.valueOf(score));
		      break;
    	case R.id.buttonMinus:
    		score--;
    		textScore.setText(String.valueOf(score));
    		  break;
    	case R.id.buttonOverall:
    		textOverall.setText(String.valueOf(overall));
    		break;
    	case R.id.buttonReset:
    		hno=1;
    		score=0;
    		overall=0;
    		textOverall.setText(String.valueOf(overall));
    		textScoreCard.setText("score card goes here");
    		break;
    	}
        
    }
}