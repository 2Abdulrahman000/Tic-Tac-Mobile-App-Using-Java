package com.example.tictac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlayers extends AppCompatActivity {
    EditText et_player1;
    EditText et_player2;
    Button btn_start;
    String name1,name2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);
        et_player1=findViewById(R.id.et_player1);
        et_player2=findViewById(R.id.et_player2);
        btn_start=findViewById(R.id.btn_start);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name1=et_player1.getText().toString();
                name2=et_player2.getText().toString();
                if(name1.isEmpty() || name2.isEmpty())
                {
                    Toast.makeText(AddPlayers.this, "Empty Text !!", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Intent intent=new Intent(AddPlayers.this,MainActivity.class);
                    intent.putExtra("name1",name1);
                    intent.putExtra("name2",name2);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
        System.exit(0);
    }
}