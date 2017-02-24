package com.example.rockpaperscissorsandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.RockPaperScissors.Game;

//import com.RockPaperScissors.Player;
//Try again later this is beyond my planning atm.
public class MainActivity extends Activity {

	Game RPS;
	ImageView P1icon;
	ImageView P2icon;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		RPS = new Game();
		P1icon = (ImageView) findViewById(R.id.imgP1);
		P2icon = (ImageView) findViewById(R.id.imgP2);
		// put the image in it's own layout container
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
				50, 50);
		P1icon.setLayoutParams(layoutParams);
		P2icon.setLayoutParams(layoutParams);
		// add listeners to the icon && adapt the game to android

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
