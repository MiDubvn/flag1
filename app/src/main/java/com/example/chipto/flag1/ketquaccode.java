package com.example.chipto.flag1;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ketquaccode extends Activity {
    Button BT;
    TextView KQ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ketquac);
        KQ =  findViewById(R.id.TxtKQc);
        BT =  findViewById(R.id.BtnBackc);
        Intent callerIntent=getIntent();
        Bundle packageFromCaller= callerIntent.getBundleExtra("MyPackagec");
        KQ.setText(packageFromCaller.getInt("KQc")+"/"+ packageFromCaller.getInt("Socauc"));
        BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}