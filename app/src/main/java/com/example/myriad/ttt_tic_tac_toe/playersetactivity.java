package com.example.myriad.ttt_tic_tac_toe;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class playersetactivity extends AppCompatActivity {
    EditText et1;
    EditText et2;

    // Preference file name
    public static final String PREF_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playersetactivity);

        et1 = (EditText) findViewById(R.id.etxt1);
        et2 = (EditText) findViewById(R.id.etxt2);

        findViewById(R.id.save).setOnClickListener(saver);
    }

    private View.OnClickListener saver = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Shared Prefs
            SharedPreferences players = getSharedPreferences(PREF_NAME, 0);
            SharedPreferences.Editor editor = players.edit();
            editor.putString("Player1", et1.getText().toString());
            editor.putString("Player2", et2.getText().toString());
            editor.commit();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_playersetactivity, menu);
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
