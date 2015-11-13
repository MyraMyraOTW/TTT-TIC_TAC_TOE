package com.example.myriad.ttt_tic_tac_toe;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class histactivity extends AppCompatActivity {

    // Preference file name
    public static final String PREF_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_histactivity);

        refreshb();
        findViewById(R.id.refresh).setOnClickListener(ref);
    }

    private View.OnClickListener ref = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            refreshb();
        }
    };

    private void refreshb(){
        SharedPreferences pref = getSharedPreferences(PREF_NAME, 0);

        TextView gm1 = (TextView) findViewById(R.id.g1);
        TextView gm2 = (TextView) findViewById(R.id.g2);
        TextView gm3 = (TextView) findViewById(R.id.g3);
        TextView gm4 = (TextView) findViewById(R.id.g4);
        TextView gm5 = (TextView) findViewById(R.id.g5);

        gm1.setText(pref.getString("hist1", null));
        gm2.setText(pref.getString("hist2", null));
        gm3.setText(pref.getString("hist3", null));
        gm4.setText(pref.getString("hist4", null));
        gm5.setText(pref.getString("hist5", null));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_histactivity, menu);
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
