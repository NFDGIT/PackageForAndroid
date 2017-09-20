package com.example.peng.phpackage;

import android.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.support.v4.app.Fragment;

import android.support.v4.view.ViewPager;
//import android.support.v7.app.AppCompatActivity;




import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.ImageButton;
import android.widget.LinearLayout;

import android.widget.Toast;

import com.example.peng.phpackage.Base.BaseActivity;
import com.example.peng.phpackage.Base.BaseViewPager;
import com.example.peng.phpackage.activity.WebActivity;
import com.example.peng.phpackage.adapter.MainPagerAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends Activity {

    private BaseViewPager mPager;
    private ArrayList<View> viewList;
    private ArrayList<Fragment> fragList;
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



        ImageButton backBtn =(ImageButton) findViewById(R.id.topnavi_back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, WebActivity.class);
                intent.putExtra("url","http://www.baidu.com");

                startActivity(intent);
//                startActivity(new Intent(getApplicationContext(),BaseActivity.class));




            }
        });



        ImageButton rightBtn = (ImageButton) findViewById(R.id.topnavi_rightBtn);
        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                JSONObject parm = new JSONObject();
                try {
                    parm.putOpt("userid","2");

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Log.i("peng","网络访问前:"+ Thread.currentThread().toString());

                com.example.peng.phpackage.Request.get("http://www.shp360.com/MshcShopGuanjia/", "Zonghe_savedefaulttongzhi.action", parm, new com.example.peng.phpackage.Request.CallBack() {
                    @Override
                    public void successed(Object obj) {
                        Log.i("peng",obj.toString());
                        Log.i("peng","网络访问后:"+ Thread.currentThread().toString());


                        Looper.prepare();
                        Toast.makeText(sContext, obj.toString(), Toast.LENGTH_SHORT).show();
                        Looper.loop();


                    }

                    @Override
                    public void faild(IOException e) {
                        Log.i("peng",e.toString());


//                        Toast.makeText(MainActivity.this,e.toString(),Toast.LENGTH_LONG).show();
                    }
                });
            }






        });


        LinearLayout tab1 =(LinearLayout) findViewById(R.id.tab1);
        LinearLayout tab2 =(LinearLayout) findViewById(R.id.tab2);
        LinearLayout tab3 =(LinearLayout) findViewById(R.id.tab3);



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



        mPager = (BaseViewPager) findViewById(R.id.mp_main);
        mPager.isCanScroll = false;



        viewList = new ArrayList<View>();


        LayoutInflater li = getLayoutInflater();
        viewList.add(li.inflate(R.layout.shouyelayout,null,false));
        viewList.add(li.inflate(R.layout.gouwuche,null,false));
        viewList.add(li.inflate(R.layout.person,null,false));


        fragList = new ArrayList<Fragment>();
//        viewList.add()



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



    }


    private void changeContentWithIndex(int index) {
        mPager.setCurrentItem(index,false);
    }
    private void seleTabBarWithIndex(int index) {

        ImageButton tabImg1 =(ImageButton) findViewById(R.id.tab1img);
        ImageButton tabImg2 =(ImageButton) findViewById(R.id.tab2img);
        ImageButton tabImg3 =(ImageButton) findViewById(R.id.tab3img);

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
