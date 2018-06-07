package com.example.chipto.flag1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.Collections;

public class menupicchon extends Activity {

    TableLayout mytb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menupicchon);

        mytb = (TableLayout) findViewById(R.id.tb);

        int sodong= 17;
        int socot = 3;

        //tron mang
        Collections.shuffle(findpiccode.arrayName);
        //tao dong va cot
        for(int i=1; i<= sodong;i++)
        {
            TableRow tableRow = new TableRow(this);

            //tao cot ->
            for (int j=1; j<=socot;j++)
            {
                ImageView imageView = new ImageView(this);
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(200,200);
                imageView.setLayoutParams(layoutParams);

                final int vitri = socot *(i-1)+j-1;

                int idhinh = getResources().getIdentifier(findpiccode.arrayName.get(vitri),"drawable",getPackageName());
                imageView.setImageResource(idhinh);
                //them IV vao dong
                tableRow.addView(imageView);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       // Toast.makeText(menupicchon.this, findpiccode.arrayName.get(vitri),Toast.LENGTH_SHORT);
                        Intent intent = new Intent();
                        intent.putExtra("tenhinhchon",findpiccode.arrayName.get(vitri));
                        setResult(RESULT_OK,intent);
                        finish();
                    }
                });
            }
            //add tablerow vao bang
            mytb.addView(tableRow);
        }
    }
}
