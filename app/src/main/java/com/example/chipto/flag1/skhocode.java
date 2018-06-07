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

public class skhocode extends Activity {
    TextView Txt1;
    Button TroVe;
    int HighScore;
    @Override
    protected  void onPostCreate(@Nullable Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.skho);
        Txt1 = (TextView)findViewById(R.id.txths2);
        TroVe=(Button)findViewById(R.id.btsbackkho);
        TroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(skhocode.this,R.raw.pop);
                mediaPlayer.start();
                Intent intent = new Intent(skhocode.this,diemsorce.class);
                startActivity(intent);
            }
        });
        LoadHighScore();
        Txt1.setText(""+ HighScore);
    }
    void LoadHighScore()
    {
        SharedPreferences sharedPreferences=getSharedPreferences("MyDatakho", Context.MODE_PRIVATE);
        if(sharedPreferences !=null)
        {
            HighScore=sharedPreferences.getInt("Hkho",0);
        }
    }
}
