package com.example.chipto.flag1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.drm.DrmStore;
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


class QuestionNarenortham
{
    public String ID;
    public  String AnswerA, AnswerB, AnswerC, AnswerD, Answer;
}

public class northamcode extends Activity {
    ArrayList<String> arrayName;
    ImageView imQ;
    Button BT,TroVe;
    RadioGroup RGde;
    RadioButton A,B,C,D;
    int kq=0;
    int pos =0;
    TextView ketqua;
    int HighScore=0;
    ArrayList <QuestionNarenortham> L = new ArrayList();
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
                MediaPlayer mediaPlayer= MediaPlayer.create(northamcode.this,R.raw.pop);
                mediaPlayer.start();
                Intent intent = new Intent(northamcode.this,continentcode.class);
                startActivity(intent);
            }
        });
        A = (RadioButton) findViewById(R.id.RBAc);
        B = (RadioButton) findViewById(R.id.RBBc);
        C = (RadioButton) findViewById(R.id.RBCc);
        D = (RadioButton) findViewById(R.id.RBDc);


//        LoadHighScore();


        ReadData();








        Display(pos);
        BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(northamcode.this,R.raw.nya);
                mediaPlayer.start();
                int idCheck=RGde.getCheckedRadioButtonId();
                switch (idCheck){
                    case  R.id.RBAc:
                        if (L.get(pos).Answer.compareTo("A")==0) kq=kq+1;
                        break;
                    case  R.id.RBBc:
                        if (L.get(pos).Answer.compareTo("B")==0) kq=kq+1;
                        break;
                    case  R.id.RBCc:
                        if (L.get(pos).Answer.compareTo("C")==0) kq=kq+1;
                        break;
                    case  R.id.RBDc:
                        if (L.get(pos).Answer.compareTo("D")==0) kq=kq+1;
                        break;
                }

                pos++;
//                if(pos>=10)
//                {
//                    finish();
//                }
                if(pos>=10){
                    Intent intent = new Intent(northamcode.this,ketquaccode.class);
                    Bundle bundle=new Bundle();
                    bundle.putInt("KQc",kq);
                    bundle.putInt("Socauc",pos);
                    intent.putExtra("MyPackagec",bundle);
                    startActivity(intent);
//                    if(kq > HighScore)
//                    { HighScore=kq;
//                       //SaveHighScore();
//                    }
//                    finish();
                }
                else
                    Display(pos);

            }
        });


    }

    void Display(int i)
    {

        A.setText(L.get(i).AnswerA);
        B.setText(L.get(i).AnswerB);
        C.setText(L.get(i).AnswerC);
        D.setText(L.get(i).AnswerD);
        ketqua.setText("Câu đúng:"+kq);
        int idHinh = getResources().getIdentifier("i"+ L.get(i).ID, "drawable", getPackageName());

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
                    listChild = Item.getElementsByTagName("AnswerA");
                    String AnswerA = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("AnswerB");
                    String AnswerB = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("AnswerC");
                    String AnswerC = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("AnswerD");
                    String AnswerD = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("Answer");
                    String Answer = listChild.item(0).getTextContent();

                    QuestionNarenortham Q1 = new QuestionNarenortham();
                    Q1.ID = ID;
                    Q1.AnswerA = AnswerA;
                    Q1.AnswerB = AnswerB;
                    Q1.AnswerC = AnswerC;
                    Q1.AnswerD = AnswerD;
                    Q1.Answer = Answer;
                    L.add(Q1);
                }
                ;
            }
            Collections.shuffle(L);
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
//
//    void LoadHighScore(){
//        SharedPreferences sharedPreferences = getSharedPreferences("MyDatac", Context.MODE_PRIVATE);
//        if(sharedPreferences !=null){
//            HighScore=sharedPreferences.getInt("Hc",0);
//        }
//    }
//    void SaveHighScore(){
//        SharedPreferences sharedPreferences=getSharedPreferences("MyDatac",Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor=sharedPreferences.edit();
//        editor.putInt("Hc",HighScore);
//        editor.apply();
//    }

}