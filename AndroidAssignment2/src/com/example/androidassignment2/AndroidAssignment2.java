package com.example.androidassignment2;
/**
ENO UDO
**/


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AndroidAssignment2 extends Activity {
	
	ImageView collegeImage;
	EditText myOptMenu;
	EditText myCxtMenu;
	WebView myWeb;
	int mercy, colum, nyu;
	String msgMe;
	
//variables
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_assignment2);
        collegeImage = (ImageView)findViewById(R.id.imageView1);
        myOptMenu = (EditText)findViewById(R.id.editText1);
        myCxtMenu = (EditText)findViewById(R.id.editText2);
        myWeb = (WebView)findViewById(R.id.webView1);
        registerForContextMenu(myCxtMenu);
   
    }
  
				
				
				
  //Option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_android_assignment2, menu);
        setOptMenu(menu);
        return true;
    }

    
  @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return (actionOptions (item) || super.onOptionsItemSelected(item));
	}
  //option menu choice deteermines context menu ouputs
  private boolean actionOptions(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getItemId() == 1)
			{collegeImage.setImageResource(R.drawable.mercycollege);
			mercy = 1;
			colum = 0;
			nyu = 0;
			myOptMenu.setText("M"+mercy+"C"+colum+"N"+nyu);
			}
			
		if (item.getItemId() == 2)
			{collegeImage.setImageResource(R.drawable.columbia_university);
			mercy = 0;
			colum = 1;
			nyu = 0;
			myOptMenu.setText("M"+mercy+"C"+colum+"N"+nyu);
			}
		
		if (item.getItemId() == 3)
			{collegeImage.setImageResource(R.drawable.nyu_logo);
			mercy = 0;
			colum = 0;
			nyu = 1;
			myOptMenu.setText("M"+mercy+"C"+colum+"N"+nyu);
			}
		return false;
	}
  
	//Context Menu  
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return (mercyContext (item)) || (columContext (item)) || (nyuContext (item)) || super.onContextItemSelected(item);
	}

	//different contexts menu outputs per school
	private boolean mercyContext(MenuItem item) {
		// TODO Auto-generated method stub
	if (mercy >= 1)	
		{if (item.getItemId() == 1)
			myWeb.loadUrl ("http://www.mercy.edu/academics/school-of-liberal-arts/department-of-mathematics-and-cis");
		if (item.getItemId() == 2)
			myWeb.loadUrl ("https://www.mercy.edu/academics/school-of-liberal-arts/department-of-mathematics-and-cis/bs-in-computer-information-systems");
		if (item.getItemId() == 3)
			myWeb.loadUrl ("https://www.cysecure.org");
		if (item.getItemId() == 4)
			myWeb.loadUrl ("https://www.mercy.edu/academics/school-of-liberal-arts/department-of-mathematics-and-cis/bs-in-mathematics");
		}
	return false;
	}
	//alert dialog for Columbia option 2 and 3
	private boolean columContext(MenuItem item) {
		// TODO Auto-generated method stub
	if (colum >= 1)	
		{if (item.getItemId() == 1)
			myWeb.loadUrl ("http://www.cs.columbia.edu");
		if (item.getItemId() == 2)
			{AlertDialog  dialBox= createDialogBox();
			dialBox.show();}
		if (item.getItemId() == 3)
			{AlertDialog  dialBox= createDialogBox();
			dialBox.show();}
		if (item.getItemId() == 4)
			myWeb.loadUrl ("http://www.math.columbia.edu");
		}
		return false;
	}	
	
	//Toast for nyu option 2 and 3
	private boolean nyuContext(MenuItem item) {
		// TODO Auto-generated method stub
	if (nyu >= 1)	
		{if (item.getItemId() == 1)
			myWeb.loadUrl ("http://cs.nyu.edu");
		if (item.getItemId() == 2)
			Toast.makeText(this, "NYU does not have a CIS", Toast.LENGTH_LONG).show();
		if (item.getItemId() == 3)
			Toast.makeText(this, "NYU does not have a Cyber Security major", Toast.LENGTH_LONG).show();
		if (item.getItemId() == 4)
			myWeb.loadUrl ("http://www.math.nyu.edu");
		}
		return false;
	
	}
	//determines which context menu shows depending on which option menu was chosen prior
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		if (mercy >= 1) setMyCxtMenuMercy(menu);
		if (colum >= 1) setMyCxtMenuColum(menu);
		if (nyu >= 1) setMyCxtMenuNYU(menu);
	}
	
	//Set Menu items
	private void setOptMenu(Menu menu) {
		// TODO Auto-generated method stub
		int groupid = 5;
		menu.add(groupid, 1, 1, "Mercy");
		menu.add(groupid, 2, 2, "Columbia");
		menu.add(groupid, 3, 3, "NYU");
	}
	
	//menus per college may have different names
	private void setMyCxtMenuMercy(ContextMenu menu) {
		// TODO Auto-generated method stub
		int groupid = 2;
		menu.add(groupid, 1, 1, "Computer ScienceM");
		menu.add(groupid, 2, 2, "Computer Information Systems");
		menu.add(groupid, 3, 3, "Cyber Security");
		menu.add(groupid, 4, 4, "Mathematics");
	}
	private void setMyCxtMenuColum(ContextMenu menu) {
		// TODO Auto-generated method stub
		int groupid = 3;
		menu.add(groupid, 1, 1, "Computer ScienceC");
		menu.add(groupid, 2, 2, "Computer Information Systems");
		menu.add(groupid, 3, 3, "Cyber Security");
		menu.add(groupid, 4, 4, "Mathematics");
	}
	private void setMyCxtMenuNYU(ContextMenu menu) {
		// TODO Auto-generated method stub
		int groupid = 4;
		menu.add(groupid, 1, 1, "Computer ScienceN");
		menu.add(groupid, 2, 2, "Computer Information Systems");
		menu.add(groupid, 3, 3, "Cyber Security");
		menu.add(groupid, 4, 4, "Mathematics");
	}

	//Alert Dialog constructor
	    private AlertDialog createDialogBox(){
			AlertDialog noMajorDialogBox=  new AlertDialog.Builder(this)
			
			.setTitle("Major unavailable at Columbia") 
			.setMessage("Do you understand?") 
			.setIcon(R.drawable.eno)
			.setPositiveButton("Yes", new DialogInterface.OnClickListener() { 
				public void onClick (DialogInterface dialog, int whichButton) { 
					msgMe = "choose another major "+ Integer.toString(whichButton);
					myCxtMenu.setText(msgMe);
				} 
			})//setPositiveButton
					.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int whichButton) {
							msgMe = "CANCEL "+ Integer.toString(whichButton);
							myCxtMenu.setText(msgMe);
						}//OnClick
			})//setNeutralButton

.setNegativeButton("NO", new DialogInterface.OnClickListener() { 
public void onClick(DialogInterface dialog, int whichButton) { 
		msgMe = "NO understand "+ Integer.toString(whichButton);
		myCxtMenu.setText(msgMe);
}
})//setNegativeButton
.create();
	return noMajorDialogBox;
}// createDialogBox
			
	   

}
