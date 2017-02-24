package com.example.menuex;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	ImageView collegeImage;
	EditText cxtMenu;
	WebView myWeb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        collegeImage = (ImageView)findViewById(R.id.imageView1);
        cxtMenu=(EditText)findViewById(R.id.editText1);
        myWeb=(WebView)findViewById(R.id.webView1);
        registerForContextMenu(cxtMenu);
    }

    @Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return (actContext (item)) || super.onContextItemSelected(item);
	}

	private boolean actContext(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getItemId() == 1)
			myWeb.loadUrl ("http://www.mercy.edu");
		return false;
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        setOptMenu(menu);
        return true;
    }

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		if (v.getId() == cxtMenu.getId()) setCxtMenu(menu);
	}

	private void setCxtMenu(ContextMenu menu) {
		// TODO Auto-generated method stub
		int groupid = 2;
		menu.add(groupid, 1, 1, "Computer Science");
		menu.add(groupid, 2, 2, "Computer Information Systems");
		menu.add(groupid, 3, 3, "Cyber Security");
		
	}

	private void setOptMenu(Menu menu) {
		// TODO Auto-generated method stub
		int groupid = 5;
		menu.add(groupid, 1, 1, "Mercy College");
		menu.add(groupid, 2, 2, "Columbia University");
		menu.add(groupid, 3, 3, "New York University");
	}
    //override; try at child's method heirarchy level, then go to super class
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return (actOptions (item) || super.onOptionsItemSelected(item));
	}

	private boolean actOptions(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getItemId() == 1)
			collegeImage.setImageResource(R.drawable.mercycollege);
		if (item.getItemId() == 2)
			Toast.makeText(this, "Yes, you are in CIS", Toast.LENGTH_LONG).show();
		return false;
	}
}
