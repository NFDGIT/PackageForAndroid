package com.example.peng.phpackage;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewPager;
//import android.support.v7.app.AppCompatActivity;




import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends Activity {

    private ViewPager mPager;
    private ArrayList<View> viewList;
    public static MainActivity MAINACTIVITY;
    public static Context sContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MAINACTIVITY=this;


        initView();
        initEvents();


    }

    private void initEvents() {
        sContext = getApplicationContext();

        ImageButton backBtn = findViewById(R.id.topnavi_back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,BaseActivity.class));
            }
        });

        ImageButton rightBtn = findViewById(R.id.topnavi_rightBtn);
        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               Log.i("wang","网络访问前:"+ Thread.currentThread().toString());




                com.example.peng.phpackage.Request.getWithParm("http://www.baidu.com", "", new JSONObject(), new com.example.peng.phpackage.Request.CallBack() {
                    @Override
                    public void successed(Object obj) {
                        Log.i("wang",obj.toString());
                        Log.i("wang","网络访问后:"+ Thread.currentThread().toString());




                        Looper.prepare();
                        Toast.makeText(MainActivity.this, obj.toString(), Toast.LENGTH_SHORT).show();
                        Looper.loop();

                       // Toast.makeText(MAINACTIVITY,"heello swift",Toast.LENGTH_LONG).show();

//                        try{
//                            android.os.Handler myHandle = new android.os.Handler(){
//                                @Override
//                                public void handleMessage(Message msg) {
//                                    super.handleMessage(msg);
//
//
//                                }
//                            };
//
//
//
////                            Handler myHandler = new Handler() {
////                                public void handleMessage(NotificationCompat.MessagingStyle.Message msg) {
////                                    switch (msg.what) {
////                                        case TestHandler.GUIUPDATEIDENTIFIER:
////                                            myBounceView.invalidate();
////                                            break;
////                                    }
////                                    super.handleMessage(msg);
////                                }
////                            };
//
//
//
//
//
//                        }catch(Exception e){
//                            Log.i("wang",e.toString());
//                        }

//
                    }

                    @Override
                    public void faild(IOException e) {
                        Log.i("wang",e.toString());


//                        Toast.makeText(MainActivity.this,e.toString(),Toast.LENGTH_LONG).show();
                    }
                });






            }






        });







        LinearLayout tab1 = findViewById(R.id.tab1);
        LinearLayout tab2 = findViewById(R.id.tab2);
        LinearLayout tab3 = findViewById(R.id.tab3);

        tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               seleTabBarWithIndex(0);
               changeContentWithIndex(0);
            }
        });
        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seleTabBarWithIndex(1);
                changeContentWithIndex(1);
            }
        });
        tab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seleTabBarWithIndex(2);
                changeContentWithIndex(2);
            }
        });



    }



    private void initView() {

        mPager = (ViewPager) findViewById(R.id.mp_main);

        viewList = new ArrayList<View>();


        LayoutInflater li = getLayoutInflater();
        viewList.add(li.inflate(R.layout.shouyelayout,null,false));
        viewList.add(li.inflate(R.layout.gouwuche,null,false));
        viewList.add(li.inflate(R.layout.person,null,false));

        MainPagerAdapter pagerAda = new MainPagerAdapter(viewList);







        mPager.setAdapter(pagerAda);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                seleTabBarWithIndex(position);

            }



            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



//







    }


    private void changeContentWithIndex(int index) {
        mPager.setCurrentItem(index,false);
    }
    private void seleTabBarWithIndex(int index) {
        ImageButton tabImg1 = findViewById(R.id.tab1img);
        ImageButton tabImg2 = findViewById(R.id.tab2img);
        ImageButton tabImg3 = findViewById(R.id.tab3img);

        tabImg1.setImageResource(R.mipmap.ic_launcher_round);
        tabImg2.setImageResource(R.mipmap.ic_launcher_round);
        tabImg3.setImageResource(R.mipmap.ic_launcher_round);

        switch (index){
            case 0:
                tabImg1.setImageResource(R.mipmap.ic_launcher);
                break;
            case 1:
                tabImg2.setImageResource(R.mipmap.ic_launcher);
                break;
            case 2:
                tabImg3.setImageResource(R.mipmap.ic_launcher);
                break;
        }

    }


}
