package com.example.chipto.flag1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class svuacode extends Activity {
    TextView Txt1;
    Button TroVe;
    int HighScore;
    @Override
    protected  void onPostCreate(@Nullable Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.svua);
        Txt1 = (TextView)findViewById(R.id.txths1);
        TroVe=(Button)findViewById(R.id.btsbackvua);
        TroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(svuacode.this,R.raw.pop);
                mediaPlayer.start();
                Intent intent = new Intent(svuacode.this,diemsorce.class);
                startActivity(intent);
            }
        });
        LoadHighScore();
        Txt1.setText(""+ HighScore);
    }
    void LoadHighScore()
    {
        SharedPreferences sharedPreferences=getSharedPreferences("MyDatavua", Context.MODE_PRIVATE);
        if(sharedPreferences !=null)
        {
            HighScore=sharedPreferences.getInt("Hvua",0);
        }
    }
}