package com.example.myriad.ttt_tic_tac_toe;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Preference file name
    public static final String PREF_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.play_button).setOnClickListener(menulistener);
        findViewById(R.id.hist_button).setOnClickListener(menulistener);
        findViewById(R.id.player_set_button).setOnClickListener(menulistener);

        SharedPreferences pref = getSharedPreferences(PREF_NAME, 0);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("hist1", "Undetermined");
        editor.putString("hist2", "Undetermined");
        editor.putString("hist3", "Undetermined");
        editor.putString("hist4", "Undetermined");
        editor.putString("hist5", "Undetermined");
        editor.commit();
    }

    private View.OnClickListener menulistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.play_button:
                    Log.d("CLICKED", "play button");
                    intent_starter(Game_Activity.class);
                    break;
                case R.id.hist_button:
                    Log.d("CLICKED", "history button");
                    intent_starter(histactivity.class);
                    break;
                case R.id.player_set_button:
                    Log.d("CLICKED", "set player button");
                    intent_starter(playersetactivity.class);
                    break;
            }
        }
    };

    private void intent_starter(Class call_class){
        Intent swintent = new Intent((getApplicationContext()), call_class);
        startActivity(swintent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
