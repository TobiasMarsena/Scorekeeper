package com.example.asus.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mScore1;
    private int mScore2;
    private TextView mScoreText1;
    private TextView mScoreText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScoreText1 = findViewById(R.id.team1_score);
        mScoreText2 = findViewById(R.id.team2_score);

        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt("STATE_SCORE_1");
            mScore2 = savedInstanceState.getInt("STATE_SCORE_2");

            //Set the score text views
            mScoreText1.setText(String.valueOf(mScore1));
            mScoreText2.setText(String.valueOf(mScore2));
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //Save the scores
        outState.putInt("STATE_SCORE_1", mScore1);
        outState.putInt("STATE_SCORE_2", mScore2);
        super.onSaveInstanceState(outState);
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
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.night_mode){

            //Get the night mode state of the app
            int nightMode = AppCompatDelegate.getDefaultNightMode();

            //Set the theme mode for the restarted activity
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }
        //Check if the correct item was clicked
        return true;
    }

    public void decreaseScore(View view) {
        //Get the ID of the button that was clicked
        int viewID = view.getId();
        switch (viewID){

            //If it was on Team 1
            case R.id.team1_decrease:
                if (!mScoreText1.getText().equals("0")) {

                    //Decrement the score and update the TextView
                    mScore1--;
                    mScoreText1.setText(String.valueOf(mScore1));
                }
                break;

            //If it was Team 2
            case R.id.team2_decrease:
                if (!mScoreText2.getText().equals("0")) {

                    //Decrement the score and update the TextView
                    mScore2--;
                    mScoreText2.setText(String.valueOf(mScore2));
                }
                break;
        }
    }
    public void increaseScore(View view) {

        //Get the ID of the button that was clicked
        int viewID = view.getId();
        switch (viewID){

            //If it was on Team 1
            case R.id.team1_increase:

                //Increment the score and update the TextView
                mScore1++;
                mScoreText1.setText(String.valueOf(mScore1));
                break;

            //If it was Team 2
            case R.id.team2_increase:

                //Increment the score and update the TextView
                mScore2++;
                mScoreText2.setText(String.valueOf(mScore2));
        }
    }
}
