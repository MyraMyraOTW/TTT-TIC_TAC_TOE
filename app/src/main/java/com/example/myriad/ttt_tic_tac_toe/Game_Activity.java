package com.example.myriad.ttt_tic_tac_toe;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

public class Game_Activity extends AppCompatActivity {

    private int[] game_array = new int[9];
    private int[] locked_array = new int[9];
    private int turn;
    private int counter;
    private int win;
    private int sav;

    private String player1;
    private String player2;
    private String WINNER_PUT;

    public static final String PREF_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_);

        // Instantiating locked array to 0 = unlocked
        for (int i = 0; i < locked_array.length; i++){
            locked_array[i]=0;
        }

        SharedPreferences players = getSharedPreferences(PREF_NAME, 0);

        player1 = players.getString("Player1", "PLAYER 1");
        player2 = players.getString("Player2", "PLAYER 2");

        if(player1.equals("") && player2.equals("")){
            player1 = "PLAYER 1";
            player2 = "PLAYER 2";
        }


        TextView turn_view = (TextView) findViewById(R.id.turn_view);
        turn_view.setText(player1 + " TURN");

        sav = 0;
        counter = 0;
        turn = 1;

        findViewById(R.id.tl).setOnClickListener(game_listener);
        findViewById(R.id.tm).setOnClickListener(game_listener);
        findViewById(R.id.tr).setOnClickListener(game_listener);
        findViewById(R.id.ml).setOnClickListener(game_listener);
        findViewById(R.id.mm).setOnClickListener(game_listener);
        findViewById(R.id.mr).setOnClickListener(game_listener);
        findViewById(R.id.bl).setOnClickListener(game_listener);
        findViewById(R.id.bm).setOnClickListener(game_listener);
        findViewById(R.id.br).setOnClickListener(game_listener);

        findViewById(R.id.reset).setOnClickListener(res_undo);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView resultsstd = (TextView) findViewById(R.id.win_condition);
        outState.putString("winner", resultsstd.getText().toString());

        outState.putIntArray("game_arr", game_array);
        outState.putIntArray("locked_arr", locked_array);

        outState.putInt("turn", turn);
        outState.putInt("cnt", counter);
        outState.putInt("win", win);
        outState.putInt("sav", sav);

        outState.putString("p1", player1);
        outState.putString("p2", player2);

        Button a1 = (Button) findViewById(R.id.tl);
        Button a2 = (Button) findViewById(R.id.tm);
        Button a3 = (Button) findViewById(R.id.tr);
        Button a4 = (Button) findViewById(R.id.ml);
        Button a5 = (Button) findViewById(R.id.mm);
        Button a6 = (Button) findViewById(R.id.mr);
        Button a7 = (Button) findViewById(R.id.bl);
        Button a8 = (Button) findViewById(R.id.bm);
        Button a9 = (Button) findViewById(R.id.br);

        String b1 = a1.getText().toString();
        String b2 = a2.getText().toString();
        String b3 = a3.getText().toString();
        String b4 = a4.getText().toString();
        String b5 = a5.getText().toString();
        String b6 = a6.getText().toString();
        String b7 = a7.getText().toString();
        String b8 = a8.getText().toString();
        String b9 = a9.getText().toString();

        outState.putString("b1", b1);
        outState.putString("b2", b2);
        outState.putString("b3", b3);
        outState.putString("b4", b4);
        outState.putString("b5", b5);
        outState.putString("b6", b6);
        outState.putString("b7", b7);
        outState.putString("b8", b8);
        outState.putString("b9", b9);

        outState.putString("WINNER_PUT", WINNER_PUT);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TextView resultsstd = (TextView) findViewById(R.id.win_condition);
        resultsstd.setText(savedInstanceState.getString("winner"));

        game_array = savedInstanceState.getIntArray("game_arr");
        locked_array = savedInstanceState.getIntArray("locked_arr");

        turn = savedInstanceState.getInt("turn");
        counter = savedInstanceState.getInt("cnt");
        win = savedInstanceState.getInt("win");
        sav = savedInstanceState.getInt("sav");

        player1 = savedInstanceState.getString("p1");
        player2 = savedInstanceState.getString("p2");

        WINNER_PUT = savedInstanceState.getString("WINNER_PUT");

        Button a1 = (Button) findViewById(R.id.tl);
        Button a2 = (Button) findViewById(R.id.tm);
        Button a3 = (Button) findViewById(R.id.tr);
        Button a4 = (Button) findViewById(R.id.ml);
        Button a5 = (Button) findViewById(R.id.mm);
        Button a6 = (Button) findViewById(R.id.mr);
        Button a7 = (Button) findViewById(R.id.bl);
        Button a8 = (Button) findViewById(R.id.bm);
        Button a9 = (Button) findViewById(R.id.br);

        a1.setText(savedInstanceState.getString("b1"));
        a2.setText(savedInstanceState.getString("b2"));
        a3.setText(savedInstanceState.getString("b3"));
        a4.setText(savedInstanceState.getString("b4"));
        a5.setText(savedInstanceState.getString("b5"));
        a6.setText(savedInstanceState.getString("b6"));
        a7.setText(savedInstanceState.getString("b7"));
        a8.setText(savedInstanceState.getString("b8"));
        a9.setText(savedInstanceState.getString("b9"));
    }

    private View.OnClickListener game_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.tl :
                    change_value(0, R.id.tl);
                    check_win();
                    break;
                case R.id.tm :
                    change_value(1, R.id.tm);
                    check_win();
                    break;
                case R.id.tr :
                    change_value(2, R.id.tr);
                    check_win();
                    break;
                case R.id.ml :
                    change_value(3, R.id.ml);
                    check_win();
                    break;
                case R.id.mm :
                    change_value(4, R.id.mm);
                    check_win();
                    break;
                case R.id.mr :
                    change_value(5, R.id.mr);
                    check_win();
                    break;
                case R.id.bl :
                    change_value(6, R.id.bl);
                    check_win();
                    break;
                case R.id.bm :
                    change_value(7, R.id.bm);
                    check_win();
                    break;
                case R.id.br :
                    change_value(8, R.id.br);
                    check_win();
                    break;
            }
        }
    };

    private View.OnClickListener res_undo = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
                    reset_game();
        }
    };

    private void x_o(int resource) {
        Button b = (Button) findViewById(resource);

        if (turn == 1) {
            b.setText("X");
        }
        if (turn == 2) {
            b.setText("O");
        }
        counter++;
    }

    private void reset_game(){
        TextView winner = (TextView) findViewById(R.id.win_condition);
        TextView turn_view = (TextView) findViewById(R.id.turn_view);

        Button b1 = (Button) findViewById(R.id.tl);
        Button b2 = (Button) findViewById(R.id.tm);
        Button b3 = (Button) findViewById(R.id.tr);
        Button b4 = (Button) findViewById(R.id.ml);
        Button b5 = (Button) findViewById(R.id.mm);
        Button b6 = (Button) findViewById(R.id.mr);
        Button b7 = (Button) findViewById(R.id.bl);
        Button b8 = (Button) findViewById(R.id.bm);
        Button b9 = (Button) findViewById(R.id.br);

        for (int i = 0;i < game_array.length; i++){
            locked_array[i] = 0;
            game_array[i] = 0;
        }

        win = 0;
        counter = 0;
        turn = 1;
        sav = 0;
        winner.setText(getString(R.string.winner));
        turn_view.setText(player1 + " TURN");
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
    }

    private void change_value(int value, int resource){
        TextView turn_view = (TextView) findViewById(R.id.turn_view);
        if(locked_array[value] != 1){
            if(turn == 1){
                game_array[value] = 1;
                x_o(resource);
                turn = 2;
                turn_view.setText(player2 + " TURN");
                locked_array[value] = 1;
            } else if(turn == 2){
                game_array[value] = 2;
                x_o(resource);
                turn = 1;
                turn_view.setText(player1 + " TURN");
                locked_array[value] = 1;
            }
        }
    }

    private void lock_all(){
        if (sav != 1){
            save_hist();
            sav = 1;
        }
        for (int i = 0; i < locked_array.length; i++){
            locked_array[i] = 1;
        }
    }

    private void check_win(){
        TextView winner = (TextView) findViewById(R.id.win_condition);
        // X win conditions
        if(game_array[0] == 1 && game_array[1] == 1 && game_array[2] == 1){
            winner.setText(player1 + " Wins");
            WINNER_PUT = player1;
            win = 1;
            lock_all();
        }
        if(game_array[3] == 1 && game_array[4] == 1 && game_array[5] == 1){
            winner.setText(player1 + " Wins");
            WINNER_PUT = player1;
            win = 1;
            lock_all();
        }
        if(game_array[6] == 1 && game_array[7] == 1 && game_array[8] == 1){
            winner.setText(player1 + " Wins");
            WINNER_PUT = player1;
            win = 1;
            lock_all();
        }
        if(game_array[0] == 1 && game_array[4] == 1 && game_array[8] == 1){
            winner.setText(player1 + " Wins");
            WINNER_PUT = player1;
            win = 1;
            lock_all();
        }
        if(game_array[6] == 1 && game_array[4] == 1 && game_array[2] == 1){
            winner.setText(player1 + " Wins");
            WINNER_PUT = player1;
            win = 1;
            lock_all();
        }
        if(game_array[8] == 1 && game_array[4] == 1 && game_array[0] == 1){
            winner.setText(player1 + " Wins");
            WINNER_PUT = player1;
            win = 1;
            lock_all();
        }
        if(game_array[0] == 1 && game_array[3] == 1 && game_array[6] == 1){
            winner.setText(player1 + " Wins");
            WINNER_PUT = player1;
            win = 1;
            lock_all();
        }
        if(game_array[1] == 1 && game_array[4] == 1 && game_array[7] == 1){
            winner.setText(player1 + " Wins");
            WINNER_PUT = player1;
            win = 1;
            lock_all();
        }
        if(game_array[8] == 1 && game_array[5] == 1 && game_array[2] == 1){
            winner.setText(player1 + " Wins");
            WINNER_PUT = player1;
            win = 1;
            lock_all();
        }


        // O win conditions
        if(game_array[0] == 2 && game_array[1] == 2 && game_array[2] == 2){
            winner.setText(player2 + " Wins");
            WINNER_PUT = player2;
            win = 1;
            lock_all();
        }
        if(game_array[3] == 2 && game_array[4] == 2 && game_array[5] == 2){
            winner.setText(player2 + " Wins");
            WINNER_PUT = player2;
            win = 1;
            lock_all();
        }
        if(game_array[6] == 2 && game_array[7] == 2 && game_array[8] == 2){
            winner.setText(player2 + " Wins");
            WINNER_PUT = player2;
            win = 1;
            lock_all();
        }
        if(game_array[0] == 2 && game_array[4] == 2 && game_array[8] == 2){
            winner.setText(player2 + " Wins");
            WINNER_PUT = player2;
            win = 1;
            lock_all();
        }
        if(game_array[6] == 2 && game_array[4] == 2 && game_array[2] == 2){
            winner.setText(player2 + " Wins");
            WINNER_PUT = player2;
            win = 1;
            lock_all();
        }
        if(game_array[8] == 2 && game_array[4] == 2 && game_array[0] == 2){
            winner.setText(player2 + " Wins");
            WINNER_PUT = player2;
            win = 1;
            lock_all();
        }
        if(game_array[0] == 2 && game_array[3] == 2 && game_array[6] == 2){
            winner.setText(player2 + " Wins");
            WINNER_PUT = player2;
            win = 1;
            lock_all();
        }
        if(game_array[1] == 2 && game_array[4] == 2 && game_array[7] == 2){
            winner.setText(player2 + " Wins");
            WINNER_PUT = player2;
            win = 1;
            lock_all();
        }
        if(game_array[8] == 2 && game_array[5] == 2 && game_array[2] == 2){
            winner.setText(player2 + " Wins");
            WINNER_PUT = player2;
            win = 1;
            lock_all();
        }

        // Draw Condition
        if(counter == 9 && win != 1){
            winner.setText("DRAW");
            lock_all();
        }
    }

    private void save_hist(){
        SharedPreferences pref = getSharedPreferences(PREF_NAME, 0);
        SharedPreferences.Editor editor = pref.edit();

        String tmp;

        if (counter == 9 && win != 1){
            tmp = "DRAW";
        } else {
            tmp = WINNER_PUT + " won with " + counter + " moves";
        }

        String h1t = pref.getString("hist1", null);
        String h2t = pref.getString("hist2", null);
        String h3t = pref.getString("hist3", null);
        String h4t = pref.getString("hist4", null);

        editor.putString("hist1", tmp);
        editor.putString("hist2", h1t);
        editor.putString("hist3", h2t);
        editor.putString("hist4", h3t);
        editor.putString("hist5", h4t);

        editor.commit();
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
