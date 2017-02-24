package edu.mercy.cysecure.sql;

import android.app.Activity;
import android.os.Bundle;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.client.methods.HttpPost;

public class cysecureSqlTest extends Activity {
    /** Called when the activity is first created. */
	String result = "";
	//
	ArrayList <E> nameValPairs = new ArrayList <E> ();
	nameValPairs.add(new BasicNameValuePair("year","2010"));
	
	try {
		HttpClient hc = new DefaultHttpClient();
		HttpPost hp = new HttpPost("http://cysecure.org/getAllBooks.php");
		hp.setEntity((HttpEntity) new UrlEncodedFormEntity(nameValPairs));
		
	} catch (Exception e) {}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}