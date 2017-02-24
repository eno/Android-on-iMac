package mobilemoney.m3;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ListView extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.list_view, menu);
        return true;
    }
}
