package com.example.tictac;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tv_player1, tv_player2,tv_counterX,tv_counterO;
    ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9;
    LinearLayout linear1,linear2;

    int activeplayer = 0;
    int[] gamestate = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    boolean IsGameActive=true;
    int counterX=0;
    int counterO=0;
    int sum =0;
    int cliked =0;
    int temp=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linear1=findViewById(R.id.linear1);
        linear2=findViewById(R.id.linear2);

        tv_player1 = findViewById(R.id.tv_player1);
        tv_player2 = findViewById(R.id.tv_player2);
        tv_counterX = findViewById(R.id.tv_counterX);
        tv_counterO = findViewById(R.id.tv_counterO);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);

        Intent intent = getIntent();
        tv_player1.setText(intent.getStringExtra("name1"));
        tv_player2.setText(intent.getStringExtra("name2"));
        tv_player1.setTextColor(Color.GREEN);
        tv_player2.setTextColor(Color.BLACK);
        linear1.setBackgroundResource(R.drawable.round_green);
    }

    public void click_image(View view) {
        ImageView im = (ImageView) view;
        int tag= Integer.parseInt(im.getTag().toString());
        /////new
        if(tag!=temp) {
            temp = tag;//1
            cliked++;
        }
        //////
        if(IsGameActive)
        {
            if (gamestate[tag - 1] == 2) {
                if (activeplayer == 0) {
                    im.setImageResource(R.drawable.secound_x);
                    im.setBackgroundResource(R.drawable.round_card);
                    tv_player1.setTextColor(Color.BLACK);
                    tv_player2.setTextColor(Color.GREEN);
                    linear2.setBackgroundResource(R.drawable.round_green);
                    linear1.setBackgroundResource(R.drawable.round_card);

                    gamestate[tag - 1] = activeplayer;
                    activeplayer = 1;
                } else {
                    im.setImageResource(R.drawable.secound_o);
                    im.setBackgroundResource(R.drawable.round_card);
                    tv_player2.setTextColor(Color.BLACK);
                    tv_player1.setTextColor(Color.GREEN);
                    linear1.setBackgroundResource(R.drawable.round_green);
                    linear2.setBackgroundResource(R.drawable.round_card);


                    gamestate[tag - 1] = activeplayer;
                    activeplayer = 0;
                }
            }
        }
        CheckWinner();
    }

    public void CheckWinner()
    {
        int[][]state_win={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
        sum=counterO+counterX;

        for (int i=0;i<8;i++)
        {
            int val0=state_win[i][0];
            int val1=state_win[i][1];
            int val2=state_win[i][2];
            if(gamestate[val0] == gamestate[val1] && gamestate[val1] == gamestate[val2])
            {
                if(gamestate[val0] !=2)
                {
                    if(gamestate[val0]==0)
                    {
                        IsGameActive=false;
                        AlertDialog builder=new AlertDialog.Builder(this)
                                .setTitle(tv_player1.getText().toString()+" Won")
                                .setPositiveButton("Restart Game", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        RestartGame();
                                    }
                                }).show();
                        counterX++;
                        tv_counterX.setText(""+counterX);
                    }
                    /////////////////////////////////////////////////////////////
                    else
                    {
                        IsGameActive=false;
                        AlertDialog builder=new AlertDialog.Builder(this)
                                .setTitle(tv_player2.getText().toString()+" Won")
                                .setPositiveButton("Restart Game", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        RestartGame();
                                    }
                                }).show();
                        counterO++;
                        tv_counterO.setText(""+counterO);
                    }
                }
            }
        }
        /////////////////////////////Finally work
        if(sum+1>(counterO+counterX)&&cliked==9)
        {
            IsGameActive=false;
            AlertDialog builder=new AlertDialog.Builder(this)
                    .setTitle("Draw !!!")
                    .setPositiveButton("Restart Game", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            RestartGame();
                        }
                    }).show();
        }
    }

    public void RestartGame()
    {

        image1.setBackgroundResource(R.drawable.round_card);
        image2.setBackgroundResource(R.drawable.round_card);
        image3.setBackgroundResource(R.drawable.round_card);
        image4.setBackgroundResource(R.drawable.round_card);
        image5.setBackgroundResource(R.drawable.round_card);
        image6.setBackgroundResource(R.drawable.round_card);
        image7.setBackgroundResource(R.drawable.round_card);
        image8.setBackgroundResource(R.drawable.round_card);
        image9.setBackgroundResource(R.drawable.round_card);

        image1.setImageResource(R.drawable.round_card);
        image2.setImageResource(R.drawable.round_card);
        image3.setImageResource(R.drawable.round_card);
        image4.setImageResource(R.drawable.round_card);
        image5.setImageResource(R.drawable.round_card);
        image6.setImageResource(R.drawable.round_card);
        image7.setImageResource(R.drawable.round_card);
        image8.setImageResource(R.drawable.round_card);
        image9.setImageResource(R.drawable.round_card);

        tv_player1.setTextColor(Color.GREEN);
        tv_player2.setTextColor(Color.BLACK);
        linear1.setBackgroundResource(R.drawable.round_green);
        linear2.setBackgroundResource(R.drawable.round_card);

        activeplayer=0;
        gamestate=new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2};
        IsGameActive=true;
        cliked=0;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
        System.exit(0);
    }
}