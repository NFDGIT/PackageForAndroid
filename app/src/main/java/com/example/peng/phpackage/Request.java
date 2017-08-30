package com.example.peng.phpackage;

import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;
import java.util.Dictionary;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;


/**
 * Created by MIAO on 2017/8/25.
 */

public class Request extends Object {


    /**
     *    网络的请求
     */
    public  interface CallBack{
        void successed(Object obj);
        void faild(IOException e);
    }


    private static   CallBack cbFunction;

    static public void  getWithParm(String baseUrl, String url, JSONObject parm, CallBack callBack){
        cbFunction = callBack;

        OkHttpClient mHttpClient = new OkHttpClient();

        okhttp3.Request request = new okhttp3.Request.Builder().url(baseUrl+url).build();

        mHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                cbFunction.faild(new IOException());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                cbFunction.successed(new Object());
            }
        });








    }




}
