package Cysecure.Ch1Intent1Demo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class Ch1Intent1DemoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Intent myIntent = new Intent (Intent.ACTION_VIEW,Uri.parse("content://contacts/people"));
        startActivity(myIntent);
    }
}