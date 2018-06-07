package com.example.chipto.flag1;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class diemsorce extends Activity {
    CheckBox cbsde,cbsvua,cbskho;
    Button OK,TroVe;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedo);
        Anhxa();

        TroVe=(Button)findViewById(R.id.btsback);
        TroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(diemsorce.this,R.raw.pop);
                mediaPlayer.start();
                Intent intent = new Intent(diemsorce.this,MainActivity.class);
                startActivity(intent);
            }
        });

        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cbsde.isChecked())
                {
                    Intent intent = new  Intent(diemsorce.this,sdecode.class);
                    startActivity(intent);
                }
                if (cbsvua.isChecked())
                {
                    Intent intent = new Intent(diemsorce.this,svuacode.class);
                    startActivity(intent);
                }
                if (cbskho.isChecked())
                {
                    Intent intent = new Intent(diemsorce.this,skhocode.class);
                    startActivity(intent);
                }

            }
        });
        cbsde.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean de) {
                MediaPlayer mediaPlayer= MediaPlayer.create(diemsorce.this,R.raw.pop);
                mediaPlayer.start();
                if(de){
                    if(cbsde.isChecked()==true)
                    {
                        cbsvua.setChecked(false);
                        cbskho.setChecked(false);
                    }

                    Toast.makeText(diemsorce.this,"Chế độ dễ: ON",Toast.LENGTH_SHORT).show();
                }else {Toast.makeText(diemsorce.this,"Chế độ dễ:OFF", Toast.LENGTH_SHORT).show();}
            }
        });
        cbsvua.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean vua) {
                MediaPlayer mediaPlayer= MediaPlayer.create(diemsorce.this,R.raw.pop);
                mediaPlayer.start();
                if(vua){
                    if(cbsvua.isChecked()==true)
                    {
                        cbsde.setChecked(false);
                        cbskho.setChecked(false);
                    }

                    Toast.makeText(diemsorce.this,"Chế độ vừa: ON",Toast.LENGTH_SHORT).show();
                }else {Toast.makeText(diemsorce.this, "Chế độ vừa: OFF",Toast.LENGTH_SHORT).show();}
            }
        });
        cbskho.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean kho) {
                MediaPlayer mediaPlayer= MediaPlayer.create(diemsorce.this,R.raw.pop);
                mediaPlayer.start();
                if(kho){
                    if(cbskho.isChecked()==true)
                    {
                        cbsde.setChecked(false);
                        cbsvua.setChecked(false);
                    }
                    Toast.makeText(diemsorce.this,"Chế độ khó: ON",Toast.LENGTH_SHORT).show();
                }else {Toast.makeText(diemsorce.this, "Chế độ khó: OFF",Toast.LENGTH_SHORT).show();}
            }
        });


    }
    private void Anhxa(){
        cbsde      = (CheckBox)findViewById(R.id.cbsde);
        cbsvua     = (CheckBox)findViewById(R.id.cbsvua);
        cbskho     = (CheckBox)findViewById(R.id.cbskho);
        OK  = (Button)findViewById(R.id.btOK);
        TroVe=(Button)findViewById(R.id.btsback);
    }
}