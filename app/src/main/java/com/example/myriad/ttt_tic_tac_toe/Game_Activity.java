package com.example.myriad.ttt_tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

public class Game_Activity extends AppCompatActivity {

    private int[] game_array = new int[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_);


        findViewById(R.id.tl).setOnClickListener(game_listener);
        findViewById(R.id.tm).setOnClickListener(game_listener);
        findViewById(R.id.tr).setOnClickListener(game_listener);
        findViewById(R.id.ml).setOnClickListener(game_listener);
        findViewById(R.id.mm).setOnClickListener(game_listener);
        findViewById(R.id.mr).setOnClickListener(game_listener);
        findViewById(R.id.bl).setOnClickListener(game_listener);
        findViewById(R.id.bm).setOnClickListener(game_listener);
        findViewById(R.id.br).setOnClickListener(game_listener);



    }

    private View.OnClickListener game_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){

            }
        }
    };

    private void check_win(){
        // X win conditions
        if(game_array[0] == 1 && game_array[1] == 1 && game_array[2] == 1){

        }
        if(game_array[3] == 1 && game_array[4] == 1 && game_array[5] == 1){

        }
        if(game_array[6] == 1 && game_array[7] == 1 && game_array[8] == 1){

        }
        if(game_array[0] == 1 && game_array[4] == 1 && game_array[8] == 1){

        }
        if(game_array[6] == 1 && game_array[4] == 1 && game_array[2] == 1){

        }

        // O win conditions
        if(game_array[0] == 2 && game_array[1] == 2 && game_array[2] == 2){

        }
        if(game_array[3] == 2 && game_array[4] == 2 && game_array[5] == 2){

        }
        if(game_array[6] == 2 && game_array[7] == 2 && game_array[8] == 2){

        }
        if(game_array[0] == 2 && game_array[4] == 2 && game_array[8] == 2){

        }
        if(game_array[6] == 2 && game_array[4] == 2 && game_array[2] == 2){

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_, menu);
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
