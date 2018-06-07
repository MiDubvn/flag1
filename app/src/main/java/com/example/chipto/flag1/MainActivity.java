package com.example.chipto.flag1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button batdau,exit,HighScore,Relax,ntdh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        batdau =(Button)findViewById(R.id.btbatdau);
        batdau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(MainActivity.this,R.raw.pop);
                mediaPlayer.start();
                Intent intent = new Intent(MainActivity.this,phanchiacode.class);
                startActivity(intent);
            }
        });
        HighScore=(Button)findViewById(R.id.btdiemcao);
        HighScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(MainActivity.this,R.raw.pop);
                mediaPlayer.start();
                Intent intent=new Intent(MainActivity.this,diemsorce.class);
                startActivity(intent);
            }
        });
        Relax=(Button)findViewById(R.id.btgiaitri);
        Relax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(MainActivity.this,R.raw.pop);
                mediaPlayer.start();
                Intent intent=new Intent(MainActivity.this,findpiccode.class);
                startActivity(intent);
            }
        });
        ntdh=(Button)findViewById(R.id.button);
        ntdh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,nhintendoanhinhcode.class);
                startActivity(intent);
            }
        });

        exit=findViewById(R.id.btthoat);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
