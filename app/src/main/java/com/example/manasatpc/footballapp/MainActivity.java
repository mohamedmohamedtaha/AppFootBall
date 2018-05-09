package com.example.manasatpc.footballapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView numberTeam1, numberTeam2,numberRedCardTeam1,numberRedCardTeam2,numberYellowCardTeam1,
            numberYellowCardTeam2,numberGoalsTeam1,numberGoalsTeam2;
    Button BTReset,BTAddGoalTeam1,BTAddGoalTeam2,BTOffsetTeam1,
            BTOffsetTeam2,BTRedCard1,BTRedCard2,BTYellowCard1,BTYellowCard2;

    private int trackGoalsTeamOne = 0;
    private int trackGoalsTeamTwo = 0;

    private int yellowCardTeamOne = 0;
    private int yellowCardTeamTwo = 0;

    private int redCardTeamOne = 0;
    private int redCardTeamTwo = 0;

    private int numberTeamOne = 11;

    private int numberTeamTwo = 11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView for number members Teams
        numberTeam1 = (TextView)findViewById(R.id.TVTeamNumber1);
        numberTeam2 = (TextView)findViewById(R.id.TVTeam2Number1);


        //TextView for number of Goals for both Teams
        numberGoalsTeam1 = (TextView)findViewById(R.id.TVGoalsTeam1Code);
        numberGoalsTeam2 = (TextView)findViewById(R.id.TVGoalsTeam2Code);

        //TextView for number of Red Card and Yellow Card for team1
        numberRedCardTeam1 = (TextView)findViewById(R.id.TVNumberRedCardTeam1);
        numberYellowCardTeam1 = (TextView)findViewById(R.id.TVNumberYellowCardTeam1);

        //TextView for number of Red Card and Yellow Card for team1
        numberRedCardTeam2 = (TextView)findViewById(R.id.TVNumber2RedCard);
        numberYellowCardTeam2 = (TextView)findViewById(R.id.TVNumber2YellowCard);

        // button for reset the Score to 0
        BTReset =(Button)findViewById(R.id.reset);

        // buttons for Add Goal for both Teams
        BTAddGoalTeam1 = (Button)findViewById(R.id.AddGoalTeam1);
        BTAddGoalTeam2 = (Button)findViewById(R.id.AddGoalTeam2);

        // buttons for offset Goal for both Teams
        BTOffsetTeam1 = (Button)findViewById(R.id.AddOffsetTeam1);
        BTOffsetTeam2 = (Button)findViewById(R.id.AddOfsyetTeam2);

        // buttons for Read Card for both Teams
        BTRedCard1 = (Button)findViewById(R.id.AddRedCardTeam1);
        BTRedCard2 = (Button)findViewById(R.id.AddRedCardTeam2);

        // buttons for Yellow Card for both Teams
        BTYellowCard1 = (Button)findViewById(R.id.AddYellowCardTeam1);
        BTYellowCard2 = (Button)findViewById(R.id.AddYellowCardTeam2);

        //Buttons for Add Goals for Teams
        BTAddGoalTeam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numberTeamOne <=0 ){
                    Toast.makeText(MainActivity.this, "There is no player to score a goal", Toast.LENGTH_SHORT).show();
                    return;
                }

                trackGoalsTeamOne ++;
                addGoalTeamOne(trackGoalsTeamOne);
            }
        });

        BTAddGoalTeam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numberTeamTwo <=0 ){
                    Toast.makeText(MainActivity.this, "There is no player to score a goal", Toast.LENGTH_SHORT).show();
                    return;
                }
                trackGoalsTeamTwo ++;
                addGoalTeamTwo(trackGoalsTeamTwo);
            }
        });
        //Button for offset Team One
        BTOffsetTeam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (trackGoalsTeamOne <= 0){
                    Toast.makeText(MainActivity.this, "there is no Goals for Team 1 ", Toast.LENGTH_SHORT).show();
                    return;
                }

                trackGoalsTeamOne --;
                offsetTeamOne(trackGoalsTeamOne);
            }
        });

        //Button for offset Team Two
        BTOffsetTeam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (trackGoalsTeamTwo <= 0){
                    Toast.makeText(MainActivity.this, "there is no Goals for Team2 ", Toast.LENGTH_SHORT).show();
                    return;
                }

                trackGoalsTeamTwo --;
                offsetTeamTwo(trackGoalsTeamTwo);

            }
        });

        //Button for Yellow Card Team One
        BTYellowCard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (yellowCardTeamOne >= 11){
                    Toast.makeText(MainActivity.this, "All Players have Yellow card", Toast.LENGTH_SHORT).show();
                    return;
                }
                yellowCardTeamOne ++;
                yellowCardTeamOne(yellowCardTeamOne);
            }
        });

        //Button for Yellow Card Team Two
        BTYellowCard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (yellowCardTeamTwo >=11 ){
                    Toast.makeText(MainActivity.this, "All players have Yellow Card", Toast.LENGTH_SHORT).show();
                    return;
                }
                yellowCardTeamTwo ++;
                yellowCardGoalTeamTwo(yellowCardTeamTwo);


            }
        });

        //Button for Red Card Team One
        BTRedCard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (numberTeamOne <= 0){
                    Toast.makeText(MainActivity.this, "There is no other player", Toast.LENGTH_SHORT).show();
                    return;
                }
                redCardTeamOne ++;
                numberTeamOne --;

                redCardTeamOne(redCardTeamOne);
                numberTeam1.setText(numberTeamOne +"");

            }
        });

        //Button for Red Card Team Two
        BTRedCard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numberTeamTwo <= 0){
                    Toast.makeText(MainActivity.this, "There is no other player", Toast.LENGTH_SHORT).show();
                    return;
                }
                redCardTeamTwo ++;
                numberTeamTwo --;

                redCardTeamTwo(redCardTeamTwo);
                numberTeam2.setText(numberTeamTwo +"");


            }
        });

        //Button for reset both Teams
        BTReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetScroe();
            }
        });




    }
    //method for add Goal Team One
    private void addGoalTeamOne(int addGoalTeamOne){
        numberGoalsTeam1.setText(addGoalTeamOne +"");
    }
    //method for add Goal Team Two
    private void addGoalTeamTwo(int addGoalTeamTwo){
        numberGoalsTeam2.setText(addGoalTeamTwo +"");
    }

    //method for offset Team One
    private void offsetTeamOne(int offsetTeam1){
        numberGoalsTeam1.setText(offsetTeam1 +"");
    } //method for offset Team Two
    private void offsetTeamTwo(int offsetTeam2){
        numberGoalsTeam2.setText(offsetTeam2 +"");
    }

    //method for Yellow Card Team One
    private void yellowCardTeamOne(int yellowCardTeam1){
        numberYellowCardTeam1.setText(yellowCardTeam1 +"");
    }
    //method for Yellow Card Team Two
    private void yellowCardGoalTeamTwo(int yellowCardTeam2){
        numberYellowCardTeam2.setText(yellowCardTeam2 +"");
    }

    //method for Red Card Team One
    private void redCardTeamOne(int redCardTeam1){
        numberRedCardTeam1.setText(redCardTeam1 +"");
    }
    //method for Red Card Team Two
    private void redCardTeamTwo(int redCardTeam2){
        numberRedCardTeam2.setText(redCardTeam2 +"");
    }
    // for reset All Score
    private void resetScroe(){
        trackGoalsTeamOne = 0;
        trackGoalsTeamTwo = 0;
        yellowCardTeamOne = 0;
        yellowCardTeamTwo = 0;
        redCardTeamOne = 0;
        redCardTeamTwo = 0;
        numberTeamOne = 11;
        numberTeamTwo = 11;
        addGoalTeamOne(trackGoalsTeamOne);
        addGoalTeamTwo(trackGoalsTeamTwo);
        yellowCardGoalTeamTwo(yellowCardTeamTwo);
        yellowCardTeamOne(yellowCardTeamOne);
        redCardTeamOne(redCardTeamOne);
        redCardTeamTwo(redCardTeamTwo);

        numberTeam1.setText(numberTeamOne +"");
        numberTeam2.setText(numberTeamTwo + "");
    }

}
