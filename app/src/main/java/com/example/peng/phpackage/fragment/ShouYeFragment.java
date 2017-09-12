package com.example.peng.phpackage.fragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.peng.phpackage.R;
import com.example.peng.phpackage.adapter.ShouYeFragmentAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MIAO on 2017/9/6.
 */

public class ShouYeFragment extends ListFragment {
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.shouyefragmentlayout,container,false);



//        return  inflater.inflate()


//        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        final String[] from = new String[] {"img","title","info"};
//        final int[] to   = new  int[] {R.id.img,R.id.title,R.id.info};
//        SimpleAdapter adapter = new SimpleAdapter(this.getActivity(),getSimpleData(),R.layout.shouyecelllayout,from,to);
//
        ShouYeFragmentAdapter adapter = new ShouYeFragmentAdapter(getActivity(),getSimpleData());
        setListAdapter(adapter);

    }
    private List<Map<String, Object>> getSimpleData() {


        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < 18; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("img", R.mipmap.ic_launcher);
            map.put("title", "Ferris wheel");
            map.put("info", "Suzhou Ferris wheel");
            list.add(map);
        }
        return list;
    }

    @Override
    public void setSelection(int position) {
        super.setSelection(position);


//        Toast.makeText(getActivity(),"hello1",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        Toast.makeText(getActivity(), "第"+position+"个", Toast.LENGTH_LONG).show();
        super.onListItemClick(l, v, position, id);

    }



}
















