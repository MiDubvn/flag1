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

public class chedocode extends Activity {
    CheckBox cbde,cbvua,cbkho;
    Button SanSang, TroVe;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chedo);
        Anhxa();

        SanSang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(chedocode.this,R.raw.pop);
                mediaPlayer.start();
                if (cbde.isChecked())
                {
                    Intent intent = new  Intent(chedocode.this,decode.class);
                    startActivity(intent);
                }
                if (cbvua.isChecked())
                {
                    Intent intent = new Intent(chedocode.this,vuacode.class);
                    startActivity(intent);
                }
                if (cbkho.isChecked())
                {
                    Intent intent = new Intent(chedocode.this,khocode.class);
                    startActivity(intent);
                }

            }
        });
        cbde.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean de) {
                MediaPlayer mediaPlayer= MediaPlayer.create(chedocode.this,R.raw.rd);
                mediaPlayer.start();
                if(de){
                    if(cbde.isChecked()==true)
                    {
                        cbvua.setChecked(false);
                        cbkho.setChecked(false);
                    }

                    Toast.makeText(chedocode.this,"Chế độ dễ: ON",Toast.LENGTH_SHORT).show();
                }else {Toast.makeText(chedocode.this,"Chế độ dễ:OFF", Toast.LENGTH_SHORT).show();}
            }
        });
        cbvua.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean vua) {
                MediaPlayer mediaPlayer= MediaPlayer.create(chedocode.this,R.raw.rd);
                mediaPlayer.start();
                if(vua){
                    if(cbvua.isChecked()==true)
                    {
                        cbde.setChecked(false);
                        cbkho.setChecked(false);
                    }

                    Toast.makeText(chedocode.this,"Chế độ vừa: ON",Toast.LENGTH_SHORT).show();
                }else {Toast.makeText(chedocode.this, "Chế độ vừa: OFF",Toast.LENGTH_SHORT).show();}
            }
        });
        cbkho.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean kho) {
                MediaPlayer mediaPlayer= MediaPlayer.create(chedocode.this,R.raw.rd);
                mediaPlayer.start();
                if(kho){
                    if(cbkho.isChecked()==true)
                    {
                        cbde.setChecked(false);
                        cbvua.setChecked(false);
                    }
                    Toast.makeText(chedocode.this,"Chế độ khó: ON",Toast.LENGTH_SHORT).show();
                }else {Toast.makeText(chedocode.this, "Chế độ khó: OFF",Toast.LENGTH_SHORT).show();}
            }
        });
        TroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(chedocode.this,R.raw.pop);
                mediaPlayer.start();
                Intent intent = new Intent(chedocode.this,phanchiacode.class);
                startActivity(intent);
            }
        });

    }
    private void Anhxa(){
        cbde      = (CheckBox)findViewById(R.id.cbde);
        cbvua     = (CheckBox)findViewById(R.id.cbvua);
        cbkho     = (CheckBox)findViewById(R.id.cbkho);
        SanSang   = (Button)findViewById(R.id.btsansang);
        TroVe     = (Button)findViewById(R.id.btback);
    }
}