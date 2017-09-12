package com.example.peng.phpackage;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Iterator;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;



/**
 * Created by MIAO on 2017/8/25.
 */

public class Request extends Object {


    /**
     *    网络的请求  定义的回调类型
     */
    public  interface CallBack{
        void successed(Object obj);
        void faild(IOException e);
    }
    /**
     * 回调的 类型对象
     */
    private static   CallBack cbFunction;

    /**
     * 统一为请求添加头信息
     * @return
     */
    private static okhttp3.Request.Builder addHeaders() {
        okhttp3.Request.Builder builder = new okhttp3.Request.Builder()
                .addHeader("Connection", "keep-alive")
                .addHeader("platform", "2")
                .addHeader("phoneModel", Build.MODEL)
                .addHeader("systemVersion", Build.VERSION.RELEASE)
                .addHeader("appVersion", "3.2.0");
        return builder;
    }

    /**
     *    JSONObject 转 get string
     */

    private static String getParmStringWithParm(JSONObject parm){
      String result = "";
        Iterator it = parm.keys();

        while (it.hasNext()){
            String key = it.next().toString();
            String value = parm.optString(key);
            result = result + key + "=" + value + "&";
        }
        if (result.endsWith("&")){
            result =  result.substring(0,result.length()-1);
        }
        Log.i("peng",result);
        return  result;
    }


    public Request() {
    }

    /**
     * get 请求
     * @param baseUrl    服务器点击事件的路径
     * @param url        服务器时间的 名字
     * @param parm       要传给服务器的参数
     * @param callBack   网络请求的回调
     */
    static public void  get(String baseUrl, String url, JSONObject parm, CallBack callBack){
        cbFunction = callBack;
        OkHttpClient mHttpClient = new OkHttpClient();


        
        
        okhttp3.Request request = new okhttp3.Request.Builder().url(baseUrl+url+"?"+getParmStringWithParm(parm)).build();
       request = addHeaders().url(baseUrl+url+"?"+getParmStringWithParm(parm)).build();

        mHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                cbFunction.faild(new IOException());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                cbFunction.successed(response.body().string());
            }
        });
    }

    /**
     * post 请求
     * @param baseUrl    服务器点击事件的路径
     * @param url        服务器时间的 名字
     * @param parm       要传给服务器的参数
     * @param callBack   网络请求的回调
     */

    static public void  post(String baseUrl, String url, JSONObject parm, CallBack callBack){
        cbFunction = callBack;
        OkHttpClient mHttpClient = new OkHttpClient();

        RequestBody body ;
        body = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded; charset=utf-8"),getParmStringWithParm(parm));
        okhttp3.Request request = addHeaders().url(baseUrl+url).post(body).build();



        mHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                cbFunction.faild(new IOException());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                cbFunction.successed(response.body().string());
            }
        });

    }

}
