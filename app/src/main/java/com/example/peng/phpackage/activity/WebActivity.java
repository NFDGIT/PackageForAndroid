package com.example.peng.phpackage.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.peng.phpackage.R;

public class WebActivity extends AppCompatActivity {
    private String url;
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        url =  getIntent().getStringExtra("url");
        setContentView(R.layout.activity_web);
        webView = (WebView) findViewById(R.id.webview);
        webView.loadUrl(url);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
    }

    @Override
    public void finish() {
        String currentUrl = webView.getUrl();

        Log.i("weburl:",currentUrl);

        if (currentUrl.equals(url)){
            super.finish();
        }else {
            webView.goBack();
        }


    }
}
