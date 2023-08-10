package com.example.tictac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class WelcomeScreen extends AppCompatActivity {

    TextView tv_myname;
    TextView tv_sharifname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        tv_myname=findViewById(R.id.tv_myname);
        tv_sharifname=findViewById(R.id.tv_sharifname);

        Animation animation1= AnimationUtils.loadAnimation(this,R.anim.alpha);
        tv_myname.startAnimation(animation1);
        tv_sharifname.startAnimation(animation1);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(getApplicationContext(),AddPlayers.class);
                startActivity(intent);
            }
        },4200);
    }
}