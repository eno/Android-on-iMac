package edu.mercy.cs.android.hellome;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MyHello extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_hello);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_my_hello, menu);
        return true;
    }
}
