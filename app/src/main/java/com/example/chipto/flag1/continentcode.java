package com.example.chipto.flag1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class continentcode extends AppCompatActivity {
    Button asian,africa ,europe, northam,southam,auaoc,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.continent);
        asian =(Button)findViewById(R.id.asian);
        asian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(continentcode.this,R.raw.pop);
                mediaPlayer.start();
                Intent intent = new Intent(continentcode.this,asiancode.class);
                startActivity(intent);
            }
        });
        africa=(Button)findViewById(R.id.africa);
        africa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(continentcode.this,R.raw.pop);
                mediaPlayer.start();
                Intent intent=new Intent(continentcode.this,africacode.class);
                startActivity(intent);
            }
        });
        europe=(Button)findViewById(R.id.europe);
        europe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(continentcode.this,R.raw.pop);
                mediaPlayer.start();
                Intent intent=new Intent(continentcode.this,europecode.class);
                startActivity(intent);
            }
        });
        northam=(Button)findViewById(R.id.northAM);
        northam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(continentcode.this,R.raw.pop);
                mediaPlayer.start();
                Intent intent=new Intent(continentcode.this,northamcode.class);
                startActivity(intent);
            }
        });
        southam=(Button)findViewById(R.id.southAM);
        southam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(continentcode.this,R.raw.pop);
                mediaPlayer.start();
                Intent intent=new Intent(continentcode.this,southamcode.class);
                startActivity(intent);
            }
        });
        auaoc=(Button)findViewById(R.id.AUOC);
        auaoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(continentcode.this,R.raw.pop);
                mediaPlayer.start();
                Intent intent=new Intent(continentcode.this,auaoccode.class);
                startActivity(intent);
            }
        });

        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(continentcode.this,R.raw.pop);
                mediaPlayer.start();
                Intent intent = new Intent(continentcode.this,phanchiacode.class);
                startActivity(intent);
            }
        });
    }
}
