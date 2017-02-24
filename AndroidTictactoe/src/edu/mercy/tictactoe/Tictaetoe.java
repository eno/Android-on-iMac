package edu.mercy.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import edu.mercy.tictactoe.library.GameActivity;
import edu.mercy.tictactoe.library.GameView.State;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findViewById(R.id.start_player).setOnClickListener(
                new OnClickListener() {
            public void onClick(View v) {
                startGame(true);
            }
        });

        findViewById(R.id.start_comp).setOnClickListener(
                new OnClickListener() {
            public void onClick(View v) {
                startGame(false);
            }
        });
    }

    private void startGame(boolean startWithHuman) {
        Intent i = new Intent(this, GameActivity.class);
        i.putExtra(GameActivity.EXTRA_START_PLAYER,
                startWithHuman ? State.PLAYER1.getValue() : State.PLAYER2.getValue());
        startActivity(i);
    }
}