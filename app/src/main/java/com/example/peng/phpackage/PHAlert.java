package com.example.peng.phpackage;

import android.os.Bundle;

import android.support.annotation.Nullable;
import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by MIAO on 2017/9/5.
 */

public class PHAlert extends DialogFragment{
    public Request.CallBack callBack;
//    public PHAlert(View view) {
//        super();
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.phalert, container);
        initEvents(view);
        return view;
    }
    private void initEvents(View view){
        Button btn =(Button) view.findViewById(R.id.alert_block);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.successed("hello");
            }
        });

    }


}
