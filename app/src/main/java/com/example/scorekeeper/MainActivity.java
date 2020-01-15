package com.example.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Set;

public class MainActivity extends AppCompatActivity {
    public int score_1=0;
    public int score_2=0;
    private TextView scoreView1;
    private TextView scoreView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreView1 = (TextView) findViewById(R.id.scoreView1);
        scoreView2 = (TextView) findViewById(R.id.scoreView2);

        if (savedInstanceState != null) {
            score_1 = savedInstanceState.getInt("STATE_SCORE_1");
            score_2 = savedInstanceState.getInt("STATE_SCORE_2");
            scoreView1.setText(String.valueOf(score_1));
            scoreView2.setText(String.valueOf(score_2));
        }
    }

    public void increaseScore1(View v){
       score_1++;
       updateScore1();
    }


    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }*/

    @NonNull
    @Override
    public MenuInflater getMenuInflater() {
        return super.getMenuInflater();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//Inflate the menu from XML
getMenuInflater().inflate(R.menu.main_menu, menu);
//Change the label of the menu based on the state of the app
int nightMode = AppCompatDelegate.getDefaultNightMode();
if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
        menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
} else{
        menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
}
return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("STATE_SCORE_1", score_1);
        outState.putInt("STATE_SCORE_2", score_2);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//Check if the correct item was clicked
        if(item.getItemId()==R.id.night_mode){
            AppCompatDelegate.getDefaultNightMode();
            recreate();
        }
        //Get the night mode state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode(); //Set the theme mode for the restarted activity
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            recreate();
        }
        else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            recreate();
        }
        return true;
    }


    public void decreaseScore1(View v){
        score_1--;
        updateScore1();
    }

    public void updateScore1(){
        scoreView1.setText(String.valueOf(score_1));
    }



    public void increaseScore2(View v){
        score_2++;
        updateScore2();
    }

    public void decreaseScore2(View v){
        score_2--;
        updateScore2();
    }

    public void updateScore2(){
        scoreView2.setText(String.valueOf(score_2));
    }

}
