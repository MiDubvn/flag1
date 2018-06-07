package com.example.chipto.flag1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.drm.DrmStore;
import android.graphics.Bitmap;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

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
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class auaoccode extends Activity {

    ArrayList<String> ArrDe=new ArrayList<>();
    ArrayList<Integer> ArrRanNum=new ArrayList<>();
    ArrayList<Integer> ArrRanNumCTL=new ArrayList<>();
    ArrayList<String> ArrCauTL=new ArrayList<>();


    ImageView imQ;
    Button BT,TroVe;
    RadioGroup RGde;
    RadioButton A,B,C,D;
    int kq=0, i=0;
    int pos =0;
    TextView ketqua;
    int HighScore=0;
    // int HighScore=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testcontinent);

        imQ =  findViewById(R.id.imageViewQc);
        BT = (Button) findViewById(R.id.bttiepc);
        ketqua = (TextView) findViewById(R.id.tketquac);
        RGde= (RadioGroup) findViewById(R.id.rdgtraloic);
        TroVe=(Button)findViewById(R.id.bttrovec);
        TroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(auaoccode.this,R.raw.pop);
                mediaPlayer.start();
                Intent intent = new Intent(auaoccode.this,chedocode.class);
                startActivity(intent);
            }
        });
        A = (RadioButton) findViewById(R.id.RBAc);
        B = (RadioButton) findViewById(R.id.RBBc);
        C = (RadioButton) findViewById(R.id.RBCc);
        D = (RadioButton) findViewById(R.id.RBDc);


//        LoadHighScore();


        ReadData();



        for(int i=0;i<ArrDe.size();i++) //Để random câu hỏi
        {
            ArrRanNum.add(i);
        }
        Collections.shuffle(ArrRanNum);
        RanCauTraLoi(ArrRanNum.get(i));
        Display(ArrRanNum.get(i));
        BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(auaoccode.this,R.raw.nya);
                mediaPlayer.start();
                int idCheck=RGde.getCheckedRadioButtonId();
                switch (idCheck){
                    case  R.id.RBAc:
                        if (A.getText().toString().compareTo(ArrDe.get(ArrRanNum.get(i)))==0) kq=kq+1;
                        break;
                    case  R.id.RBBc:
                        if (B.getText().toString().compareTo(ArrDe.get(ArrRanNum.get(i)))==0) kq=kq+1;
                        break;
                    case  R.id.RBCc:
                        if (C.getText().toString().compareTo(ArrDe.get(ArrRanNum.get(i)))==0) kq=kq+1;
                        break;
                    case  R.id.RBDc:
                        if (D.getText().toString().compareTo(ArrDe.get(ArrRanNum.get(i)))==0) kq=kq+1;
                        break;
                }

                pos++;
                if(pos>=10){
                    Intent intent = new Intent(auaoccode.this,ketquaccode.class);
                    Bundle bundle=new Bundle();
                    bundle.putInt("KQc",kq);
                    bundle.putInt("Socauc",pos);
                    intent.putExtra("MyPackagec",bundle);
                    startActivity(intent);
//                    if(kq > HighScore)
//                    { HighScore=kq;
//                        SaveHighScore();}
//                    finish();
                }
//                else
                Display(pos);

            }
        });


    }

    void RanCauTraLoi(int i)
    {

        ArrCauTL.clear();
        ArrRanNumCTL.clear();
        ArrCauTL.add(ArrDe.get(i));
        for(int x=0;x<ArrDe.size();x++)
        {

            if(x==i)
                x++;
            ArrRanNumCTL.add(x);
        }
        Collections.shuffle(ArrRanNumCTL);
        ArrCauTL.add(ArrDe.get(ArrRanNumCTL.get(0)));
        ArrCauTL.add(ArrDe.get(ArrRanNumCTL.get(1)));
        ArrCauTL.add(ArrDe.get(ArrRanNumCTL.get(2)));

        Collections.shuffle(ArrCauTL);
    }


    void Display(int i)
    {

        RanCauTraLoi(i);
        A.setText(ArrCauTL.get(0));
        B.setText(ArrCauTL.get(1));
        C.setText(ArrCauTL.get(2));
        D.setText(ArrCauTL.get(3));
        ketqua.setText("Câu đúng:"+kq);
        int idHinh = getResources().getIdentifier("i"+ i, "drawable", getPackageName());

        imQ.setImageResource(idHinh);
        RGde.clearCheck();
    }
    void ReadData() {
        try {
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = DBF.newDocumentBuilder();
            InputStream in = getAssets().open("dataauaoc.xml");
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

                    ArrDe.add(Answer);
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

//    void LoadHighScore(){
//        SharedPreferences sharedPreferences = getSharedPreferences("MyDatade", Context.MODE_PRIVATE);
//        if(sharedPreferences !=null){
//            HighScore=sharedPreferences.getInt("Hde",0);
//        }
//    }
//    void SaveHighScore(){
//        SharedPreferences sharedPreferences=getSharedPreferences("MyDatade",Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor=sharedPreferences.edit();
//        editor.putInt("Hde",HighScore);
//        editor.apply();
//    }
//
}