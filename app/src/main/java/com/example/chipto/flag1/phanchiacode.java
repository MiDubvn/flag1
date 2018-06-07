package com.example.chipto.flag1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class phanchiacode extends AppCompatActivity {
    Button chauluc,world,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phanchia);
        chauluc =(Button)findViewById(R.id.chauluc);
        chauluc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(phanchiacode.this,R.raw.pop);
                mediaPlayer.start();
                Intent intent = new Intent(phanchiacode.this,continentcode.class);
                startActivity(intent);
            }
        });
        world=(Button)findViewById(R.id.thegioi);
        world.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(phanchiacode.this,R.raw.pop);
                mediaPlayer.start();
                Intent intent=new Intent(phanchiacode.this,chedocode.class);
                startActivity(intent);
            }
        });

        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(phanchiacode.this,R.raw.pop);
                mediaPlayer.start();
                Intent intent = new Intent(phanchiacode.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
