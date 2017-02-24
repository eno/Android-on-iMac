package cysecure.getSql;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//import android.app.Activity;
import android.app.ListActivity;
import android.net.ParseException;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MySQL2getCustomersActivity extends ListActivity {
	/** Called when the activity is first created. */

	JSONArray jArray;
	String result = null;
	InputStream is;
	StringBuilder sb = null;
	TextView dbView;
	public static final String KEY1 = "http://cysecure.org/courses/359wa/mysql/android/getCustomers.php";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//dbV = (TextView) findViewById(R.id.viewDB);
		//dbV.setText("Here to go\n");
		LinearLayout rootLayout = new LinearLayout(getApplicationContext());
		dbView = new TextView(getApplicationContext());
		rootLayout.addView(dbView);
		setContentView(rootLayout);
		dbView.setText(getServerData(KEY1));
	}
		
	private String getServerData(String returnString) {
		//String returnString = null;

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("zip", "10000"));

		// http post
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(returnString);
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent(); 
			//result = EntityUtils.toString(response.getEntity());
			//dbV.setText(result);
			//dbV.setText("Get connected\n");

		} catch (Exception e) {
			Log.e("log_tag", "Error in http connection " + e.toString());
		}

		// convert response to string
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "iso-8859-1"), 8);
			sb = new StringBuilder();
			sb.append(reader.readLine() + "\n");
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			result = sb.toString();
		} catch (Exception e) {
			Log.e("log_tag", "Error converting result " + e.toString());
		}
		

		// print data
		//String ct_name;
		//String phone;

		try {
			jArray = new JSONArray(result);

			for (int i = 0; i < jArray.length(); i++) {
				JSONObject json_data = jArray.getJSONObject(i);
				//ct_name = json_data.getString("custName");
				//phone = json_data.getString("phone");
				//dbV.setText(ct_name);
				//dbV.setText(phone);
				Log.i("log_tag","cname: "+json_data.getInt("custName")+
                        ", phone: "+json_data.getString("phone")
                );
				// Get an output to the screen
				returnString += "\n\t" + jArray.getJSONObject(i);

			}
		} catch (JSONException e1) {
			Toast.makeText(getBaseContext(), "No customer", Toast.LENGTH_LONG)
					.show();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return returnString;
	}
}