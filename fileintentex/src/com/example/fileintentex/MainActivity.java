package com.example.fileintentex;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	EditText edit2send;
	Button click2send;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit2send = (EditText)findViewById(R.id.editText1);
        click2send = (Button)findViewById(R.id.button1);
       
    }
    
    public void doThisOnClick() {
    	Intent i = new Intent (this, MyBoss.class);
    	Bundle myGift = new Bundle();
    	myGift.putString("myInquiry1", edit2send.getText().toString());
    	i.putExtras(myGift);
    	startActivityForResult(i, 7878);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	/* (non-Javadoc)
	 * @see android.app.Activity#onActivityResult(int, int, android.content.Intent)
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if (resultCode == RESULT_OK)
			Toast.makeText(this, data.getExtras().getString("return1"), Toast.LENGTH_SHORT).show();
			Toast.makeText(this, data.getExtras().getString("comment1"), Toast.LENGTH_SHORT).show();
		super.onActivityResult(requestCode, resultCode, data);
	}
}
