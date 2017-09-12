package com.example.peng.phpackage.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.peng.phpackage.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;

/**
 * Created by MIAO on 2017/9/6.
 */


public class ShouYeFragmentAdapter extends BaseAdapter {


    private List<Map<String, Object>> mData;
    private LayoutInflater inflater;


//    public ShouYeFragmentAdapter(Context context,ArrayList<HashMap> datas){
//        mData = datas;
//        inflater = LayoutInflater.from(context);
//    }

    public ShouYeFragmentAdapter(Context context, List<Map<String, Object>> simpleData) {
        mData = simpleData;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
         ViewHolder holder = null;
        if (view == null){
            holder = new ViewHolder();

            view = inflater.inflate(R.layout.shouyecelllayout,null);

            holder.img   =(ImageView) view.findViewById(R.id.img);
            holder.title =(TextView) view.findViewById(R.id.title);
            holder.info  =(TextView) view.findViewById(R.id.info);
            holder.viewBtn =(Button) view.findViewById(R.id.view_btn);

            view.setTag(holder);
        }else {
            holder =(ViewHolder) view.getTag();
        }
        Map map = null;
        map = mData.get(i);


        holder.img.setImageResource((Integer) map.get("img"));
        holder.title.setText((String)map.get("title"));
        holder.info.setText((String)map.get("info"));
//        if (i%2 == 0){
//
//
//        }else {
//            holder.title.setCursorVisible(true);
//        }
        holder.title.setCursorVisible(true);

        holder.viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                new AlertDialog.Builder(inflater.getContext())
                        .setTitle("我的listview")
                        .setMessage("第"+ i +"个")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .show();

//                Toast.makeText(inflater.getContext(),"hello",Toast.LENGTH_LONG).show();
            }
        });

       return view;


    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }


    public final class ViewHolder{

           public ImageView img;
           public TextView title;
           public TextView info;
           public Button viewBtn;
       }

}
