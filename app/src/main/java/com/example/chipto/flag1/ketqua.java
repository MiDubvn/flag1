package com.example.chipto.flag1;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ketqua extends Activity {
    Button BT;
    TextView KQ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ketqua);
        KQ =  findViewById(R.id.TxtKQ);
        BT =  findViewById(R.id.BtnBack);
        Intent callerIntent=getIntent();
        Bundle packageFromCaller= callerIntent.getBundleExtra("MyPackage");
        KQ.setText(packageFromCaller.getInt("KQ")+"/"+ packageFromCaller.getInt("Socau"));
        BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}