package com.example.chipto.flag1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chipto.flag1.R;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class nhintendoanhinhcode extends Activity {

    int i = 0, kq = 0, hanhtrinh;
    int HighScore = 0;
    ProgressBar TimeLine;
    String Traloi = "";
    TextView Txttenquocgia, ketqua;
    Button Btntraloi, Btnbocuoc;
    ImageView ImgBtnB, ImgBtnC, ImgBtnD;
    ImageView ImgBtnA, ImghighlghtA, ImghighlghtB, ImghighlghtC, ImghighlghtD;
    CheckBox CbA, CbB, CbD, CbC;
    ArrayList<String> Tencauhoi = new ArrayList<>();
    ArrayList<Integer> ArrRanCauHoi = new ArrayList<>();//mảng chứa câu hỏi
    ArrayList<Integer> ArrRanNumCTL = new ArrayList<>();
    ArrayList<Integer> ArrCauTL = new ArrayList<>();
    ArrayList<Integer> songaunhien = new ArrayList<>();
    ArrayList<String> ArrDapAn = new ArrayList<>();//mảng chứa vị trí đáp án trong 4 câu trắc nghiệm
    CountDownTimer countDownTimer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nhintenchonhinh);

        Txttenquocgia = (TextView) findViewById(R.id.Txttenquocgia);
        Btntraloi = (Button) findViewById(R.id.Btntraloi);
        Btnbocuoc = (Button) findViewById(R.id.Btnbocuoc);
        ImgBtnA = (ImageView) findViewById(R.id.ImgBtnA);
        ImgBtnB = (ImageView) findViewById(R.id.ImgBtnB);
        ImgBtnC = (ImageView) findViewById(R.id.ImgBtnC);
        ImgBtnD = (ImageView) findViewById(R.id.ImgBtnD);
        TimeLine = (ProgressBar) findViewById(R.id.timeline);
        CbA = (CheckBox) findViewById(R.id.CbA);
        CbB = (CheckBox) findViewById(R.id.CbB);
        CbC = (CheckBox) findViewById(R.id.CbC);
        CbD = (CheckBox) findViewById(R.id.CbD);
        ImghighlghtA = (ImageView) findViewById(R.id.ImghighlghtA);
        ImghighlghtB = (ImageView) findViewById(R.id.ImghighlghtB);
        ImghighlghtC = (ImageView) findViewById(R.id.ImghighlghtC);
        ImghighlghtD = (ImageView) findViewById(R.id.ImghighlghtD);

        ImghighlghtA.setVisibility(View.INVISIBLE);
        ImghighlghtB.setVisibility(View.INVISIBLE);
        ImghighlghtC.setVisibility(View.INVISIBLE);
        ImghighlghtD.setVisibility(View.INVISIBLE);

        ReadData();

        for (int i = 0; i < Tencauhoi.size(); i++) {
            ArrRanCauHoi.add(i);
        }
        Collections.shuffle(ArrRanCauHoi);
        Display(ArrRanCauHoi.get(i));
        Choose(i);
        // Txttenquocgia.setText(Tencauhoi.get(i));

        Btntraloi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                ImghighlghtA.setVisibility(View.INVISIBLE);
                ImghighlghtB.setVisibility(View.INVISIBLE);
                ImghighlghtC.setVisibility(View.INVISIBLE);
                ImghighlghtD.setVisibility(View.INVISIBLE);

                Choose(i);
                i++;
                if (i >= 10) {
                    Intent intent = new Intent(nhintendoanhinhcode.this, ketqua.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("KQ", kq);
                    bundle.putInt("Socau", i);
                    intent.putExtra("MyPackage", bundle);
                    startActivity(intent);
                    countDownTimer.cancel();
                    if (kq > HighScore) {
                        HighScore = kq;
                        SaveHighScore();
                    }
                    finish();
                } else
                    Display(ArrRanCauHoi.get(i));
            }
        });
    }

    void Choose(final int i)        // Mục đích: bỏ chọn các câu còn lại và hiển thị Highlight câu đã chọn
    {

        CbA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Traloi = CbA.getText().toString();
                    CbB.setChecked(false);
                    CbC.setChecked(false);
                    CbD.setChecked(false);
                    ImghighlghtA.setVisibility(View.VISIBLE);        //   Hiện highlight
                } else ImghighlghtA.setVisibility(View.INVISIBLE);   //   Ẩn highlight

            }
        });
        CbB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Traloi = CbB.getText().toString();
                    CbA.setChecked(false);
                    CbC.setChecked(false);
                    CbD.setChecked(false);
                    ImghighlghtB.setVisibility(View.VISIBLE);
                } else ImghighlghtB.setVisibility(View.INVISIBLE);

            }
        });
        CbC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Traloi = CbC.getText().toString();
                    CbB.setChecked(false);
                    CbA.setChecked(false);
                    CbD.setChecked(false);
                    ImghighlghtC.setVisibility(View.VISIBLE);
                } else ImghighlghtC.setVisibility(View.INVISIBLE);
            }
        });
        CbD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Traloi = CbD.getText().toString();
                    CbB.setChecked(false);
                    CbC.setChecked(false);
                    CbA.setChecked(false);
                    ImghighlghtD.setVisibility(View.VISIBLE);
                } else ImghighlghtD.setVisibility(View.INVISIBLE);
            }
        });
        if (Traloi.compareTo(Tencauhoi.get(ArrRanCauHoi.get(i)).toString()) == 0)      // So sánh tên cờ của câu đã chọn với đề, đúng thì tăng điểm
        {
            kq++;
        }
    }

    void Display(int i) {
        timedown();
        songaunhien.clear();
        for (int x = 0; x < 4; x++) {
            songaunhien.add(x);
        }
        Collections.shuffle(songaunhien);
        RanCauTraLoi(i);
        Txttenquocgia.setText(Tencauhoi.get(i));

        ImgBtnA.setImageResource(ArrCauTL.get(songaunhien.get(0)));

        ImgBtnB.setImageResource(ArrCauTL.get(songaunhien.get(1)));

        ImgBtnC.setImageResource(ArrCauTL.get(songaunhien.get(2)));

        ImgBtnD.setImageResource(ArrCauTL.get(songaunhien.get(3)));

        CbA.setText(ArrDapAn.get(songaunhien.get(0)));
        CbB.setText(ArrDapAn.get(songaunhien.get(1)));
        CbC.setText(ArrDapAn.get(songaunhien.get(2)));
        CbD.setText(ArrDapAn.get(songaunhien.get(3)));
//        ketqua.setText("Câu đúng:"+kq);

    }

    void RanCauTraLoi(int i) {
        ArrDapAn.clear();
        ArrCauTL.clear();
        ArrRanNumCTL.clear();
        ArrCauTL.add(getResources().getIdentifier("i" + i, "drawable", getPackageName()));
        ArrDapAn.add(Tencauhoi.get(i));
        for (int x = 0; x < Tencauhoi.size(); x++) {

            if (x == i)
                x++;
            ArrRanNumCTL.add(x);
        }
        Collections.shuffle(ArrRanNumCTL);
        ArrCauTL.add(getResources().getIdentifier("i" + ArrRanNumCTL.get(0), "drawable", getPackageName()));
        ArrCauTL.add(getResources().getIdentifier("i" + ArrRanNumCTL.get(1), "drawable", getPackageName()));
        ArrCauTL.add(getResources().getIdentifier("i" + ArrRanNumCTL.get(2), "drawable", getPackageName()));

        ArrDapAn.add(Tencauhoi.get(ArrRanNumCTL.get(0)));
        ArrDapAn.add(Tencauhoi.get(ArrRanNumCTL.get(0)));
        ArrDapAn.add(Tencauhoi.get(ArrRanNumCTL.get(0)));
//        Collections.shuffle(ArrCauTL);
    }

    void ReadData() {
        try {
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = DBF.newDocumentBuilder();
            InputStream in = getAssets().open("data.xml");
            Document doc = builder.parse(in);
            Element root = doc.getDocumentElement();
            NodeList list = root.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element Item = (Element) node;
                    NodeList listChild = Item.getElementsByTagName("ID");
                    String ID = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("Answer");
                    String Answer = listChild.item(0).getTextContent();

                    Tencauhoi.add(Answer);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void LoadHighScore() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyDataHH", Context.MODE_PRIVATE);
        if (sharedPreferences != null) {
            HighScore = sharedPreferences.getInt("HH", 0);
        }
    }

    void SaveHighScore() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyDataHH", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("HH", HighScore);
        editor.apply();
    }

    void timedown() {
        TimeLine.setMax(100);
        TimeLine.setProgress(0);
        hanhtrinh = TimeLine.getProgress();
        countDownTimer = new CountDownTimer(5000, 50) {

            @Override
            public void onTick(long millisUntilFinished) {
                TimeLine.setProgress(hanhtrinh);
                hanhtrinh++;
            }

            @Override
            public void onFinish() {
                i++;
                if (i == 10) {
                    Intent intent = new Intent(nhintendoanhinhcode.this, ketqua.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("KQ", kq);
                    bundle.putInt("Socau", i);
                    intent.putExtra("MyPackage", bundle);
                    startActivity(intent);
                    countDownTimer.cancel();
                    if (kq > HighScore) {
                        HighScore = kq;
                        SaveHighScore();
                    }
                    finish();
                }

            }

        };countDownTimer.start();


    }
}