package edu.mercy.HelloTime;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Date;

public class ClickTime extends Activity implements View.OnClickListener {
    /** Called when the activity is first created. */
	Button btn;
    @Override
    public void onCreate(Bundle tclck) {
        super.onCreate(tclck);
        btn = new Button(this);
        btn.setOnClickListener(this);
        updateTime();
        setContentView(btn);
    }
    
    public void onClick(View view) {
    	updateTime();
    }
    
    private void updateTime() {
/**    	TextView tv = new TextView(this);
    	tv.setText("Hey! ");
    	setContentView(tv);
    	*/
    	btn.setText(new Date().toString());
    }
}