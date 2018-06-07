package com.example.chipto.flag1;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class findpiccode extends AppCompatActivity {
   public static ArrayList<String> arrayName;
    ImageView picgoc,picnhan;
    TextView diem;
    int REQUEST_CODE_IMAGE=123;
    String tenhinhgoc="";
    int total = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findpic);

        picgoc = (ImageView) findViewById(R.id.picgoc);
        picnhan= (ImageView) findViewById(R.id.picchon);
        diem = (TextView) findViewById(R.id.Sfinhinh);
        diem.setText((total +""));

        String[] mangTen = getResources().getStringArray(R.array.list_name);
        arrayName = new ArrayList<>(Arrays.asList(mangTen));

        //đảo lộn mảng
        Collections.shuffle(arrayName);
        tenhinhgoc=arrayName.get(0);
        int idhinh = getResources().getIdentifier(arrayName.get(0),"drawable",getPackageName());

        picgoc.setImageResource(idhinh);

        picnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult( new Intent(findpiccode.this,menupicchon.class),REQUEST_CODE_IMAGE);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode== REQUEST_CODE_IMAGE && requestCode == RESULT_OK && data !=null){
            String tenhinhnhan = data.getStringExtra("tenhinhchon");
            int idhinhnhan = getResources().getIdentifier(tenhinhnhan,"drawable",getPackageName());
            picnhan.setImageResource(idhinhnhan);
            //sosanh theo ten hinh
            if(tenhinhgoc.equals(tenhinhnhan)){
                Toast.makeText(this,"Chính xác!!!\n bị cộng 10 điểm",Toast.LENGTH_SHORT).show();
//cong diem
                total += 10;
                //doi hinh goc
                new CountDownTimer(2000, 100) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        //đảo lộn mảng
                        Collections.shuffle(arrayName);
                        tenhinhgoc=arrayName.get(0);
                        int idhinh = getResources().getIdentifier(arrayName.get(0),"drawable",getPackageName());

                        picgoc.setImageResource(idhinh);
                    }
                }.start();

            }else {
                Toast.makeText(this,"Đi khám mắt đi !!!\n bị trừ 5 điểm",Toast.LENGTH_SHORT).show();
                total -=5;
            }diem.setText(total+"");
        }
        //kiemtra kio chon hin
        if(requestCode == REQUEST_CODE_IMAGE && resultCode==RESULT_CANCELED){
            Toast.makeText(this, "Quên hình hả ???\n bị trừ 15 điểm",Toast.LENGTH_SHORT).show();
        total -=15;
        diem.setText(total+"");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.reload, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()== R.id.reload){
            //đảo lộn mảng
            Collections.shuffle(arrayName);
            tenhinhgoc=arrayName.get(0);
            int idhinh = getResources().getIdentifier(arrayName.get(0),"drawable",getPackageName());

            picgoc.setImageResource(idhinh);
        }
        return super.onOptionsItemSelected(item);
    }
}
